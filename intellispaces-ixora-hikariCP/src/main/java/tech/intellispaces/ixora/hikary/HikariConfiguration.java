package tech.intellispaces.ixora.hikary;

import tech.intellispaces.ixora.rdb.hikary.HikariDataSource;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceFactory;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceSettings;
import tech.intellispaces.jaquarius.annotation.Configuration;
import tech.intellispaces.jaquarius.annotation.Projection;
import tech.intellispaces.jaquarius.annotation.Settings;

@Configuration
public abstract class HikariConfiguration {

  @Projection
  @Settings("datasource")
  public abstract HikariDataSourceSettings hikariDataSourceSettings();

  @Projection
  public HikariDataSourceFactory hikariDataSourceFactory() {
    return new HikariDataSourceFactoryHandleImpl();
  }

  @Projection
  public HikariDataSource dataSource(
      HikariDataSourceFactory hikariDataSourceFactory,
      HikariDataSourceSettings hikariDataSourceSettings
  ) {
    return hikariDataSourceFactory
        .asMovableOrElseThrow()
        .create(hikariDataSourceSettings)
        .asMovableOrElseThrow();
  }
}
