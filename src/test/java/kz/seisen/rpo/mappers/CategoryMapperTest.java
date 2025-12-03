package kz.seisen.rpo.mappers;

import kz.seisen.rpo.dto.CategoryDto;
import kz.seisen.rpo.dto.CountryDto;
import kz.seisen.rpo.models.Category;
import kz.seisen.rpo.models.Country;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    private CategoryMapper mapper;


    @Test
    void convertEntityToDtoTest() {

        Category entity = new Category(1L, "test");


        CategoryDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());



    }

    @Test
    void convertDtoToEntityTest() {
        CategoryDto dto = new CategoryDto(1L, "test");


        Category entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());

        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());


    }


    @Test
    void convertEntityListToDtoListTest() {



        List<Category> entities = new ArrayList<>();
        entities.add(new Category(1L, "test1"));
        entities.add(new Category(2L, "test2"));
        entities.add(new Category(3L, "test3"));

        List<CategoryDto> dtos = mapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(dtos.size(), entities.size());

        for ( int i = 0; i < dtos.size(); i++) {
            Category entity = entities.get(i);
            CategoryDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());

            Assertions.assertEquals(dto.getId(), entity.getId());
            Assertions.assertEquals(dto.getNameDto(), entity.getName());


        }

    }
}
