
package com.ServiceImpl;

import com.entity.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuImplTest {

    @Test
    void addMenu() {
        Menu menu = new Menu(1, "Chilli Chicken", 365);
        assertEquals(1, menu.getItemId());
        assertEquals("Chilli Chicken", menu.getItemName());
        assertEquals(365, menu.getPrice());
    }
}
