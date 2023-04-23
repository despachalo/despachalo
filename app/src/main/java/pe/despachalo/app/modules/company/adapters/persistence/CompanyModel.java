package pe.despachalo.app.modules.company.adapters.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("company")
@NoArgsConstructor
public class CompanyModel {
  @Id
  private Long id;

  @Column("business_name")
  private String businessName;

  @Column("ruc")
  private String ruc;
}
