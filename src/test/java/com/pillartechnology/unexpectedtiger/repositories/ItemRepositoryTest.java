package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.ItemService;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ItemRepositoryTest {
    public static String DATA_PATH = "/Users/jenniferkron/dev/unexpectedtiger/src/test/java/com/pillartechnology/unexpectedtiger/Data";

    ItemRepository itemRepository;
    ItemService itemService;

    @Before
    public void setUp() throws Exception {
//        itemRepository = new ItemRepository(DATA_PATH);
        itemRepository = new ItemRepository();
        itemService = new ItemService();
    }

    @After
    public void tearDown() throws Exception {
        File data = new File(DATA_PATH);
        FileUtils.cleanDirectory(data);
    }

    @Test(expected = RuntimeException.class)
    public void add_throws_exception_when_content_is_null() throws Exception {

        itemRepository.add(new Item());
    }

    @Test(expected = RuntimeException.class)

    public void add_throws_exception_when_content_is_empty() throws Exception {
        Item item = new Item();
        item.setContent("   ");
        itemRepository.add(item);
    }

    @Test
    public void add_creates_item_file_with_fileName() throws Exception {
        Item item = new Item("content");
        //Act
        Item actualItem = itemRepository.add(item);

        //Assert
        String actualFileName = actualItem.getFileName();
        assertNotNull(actualFileName);
        assertTrue(actualFileName.contains(".txt"));
        String[] parts = actualFileName.split("\\.");
        String name1 = parts[0];
        boolean matches = name1.matches("[0-9]+");
        assertTrue(matches);

        Item item2 = new Item("content 2");
        Item actualItem2 = itemRepository.add(item2);
        parts = actualItem2.getFileName().split("\\.");
        String name2 = parts[0];
        matches = name2.matches("[0-9]+");
        assertTrue(matches);
        assertFalse(name1.equals(name2));
    }

    @Test
    public void add_writes_a_file_that_isnt_null() throws Exception {
        //Arrange
        Item item = new Item("content");

        //Act
        Item actualItem = itemRepository.add(item);

        File actualFile = new File(DATA_PATH + File.separator + actualItem.getFileName());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(actualFile));
        String line = bufferedReader.readLine();


        //Assert
        Assert.assertTrue(actualFile.exists());
        Assert.assertEquals("content", line);
    }

    @Test
    public void retrieveAll_returns_emptyList_whenNoItemsFound() throws Exception {
        List<Item> actualItems = itemRepository.retrieveAllItems();

        assertThat(actualItems, Matchers.is(Matchers.empty()));
    }

//    @Test
//    public void retriveAll_will_have_one_item_when_one_file_added() throws Exception {
//        ItemService itemServiceMock = Mockito.mock(ItemService.class);
//        final Item item = new Item("cat");
//        item.setFileName("123.txt");
//        Mockito.when(itemServiceMock.makeItem(Mockito.any())).thenReturn(item);
//        itemRepository.setItemService(itemServiceMock);
//
//
//        itemRepository.add(new Item("dog"));
//        itemRepository.retrieveAllItems();
//
//        assertEquals(1, itemRepository.retrieveAllItems().size());
//        assertEquals("cat", itemRepository.retrieveAllItems().get(0).getContent());
//        assertEquals("123.txt", itemRepository.retrieveAllItems().get(0).getFileName());
//    }

    @Test
    public void retrieveAll_should_read_file_from_correct_directory() throws Exception {
        File fileMock = Mockito.mock(File.class);

        File[] files = new File[2];


        Mockito.when(fileMock.listFiles()).thenReturn(files);
        itemService.setDataDir(fileMock);

        itemRepository.retrieveAllItems();

    }

    @Test
    public void retrieveAll_returns_all_items_from_data_dir() throws Exception {
        //Arrange
        String expected_content1 = "content1";
        String expected_content2 = "content2";
        String expected_content3 = "content3";

        Item item1 = new Item(expected_content1);
        Item item2 = new Item(expected_content2);
        Item item3 = new Item(expected_content3);

        item1 = itemRepository.add(item1);
        item2 = itemRepository.add(item2);
        item3 = itemRepository.add(item3);

        //Act
        List<Item> actualItems = itemRepository.retrieveAllItems();

        //Assert
        assertEquals(3, actualItems.size());
        assertThat(actualItems, Matchers.contains(actualItems.get(0), actualItems.get(1), actualItems.get(2)));
        List<String> expectedFileNames = new ArrayList<>();
        expectedFileNames.add(item1.getFileName());
        expectedFileNames.add(item2.getFileName());
        expectedFileNames.add(item3.getFileName());

        List<String> actualFileNames = new ArrayList<>();
        actualFileNames.add(actualItems.get(0).getFileName());
        actualFileNames.add(actualItems.get(1).getFileName());
        actualFileNames.add(actualItems.get(2).getFileName());

        assertThat(actualItems, Matchers.contains(actualItems.get(0), actualItems.get(1), actualItems.get(2)));
        assertThat(actualFileNames, Matchers.containsInAnyOrder(item1.getFileName(), item2.getFileName(), item3.getFileName()));
    }

    @Test(expected = RuntimeException.class)
    public void remove_throwsException_when_invalidFileName() throws Exception {
        //Arrange
        Item item = new Item("item");
        item.setFileName("does_not_exist.txt");

        //Act
        itemRepository.remove(item);
    }

    @Test
    public void remove_item_from_data_dir() throws Exception {
        //Arrange
        Item item1 = itemRepository.add(new Item("item1"));
        Item item2 = itemRepository.add(new Item("item2"));
        List<Item> items = itemRepository.retrieveAllItems();
        assertEquals(2, items.size());

        //Act
        itemRepository.remove(item1);

        //Assert
        List<Item> actualItems = itemRepository.retrieveAllItems();
        assertEquals(1, actualItems.size());
    }

}