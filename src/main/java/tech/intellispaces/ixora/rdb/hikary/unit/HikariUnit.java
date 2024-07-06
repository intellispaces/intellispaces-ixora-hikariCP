package tech.intellispaces.ixora.rdb.hikary.unit;

import tech.intellispaces.framework.core.annotation.Projection;
import tech.intellispaces.framework.core.annotation.Unit;
import tech.intellispaces.ixora.rdb.DataSourceMovableHandle;
import tech.intellispaces.ixora.rdb.DataSourcePropertiesHandle;
import tech.intellispaces.ixora.rdb.hikary.HikariDataSource;

@Unit
public class HikariUnit {

  @Projection
  public DataSourceMovableHandle dataSource(DataSourcePropertiesHandle dataSourceProperties) {
    return new HikariDataSource(dataSourceProperties);
  }
}
