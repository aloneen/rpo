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
public class CountryServiceTest {

    @Autowired
    private CountryService service;


    @Test
    void getAllTest() {

        List<CountryDto> dtos = service.getAll();


        Assertions.assertNotNull(dtos);
        Assertions.assertNotEquals(0, dtos.size());

        for (CountryDto dto : dtos) {
            Assertions.assertNotNull(dto.getId());
            Assertions.assertNotNull(dto.getNameDto());
            Assertions.assertNotNull(dto.getCodeDto());
        }

    }


    @Test
    void getByIdTest(){
        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();


        CountryDto dto = service.getById(someIndex);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getNameDto());
        Assertions.assertNotNull(dto.getCodeDto());


    }


    @Test
    void addTest() {

        int before = service.getAll().size();


        CountryDto countryDto = new CountryDto();
        countryDto.setNameDto("Test-Country");
        countryDto.setCodeDto("Test-code");
        CountryDto savedCountry = service.create(countryDto);



        Assertions.assertNotNull(savedCountry);
        Assertions.assertNotNull(savedCountry.getId());
        Assertions.assertNotNull(savedCountry.getNameDto());
        Assertions.assertNotNull(savedCountry.getCodeDto());


        CountryDto savedTest = service.getById(savedCountry.getId());

        Assertions.assertNotNull(savedTest);
        Assertions.assertNotNull(savedTest.getId());
        Assertions.assertNotNull(savedTest.getNameDto());
        Assertions.assertNotNull(savedTest.getCodeDto());


        Assertions.assertEquals(savedCountry.getId(), savedTest.getId());
        Assertions.assertEquals(savedCountry.getNameDto(), savedTest.getNameDto());
        Assertions.assertEquals(savedCountry.getCodeDto(), savedTest.getCodeDto());


        int after = service.getAll().size();
        Assertions.assertEquals(before+1, after);




    }

    @Test
    void updateTest() {

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();



        CountryDto newCountry = new CountryDto(someIndex, "TestUpdate", "codeTest");

        CountryDto updated = service.update(someIndex, newCountry);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getNameDto());
        Assertions.assertNotNull(updated.getCodeDto());


        CountryDto updateTest = service.getById(someIndex);

        Assertions.assertNotNull(updateTest);
        Assertions.assertNotNull(updateTest.getId());
        Assertions.assertNotNull(updateTest.getNameDto());
        Assertions.assertNotNull(updateTest.getCodeDto());


        Assertions.assertEquals(updated.getId(), updateTest.getId());
        Assertions.assertEquals(updated.getNameDto(), updateTest.getNameDto());
        Assertions.assertEquals(updated.getCodeDto(), updateTest.getCodeDto());




    }


    @Test
    void deleteTest() {
        int before = service.getAll().size();

        Random random = new Random();
        int randomIndex = random.nextInt(service.getAll().size());
        Long someIndex = service.getAll().get(randomIndex).getId();

        boolean deleted = service.delete(someIndex);
        Assertions.assertTrue(deleted);

        CountryDto deletedTest = service.getById(someIndex);
        Assertions.assertNull(deletedTest);


        int after = service.getAll().size();
        Assertions.assertEquals(before-1,after);



    }

}
