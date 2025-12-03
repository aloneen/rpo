package kz.seisen.rpo.services;


import kz.seisen.rpo.dto.CategoryDto;
import kz.seisen.rpo.dto.CountryDto;
import kz.seisen.rpo.dto.ItemDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class ItemServiceTest {

    @Autowired
    private ItemService service;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void getAllTest() {

        List<ItemDto> dtos = service.getAll();


        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (ItemDto dto : dtos) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getPriceDto());
            Assertions.assertNotNull(dto.getCountryDto());
            Assertions.assertNotNull(dto.getCategoryDtos());
        }

    }


    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        ItemDto dto = service.getById(someIndex);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getPriceDto());
        Assertions.assertNotNull(dto.getCountryDto());
        Assertions.assertNotNull(dto.getCategoryDtos());

    }


    @Test
    void addTest() {

        int before = service.getAll().size();


        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setNameDto("Test-Categ");
        CategoryDto savedCategory = categoryService.create(categoryDto);
        CountryDto countryDto = new CountryDto();
        countryDto.setNameDto("Test-Country");
        countryDto.setCodeDto("Test-code");
        CountryDto savedCountry = countryService.create(countryDto);

        ItemDto itemDto = new ItemDto();
        itemDto.setNameDto("TestName");
        itemDto.setPriceDto(1333);
        itemDto.setCountryDto(savedCountry);
        itemDto.setCategoryDtos(List.of(savedCategory));
        ItemDto savedItem = service.create(itemDto);

        Assertions.assertNotNull(savedItem);
        Assertions.assertNotNull(savedItem.getId());
        Assertions.assertNotNull(savedItem.getNameDto());
        Assertions.assertNotNull(savedItem.getPriceDto());
        Assertions.assertNotNull(savedItem.getCountryDto());
        Assertions.assertNotNull(savedItem.getCategoryDtos());

        ItemDto savedTest = service.getById(savedItem.getId());

        Assertions.assertNotNull(savedTest);
        Assertions.assertNotNull(savedTest.getId());
        Assertions.assertNotNull(savedTest.getNameDto());
        Assertions.assertNotNull(savedTest.getPriceDto());
        Assertions.assertNotNull(savedTest.getCountryDto());
        Assertions.assertNotNull(savedTest.getCategoryDtos());

        Assertions.assertEquals(savedItem.getId(), savedTest.getId());
        Assertions.assertEquals(savedItem.getNameDto(), savedTest.getNameDto());
        Assertions.assertEquals(savedItem.getPriceDto(), savedTest.getPriceDto());
        Assertions.assertEquals(savedItem.getCategoryDtos(), savedTest.getCategoryDtos());
        Assertions.assertEquals(savedItem.getCategoryDtos(), savedTest.getCategoryDtos());

        int after = service.getAll().size();
        Assertions.assertEquals(before+1, after);




    }

    @Test
    void updateTest() {

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        ItemDto current = service.getById(someIndex);

        ItemDto newItem = new ItemDto(someIndex, "TestUpdate", 200, current.getCountryDto(), current.getCategoryDtos());

        ItemDto updated = service.update(someIndex, newItem);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getPriceDto());
        Assertions.assertNotNull(updated.getCountryDto());
        Assertions.assertNotNull(updated.getCategoryDtos());

        ItemDto updateTest = service.getById(someIndex);

        Assertions.assertNotNull(updateTest);
        Assertions.assertNotNull(updateTest.getId());
        Assertions.assertNotNull(updateTest.getNameDto());
        Assertions.assertNotNull(updateTest.getPriceDto());
        Assertions.assertNotNull(updateTest.getCountryDto());
        Assertions.assertNotNull(updateTest.getCategoryDtos());

        Assertions.assertEquals(updated.getId(), updateTest.getId());
        Assertions.assertEquals(updated.getNameDto(), updateTest.getNameDto());
        Assertions.assertEquals(updated.getPriceDto(), updateTest.getPriceDto());
        Assertions.assertEquals(updated.getCountryDto(), updateTest.getCountryDto());
        Assertions.assertEquals(updated.getCategoryDtos(), updateTest.getCategoryDtos());



    }


    @Test
    void deleteTest() {
        int before = service.getAll().size();

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();

        boolean deleted = service.delete(someIndex);
        Assertions.assertTrue(deleted);

        ItemDto deletedTest = service.getById(someIndex);
        Assertions.assertNull(deletedTest);


        int after = service.getAll().size();
        Assertions.assertEquals(before-1,after);



    }

}
