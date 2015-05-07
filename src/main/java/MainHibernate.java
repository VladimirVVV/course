import com.courses.phones.Phone;
import com.courses.phones.domain.PhoneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by vladimir on 07.05.2015.
 */
public class MainHibernate {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context-hibernate.xml");
        PhoneService service = ctx.getBean("phoneServiceImpl", PhoneService.class);
        init(service);
        List<Phone> phones = service.getAll();

        for(Phone phone:phones){
            System.out.println(phone);
        }

        System.out.println("======= Increase Price =================");
        System.out.println();

        final Long ID_LG = 1L;
        System.out.println(service.getPhoneBy(ID_LG));
        service.increasePrice(ID_LG, 7);
        System.out.println(service.getPhoneBy(ID_LG));
    }

    private static void init(PhoneService service) {
        Phone p = preparePhone(1L, "Lg Optimus two", 74);
        service.create(p);
        service.create("Lg Optimus", 246);
        service.create("Nokia N7", 78);
        service.create("SonyEricson 2000 ", 300);
        service.create("Nokia N7", 78);
        service.create("Motorola 77 ", 130);
        service.create("Nokia N5", 50);
    }

    private static Phone preparePhone(Long id, String name, int price) {
        Phone p = new Phone();
        p.setId(id);
        p.setName(name);
        p.setPrice(price);
        return p;
    }
}
