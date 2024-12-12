package com.ServiceImpl;

import com.Service.BookTableService;
import com.entity.BookTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Scanner;

public class BooktableImpl implements BookTableService {
    Scanner sc = new Scanner(System.in);
    Session s;
    Transaction t;
    @Override
    public void booktable(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        BookTable book = new BookTable();
        System.out.print("Enter Customer name :");
        book.setCustomerName(sc.next());
        System.out.println("Enter no.of people you gonna attend :");
        int attend=sc.nextInt();
        book.setNoOfPeople(attend);
        int amount = 250*attend;
        s.save(book);
        t.commit();
        System.out.println("Your table booked successfully\nYour booking id is "+book.getTableId());
        System.out.println("Amount to pay is Rs."+amount);
    }

    @Override
    public void unbooktable(SessionFactory sf) {
        s = sf.openSession();
        t = s.beginTransaction();
        System.out.println("Enter your booking id to cancel your booking");
        int bid=sc.nextInt();
        BookTable book = s.get(BookTable.class, bid);
        if(book != null){
            s.delete(book);
        }
        t.commit();
        System.out.println("Your Cancellation is done succesfully");
    }
}
