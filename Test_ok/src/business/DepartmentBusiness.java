package business;

import entity.Departments;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentBusiness {
    //Hiển thị
    public static List<Departments> displayDepartments() {
        //1. Khởi tạo đối tượng Connection và CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2. Khởi tạo kết quả trả về
        List<Departments> listDepartments = null;
        try {
            //3. Khởi tạo giá trị cho đối tượng ConnectionDB và CallableStatement
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call display_departments()}");
            //4. Set giá trị cho các tham số vào
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Gọi đối tượng procedure
            ResultSet rs = callSt.executeQuery();
            //7. Xử lý kết quả
            listDepartments = new ArrayList<Departments>();
            while (rs.next()) {
                Departments department = new Departments();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDepartmentStatus(rs.getBoolean("department_status"));
                listDepartments.add(department);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listDepartments;
    }

    //Thêm mới
    public static boolean createNewDepartment(Departments department) {
        Connection conn = null;
        CallableStatement callSt = null;

        boolean result = false;
        try {
            //3. Khởi tạo giá trị cho Conn và callSt
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_department(?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setString(1, department.getDepartmentName());
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

    // Tìm kiếm
    public static Departments findById(int departmentId) {
        //1 Khởi tạo đối tượng Connection và CallableStatement
        Connection conn = null;
        CallableStatement callSt = null;
        //2.  Khởi tạo kết quả trả về
        try {
            //3. Khởi tạo giá trị cho các đối tượng
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_department_by_id(?)}");
            //4. Set giá trị cho các tham số vào
            callSt.setInt(1, departmentId);
            //5. Đăng ký kiểu dữ liệu cho các tham số trả ra
            //6. Thực hiện gọi procedure
            ResultSet rs = callSt.executeQuery();
            //7. Xử lý kết quả
            if (rs.next()) {
                Departments department = new Departments();
                department.setDepartmentId(rs.getInt("department_id"));
                department.setDepartmentName(rs.getString("department_name"));
                department.setDepartmentStatus(rs.getBoolean("department_status"));
                return department;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return null;
    }

    //Cập nhật
    public static boolean updateDepartment(Departments department) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_department(?,?,?)}");

            callSt.setInt(1, department.getDepartmentId());
            callSt.setString(2, department.getDepartmentName());
            callSt.setBoolean(3, department.getDepartmentStatus());

            callSt.executeUpdate();
            result = true;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
        return result;
    }

    //Xóa phòng ban
    public static boolean deleteDepartment(int departmentId) {
        Connection conn = null;
        CallableStatement callSt = null;
        boolean result = false;
        try{
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_department(?)}");
            callSt.setInt(1, departmentId);
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
