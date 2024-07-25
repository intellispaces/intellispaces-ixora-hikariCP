package tech.mindstructs.hikary;

import intellispaces.ixora.mindstructs.rdb.hikary.HikariDataSourcePropertiesHandle;
import tech.intellispaces.framework.core.annotation.Configuration;
import tech.intellispaces.framework.core.annotation.Projection;

@Configuration
public class HikariConfiguration {

  @Projection
  public HikariDataSource dataSource(HikariDataSourcePropertiesHandle dataSourceProperties) {
    return new HikariDataSource(dataSourceProperties);
  }
}
