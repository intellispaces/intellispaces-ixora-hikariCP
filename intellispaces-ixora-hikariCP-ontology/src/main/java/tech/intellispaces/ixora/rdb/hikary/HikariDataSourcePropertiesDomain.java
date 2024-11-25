package tech.intellispaces.ixora.rdb.hikary;

import tech.intellispaces.ixora.rdb.DataSourcePropertiesDomain;
import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Data;
import tech.intellispaces.jaquarius.annotation.Domain;

@Data
@Domain("3094f25e-798b-4bf9-a84c-7e581522060a")
public interface HikariDataSourcePropertiesDomain extends DataSourcePropertiesDomain {

  @Channel("c6a1f862-1752-4e60-acf6-880c29cfd727")
  DataSourcePropertiesDomain asDataSourceProperties();
}

