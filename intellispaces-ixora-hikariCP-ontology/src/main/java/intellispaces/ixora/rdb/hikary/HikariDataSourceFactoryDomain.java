package intellispaces.ixora.rdb.hikary;

import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Factory;
import intellispaces.framework.core.annotation.Transition;
import intellispaces.framework.core.traverse.TraverseTypes;

@Factory
@Domain("7aae1f0c-1d54-43a3-a9f8-fc32bbb6891e")
public interface HikariDataSourceFactoryDomain {

  @Transition(value = "16b62a7e-4c8c-4d41-bd44-36581db13589", allowedTraverse = TraverseTypes.MovingThenMapping)
  HikariDataSourceDomain create(HikariDataSourcePropertiesDomain properties);
}
