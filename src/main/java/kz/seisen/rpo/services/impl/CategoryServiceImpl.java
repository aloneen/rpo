package kz.seisen.rpo.services.impl;



import kz.seisen.rpo.dto.CategoryDto;
import kz.seisen.rpo.mappers.CategoryMapper;
import kz.seisen.rpo.models.Category;
import kz.seisen.rpo.repositories.CategoryRepository;
import kz.seisen.rpo.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;



    public List<CategoryDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


    public CategoryDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }


    public CategoryDto create(CategoryDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }


    public CategoryDto update(Long id, CategoryDto dto) {

        CategoryDto oldCategory = getById(id);

        if (Objects.isNull(oldCategory) || Objects.isNull(dto)) {
            return null;
        }

        oldCategory.setNameDto(dto.getNameDto());


        return mapper.toDto(repository.save(mapper.toEntity(oldCategory)));


    }


    public boolean delete(Long id) {
        repository.deleteById(id);
        Category category = repository.findById(id).orElse(null);

        if (Objects.isNull(category)) {
            return true;
        }

        return false;
    }
}
