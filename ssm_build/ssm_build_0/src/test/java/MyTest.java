import com.demo.pojo.Books;
import com.demo.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookServiceImpl = applicationContext.getBean("BookServiceImpl", BookService.class);
        for(Books books : bookServiceImpl.queryAllBook())
            System.out.println(books.toString());
    }
}
