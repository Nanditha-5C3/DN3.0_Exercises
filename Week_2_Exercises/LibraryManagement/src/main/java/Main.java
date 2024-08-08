import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean
        BookService bookServices = (BookService) context.getBean("bookService");

        // Verify that the BookRepository has been injected
        if (bookServices != null && bookServices.getBookRepository() != null) {
            System.out.println("Dependency Injection successful: BookRepository has been injected into BookService.");
        } else {
            System.out.println("Dependency Injection failed.");
        }
        bookServices.someMethod();

	}

}
