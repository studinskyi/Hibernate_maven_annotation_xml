package com.journaldev.hibernate.dao;

import com.journaldev.hibernate.model.Nickname;

import java.util.List;

public interface NicknameDao {
    public static final String TABLE_NAME = "Nickname";
    public static final String ID_COLUMN = "id";
    public static final String NAME_COLUMN = "name";

    public static final String SQL_FIND_ALL = "from " + TABLE_NAME;

    public List<Nickname> getListAllNicknames();
}
