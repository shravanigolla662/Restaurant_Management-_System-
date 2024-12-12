package com.ServiceImpl;

import com.entity.Menu;
import com.entity.PlaceOrder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlaceOrderImplTest {

    @Test
    void makeOrder() {
        Menu menu = new Menu();
        menu.setItemName("Chilli Chicken");

        PlaceOrder order = new PlaceOrder(1, "Ganesh", 180, 3, menu);
        assertEquals(1, order.getOrderId());
        assertEquals("Ganesh", order.getCustomerName());
        assertEquals(180, order.getBillAmount());
        assertEquals(3, order.getQuantity());
        assertEquals("Chilli Chicken", order.getMenu().getItemName());
    }
}
