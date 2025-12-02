package kz.seisen.rpo.mappers;


import kz.seisen.rpo.dto.CountryDto;
import kz.seisen.rpo.models.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "codeDto", source = "code")
    CountryDto toDto(Country country);

    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "code", source = "codeDto")
    Country toEntity(CountryDto dto);


    List<CountryDto> toDtoList(List<Country> countries);
}
