package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import org.springframework.data.repository.CrudRepository;

public interface ItemDBService extends CrudRepository<ItemEntity, Integer>{


}
