package tech.mindstructs.hikary;

import com.zaxxer.hikari.HikariConfig;
import intellispaces.ixora.mindstructs.rdb.hikary.HikariDataSourceHandle;
import intellispaces.ixora.mindstructs.rdb.hikary.HikariDataSourceProperties;
import intellispaces.ixora.mindstructs.rdb.hikary.MovableHikariDataSourceFactoryHandle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.intellispaces.framework.core.annotation.Mover;
import tech.intellispaces.framework.core.annotation.ObjectHandle;

@ObjectHandle("HikariDataSource")
public abstract class AbstractHikariDataSourceFactory implements MovableHikariDataSourceFactoryHandle {
  private static final Logger LOG = LoggerFactory.getLogger(AbstractHikariDataSourceFactory.class);

  @Mover
  @Override
  public HikariDataSourceHandle create(HikariDataSourceProperties properties) {
    var config = new HikariConfig();
    config.setJdbcUrl(properties.url().trim());
    config.setUsername(properties.username().trim());
    config.setPassword(properties.password().trim());
    var hds = new com.zaxxer.hikari.HikariDataSource(config);
    return new HikariDataSource(hds, properties);
  }
}
