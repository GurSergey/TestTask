package TestTask.dto;

import TestTask.db.mappers.EmployeeMapper;
import TestTask.entities.Employee;
import TestTask.rest.EmployeeDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
@Repository
public class EmployeeDTODB implements EmployeeDTO {
    public Employee getEmployee(int id) {
                SqlSessionFactory sqlSessionFactory;
        EmployeeMapper subscriberMapper;
        Reader reader = null;
        try {
            reader = Resources
                    .getResourceAsReader("mybatis-config.xml"); //Читаем файл с настройками подключения и настройками MyBatis
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            subscriberMapper = sqlSessionFactory.openSession().getMapper(EmployeeMapper.class); //Создаем маппер, из которого и будем вызывать методы getSubscriberById и getSubscribers
//            List<Employee> subscribers = subscriberMapper.getEmployees();
            Employee employee = subscriberMapper.getEmployeeById(id);
            return employee;
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
