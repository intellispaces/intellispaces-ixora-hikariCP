package intellispaces.ixora.hikary;

import intellispaces.framework.core.annotation.Configuration;
import intellispaces.framework.core.annotation.Projection;
import intellispaces.framework.core.annotation.Properties;
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
