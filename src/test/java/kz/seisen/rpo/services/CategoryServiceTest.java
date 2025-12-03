package kz.seisen.rpo.services;


import kz.seisen.rpo.dto.CategoryDto;
import kz.seisen.rpo.dto.CountryDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class CategoryServiceTest {


    @Autowired
    private CategoryService service;


    @Test
    void getAllTest() {

        List<CategoryDto> dtos = service.getAll();


        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (CategoryDto dto : dtos) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
        }

    }


    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        CategoryDto dto = service.getById(someIndex);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());



    }


    @Test
    void addTest() {

        int before = service.getAll().size();


        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setNameDto("Test-Country");

        CategoryDto saved = service.create(categoryDto);



        Assertions.assertNotNull(saved);
        Assertions.assertNotNull(saved.getId());
        Assertions.assertNotNull(saved.getNameDto());



        CategoryDto savedTest = service.getById(saved.getId());

        Assertions.assertNotNull(savedTest);
        Assertions.assertNotNull(savedTest.getId());
        Assertions.assertNotNull(savedTest.getNameDto());



        Assertions.assertEquals(saved.getId(), savedTest.getId());
        Assertions.assertEquals(saved.getNameDto(), savedTest.getNameDto());


        int after = service.getAll().size();
        Assertions.assertEquals(before+1, after);



    }

    @Test
    void updateTest() {

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();



        CategoryDto newCat = new CategoryDto(someIndex, "TestUpdate");

        CategoryDto updated = service.update(someIndex, newCat);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());



        CategoryDto updateTest = service.getById(someIndex);

        Assertions.assertNotNull(updateTest);
        Assertions.assertNotNull(updateTest.getId());
        Assertions.assertNotNull(updateTest.getNameDto());



        Assertions.assertEquals(updated.getId(), updateTest.getId());
        Assertions.assertEquals(updated.getNameDto(), updateTest.getNameDto());


    }


    @Test
    void deleteTest() {
        int before = service.getAll().size();

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();

        boolean deleted = service.delete(someIndex);
        Assertions.assertTrue(deleted);

        CategoryDto deletedTest = service.getById(someIndex);
        Assertions.assertNull(deletedTest);


        int after = service.getAll().size();
        Assertions.assertEquals(before-1,after);



    }

}
