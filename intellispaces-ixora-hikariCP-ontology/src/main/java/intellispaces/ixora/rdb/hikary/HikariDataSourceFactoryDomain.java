package intellispaces.ixora.rdb.hikary;

import intellispaces.framework.core.annotation.Channel;
import intellispaces.framework.core.annotation.Domain;
import intellispaces.framework.core.annotation.Factory;
import intellispaces.framework.core.annotation.Movable;
import intellispaces.framework.core.traverse.TraverseTypes;

@Domain("7aae1f0c-1d54-43a3-a9f8-fc32bbb6891e")
public interface HikariDataSourceFactoryDomain {

  @Factory
  @Channel(
      value = "16b62a7e-4c8c-4d41-bd44-36581db13589",
      allowedTraverse = TraverseTypes.MappingOfMoving
  )
  @Movable
  HikariDataSourceDomain create(HikariDataSourcePropertiesDomain properties);
}
