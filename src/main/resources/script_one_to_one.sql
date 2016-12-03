create database db1;
use db1;
create table Employee(
  ID INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20),
  ROLE VARCHAR(20),
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