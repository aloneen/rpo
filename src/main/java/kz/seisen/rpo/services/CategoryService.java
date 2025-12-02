package kz.seisen.rpo.services;



import kz.seisen.rpo.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> getAll();
    CategoryDto getById(Long id);
    CategoryDto create(CategoryDto dto);
    CategoryDto update(Long id, CategoryDto dto);
    boolean delete(Long id);
}
