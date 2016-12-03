create database db1;
use db1;
create table Employee(
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(20),
  role VARCHAR(20),
  insert_time DATE,
  PRIMARY KEY (ID)
);
-- Create Department table with one to one communication to Employee
create table Department(
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Department_EmployeesID FOREIGN KEY (id) REFERENCES Employee (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
-- Create Nickname table with one to many communication to Employee
CREATE TABLE Nickname (
  id INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  employee_id int(11) unsigned NOT NULL,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_Nickname_EmployeeID FOREIGN KEY (employee_id) REFERENCES Employee (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
