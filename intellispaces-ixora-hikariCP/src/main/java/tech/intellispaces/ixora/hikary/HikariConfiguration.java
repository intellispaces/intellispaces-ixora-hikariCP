package tech.intellispaces.ixora.hikary;

import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryHandle;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceHandle;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceSettingsHandle;
import tech.intellispaces.jaquarius.annotation.Configuration;
import tech.intellispaces.jaquarius.annotation.Projection;
import tech.intellispaces.jaquarius.annotation.Settings;

@Configuration
public abstract class HikariConfiguration {

  @Projection
  @Settings("datasource")
  public abstract HikariDataSourceSettingsHandle hikariDataSourceSettings();

  @Projection
  public HikariDataSourceFactoryHandle hikariDataSourceFactory() {
    return new HikariDataSourceFactoryHandleImpl();
  }

  @Projection
  public HikariDataSourceHandle dataSource(
      HikariDataSourceFactoryHandle hikariDataSourceFactory,
      HikariDataSourceSettingsHandle hikariDataSourceSettings
  ) {
    return hikariDataSourceFactory
        .asMovableOrElseThrow()
        .create(hikariDataSourceSettings)
        .asMovableOrElseThrow();
  }
}
