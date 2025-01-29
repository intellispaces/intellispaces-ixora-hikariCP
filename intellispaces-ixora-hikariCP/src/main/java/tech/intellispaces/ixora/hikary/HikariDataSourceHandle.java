package tech.intellispaces.ixora.hikary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.intellispaces.ixora.rdb.JavaConnectionHandleImpl;
import tech.intellispaces.ixora.rdb.MovableConnectionHandle;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceDomain;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceSettingsHandle;
import tech.intellispaces.ixora.rdb.hikary.MovableHikariDataSourceHandle;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.annotation.MapperOfMoving;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;
import tech.intellispaces.jaquarius.exception.TraverseExceptions;

import java.sql.SQLException;

@ObjectHandle(value = HikariDataSourceDomain.class, name = "HikariDataSourceHandleImpl")
public abstract class HikariDataSourceHandle implements MovableHikariDataSourceHandle {
  private static final Logger LOG = LoggerFactory.getLogger(HikariDataSourceHandle.class);

  private final HikariDataSourceSettingsHandle dataSourceProperties;
  private final com.zaxxer.hikari.HikariDataSource dataSource;

  public HikariDataSourceHandle(
      com.zaxxer.hikari.HikariDataSource dataSource,
      HikariDataSourceSettingsHandle dataSourceSettings
  ) {
    this.dataSource = dataSource;
    this.dataSourceProperties = dataSourceSettings;
  }

  @Mapper
  @Override
  public HikariDataSourceSettingsHandle settings() {
    return dataSourceProperties;
  }

  @Override
  @MapperOfMoving
  public MovableConnectionHandle getConnection() {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Get JDBC connection from Hikari data source. URL '{}', username '{}'", url(), username());
    }
    try {
      java.sql.Connection connection = dataSource.getConnection();
      return new JavaConnectionHandleImpl(connection);
    } catch (SQLException e) {
      throw TraverseExceptions.withCauseAndMessage(e, "Could not get JDBC connection from Hikari data source. " +
          "URL '{}', username '{}'");
    }
  }

  private String url() {
    return dataSourceProperties.url().trim();
  }

  private String username() {
    return dataSourceProperties.username().trim();
  }
}
