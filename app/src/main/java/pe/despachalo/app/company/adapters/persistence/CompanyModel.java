package pe.despachalo.app.company.adapters.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("COMPANY")
@NoArgsConstructor
public class CompanyModel {
  @Id
  private Long id;
  private String businessName;
  private String ruc;
}
