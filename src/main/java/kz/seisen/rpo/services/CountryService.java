package kz.seisen.rpo.services;



import kz.seisen.rpo.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> getAll();
    CountryDto getById(Long id);
    CountryDto create(CountryDto dto);
    CountryDto update(Long id, CountryDto dto);
    boolean delete(Long id);
}
