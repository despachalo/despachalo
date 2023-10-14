package pe.despachalo.app.modules.user.adapters.web;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.despachalo.app.modules.common.hexagonal.WebAdapter;
import pe.despachalo.app.modules.user.GetAllActionsByModuleService;
import pe.despachalo.app.modules.user.domain.ModuleWithActions;
import reactor.core.publisher.Flux;

@WebAdapter
@RestController
@RequestMapping(value = "users")
@RequiredArgsConstructor
public class GetAllActionsByModuleController {
  private final GetAllActionsByModuleService getAllActionsByModuleService;

  @Operation(summary = "get all actions available in the system, grouped by module")
  @ResponseStatus(HttpStatus.OK)
  @GetMapping(value = "/modules/actions", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Flux<ModuleWithActions> getAllByModule() {
    return getAllActionsByModuleService.execute();
  }
}
