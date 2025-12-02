package kz.seisen.rpo.mappers;


import kz.seisen.rpo.dto.CategoryDto;
import kz.seisen.rpo.models.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "nameDto", source = "name")
    CategoryDto toDto(Category category);

    @Mapping(target = "name", source = "nameDto")
    Category toEntity(CategoryDto dto);

    List<CategoryDto> toDtoList(List<Category> categories);
}
