package intellispaces.ixora.hikary;

import intellispaces.ixora.rdb.hikary.HikariDataSourceFactoryHandle;
import intellispaces.ixora.rdb.hikary.HikariDataSourceHandle;
import intellispaces.ixora.rdb.hikary.HikariDataSourcePropertiesHandle;
import intellispaces.core.annotation.Configuration;
import intellispaces.core.annotation.Projection;
import intellispaces.core.annotation.Properties;

@Configuration
public abstract class HikariConfiguration {

  @Projection
  @Properties("datasource")
  public abstract HikariDataSourcePropertiesHandle hikariDataSourceProperties();

  @Projection
  public HikariDataSourceFactoryHandle hikariDataSourceFactory() {
    return new HikariDataSourceFactory();
  }

  @Projection
  public HikariDataSourceHandle dataSource(
      HikariDataSourceFactoryHandle hikariDataSourceFactory,
      HikariDataSourcePropertiesHandle hikariDataSourceProperties
  ) {
    return hikariDataSourceFactory.create(hikariDataSourceProperties).asMovableOrElseThrow();
  }
}
