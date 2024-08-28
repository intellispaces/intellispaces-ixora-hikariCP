package intellispaces.ixora.hikary;

import intellispaces.core.annotation.Mapper;
import intellispaces.core.annotation.Mover;
import intellispaces.core.annotation.ObjectHandle;
import intellispaces.core.exception.TraverseException;
import intellispaces.ixora.rdb.BasicConnection;
import intellispaces.ixora.rdb.Connection;
import intellispaces.ixora.rdb.hikary.HikariDataSourceDomain;
import intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;
import intellispaces.ixora.rdb.hikary.MovableHikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

@ObjectHandle(value = HikariDataSourceDomain.class, name = "HikariDataSourceWrapper")
public abstract class AbstractHikariDataSource implements MovableHikariDataSource {
  private static final Logger LOG = LoggerFactory.getLogger(AbstractHikariDataSource.class);

  private final HikariDataSourceProperties dataSourceProperties;
  private final com.zaxxer.hikari.HikariDataSource dataSource;

  public AbstractHikariDataSource(
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

  @Mover
  @Override
  public Connection getConnection() {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Get JDBC connection from Hikari data source. URL '{}', username '{}'", url(), username());
    }
    try {
      java.sql.Connection connection = dataSource.getConnection();
      return new BasicConnection(connection);
    } catch (SQLException e) {
      throw TraverseException.withCauseAndMessage(e, "Could not get JDBC connection from Hikari data source. " +
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
