package pe.despachalo.app.modules.center.adapters.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.despachalo.app.modules.center.RegisterDistributionCenterService;
import pe.despachalo.app.modules.center.domain.DistributionCenter;
import pe.despachalo.app.modules.center.domain.DistributionCenterToRegister;
import pe.despachalo.app.modules.common.hexagonal.WebAdapter;
import reactor.core.publisher.Mono;

@WebAdapter
@RestController
@RequestMapping(value = "distribution-center")
@RequiredArgsConstructor
public class RegisterDistributionCenterController {
  private final RegisterDistributionCenterService registerDistributionCenterService;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  Mono<DistributionCenter> registerCompany(@Valid @RequestBody DistributionCenterToRegister distributionCenterToRegister) {
    return registerDistributionCenterService.execute(distributionCenterToRegister);
  }
}
