package TestTask.dto;

import TestTask.db.mappers.EmployeeMapper;
import TestTask.entities.Employee;
import TestTask.exception.IdNotFound;
import TestTask.rest.EmployeeDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
@Repository
public class EmployeeDTODB  implements EmployeeDTO  {
    public Employee getEmployee(int id) throws IdNotFound {
                SqlSessionFactory sqlSessionFactory;
        EmployeeMapper subscriberMapper;
        Reader reader = null;
        try {
            reader = Resources
                    .getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            subscriberMapper = sqlSessionFactory.openSession().getMapper(EmployeeMapper.class);
//            List<Employee> subscribers = subscriberMapper.getEmployees();
            Employee employee = subscriberMapper.getEmployeeById(id);
            if(employee==null){
                throw new IdNotFound();
            }
            return employee;
        } catch ( IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
