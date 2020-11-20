package in.psg.sjt;

import in.psg.sjt.dao.Dao;
import in.psg.sjt.model.Course;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJdbcDemoApplication {

    private static Dao<Course> courseDao;

    public SpringJdbcDemoApplication(Dao<Course> courseDao) {
        this.courseDao = courseDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcDemoApplication.class, args);

        System.out.println("\n All Courses......................\n");
        List<Course> courses = courseDao.list();
        courses.forEach(System.out::println);
    }

}
