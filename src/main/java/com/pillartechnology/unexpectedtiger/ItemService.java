package com.pillartechnology.unexpectedtiger;

import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ItemService {
    //    private String path = "src/main/resources/item_files";
    private File dataDir;
    private List<Item> todoItems = new ArrayList<>();
    private String path = "/Users/jenniferkron/dev/unexpectedtiger/src/test/java/com/pillartechnology/unexpectedtiger/Data";
    public static final Random RANDOM = new Random();



    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

    public Item addItem(Item item) throws IOException {
        String randomNumberString = generateRandomNumberToString();
        final String fileName = randomNumberString + ".txt";
        item.setId(fileName);

        createFileWithItemContent(item);
        return item;
    }

    public List<Item> retrieveItems() throws IOException {
        dataDir = new File(path);
        final File[] allItemFiles = dataDir.listFiles();
        final ArrayList<Item> items = new ArrayList<>();

        for (File itemFile : allItemFiles) {
            items.add(makeItem(itemFile));
        }
        return items;
    }

    public void removeItem(Item item) {
        final String fileName = item.getId();
        final File file = new File(path + File.separator + fileName);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        file.delete();
    }

    public void removeLastItem() {
        if (todoItems.size() > 0) {
            todoItems.remove(todoItems.size() - 1);
        }
    }


    private void createFileWithItemContent(Item item) throws IOException {
        File file = new File(path + File.separator + item.getId());
        try (FileWriter fileWriter = new FileWriter(file)) {
            file.createNewFile();
            fileWriter.write(item.getContent());
        }
    }

    private Item makeItem(File itemFile) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(itemFile));
        final String content = bufferedReader.readLine();
        final Item item = new Item(content);
        item.setId(itemFile.getName());
        return item;
    }

    private String generateRandomNumberToString() {
        int n = RANDOM.nextInt(100000);
        return String.valueOf(n);
    }

}
