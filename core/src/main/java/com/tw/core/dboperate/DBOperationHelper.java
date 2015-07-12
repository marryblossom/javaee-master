package com.tw.core.dboperate;

import com.tw.core.bean.Person;
import com.tw.core.util.DBConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBOperationHelper {
    private static final String SELECT_SQL= "select name,gender,email,age, id from person";
    private static final String SELECT_ONE_SQL= "select name,gender,email,age,id from person where id=?";
    private static final String DELETE_SQL = "delete from person where id=?;";
    private static final String INSERT_SQL = "insert into person(id, name, gender, email, age) values(?, ?, ?, ?, ?);";
    private static final String UPDATE_SQL = "update person set name=?, gender=?, email=?, age=? where id=?";

    public List<Person> selectData() {
        DBConnectionHelper dbHlper = new DBConnectionHelper();
        Connection connection = dbHlper.dbConnection();
        List<Person> people = new ArrayList();
        try {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_SQL);
            ResultSet rs = pstmt.executeQuery(SELECT_SQL);
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getString(5));
                person.setName(rs.getString(1));
                person.setGender(rs.getString(2));
                person.setEmail(rs.getString(3));
                person.setAge(new Integer(rs.getString(4)));
                people.add(person);
            }
            dbHlper.dbClose(pstmt,rs,connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return people;
    }
    public void insertData(String name, String gender, String email, int age){
        DBConnectionHelper dbHlper = new DBConnectionHelper();
        Connection connection = dbHlper.dbConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_SQL);
            ResultSet rs = pstmt.executeQuery(SELECT_SQL);
            rs.last();
            int rowCount = rs.getRow();
            pstmt = connection.prepareStatement(INSERT_SQL);
            pstmt.setInt(1, rowCount + 1);
            pstmt.setString(2, name);
            pstmt.setString(3, gender);
            pstmt.setString(4, email);
            pstmt.setInt(5, age);
            pstmt.executeUpdate();
            dbHlper.dbClose(pstmt,rs,connection);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteData(int id){
        DBConnectionHelper dbHlper = new DBConnectionHelper();
        Connection connection = dbHlper.dbConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(DELETE_SQL);
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            pstmt.close();
            connection.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public Person inquirePerson(String id){
        DBConnectionHelper dbHlper = new DBConnectionHelper();
        Connection connection = dbHlper.dbConnection();
        Person person = new Person();
        try {
            PreparedStatement pstmt = connection.prepareStatement(SELECT_ONE_SQL);
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                person.setId(id);
                person.setName(rs.getString(1));
                person.setGender(rs.getString(2));
                person.setEmail(rs.getString(3));
                person.setAge(new Integer(rs.getString(4)));
            }
            dbHlper.dbClose(pstmt, rs, connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }
    public void updateData(String name, String gender, String email, int age,int id){
        DBConnectionHelper dbHlper = new DBConnectionHelper();
        Connection connection = dbHlper.dbConnection();
        try {
            PreparedStatement pstmt = connection.prepareStatement(UPDATE_SQL);
            pstmt.setString(1, name);
            pstmt.setString(2,gender);
            pstmt.setString(3,email);
            pstmt.setInt(4,age);
            pstmt.setInt(5,id);
            pstmt.executeUpdate();
            pstmt.close();
            pstmt.close();
            connection.close();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        DBOperationHelper helper = new DBOperationHelper();
       // System.out.print(helper.selectData().size());
        helper.deleteData(4);


    }
}
