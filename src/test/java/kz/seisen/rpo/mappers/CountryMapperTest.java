package kz.seisen.rpo.mappers;

import kz.seisen.rpo.dto.CategoryDto;
import kz.seisen.rpo.dto.CountryDto;
import kz.seisen.rpo.dto.ItemDto;
import kz.seisen.rpo.models.Category;
import kz.seisen.rpo.models.Country;
import kz.seisen.rpo.models.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CountryMapperTest {



    @Autowired
    private CountryMapper mapper;


    @Test
    void convertEntityToDtoTest() {

        Country entity = new Country(1L, "country", "code");


        CountryDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getCodeDto());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getCodeDto(), entity.getCode());


    }

    @Test
    void convertDtoToEntityTest() {
        CountryDto dto = new CountryDto(1L, "country", "code");


        Country entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());
        Assertions.assertNotNull(entity.getCode());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getCodeDto(), entity.getCode());


    }


    @Test
    void convertEntityListToDtoListTest() {



        List<Country> entities = new ArrayList<>();
        entities.add(new Country(1L, "test1", "codetest1"));
        entities.add(new Country(2L, "test2", "codetest2"));
        entities.add(new Country(3L, "test3", "codetest3"));

        List<CountryDto> dtos = mapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(dtos.size(), entities.size());

        for ( int i = 0; i < dtos.size(); i++) {
            Country entity = entities.get(i);
            CountryDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getCodeDto());



            Assertions.assertEquals(dto.getId(), entity.getId());
            Assertions.assertEquals(dto.getNameDto(), entity.getName());
            Assertions.assertEquals(dto.getCodeDto(), entity.getCode());


        }

    }
}
