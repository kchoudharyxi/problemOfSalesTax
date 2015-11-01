package com.xebia.services;

import com.xebia.models.Items;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TaxCalculatorTest {

    TaxCalculator tax;
    TaxCalculator mockedTax;
    Items items;
    double delta = 1e-8;
    List<Items> list;

    @Before
    public void setUp() throws Exception {
        mockedTax = mock(TaxCalculator.class);
        tax = new TaxCalculator();
        items = new Items();
    }

    @Test
    public void testReadInput() throws Exception {
        when(mockedTax.readInput()).thenReturn(true);
        assertEquals(mockedTax.readInput(),true);
        mockedTax.readInput();
        verify(mockedTax,times(2)).readInput();
        list = new ArrayList<Items>();
        assertTrue(list.add(items));
    }

    @Test
    public void testComputeTax() throws Exception {
        when(mockedTax.computeTax()).thenReturn(52.15);
        assertEquals(mockedTax.computeTax(),52.15,delta);
        assertThat(mockedTax.computeTax(), equalTo(52.15));
        mockedTax.computeTax();
        verify(mockedTax,times(3)).computeTax();
        assertTrue(String.valueOf(tax.computeTax()),true);
        double basicTax = 0.10;
        double importTax = 0.05;
        double price = 0.0;
        int quantity = 0;
        double taxForOtherItems = price * basicTax * quantity;
        double taxForImported = price * importTax * quantity;
        assertEquals(items.getPrice()*basicTax*items.getQuantity(),taxForOtherItems, delta);
        assertEquals(items.getPrice()*importTax*items.getQuantity(),taxForImported, delta);
    }

    @Test
    public void testComputePrice() throws Exception {
        when(mockedTax.computePrice()).thenReturn(21.12);
        assertEquals(mockedTax.computePrice(),21.12,delta);
        assertThat(mockedTax.computePrice(), equalTo(21.12));
        mockedTax.computePrice();
        mockedTax.computePrice();
        verify(mockedTax,times(4)).computePrice();
        assertTrue(String.valueOf(tax.computePrice()), true);

    }

    @Test
    public void testView() throws Exception {
        when(mockedTax.view()).thenReturn("Result");
        assertEquals(mockedTax.view(),"Result");
        mockedTax.view();
        mockedTax.view();
        verify(mockedTax,times(3)).view();
        assertTrue(tax.view(),true);
        String message = items.getQuantity() + items.getName() + items.getPrice();
        assertEquals(items.getQuantity()+items.getName()+items.getPrice(),message);
    }
}