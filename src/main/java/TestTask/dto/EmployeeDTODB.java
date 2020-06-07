package TestTask.dto;

import TestTask.db.mappers.EmployeeMapper;
import TestTask.entities.Employee;
import TestTask.exception.IdNotFound;
import TestTask.rest.EmployeeDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
@Repository
public class EmployeeDTODB extends DTODB  implements EmployeeDTO   {
    EmployeeMapper employeeMapper;
    Reader reader;

    EmployeeDTODB() throws IOException {

    }

    private SqlSession getSession() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(this.getReader());
        return sqlSessionFactory.openSession();
    }

    public void addEmployee(Employee employee){
        try(SqlSession session = getSession()) {
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            mapper.addEmployee(employee);
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee[] getAllEmployees() {
        Employee[] employees = null;
        try(SqlSession session = getSession()) {
            employees = session.getMapper(EmployeeMapper.class).getAllEmployees();
            return employees;
        } catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }

    public Employee[] searchEmployeeByPatternFamily(String pattern){
        Employee[] employees = null;
        try(SqlSession session = getSession()) {
            employees = session.getMapper(EmployeeMapper.class).getEmployeeByFamilyPattern(pattern);
            return employees;
        } catch (IOException e){
            e.printStackTrace();
        }
        return employees;
    }

    public Employee getEmployee(int id) throws IdNotFound {

        Employee employee = null;
        try (SqlSession session = getSession()){
            employee = session.getMapper(EmployeeMapper.class).getEmployeeById(id);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(employee==null){
            throw new IdNotFound();
        }
        return employee;

    }
}
