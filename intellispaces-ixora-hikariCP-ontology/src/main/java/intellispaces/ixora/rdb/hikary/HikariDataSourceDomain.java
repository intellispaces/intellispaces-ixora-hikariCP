package intellispaces.ixora.rdb.hikary;

import intellispaces.ixora.rdb.DataSourceDomain;
import intellispaces.jaquarius.annotation.Channel;
import intellispaces.jaquarius.annotation.Domain;

@Domain("01908c4f-942b-7715-a5a0-0d89c9aaebaf")
public interface HikariDataSourceDomain extends DataSourceDomain {

  @Channel("29dff81b-c679-49e2-9f0a-60e24ecfc342")
  DataSourceDomain asDataSource();

  @Channel("4167089f-3759-4187-85fb-5b324fcc2565")
  HikariDataSourcePropertiesDomain properties();
}
