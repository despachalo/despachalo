package pe.despachalo.app.modules.center.adapters.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;

@Mapper(componentModel = "spring")
public interface DistributionCenterMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "name")
  @Mapping(target = "address", source = "address")
  @Mapping(target = "location.latitude", source = "latitude")
  @Mapping(target = "location.longitude", source = "longitude")
  DistributionCenter toDistributionCenter(DistributionCenterModel model);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "name", source = "name")
  @Mapping(target = "address", source = "address")
  @Mapping(target = "longitude", source = "location.longitude")
  @Mapping(target = "latitude", source = "location.latitude")
  DistributionCenterModel toDistributionCenterModel(DistributionCenterToRegister toRegister);
}
