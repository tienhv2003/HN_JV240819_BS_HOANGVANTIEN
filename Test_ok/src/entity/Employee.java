package entity;

import java.util.Date;
import java.util.Scanner;

public class Employee implements IHrManagement {
    private int employeeId;
    private String employeeName;
    private String employeePosition;
    private float employeeSalary;
    private String hireDate;
    private int departmentId;

    public Employee() {
    }

    public Employee(int employeeId, String employeeName, String employeePosition, float employeeSalary, String hireDate, int departmentId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
        this.hireDate = hireDate;
        this.departmentId = departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public float getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(float employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào tên nhân viên: ");
        employeeName = scanner.nextLine();
        System.out.println("Nhập vào vị trí công việc: ");
        employeePosition = scanner.nextLine();
        System.out.println("Nhập vào lương: ");
        employeeSalary = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào ngày tuyển dụng");
        hireDate = scanner.nextLine();
        System.out.println("Nhập phòng ban trực thuộc");
        departmentId = scanner.nextInt();

    }

    @Override
    public void outputData() {
        System.out.println("Mã nhân viên: "+ this.employeeId);
        System.out.println("    Tên nhân viên: "+ this.employeeName);
        System.out.println("    Vị trí công việc: "+this.employeePosition);
        System.out.println("    Mức lương: "+ this.employeeSalary);
        System.out.println("    Ngày tuyển dụng:  "+ this.hireDate);
        System.out.println("    Phòng ban trực thuộc:  "+ this.departmentId);

    }
}
