package pe.despachalo.app.modules.company.adapters.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CompanyReactiveRepository extends ReactiveCrudRepository<CompanyModel, Long> {
}
