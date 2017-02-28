package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.model.Item;
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
    private ItemDBService mockItemDBService;

    @InjectMocks
    private ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = RuntimeException.class)
    public void add_throws_exception_when_item_content_is_null() throws Exception {
        //Arrange
        final ItemRepository itemRepository = new ItemRepository();
        final Item item = new Item();

        //Act
        itemRepository.add(item);
    }

    @Test
    public void add_invokes_save_on_itemDBService() throws Exception {
        //Arrange
        final String expected_content = "content";
        Item item = new Item(expected_content);
        ItemEntity entity = new ItemEntity();
        entity.setContent(expected_content);
        entity.setId(200l);
        when(mockItemDBService.save(Mockito.any(ItemEntity.class))).thenReturn(entity);

        //Act
        final Item result = itemRepository.add(item);

        assertThat(result.getId(), is("200"));
        assertThat(result.getContent(), is(expected_content));
    }

    @Test
    public void retrieveAllItems_invokes_findAll_on_itemDBService() throws Exception {
        //Arrange
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setContent("content");
        itemEntity.setId(200l);
        List<ItemEntity> items = new ArrayList<>();
        items.add(itemEntity);
        when(mockItemDBService.findAll()).thenReturn(items);

        //Act
        final List<Item> result = itemRepository.retrieveAllItems();

        //Assert
        verify(mockItemDBService).findAll();
        assertThat(result.size(), is(1));
        final Item item = result.get(0);
        assertThat(item.getContent(), is("content"));
        assertThat(item.getId(), is("200"));
    }

    @Test
    public void retrieveAllItems_returns_two_items() throws Exception {
        //Arrange
        final Item item1 = new Item();
        item1.setContent("content");
        item1.setId("200");
         final Item item2 = new Item();
        item2.setContent("content1");
        item2.setId("300");


        final ItemEntity itemEntity1 = new ItemEntity();
        final ItemEntity itemEntity2 = new ItemEntity();

        itemEntity1.setContent("content");
        itemEntity1.setId(200l);
        itemEntity2.setContent("content1");
        itemEntity2.setId(300l);

        List<ItemEntity> items = new ArrayList<>();
        items.add(itemEntity1);
        items.add(itemEntity2);
        when(mockItemDBService.findAll()).thenReturn(items);

        //Act
        final List<Item> results = itemRepository.retrieveAllItems();

        //Assert
        assertThat(results, Matchers.hasSize(2));
        assertThat(results, Matchers.hasItems(item1, item2));

    }

    @Test
    public void remove_invokes_delete_on_ItemDBService() throws Exception {
        //Arrange
        final String expectedContent = "content";
        final Item item = new Item(expectedContent);
        item.setId("200");

        //Act
        itemRepository.remove(item);

        //Assert
        verify(mockItemDBService).delete(Integer.valueOf(item.getId()));

    }
}