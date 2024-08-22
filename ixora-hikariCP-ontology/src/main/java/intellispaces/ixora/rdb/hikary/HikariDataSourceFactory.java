package intellispaces.ixora.rdb.hikary;

import tech.intellispaces.core.annotation.Domain;
import tech.intellispaces.core.annotation.Factory;
import tech.intellispaces.core.annotation.Transition;
import tech.intellispaces.core.traverse.TraverseTypes;

@Factory
@Domain("7aae1f0c-1d54-43a3-a9f8-fc32bbb6891e")
public interface HikariDataSourceFactory {

  @Transition(value = "16b62a7e-4c8c-4d41-bd44-36581db13589", allowedTraverseTypes = TraverseTypes.Moving, factory = true)
  HikariDataSource create(HikariDataSourceProperties properties);
}
