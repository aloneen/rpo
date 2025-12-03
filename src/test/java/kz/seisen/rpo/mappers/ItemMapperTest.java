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
public class ItemMapperTest {

    @Autowired
    private ItemMapper mapper;


    @Test
    void convertEntityToDtoTest() {
        Category category = new Category(1L, "Cat");
        Country country = new Country(1L, "country", "code");
        Item entity = new Item(1L, "Name", 234, country, List.of(category));

        ItemDto dto = mapper.toDto(entity);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getPriceDto());
        Assertions.assertNotNull(dto.getCountryDto());
        Assertions.assertNotNull(dto.getCategoryDtos());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getPriceDto(), entity.getPrice());

        Assertions.assertEquals(dto.getCountryDto().getId(), entity.getCountry().getId());
        Assertions.assertEquals(dto.getCountryDto().getNameDto(), entity.getCountry().getName());
        Assertions.assertEquals(dto.getCountryDto().getCodeDto(), entity.getCountry().getCode());


        Assertions.assertEquals(dto.getCategoryDtos().size(), entity.getCategories().size());
        for (int i = 0; i < dto.getCategoryDtos().size(); i ++) {
            Assertions.assertEquals(dto.getCategoryDtos().get(i).getId(), entity.getCategories().get(i).getId());
            Assertions.assertEquals(dto.getCategoryDtos().get(i).getNameDto(), entity.getCategories().get(i).getName());
        }

    }

    @Test
    void convertDtoToEntityTest() {
        CategoryDto category = new CategoryDto(1L, "Cat");
        CountryDto country = new CountryDto(1L, "country", "code");
        ItemDto dto = new ItemDto(1L, "Name", 234, country, List.of(category));

        Item entity = mapper.toEntity(dto);

        Assertions.assertNotNull(entity);
        Assertions.assertNotNull(entity.getId());
        Assertions.assertNotNull(entity.getName());
        Assertions.assertNotNull(entity.getPrice());
        Assertions.assertNotNull(entity.getCountry());
        Assertions.assertNotNull(entity.getCategories());


        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getNameDto(), entity.getName());
        Assertions.assertEquals(dto.getPriceDto(), entity.getPrice());

        Assertions.assertEquals(dto.getCountryDto().getId(), entity.getCountry().getId());
        Assertions.assertEquals(dto.getCountryDto().getNameDto(), entity.getCountry().getName());
        Assertions.assertEquals(dto.getCountryDto().getCodeDto(), entity.getCountry().getCode());


        Assertions.assertEquals(dto.getCategoryDtos().size(), entity.getCategories().size());
        for (int i = 0; i < dto.getCategoryDtos().size(); i ++) {
            Assertions.assertEquals(dto.getCategoryDtos().get(i).getId(), entity.getCategories().get(i).getId());
            Assertions.assertEquals(dto.getCategoryDtos().get(i).getNameDto(), entity.getCategories().get(i).getName());
        }

    }


    @Test
    void convertEntityListToDtoListTest() {
        Category category = new Category(1L, "Cat");
        Country country = new Country(1L, "country", "code");

        List<Item> entities = new ArrayList<>();
        entities.add(new Item(1L, "test1", 133, country, List.of(category)));
        entities.add(new Item(2L, "test2", 234, country, List.of(category)));
        entities.add(new Item(3L, "test3", 49494, country, List.of(category)));

        List<ItemDto> dtos = mapper.toDtoList(entities);

        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());
        Assertions.assertEquals(dtos.size(), entities.size());

        for ( int i = 0; i < dtos.size(); i++) {
            Item entity = entities.get(i);
            ItemDto dto = dtos.get(i);

            Assertions.assertNotNull(dto);
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getPriceDto());
            Assertions.assertNotNull(dto.getCountryDto());
            Assertions.assertNotNull(dto.getCategoryDtos());


            Assertions.assertEquals(dto.getId(), entity.getId());
            Assertions.assertEquals(dto.getNameDto(), entity.getName());
            Assertions.assertEquals(dto.getPriceDto(), entity.getPrice());

            Assertions.assertEquals(dto.getCountryDto().getId(), entity.getCountry().getId());
            Assertions.assertEquals(dto.getCountryDto().getNameDto(), entity.getCountry().getName());
            Assertions.assertEquals(dto.getCountryDto().getCodeDto(), entity.getCountry().getCode());


            Assertions.assertEquals(dto.getCategoryDtos().size(), entity.getCategories().size());
            for (int j = 0; j < dto.getCategoryDtos().size(); j ++) {
                Assertions.assertEquals(dto.getCategoryDtos().get(j).getId(), entity.getCategories().get(j).getId());
                Assertions.assertEquals(dto.getCategoryDtos().get(j).getNameDto(), entity.getCategories().get(j).getName());
            }

        }

    }
}
