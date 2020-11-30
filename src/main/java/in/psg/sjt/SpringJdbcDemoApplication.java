package in.psg.sjt;

import in.psg.sjt.dao.Dao;
import in.psg.sjt.model.Office;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

    private static Dao<Office> officeDao;

    public SpringJdbcDemoApplication(Dao<Office> officeDao) {
        this.officeDao = officeDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);

        System.out.println("\n All Offices......................\n");
        List<Office> courses = officeDao.list();
        courses.forEach(System.out::println);
    }

}
