package com.xebia.models;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ItemsTest {

    Items itemsMock;

    @Before
    public void setUp() throws Exception {
        itemsMock = mock(Items.class);
    }

    @Test
    public void testGetQuantity() throws Exception {
        when(itemsMock.getQuantity()).thenReturn(2);
        assertEquals(itemsMock.getQuantity(),2);
        itemsMock.getQuantity();
        verify(itemsMock,times(2)).getQuantity();

    }

    @Test
    public void testGetName() throws Exception {
        when(itemsMock.getName()).thenReturn("Test");
        assertEquals(itemsMock.getName(),"Test");
        itemsMock.getName();
        itemsMock.getName();
        verify(itemsMock,times(3)).getName();
    }

    @Test
    public void testGetPrice() throws Exception {
        double delta = 1e-8;
        when(itemsMock.getPrice()).thenReturn(22.14);
        assertEquals(itemsMock.getPrice(), 22.14, delta);
        assertThat(itemsMock.getPrice(), equalTo(22.14));
        itemsMock.getPrice();
        itemsMock.getPrice();
        itemsMock.getPrice();
        verify(itemsMock,times(5)).getPrice();
    }
}