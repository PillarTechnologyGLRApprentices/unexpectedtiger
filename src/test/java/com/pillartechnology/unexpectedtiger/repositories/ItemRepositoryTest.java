package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import static org.junit.Assert.*;

public class ItemRepositoryTest {
    public static final String DATA_PATH = "/Users/jenniferkron/dev/unexpectedtiger/src/test/java/com/pillartechnology/unexpectedtiger/Data";

    ItemRepository itemRepository;

    @Before
    public void setUp() throws Exception {
        itemRepository = new ItemRepository(DATA_PATH);
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

        final Item item2 = new Item("content 2");
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
        final Item item = new Item("content");

        //Act
        Item actualItem = itemRepository.add(item);

        final File actualFile = new File(DATA_PATH + File.separator + actualItem.getFileName());
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(actualFile));
        String line = bufferedReader.readLine();


        //Assert
        Assert.assertTrue(actualFile.exists());
        Assert.assertEquals("content", line);
    }

}