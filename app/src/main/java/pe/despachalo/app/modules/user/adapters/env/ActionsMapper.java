package pe.despachalo.app.modules.user.adapters.env;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.despachalo.app.modules.user.domain.Action;

@Mapper(componentModel = "spring")
public interface ActionsMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "description", source = "description")
  Action toAction(PermissionProps.Action action);
}
