package entity;


import java.util.Scanner;

public class Departments implements IHrManagement {
    private int departmentId;
    private String departmentName;
    private Boolean departmentStatus;

    public Departments() {
    }

    public Departments(int departmentId, String departmentName, Boolean departmentStatus) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentStatus = departmentStatus;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Boolean getDepartmentStatus() {
        return departmentStatus;
    }

    public void setDepartmentStatus(Boolean departmentStatus) {
        this.departmentStatus = departmentStatus;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên phòng ban: ");
        this.departmentName = scanner.nextLine();
    }

    @Override
    public void outputData() {
        System.out.println("Thông tin phòng ban");
        System.out.println("Mã phòng ban: "+this.departmentId);
        System.out.println("   Tên phòng ban: "+this.departmentName);
        System.out.printf("   Trạng thái phòng ban: %s\n", this.departmentStatus?"Hoạt động":"Không hoạt động");
    }
}
