package kz.seisen.rpo.services.impl;



import kz.seisen.rpo.dto.ItemDto;
import kz.seisen.rpo.mappers.ItemMapper;
import kz.seisen.rpo.models.Item;
import kz.seisen.rpo.repositories.ItemRepository;
import kz.seisen.rpo.services.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {


    private final ItemRepository repository;
    private final ItemMapper mapper;



    public List<ItemDto> getAll() {
        return mapper.toDtoList(repository.findAll());
    }


    public ItemDto getById(Long id) {
        return mapper.toDto(repository.findById(id).orElse(null));
    }


    public ItemDto create(ItemDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }


    public ItemDto update(Long id, ItemDto dto) {

        ItemDto oldItem = getById(id);

        if (Objects.isNull(oldItem) || Objects.isNull(dto)) {
            return null;
        }

        oldItem.setNameDto(dto.getNameDto());
        oldItem.setPriceDto(dto.getPriceDto());
        oldItem.setCountryDto(dto.getCountryDto());
        oldItem.setCategoryDtos(dto.getCategoryDtos());

        return mapper.toDto(repository.save(mapper.toEntity(oldItem)));


    }


    public boolean delete(Long id) {
        repository.deleteById(id);
        Item item = repository.findById(id).orElse(null);

        if (Objects.isNull(item)) {
            return true;
        }

        return false;
    }
}

