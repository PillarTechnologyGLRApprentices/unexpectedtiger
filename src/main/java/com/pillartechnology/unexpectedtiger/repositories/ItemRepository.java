package com.pillartechnology.unexpectedtiger.repositories;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class ItemRepository {
    public static final Random RANDOM = new Random();
    private String path;

    private List<Item> todoItems = new ArrayList<>();

    public ItemRepository(String path) {
        this.path = path;
    }

    public ItemRepository() {
    }

    public Item add(Item item) throws IOException {
        if (item.getContent() == null || item.getContent().trim().isEmpty()) {
            throw new RuntimeException();
        }

        String randomNumberString = generateRandomNumberToString();
        final String fileName = randomNumberString + ".txt";
        item.setFileName(fileName);

        createFileWithItemContent(item);
        return item;
    }

    public List<Item> retrieveAllItems() throws IOException {
        File dataDir = new File(path);
        final File[] allItemFiles = dataDir.listFiles();
        final ArrayList<Item> items = new ArrayList<>();

        for (File itemFile : allItemFiles) {
            final BufferedReader bufferedReader = new BufferedReader(new FileReader(itemFile));
            final String content = bufferedReader.readLine();
            items.add(new Item(content));
        }
        return items;
    }

    public void removeLastItem() {
        if (todoItems.size() > 0) {
            todoItems.remove(todoItems.size() - 1);
        }

    }

    public void remove(Item item) {
        todoItems.remove(item);
    }

    private void createFileWithItemContent(Item item) throws IOException {
        File file = new File(path + File.separator + item.getFileName());
        try (FileWriter fileWriter = new FileWriter(file)) {
            file.createNewFile();
            fileWriter.write(item.getContent());
        }
    }

    private String generateRandomNumberToString() {
        int n = RANDOM.nextInt(100000);
        return String.valueOf(n);
    }

}



