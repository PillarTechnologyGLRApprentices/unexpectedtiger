package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.entities.ItemEntity;
import com.pillartechnology.unexpectedtiger.model.Item;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ItemFileServiceImpl implements ItemService {
    //    private String path = "src/main/resources/item_files";
    private File dataDir;
    private List<Item> todoItems = new ArrayList<>();
    private String path = "/Users/jenniferkron/dev/unexpectedtiger/src/test/java/com/pillartechnology/unexpectedtiger/data";
    public static final Random RANDOM = new Random();



    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

    @Override
    public ItemEntity save(ItemEntity item) throws IOException {
        String randomNumberString = generateRandomNumberToString();
        final String fileName = randomNumberString;
        item.setId(Long.valueOf(fileName));

        createFileWithItemContent(item);
        return item;
    }

    @Override
    public List<ItemEntity> findAll() throws IOException {
        dataDir = new File(path);
        final File[] allItemFiles = dataDir.listFiles();
        final ArrayList<ItemEntity> items = new ArrayList<>();

        for (File itemFile : allItemFiles) {
            items.add(makeItem(itemFile));
        }
        return items;
    }

    @Override
    public void delete(ItemEntity item) {
        final String fileName = String.valueOf(item.getId());
        final File file = new File(path + File.separator + fileName);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        file.delete();
    }

    private void createFileWithItemContent(ItemEntity item) throws IOException {
        File file = new File(path + File.separator + item.getId());
        try (FileWriter fileWriter = new FileWriter(file)) {
            file.createNewFile();
            fileWriter.write(item.getContent());
        }
    }

    private ItemEntity makeItem(File itemFile) throws IOException {
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(itemFile));
        final String content = bufferedReader.readLine();
        final ItemEntity item = new ItemEntity(content);
        item.setId(Long.valueOf(itemFile.getName()));
        return item;
    }

    private String generateRandomNumberToString() {
        int n = RANDOM.nextInt(100000);
        return String.valueOf(n);
    }

}
