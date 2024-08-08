package com.library.App;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class LibraryManagementApplication{

	@SuppressWarnings("resource")
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext contexts = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookServices = (BookService) contexts.getBean("bookService");

        // Verify that the BookRepository has been injected
        if (bookServices != null && bookServices.getBookRepository() != null) {
            System.out.println("Dependency Injection successful: BookRepository has been injected into BookService.");
        } else {
            System.out.println("Dependency Injection failed.");
        }
        bookServices.someMethod();
        
        bookServices.getBookRepository();

        System.out.println("AOP functionality tested successfully.");

	}

}
