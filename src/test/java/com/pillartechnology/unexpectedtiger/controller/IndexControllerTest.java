    package com.pillartechnology.unexpectedtiger.controller;

    import com.pillartechnology.unexpectedtiger.entity.CategoryEntity;
    import com.pillartechnology.unexpectedtiger.entity.ItemEntity;
    import com.pillartechnology.unexpectedtiger.services.CategoryService;
    import com.pillartechnology.unexpectedtiger.services.ItemService;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.mockito.Mockito;
    import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
    import org.springframework.ui.ExtendedModelMap;

    import java.util.ArrayList;
    import java.util.List;

    import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertThat;
    import static org.mockito.Mockito.mock;
    import static org.mockito.Mockito.verify;
    import static org.mockito.Mockito.when;

    @RunWith(SpringJUnit4ClassRunner.class)
    public class IndexControllerTest {

        @Test
        public void saveAnItem() {
            //Arrange
            ItemService itemService = mock(ItemService.class);

            IndexController controller = new IndexController();
            controller.setItemService(itemService);
            CategoryEntity categoryEntity = new CategoryEntity();
            ItemEntity itemEntity = new ItemEntity("test1");

            //Act
            String actualRedirect = controller.add(itemEntity, categoryEntity);

            //Assert
            Mockito.verify(itemService).saveItem(itemEntity);
            assertEquals("redirect:/", actualRedirect);
        }

        @Test
        public void index_sets_list_of_all_items() throws Exception {
            //Arrange
            ItemService itemServiceMock = mock(ItemService.class);
            CategoryService categoryServiceMock = mock(CategoryService.class);

            IndexController controller = new IndexController();
            controller.setItemService(itemServiceMock);
            controller.setCategoryService(categoryServiceMock);


            List<ItemEntity> itemEntities = new ArrayList<>();
            itemEntities.add(new ItemEntity("content"));
            when(itemServiceMock.listAllItems()).thenReturn(itemEntities);

            List<CategoryEntity> categories = new ArrayList<>();
            CategoryEntity expectedCategoryEntity = new CategoryEntity("Work");
            categories.add(expectedCategoryEntity);
            when(categoryServiceMock.listAllCategories()).thenReturn(categories);

            //Act
            ExtendedModelMap model = new ExtendedModelMap();
            String actualRedirect = controller.index(model);

            //Assert
            Iterable<ItemEntity> actualItems = (Iterable<ItemEntity>) model.get("itemEntities");
            for (ItemEntity itemEntity : actualItems) {
                assertEquals("content", itemEntity.getContent());
            }

            Iterable<CategoryEntity> actualCategories = (Iterable<CategoryEntity>) model.get("categories");
            for (CategoryEntity categoryEntity : actualCategories) {
                assertEquals("Work", categoryEntity.getCategoryName());
            }
            assertEquals("index", actualRedirect);
        }

        @Test
        public void indexControllerDeletesAnItem() {
            //Arrange
            ItemService itemServiceMock = mock(ItemService.class);

            IndexController controller = new IndexController();
            controller.setItemService(itemServiceMock);

            //Act
            String actualRedirect = controller.remove(2);

            //Assert
            assertEquals("redirect:/", actualRedirect);
            verify(itemServiceMock).deleteItem(2);
        }







    }