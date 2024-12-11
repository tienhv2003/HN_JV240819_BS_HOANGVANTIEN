create database quanlynhansu;
use quanlynhansu;

create table Departments
(
    department_id     int primary key auto_increment,
    department_name   varchar(50) not null unique,
    department_status bit default 1
);

create table Employee
(
    employee_id   int primary key auto_increment,
    employee_name varchar(50) not null unique,
    position      varchar(50) not null,
    salary        double      not null check ( salary > 0 ),
    hire_date     DATE        not null,
    department_id int         not null,
    foreign key (department_id) references Departments (department_id)
);

-- Làm việc với departments

-- Hiển thị phòng ban
DELIMITER &&
create procedure display_departments()
begin
select * from departments;
end &&
DELIMITER &&;

-- Thêm mới phòng ban
DELIMITER &&
create procedure create_department(
    name_in varchar(50)
)
begin
insert into departments(department_name)
    value (name_in);
end &&
DELIMITER &&;

-- Tim phong ban theo id
DELIMITER &&
create procedure find_department_by_id(id_in int)
begin
select *from departments where department_id = id_in;
end &&
DELIMITER &&;

-- Cập nhật phòng ban
DELIMITER &&
create procedure update_department(
    id_in int,
    name_in varchar(50),
    status_in bit
)
begin
update departments
set department_name   = name_in,
    department_status = status_in
where department_id = id_in;
end &&
DELIMITER &&;

-- Xóa phòng ban
DELIMITER &&
create procedure delete_department(
    id_in int
)
begin
delete from departments where department_id = id_in;
end &&
DELIMITER &&;



-- Làm việc với nhân viên
DELIMITER &&
create procedure display_employee()
begin
select * from employee;
end &&
DELIMITER &&;

-- Them moi
DELIMITER &&
create procedure create_employee(
    name_in varchar(50),
    position_in varchar(50),
    salary_in double,
    hire_date_in DATE,
    department_id_in int
)
begin
insert into employee(employee_name, position, salary, hire_date, department_id)
    value (name_in, position_in, salary_in, hire_date_in, department_id_in);
end &&
DELIMITER &&;

-- Xoa nhan vien
DELIMITER &&
create procedure delete_employee(
    id_in int
)
begin
delete from employee where employee_id = id_in;
end &&
DELIMITER &&;

-- Tim phong ban theo id
DELIMITER &&
create procedure find_employee_by_id(id_in int)
begin
select *from employee where employee_id = id_in;
end &&
DELIMITER &&;

-- Tim theo ten
DELIMITER &&
create procedure find_employee_by_name(name_in String)
begin
select *from employee where employee_name= 'name_in';
end &&
DELIMITER &&;







