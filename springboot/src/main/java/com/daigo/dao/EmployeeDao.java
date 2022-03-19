package com.daigo.dao;

import com.daigo.pojo.Department;
import com.daigo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();
        employees.put(1001, new Employee(1001, "AA", "AA1564@QQ.COM", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "BB1564@QQ.COM", 0, new Department(101, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "CC1564@QQ.COM", 1, new Department(101, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "DD1564@QQ.COM", 0, new Department(101, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "EE1564@QQ.COM", 1, new Department(101, "后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;

    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //   查询所有员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    //   通过id查询员工信息
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    //   通过id删除员工
    public void delete(Integer id) {
        employees.remove(id);
    }
}
