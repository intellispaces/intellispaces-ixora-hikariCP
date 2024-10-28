package intellispaces.ixora.hikary;

import intellispaces.jaquarius.annotation.Configuration;
import intellispaces.jaquarius.annotation.Projection;
import intellispaces.jaquarius.annotation.Properties;
import intellispaces.ixora.rdb.hikary.HikariDataSource;
import intellispaces.ixora.rdb.hikary.HikariDataSourceFactory;
import intellispaces.ixora.rdb.hikary.HikariDataSourceProperties;

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
