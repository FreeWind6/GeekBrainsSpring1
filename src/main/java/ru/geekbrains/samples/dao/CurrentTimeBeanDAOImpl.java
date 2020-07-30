package ru.geekbrains.samples.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dmitry Kubyshkin
 * @dateOfCreation 29.07.2020
 */
public class CurrentTimeBeanDAOImpl implements CurrentTimeBeanDAO {
    @Override
    public String getText() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return "Hi! Current time is " + dateFormat.format(date);
    }
}
