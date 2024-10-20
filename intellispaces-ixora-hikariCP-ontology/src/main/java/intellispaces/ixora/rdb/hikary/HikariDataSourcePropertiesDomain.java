package intellispaces.ixora.rdb.hikary;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Data;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.ixora.rdb.DataSourcePropertiesDomain;

@Data
@Domain("3094f25e-798b-4bf9-a84c-7e581522060a")
public interface HikariDataSourcePropertiesDomain extends DataSourcePropertiesDomain {

  @Channel("c6a1f862-1752-4e60-acf6-880c29cfd727")
  DataSourcePropertiesDomain asDataSourceProperties();
}

