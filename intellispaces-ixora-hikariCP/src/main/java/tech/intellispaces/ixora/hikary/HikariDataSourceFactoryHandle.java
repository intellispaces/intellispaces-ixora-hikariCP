package tech.intellispaces.ixora.hikary;

import com.zaxxer.hikari.HikariConfig;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryDomain;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;
import tech.intellispaces.ixora.rdb.hikary.MovableHikariDataSource;
import tech.intellispaces.ixora.rdb.hikary.MovableHikariDataSourceFactory;
import tech.intellispaces.jaquarius.annotation.MapperOfMoving;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;

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
