package tech.intellispaces.ixora.hikary;

import com.zaxxer.hikari.HikariConfig;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryDomain;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceSettingsHandle;
import tech.intellispaces.ixora.rdb.hikary.MovableHikariDataSourceFactoryHandle;
import tech.intellispaces.ixora.rdb.hikary.MovableHikariDataSourceHandle;
import tech.intellispaces.jaquarius.annotation.MapperOfMoving;
import tech.intellispaces.jaquarius.annotation.ObjectHandle;

@ObjectHandle(HikariDataSourceFactoryDomain.class)
public abstract class HikariDataSourceFactoryHandle implements MovableHikariDataSourceFactoryHandle {

  @Override
  @MapperOfMoving
  public MovableHikariDataSourceHandle create(HikariDataSourceSettingsHandle settings) {
    var config = new HikariConfig();
    config.setJdbcUrl(settings.url().trim());
    config.setUsername(settings.username().trim());
    config.setPassword(settings.password().trim());
    var hds = new com.zaxxer.hikari.HikariDataSource(config);
    return new HikariDataSourceHandleImpl(hds, settings);
  }
}
