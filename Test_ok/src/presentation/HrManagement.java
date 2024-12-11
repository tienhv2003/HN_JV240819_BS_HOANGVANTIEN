package presentation;

import business.DepartmentBusiness;
import business.EmployeeBusiness;
import entity.Departments;
import entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static business.DepartmentBusiness.findById;

public class HrManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("*********************HR-Management********************");
            System.out.println("1. Quản lý phòng ban");
            System.out.println("2. Quản lý nhân viên");
            System.out.println("3. Thoát");
            System.out.println("");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //Quản lý phòng ban
                    departmentManagement(scanner);
                    break;
                case 2:
                    //Quản lý nhân viên
                    employeeManagement(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập các chức năng từ 1 đến 3");
                    break;
            }
        } while (true);
    }

    //Quản lý department
    public static void departmentManagement(Scanner scanner) {
        inner_loop1:
        do {
            System.out.println("*********************DEPARTMENT-MENU***********************");
            System.out.println("1. Danh sách phòng ban");
            System.out.println("2. Thêm mới phòng ban");
            System.out.println("3. Cập nhật thông tin phòng ban");
            System.out.println("4. Xóa phòng ban");
            System.out.println("5. Hiển thị phòng ban có nhiều nhân viên nhất");
            System.out.println("6. Thoát");
            System.out.println("");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    //Hiển thị danh sách
                    HrManagement.displayDepartment();
                    break;
                case 2:
                    //Thêm mới
                    HrManagement.createDepartment(scanner);
                    break;
                case 3:
                    //Cập nhật
                    HrManagement.updateDepartment(scanner);
                    break;
                case 4:
                    //Xóa phòng ban
                    HrManagement.deleteDepartment(scanner);
                    break;
                case 5:
                    break;
                case 6:
                    break inner_loop1;
                default:

            }
        } while (true);
    }

    public static void displayDepartment() {
        List<Departments> listDepartment = DepartmentBusiness.displayDepartments();
        listDepartment.forEach(Departments::outputData);
    }

    // Tạo mới department
    public static void createDepartment(Scanner scanner) {
        Departments department = new Departments();
        department.inputData(scanner);
        boolean result = DepartmentBusiness.createNewDepartment(department);
        if (result) {
            System.out.println("Phòng ban đã được thêm mới");
        } else {
            System.out.println("Thêm mới thất bại");
        }

    }

    // Update phòng ban
    public static void updateDepartment(Scanner scanner) {
        System.out.println("Nhập vào mã phòng ban muốn cập nhật thông tin: ");
        int findDepartmentId = Integer.parseInt(scanner.nextLine());
        Departments departmentUpdate = findById(findDepartmentId);
        if (departmentUpdate != null) {
            boolean isExit = true;
            departmentUpdate.outputData();
            inner_loop3:
            do {
                System.out.println("1. Cập nhật tên phòng ban: ");
                System.out.println("2. Cập nhật trạng thái: ");
                System.out.println("3. Thoát");
                System.out.println("Nhập vào lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Cập nhật tên phòng ban: ");
                        departmentUpdate.setDepartmentName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Cập nhật trạng thái: ");
                        departmentUpdate.setDepartmentStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 3:
                        break inner_loop3;
                    default:
                        System.err.println("Vui lòng chỉ cập nhật các chức năng từ 1 đến 3");
                }
            } while (isExit);
            boolean result = DepartmentBusiness.updateDepartment(departmentUpdate);
            if (result) {
                System.out.println("Phòng ban được cập nhật");
            } else {
                System.out.println("Cập nhật thất bại");
            }
        }
    }

    //Xóa phòng ban
    public static void deleteDepartment (Scanner scanner){
        System.out.println("Nhập mã phòng ban muốn xóa: ");
        int deleteDepartmentId = Integer.parseInt(scanner.nextLine());
        boolean result = DepartmentBusiness.deleteDepartment(deleteDepartmentId);
        if (result) {
            System.out.println("Phòng ban đã được xóa ");
        } else {
            System.out.println("Xóa thất bại");
        }
    }





    //Quản lý nhân viên
    public static void employeeManagement(Scanner scanner) {
        inner_loop2:
        do {
            System.out.println("********************EMPLOYEE-MENU**********************");
            System.out.println("1. Danh sách nhân viên");
            System.out.println("2. Thêm mới nhân viên");
            System.out.println("3. Cập nhật thông tin nhân viên");
            System.out.println("4. Xóa nhân viên");
            System.out.println("5. Hiển thị danh sách nhân viên theo phòng ban");
            System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
            System.out.println("7. Hiển thị top 5 nhân viên có lương cao nhất");
            System.out.println("8. Thoát");
            System.out.println("");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    HrManagement.displayEmployee();
                    break;
                case 2:
                    HrManagement.createEmployee(scanner);
                    break;
                case 3:
                    HrManagement.deleteEmployee(scanner);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    // tim nhan vien theo ten
                    break;
                case 7:
                    break;
                case 8:
                    break inner_loop2;
                default:
                    System.err.println("Vui lòng chỉ chọn các chức năng từ 1 đến 8!");
                    break;

            }
        } while (true);
    }

    public static void displayEmployee()  {
        List<Employee> listEmployee = EmployeeBusiness.displayEmployee();
        listEmployee.forEach(Employee::outputData);
    }

    public static void createEmployee(Scanner scanner) {
        Employee employee = new Employee();
        employee.inputData(scanner);
        boolean result = EmployeeBusiness.createNewEmployee(employee);
        if (result) {
            System.out.println("Nhân viên đã được thêm mới");
        } else {
            System.out.println("Thêm mới thất bại");
        }

    }

    //xoa
    public static void deleteEmployee (Scanner scanner){
        System.out.println("Nhập mã nhân viên muốn xóa: ");
        int deleteEmployeeId = Integer.parseInt(scanner.nextLine());
        boolean result = EmployeeBusiness.deleteEmployee(deleteEmployeeId);
        if (result) {
            System.out.println("Nhan vien đã được xóa ");
        } else {
            System.out.println("Xóa thất bại");
        }
    }

}
