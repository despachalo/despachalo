package pe.despachalo.app.modules.center.adapters.persistence;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("distribution_center")
@NoArgsConstructor
public class DistributionCenterModel {
  @Id
  private Long id;

  @Column("name")
  private String name;

  @Column("address")
  private String address;

  @Column("geo_coord_longitude")
  private Double longitude;

  @Column("geo_coord_latitude")
  private Double latitude;
}
