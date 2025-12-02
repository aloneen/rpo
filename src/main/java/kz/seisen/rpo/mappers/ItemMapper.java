package kz.seisen.rpo.mappers;

import kz.seisen.rpo.dto.ItemDto;
import kz.seisen.rpo.models.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class, CountryMapper.class})
public interface ItemMapper {

    @Mapping(target = "nameDto", source = "name")
    @Mapping(target = "priceDto", source = "price")
    @Mapping(target = "countryDto", source = "country")
    @Mapping(target = "categoryDtos", source = "categories")
    ItemDto toDto(Item item);


    @Mapping(target = "name", source = "nameDto")
    @Mapping(target = "price", source = "priceDto")
    @Mapping(target = "country", source = "countryDto")
    @Mapping(target = "categories", source = "categoryDtos")
    Item toEntity(ItemDto dto);


    List<ItemDto> toDtoList(List<Item> items);


}
