package com.ServiceImpl;

import com.entity.BookTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BooktableImplTest {

    @Test
    void bookTable() {
        BookTable book = new BookTable(1, "Ganesh", 7);
        assertEquals(1, book.getTableId());
        assertEquals("Ganesh", book.getCustomerName());
        assertEquals(7, book.getNoOfPeople());
    }
}
