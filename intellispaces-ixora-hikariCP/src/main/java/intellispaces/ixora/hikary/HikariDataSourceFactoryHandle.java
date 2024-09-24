package intellispaces.ixora.hikary;

import com.zaxxer.hikari.HikariConfig;
import intellispaces.framework.core.annotation.MapperOfMoving;
import intellispaces.framework.core.annotation.ObjectHandle;
import intellispaces.ixora.rdb.hikary.HikariDataSource;
import intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryDomain;
import intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;
import intellispaces.ixora.rdb.hikary.MovableHikariDataSourceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ObjectHandle(value = HikariDataSourceFactoryDomain.class, name = "HikariDataSourceFactoryHandleImpl")
public abstract class HikariDataSourceFactoryHandle implements MovableHikariDataSourceFactory {
  private static final Logger LOG = LoggerFactory.getLogger(HikariDataSourceFactoryHandle.class);

  @Override
  @MapperOfMoving
  public HikariDataSource create(HikariDataSourceProperties properties) {
    var config = new HikariConfig();
    config.setJdbcUrl(properties.url().trim());
    config.setUsername(properties.username().trim());
    config.setPassword(properties.password().trim());
    var hds = new com.zaxxer.hikari.HikariDataSource(config);
    return new HikariDataSourceHandleImpl(hds, properties);
  }
}
