package com.pillartechnology.unexpectedtiger.repositories;

import com.google.common.collect.Lists;
import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.services.ItemDBServiceImpl;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ItemRepositoryTest {

    @Mock
    private ItemDBServiceImpl mockItemDBServiceImpl;

    @InjectMocks
    private ItemRepository itemRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void add_throws_exception_when_item_content_is_null() throws Exception {
        //Arrange
        final ItemRepository itemRepository = new ItemRepository(mockItemDBServiceImpl);
        final ItemEntity item = new ItemEntity();

        //Act
        itemRepository.add(item);
    }

    @Test
    public void add_invokes_save_on_itemDBService() throws Exception {
        //Arrange
        final String expected_content = "content";
        ItemEntity item = new ItemEntity(expected_content);
        item.setId(200L);
        when(mockItemDBServiceImpl.save(Mockito.any(ItemEntity.class))).thenReturn(item);

        //Act
        final ItemEntity result = itemRepository.add(item);

        assertThat(result.getId(), is(200));
        assertThat(result.getContent(), is(expected_content));
    }

    @Test
    public void retrieveAllItems_invokes_findAll_on_itemDBService() throws Exception {
        //Arrange
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setContent("content");
        itemEntity.setId(200L);
        List<ItemEntity> items = new ArrayList<>();
        items.add(itemEntity);
        when(mockItemDBServiceImpl.findAll()).thenReturn(items);

        //Act
        final Iterable<ItemEntity> result = itemRepository.retrieveAllItems();
        List<ItemEntity> listResult = Lists.newArrayList(result);

        //Assert
        verify(mockItemDBServiceImpl).findAll();
        assertThat(listResult.size(), is(1));
        final ItemEntity item = listResult.get(0);
        assertThat(item.getContent(), is("content"));
        assertThat(item.getId(), is(200));
    }

    @Test
    public void retrieveAllItems_returns_two_items() throws Exception {
        //Arrange
        final ItemEntity item1 = new ItemEntity();
        item1.setContent("content");
        item1.setId(200L);
         final ItemEntity item2 = new ItemEntity();
        item2.setContent("content1");
        item2.setId(300L);

        List<ItemEntity> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        when(mockItemDBServiceImpl.findAll()).thenReturn(items);

        //Act
        final Iterable<ItemEntity> results = itemRepository.retrieveAllItems();
        List<ItemEntity> convertedToListResults = Lists.newArrayList(results);

        //Assert
        assertThat(convertedToListResults, Matchers.hasSize(2));
        assertThat(convertedToListResults, Matchers.hasItems(item1, item2));

    }

    @Test
    public void remove_invokes_delete_on_ItemDBService() throws Exception {
        //Arrange
        final String expectedContent = "content";
        final ItemEntity item = new ItemEntity(expectedContent);
        item.setId(200L);

        //Act
        itemRepository.remove(item);

        //Assert
        verify(mockItemDBServiceImpl).delete(item);

    }
}