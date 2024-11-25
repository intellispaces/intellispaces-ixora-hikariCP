package tech.intellispaces.ixora.hikary;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.intellispaces.ixora.rdb.ConnectionHandleImpl;
import tech.intellispaces.ixora.rdb.MovableConnection;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceDomain;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;
import tech.intellispaces.ixora.rdb.hikary.MovableHikariDataSource;
import tech.intellispaces.jaquarius.annotation.Mapper;
import tech.intellispaces.jaquarius.annotation.MapperOfMoving;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;
import tech.intellispaces.jaquarius.exception.TraverseExceptions;

import java.sql.SQLException;

@ObjectHandle(value = HikariDataSourceDomain.class, name = "HikariDataSourceHandleImpl")
public abstract class HikariDataSourceHandle implements MovableHikariDataSource {
  private static final Logger LOG = LoggerFactory.getLogger(HikariDataSourceHandle.class);

  private final HikariDataSourceProperties dataSourceProperties;
  private final com.zaxxer.hikari.HikariDataSource dataSource;

  public HikariDataSourceHandle(
      com.zaxxer.hikari.HikariDataSource dataSource,
      HikariDataSourceProperties dataSourceProperties
  ) {
    this.dataSource = dataSource;
    this.dataSourceProperties = dataSourceProperties;
  }

  @Mapper
  @Override
  public HikariDataSourceProperties properties() {
    return dataSourceProperties;
  }

  @Override
  @MapperOfMoving
  public MovableConnection getConnection() {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Get JDBC connection from Hikari data source. URL '{}', username '{}'", url(), username());
    }
    try {
      java.sql.Connection connection = dataSource.getConnection();
      return new ConnectionHandleImpl(connection);
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
