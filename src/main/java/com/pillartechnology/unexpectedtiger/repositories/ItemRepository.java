package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entity.ItemEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {
}
