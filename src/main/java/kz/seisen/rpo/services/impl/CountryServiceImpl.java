package kz.seisen.rpo.services.impl;



import kz.seisen.rpo.dto.CountryDto;
import kz.seisen.rpo.mappers.CountryMapper;
import kz.seisen.rpo.models.Country;
import kz.seisen.rpo.repositories.CountryRepository;
import kz.seisen.rpo.services.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {


    private final CountryRepository repository;
    private final CountryMapper mapper;



    public List<CountryDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


    public CountryDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }


    public CountryDto create(CountryDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }


    public CountryDto update(Long id, CountryDto dto) {

        CountryDto oldCountry = getById(id);

        if (Objects.isNull(oldCountry) || Objects.isNull(dto)) {
            return null;
        }

        oldCountry.setNameDto(dto.getNameDto());
        oldCountry.setCodeDto(dto.getCodeDto());

        return mapper.toDto(repository.save(mapper.toEntity(oldCountry)));


    }


    public boolean delete(Long id) {
        repository.deleteById(id);
        Country country = repository.findById(id).orElse(null);

        if (Objects.isNull(country)) {
            return true;
        }

        return false;
    }
}
