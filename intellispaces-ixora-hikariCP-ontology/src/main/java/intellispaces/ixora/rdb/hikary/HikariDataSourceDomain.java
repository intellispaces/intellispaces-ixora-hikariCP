package intellispaces.ixora.rdb.hikary;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Transition;
import intellispaces.ixora.rdb.DataSourceDomain;

@Domain("01908c4f-942b-7715-a5a0-0d89c9aaebaf")
public interface HikariDataSourceDomain extends DataSourceDomain {

  @Transition("4167089f-3759-4187-85fb-5b324fcc2565")
  HikariDataSourcePropertiesDomain properties();
}
