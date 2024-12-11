package business;

import entity.Departments;
import entity.Employee;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeBusiness {
    //Hiển thị nhân viên
    public static List<Employee> displayEmployee() {
        //1. Khởi tạo đối tượng Connection và CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo kết quả trả về
        List<Employee> listEmployee = null;
        try {
            //3. Khởi tạo giá trị cho đối tượng ConnectionDB và CallableStatement
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_employee()}");
            //4. Set giá trị cho các tham số vào
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Gọi đối tượng procedure
            ResultSet rs = callSt.executeQuery();
            //7. Xử lý kết quả
            listEmployee = new ArrayList<Employee>();
            while (rs.next()) {
                Employee employee = new Employee();


                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setEmployeePosition(rs.getString("position"));
                employee.setEmployeeSalary(rs.getFloat("salary"));
                employee.setHireDate(rs.getString("hire_date"));
                employee.setDepartmentId(rs.getInt("department_id"));


                listEmployee.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listEmployee;
    }

    // them moi
    public static boolean createNewEmployee(Employee employee) {
        Connection conn = null;
        CallableStatement callSt = null;

        boolean result = false;
        try {
            //3. Khởi tạo giá trị cho Conn và callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_employee(?,?,?,?,?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, employee.getEmployeeName());
            callSt.setString(2, employee.getEmployeePosition());
            callSt.setFloat(3, employee.getEmployeeSalary());
            callSt.setString(4, employee.getHireDate());
            callSt.setInt(5, employee.getDepartmentId());

            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Gọi procedure
            callSt.executeUpdate();
            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }


    // tim
    public static Employee findEmployeeById(int employeeId) {
        //1 Khởi tạo đối tượng Connection và CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2.  Khởi tạo kết quả trả về
        try {
            //3. Khởi tạo giá trị cho các đối tượng
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_employee_by_id(?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setInt(1, employeeId);
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            ResultSet rs = callSt.executeQuery();
            //7. Xử lý kết quả
            if (rs.next()) {
                Employee employee = new Employee();
                employee.setEmployeeId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setEmployeePosition(rs.getString("position"));
                employee.setEmployeeSalary(rs.getFloat("salary"));
                employee.setHireDate(rs.getString("hire_date"));
                employee.setDepartmentId(rs.getInt("department_id"));


                return employee;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }

    // xoa
    public static boolean deleteEmployee(int employeetId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_employee(?)}");
            callSt.setInt(1, employeetId);
            callSt.executeUpdate();

            result = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }
}
