package com.rabitabank.task.demo.service.Impl;

import com.rabitabank.task.demo.model.RequestModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.*;

@ExtendWith(MockitoExtension.class)
public class MainServiceImplTest {

    @Mock
    RequestModel requestModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Mockito.when(requestModel.getIntA()).thenReturn(15);
        Mockito.when(requestModel.getIntB()).thenReturn(3);
    }

    @Test
    public void testAdd() {
        int result = requestModel.getIntA() + requestModel.getIntB();
        assertEquals("Add service must be 18",18, result);
    }

    @Test
    public void testSubtract() {
        int result = requestModel.getIntA() - requestModel.getIntB();
        assertEquals("Subtract service must be 12",12, result);
    }

    @Test
    public void testMultiply() {
        int result = requestModel.getIntA() * requestModel.getIntB();
        assertEquals("Add Multiply must be 45",45, result);
    }

    @Test
    public void testDivide() {
        int result = requestModel.getIntA() / requestModel.getIntB();
        assertEquals("Add Divide must be 5",5, result);
    }


}