package intellispaces.ixora.hikary;

import com.zaxxer.hikari.HikariConfig;
import intellispaces.ixora.rdb.hikary.HikariDataSourceHandle;
import intellispaces.ixora.rdb.hikary.HikariDataSourcePropertiesHandle;
import intellispaces.ixora.rdb.hikary.MovableHikariDataSourceFactoryHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import intellispaces.core.annotation.MovableObjectHandle;
import intellispaces.core.annotation.Mover;

@MovableObjectHandle("HikariDataSourceFactory")
public abstract class AbstractHikariDataSourceFactory implements MovableHikariDataSourceFactoryHandle {
  private static final Logger LOG = LoggerFactory.getLogger(AbstractHikariDataSourceFactory.class);

  @Mover
  @Override
  public HikariDataSourceHandle create(HikariDataSourcePropertiesHandle properties) {
    var config = new HikariConfig();
    config.setJdbcUrl(properties.url().trim());
    config.setUsername(properties.username().trim());
    config.setPassword(properties.password().trim());
    var hds = new com.zaxxer.hikari.HikariDataSource(config);
    return new HikariDataSource(hds, properties);
  }
}
