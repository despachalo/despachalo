package pe.despachalo.app.company.adapters.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pe.despachalo.app.company.Company;
import pe.despachalo.app.company.GetAllCompaniesService;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "companies")
@RequiredArgsConstructor
public class GetAllCompaniesController {
  private final GetAllCompaniesService getAllCompaniesService;

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  Flux<Company> getAllCompanies() {
    return getAllCompaniesService.execute();
  }
}
