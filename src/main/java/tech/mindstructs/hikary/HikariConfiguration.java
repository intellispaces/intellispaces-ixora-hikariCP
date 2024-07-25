package tech.mindstructs.hikary;

import intellispaces.ixora.mindstructs.rdb.hikary.HikariDataSourceFactory;
import intellispaces.ixora.mindstructs.rdb.hikary.HikariDataSourceFactoryHandle;
import intellispaces.ixora.mindstructs.rdb.hikary.HikariDataSourcePropertiesHandle;
import tech.intellispaces.framework.core.annotation.Configuration;
import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.framework.core.annotation.Properties;

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
  public HikariDataSource dataSource(
      HikariDataSourceFactoryHandle hikariDataSourceFactory,
      HikariDataSourcePropertiesHandle hikariDataSourceProperties
  ) {
    return hikariDataSourceFactory.create(hikariDataSourceProperties);
  }
}
