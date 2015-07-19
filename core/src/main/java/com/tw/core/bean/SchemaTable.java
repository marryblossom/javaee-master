package com.tw.core.bean;

import java.util.Date;
import java.util.UUID;

/**
 * Created by marry on 7/19/15.
 */
public class SchemaTable {
    private String schemaTableId;
    private String schemasId;
    private Course course;
    private Employee employee;
    private Coach coach;
    private String date;

    public SchemaTable() {

    }

    String state;
    private String type;

    public SchemaTable(String schemasId,Course course,Employee employee,String date,String state) {
        UUID schemaTableId = new UUID(6, 6);
        this.schemaTableId = schemaTableId.toString();
        this.schemasId = schemasId;
        this.employee = employee;
        this.course = course;
        this.date = date;
        this.state = state;
    }



    public String getSchemasId() {
        return schemasId;
    }

    public void setSchemasId(String schemasId) {
        this.schemasId = schemasId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {

        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDate() {

        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Coach getCoach() {

        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }

    public Course getCourse() {

        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getSchemaTableId() {

        return schemaTableId;
    }

    public void setSchemaTableId(String schemaTableId) {
        this.schemaTableId = schemaTableId;
    }
}
