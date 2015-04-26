import com.courses.view.Print;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by vladimir on 24.04.2015.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        Print res = ctx.getBean("viewService", Print.class);

        System.out.println("Hi all! ");
        res.print();
    }
}
