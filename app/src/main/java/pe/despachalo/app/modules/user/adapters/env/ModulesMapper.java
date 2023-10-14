package pe.despachalo.app.modules.user.adapters.env;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.despachalo.app.modules.user.domain.ModuleWithActions;

@Mapper(componentModel = "spring", uses = {ActionsMapper.class})
public interface ModulesMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "description", source = "description")
  @Mapping(target = "actionsAllowed", source = "actions")
  ModuleWithActions toModuleWithActions(PermissionProps.Module module);
}
