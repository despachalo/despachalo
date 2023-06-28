package pe.despachalo.app.modules.center.domain;

import pe.despachalo.app.modules.common.domain.Location;

public record DistributionCenter(
    Long id,
    String name,
    String address,
    Location location
) {
}
