package com.journaldev.hibernate.dao;

import com.journaldev.hibernate.model.Employee;

import java.util.List;

public interface EmployeeDao {
    public static final String TABLE_NAME = "Employee";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";

    public static final String SQL_FIND_ALL = "from " + TABLE_NAME;
    //    public static final String SQL_FIND_BY_ID = SQL_FIND_ALL + " where " + Item.ID_COLUMN + " = ?";
    //    public static final String SQL_INSERT = "insert into " + Item.TABLE_NAME + " (" + Item.NAME_COLUMN + ", " + Item.WAREHOUSE_ID_COLUMN + ") values (?, ?)";
    //    public static final String SQL_UPDATE = "update " + Item.TABLE_NAME + " set " + Item.NAME_COLUMN + " where " + Item.ID_COLUMN + " = ?";
    //    public static final String SQL_DELETE = "delete from " + Item.TABLE_NAME + " where " + Item.ID_COLUMN + " = ?";

    public List<Employee> getListAllEmployee();
    public List<Employee> getListEmployeeByName(String nameEmpl);
    public void showAllNicknamesEmployee();
    public List<Employee> getListEmployeeByDate(String dateSelect);
    public List<Employee> getListEmployeeAfterDate(String dateAfter);
    //    public Item findById(Long id);
    //    public void insert(Item item);
    //    public void update(Item item);
    //    public void delete(Item item);
}