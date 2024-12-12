package tech.intellispaces.ixora.rdb.hikary;

import tech.intellispaces.jaquarius.annotation.Channel;
import tech.intellispaces.jaquarius.annotation.Domain;
import tech.intellispaces.jaquarius.annotation.Factory;
import tech.intellispaces.jaquarius.annotation.Movable;
import tech.intellispaces.jaquarius.traverse.TraverseTypes;

@Domain("7aae1f0c-1d54-43a3-a9f8-fc32bbb6891e")
public interface HikariDataSourceFactoryDomain {

  @Factory
  @Channel(
      value = "16b62a7e-4c8c-4d41-bd44-36581db13589",
      allowedTraverse = TraverseTypes.MappingOfMoving
  )
  @Movable
  HikariDataSourceDomain create(HikariDataSourceSettingsDomain properties);
}
