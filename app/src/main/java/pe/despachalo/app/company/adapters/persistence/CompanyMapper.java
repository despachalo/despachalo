package pe.despachalo.app.company.adapters.persistence;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.despachalo.app.company.Company;
import pe.despachalo.app.company.CompanyToRegister;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

  @Mapping(target = "id", source = "id")
  @Mapping(target = "businessName", source = "businessName")
  @Mapping(target = "ruc", source = "ruc")
  Company toCustomer(CompanyModel companyModel);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "businessName", source = "businessName")
  @Mapping(target = "ruc", source = "ruc")
  CompanyModel toCompanyModel(CompanyToRegister companyToRegister);
}
