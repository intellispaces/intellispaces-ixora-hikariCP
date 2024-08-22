package intellispaces.ixora.rdb.hikary;

import intellispaces.core.annotation.Domain;
import intellispaces.ixora.rdb.DataSource;
import intellispaces.core.annotation.Transition;

@Domain("01908c4f-942b-7715-a5a0-0d89c9aaebaf")
public interface HikariDataSource extends DataSource {

  @Transition("4167089f-3759-4187-85fb-5b324fcc2565")
  HikariDataSourceProperties properties();
}
