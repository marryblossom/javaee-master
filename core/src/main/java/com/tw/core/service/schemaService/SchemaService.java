package com.tw.core.service.schemaService;

import com.tw.core.bean.*;
import com.tw.core.util.DateParseHelper;

import java.util.Date;
import java.util.List;

/**
 * Created by marry on 7/19/15.
 */
public interface SchemaService {
    public void insertSchema(Schema schema);
    public void delelteSchema(String id);
    public List<Schema> getSchemas();
    public Schema getSchemaById(String id);
    public void updateSchema(Schema schema);


    public List<SchemaTable> getAllSchemaTables();
    public List<Schema> getSchemaTablesByIds(String schemasId);
    public void deleteAllSchemaByIds(String schemasId);
    public void updateSchemaTablesByIds(String schemasId);

    public List<Schema> getPrivateSchemas();

    public List<Schema> getSchemasByEmployee(Employee employee);
    public List<Schema> getSchemasByCustomer(Customer customer);
    public List<Schema> getSchemasByCourse(Course course);

    public void deleteAllSchemas(List<Schema> schemas);
    public boolean schemaAtThisTimeExist(Employee employee, Date date);
}
