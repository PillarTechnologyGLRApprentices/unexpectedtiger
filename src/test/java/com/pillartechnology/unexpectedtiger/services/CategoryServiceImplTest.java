package com.pillartechnology.unexpectedtiger.services;

import com.pillartechnology.unexpectedtiger.repositories.CategoryRepository;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class CategoryServiceImplTest {

    @Test
    public void listAllCategories_calls_categoryRepository_findAll() {
        //Arrange
        CategoryRepository categoryRepositoryMock = Mockito.mock(CategoryRepository.class);

        CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
        categoryServiceImpl.setCategoryRepository(categoryRepositoryMock);
        //Act
        categoryServiceImpl.listAllCategories();
        //Assert
        Mockito.verify(categoryRepositoryMock).findAll();
    }

    @Test
    public void getCategoryById_calls_categoryRepository_findOne() {
        //Arrange
        CategoryRepository categoryRepositoryMock = Mockito.mock(CategoryRepository.class);

        CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
        categoryServiceImpl.setCategoryRepository(categoryRepositoryMock);

        //Act
        categoryServiceImpl.getCategoryById(1);
        //Assert
        Mockito.verify(categoryRepositoryMock).findOne(1);
    }
}