package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entity.ItemEntity;
import com.pillartechnology.unexpectedtiger.repositories.ItemRepository;
import org.junit.Test;
import org.mockito.Mockito;


public class ItemServiceImplTest {

    @Test
    public void listAllItems_calls_itemRepository_findAll() {
        //Arrange
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);

        ItemServiceImpl itemService = new ItemServiceImpl();
        itemService.setItemRepository(itemRepositoryMock);
        //Act
        itemService.listAllItems();
        //Assert
        Mockito.verify(itemRepositoryMock).findAll();
    }

    @Test
    public void getItemById_calls_itemRepository_fineOne() {
        //Arrange
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);

        ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
        itemServiceImpl.setItemRepository(itemRepositoryMock);

        itemServiceImpl.saveItem(new ItemEntity("Test ItemEntity"));
        //Act
        itemServiceImpl.getItemById(1);
        //Assert
        Mockito.verify(itemRepositoryMock).findOne(1);

    }

    @Test
    public void saveItem_calls_itemRepository_save() {
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);

        ItemEntity testItemEntity = new ItemEntity("I'm a test item");

        ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
        itemServiceImpl.setItemRepository(itemRepositoryMock);

        itemServiceImpl.saveItem(testItemEntity);

        Mockito.verify(itemRepositoryMock).save(testItemEntity);
    }

    @Test
    public void deleteItem_calls_itemRepository_delete() {
        //Arrange
        ItemRepository itemRepositoryMock = Mockito.mock(ItemRepository.class);

        ItemServiceImpl itemServiceImpl = new ItemServiceImpl();
        itemServiceImpl.setItemRepository(itemRepositoryMock);

        itemServiceImpl.saveItem(new ItemEntity("Test ItemEntity"));

        //Act
        itemServiceImpl.deleteItem(1);
        //Assert
        Mockito.verify(itemRepositoryMock).delete(1);
    }
}
