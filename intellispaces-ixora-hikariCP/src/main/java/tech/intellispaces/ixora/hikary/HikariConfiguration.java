package tech.intellispaces.ixora.hikary;

import tech.intellispaces.ixora.rdb.hikary.HikariDataSource;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceFactory;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;
import tech.intellispaces.jaquarius.annotation.Configuration;
import tech.intellispaces.jaquarius.annotation.Projection;
import tech.intellispaces.jaquarius.annotation.Properties;

@Configuration
public abstract class HikariConfiguration {

  @Projection
  @Properties("datasource")
  public abstract HikariDataSourceProperties hikariDataSourceProperties();

  @Projection
  public HikariDataSourceFactory hikariDataSourceFactory() {
    return new HikariDataSourceFactoryHandleImpl();
  }

  @Projection
  public HikariDataSource dataSource(
      HikariDataSourceFactory hikariDataSourceFactory,
      HikariDataSourceProperties hikariDataSourceProperties
  ) {
    return hikariDataSourceFactory
        .asMovableOrElseThrow()
        .create(hikariDataSourceProperties)
        .asMovableOrElseThrow();
  }
}
