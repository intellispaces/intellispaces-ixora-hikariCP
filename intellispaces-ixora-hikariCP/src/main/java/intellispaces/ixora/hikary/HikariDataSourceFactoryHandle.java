package intellispaces.ixora.hikary;

import com.zaxxer.hikari.HikariConfig;
import intellispaces.jaquarius.annotation.MapperOfMoving;
import intellispaces.jaquarius.annotation.ObjectHandle;
import intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryDomain;
import intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;
import intellispaces.ixora.rdb.hikary.MovableHikariDataSource;
import intellispaces.ixora.rdb.hikary.MovableHikariDataSourceFactory;

@ObjectHandle(HikariDataSourceFactoryDomain.class)
public abstract class HikariDataSourceFactoryHandle implements MovableHikariDataSourceFactory {

  @Override
  @MapperOfMoving
  public MovableHikariDataSource create(HikariDataSourceProperties properties) {
    var config = new HikariConfig();
    config.setJdbcUrl(properties.url().trim());
    config.setUsername(properties.username().trim());
    config.setPassword(properties.password().trim());
    var hds = new com.zaxxer.hikari.HikariDataSource(config);
    return new HikariDataSourceHandleImpl(hds, properties);
  }
}
