package pe.despachalo.app.company.adapters.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CompanyReactiveRepository extends ReactiveCrudRepository<CompanyModel, Long> {
}
