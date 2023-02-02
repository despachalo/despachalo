package pe.despachalo.app.company.adapters.persistence;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyReactiveRepository extends ReactiveCrudRepository<CompanyModel, Long> {
}
