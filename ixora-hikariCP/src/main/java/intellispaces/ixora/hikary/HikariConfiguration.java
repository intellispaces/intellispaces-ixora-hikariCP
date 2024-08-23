package intellispaces.ixora.hikary;

import intellispaces.core.annotation.Configuration;
import intellispaces.core.annotation.Projection;
import intellispaces.core.annotation.Properties;
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
    return new HikariDataSourceFactoryImpl();
  }

  @Projection
  public HikariDataSource dataSource(
      HikariDataSourceFactory hikariDataSourceFactory,
      HikariDataSourceProperties hikariDataSourceProperties
  ) {
    return hikariDataSourceFactory.create(hikariDataSourceProperties).asMovableOrElseThrow();
  }
}
