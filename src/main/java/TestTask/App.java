/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TestTask;

import TestTask.db.mappers.EmployeeMapper;
import TestTask.entities.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
//        SpringApplication.run(App.class, args);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8083"));
        app.run(args);
//        SqlSessionFactory sqlSessionFactory;
//        EmployeeMapper subscriberMapper;
//        Reader reader = null;
//        try {
//            reader = Resources
//                    .getResourceAsReader("mybatis-config.xml"); //Читаем файл с настройками подключения и настройками MyBatis
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            subscriberMapper = sqlSessionFactory.openSession().getMapper(EmployeeMapper.class); //Создаем маппер, из которого и будем вызывать методы getSubscriberById и getSubscribers
////            List<Employee> subscribers = subscriberMapper.getEmployees();
//            Employee subscriber = subscriberMapper.getEmployeeById(1);
//            System.out.println(subscriber.getFamily());
//        } catch (  IOException e) {
//            e.printStackTrace();
//        }
    }
}
