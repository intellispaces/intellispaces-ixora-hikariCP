package tech.intellispaces.ixora.rdb.hikary;

import com.zaxxer.hikari.HikariConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.intellispaces.framework.core.annotation.Mapper;
import tech.intellispaces.framework.core.annotation.Mover;
import tech.intellispaces.framework.core.annotation.ObjectHandle;
import tech.intellispaces.framework.core.exception.TraverseException;
import tech.intellispaces.ixora.rdb.BasicConnectionHandleImpl;
import tech.intellispaces.ixora.rdb.ConnectionHandle;
import tech.intellispaces.ixora.rdb.DataSourceMovableHandle;
import tech.intellispaces.ixora.rdb.DataSourcePropertiesHandle;

import java.sql.Connection;
import java.sql.SQLException;

@ObjectHandle
public abstract class HikariDataSourceHandle implements DataSourceMovableHandle {
  private static final Logger LOG = LoggerFactory.getLogger(HikariDataSourceHandle.class);

  private final DataSourcePropertiesHandle dataSourceProperties;
  private final com.zaxxer.hikari.HikariDataSource dataSource;

  public HikariDataSourceHandle(DataSourcePropertiesHandle dataSourceProperties) {
    this.dataSourceProperties = dataSourceProperties;
    this.dataSource = createDataSource();
  }

  @Mapper
  @Override
  public DataSourcePropertiesHandle properties() {
    return dataSourceProperties;
  }

  @Mover
  @Override
  public ConnectionHandle getConnection() {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Get JDBC connection from Hikari data source. URL '{}', username '{}'", url(), username());
    }
    try {
      Connection connection = dataSource.getConnection();
      return new BasicConnectionHandleImpl(connection);
    } catch (SQLException e) {
      throw TraverseException.withCauseAndMessage(e, "Could not get JDBC connection from Hikari data source. " +
          "URL '{}', username '{}'");
    }
  }

  String url() {
    return dataSourceProperties.url().trim();
  }

  String username() {
    return dataSourceProperties.username().trim();
  }

  String password() {
    return dataSourceProperties.password().trim();
  }

  private com.zaxxer.hikari.HikariDataSource createDataSource() {
    var config = new HikariConfig();
    config.setJdbcUrl(url());
    config.setUsername(username());
    config.setPassword(password());
    return new com.zaxxer.hikari.HikariDataSource(config);
  }
}
