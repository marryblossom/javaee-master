package com.tw.core.service.schemaService.schemaServiceImpl;

import com.tw.core.bean.*;
import com.tw.core.DAO.impl.BaseServiceImpl;
import com.tw.core.service.schemaService.SchemaService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by marry on 7/19/15.
 */
@Service
public class SchemaServiceImpl extends BaseServiceImpl implements SchemaService{
    private static Logger logger = Logger.getLogger("SchemaServiceImpl");

    @Override
    public void insertSchema(Schema schema) {
        this.save(schema);
    }

    @Override
    public void delelteSchema(String id) {
        this.deleteById(Schema.class, id);
    }

    @Override
    public List<Schema> getSchemas() {
        List<Schema> schemas = this.queryAll(Schema.class);
        return schemas;
    }

    @Override
    public Schema getSchemaById(String id) {
        Schema schema = findById(Schema.class, id);
        return schema;
    }

    @Override
    public void updateSchema(Schema schema) {
        this.update(schema);
    }
    @Override
    public List<SchemaTable> getAllSchemaTables() {
        List<SchemaTable> schemaTables = new ArrayList<SchemaTable>();
        List<Schema> schemas = getSchemas();
        for (int i = 0; i < schemas.size(); i++) {
            Course course = schemas.get(i).getCourse();
            Employee employee = schemas.get(i).getEmployee();
            if (hasExist(schemaTables, course, employee)) {
                continue;
            } else {
                String arrangeTime = getCourseArrangementTime(schemas, course, employee);
                String schemasId = getSchemasId(course,employee);
                SchemaTable schemaTable = new SchemaTable(schemasId,course, employee, arrangeTime, schemas.get(i).getState());
                schemaTable.setType(schemas.get(i).getType());
                schemaTables.add(schemaTable);
            }
        }
        return schemaTables;
    }

    @Override
    public void deleteAllSchemaByIds(String schemasId){
        String[] schemasIds = schemasId.split("\\,");
        for (int i=0;i<schemasIds.length;i++){
            delelteSchema(schemasIds[i]);
        }
    }
    private boolean hasExist(List<SchemaTable> schemaTables, Course course, Employee employee){
        for (int i = 0; i <schemaTables.size() ; i++) {
            Course courseInTable = schemaTables.get(i).getCourse();
            Employee employeeInTable = schemaTables.get(i).getEmployee();
            if (courseInTable.equals(course) && employeeInTable.equals(employee)){
                return true;
            }
        }
        return false;
    }



    @Override
    public List<Schema> getSchemaTablesByIds(String schemasId){
        String[] schemasIds = schemasId.split("\\,");
        List<Schema> schemas = new ArrayList<Schema>();
        for (int i = 0; i < schemasIds.length; i++) {
            schemas.add(getSchemaById(schemasIds[i]));
        }
        return schemas;
    }
    @Override
    public void updateSchemaTablesByIds(String schemasId){
        String[] schemasIds = schemasId.split("\\,");
        for(int i=0;i<schemasIds.length;i++){
            Schema schema = getSchemaById(schemasIds[i]);
            updateSchema(schema);
        }

    }
    @Override
    public List<Schema> getPrivateSchemas(){
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        dCriteria.add(Restrictions.eq("type", "private"));
        List<Schema> privateSchemas =  queryAllOfCondition(Schema.class, dCriteria);
        return privateSchemas;

    }

    @Override
    public List<Schema> getSchemasByEmployee(Employee employee) {
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        dCriteria.add(Restrictions.eq("employee", employee));
        List<Schema> schemas = queryAllOfCondition(Schema.class, dCriteria);
        return  schemas;
    }

    @Override
    public List<Schema> getSchemasByCustomer(Customer customer) {
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        dCriteria.add(Restrictions.eq("customer", customer));
        List<Schema> schemas = queryAllOfCondition(Schema.class, dCriteria);
        return  schemas;
    }

    @Override
    public List<Schema> getSchemasByCourse(Course course) {
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        dCriteria.add(Restrictions.eq("course", course));
        List<Schema> schemas = queryAllOfCondition(Schema.class, dCriteria);
        return  schemas;
    }
    @Override
    public void deleteAllSchemas(List<Schema> schemas){
        if (schemas.size()>0){
            deleteAll(schemas);

        }
    }

    private String getCourseArrangementTime(List<Schema> schemas,Course course, Employee employee){
        String arrangementTime = "";
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        List<Schema> schemasInTable = null;
        for (int i=0;i<schemas.size();i++){
            dCriteria.add(Restrictions.eq("course", course));
            dCriteria.add(Restrictions.eq("employee", employee));
            schemasInTable = queryAllOfCondition(Schema.class, dCriteria);
        }
        if (schemasInTable != null){
            for (int i = 0; i <schemasInTable.size()-1 ; i++) {
                Date date = schemasInTable.get(i).getDate();
                arrangementTime +=  date.toString()+",";
            }
            Date dateLast = schemasInTable.get(schemasInTable.size()-1).getDate();
            arrangementTime +=  dateLast.toString();
        }
        return arrangementTime;
    }
    @Override
    public boolean schemaAtThisTimeExist(Employee employee,Date date){
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        dCriteria.add(Restrictions.eq("employee", employee));
        dCriteria.add(Restrictions.eq("date",date));
        List<Schema> schemas = queryAllOfCondition(Schema.class, dCriteria);
        if (schemas.size()>0){
            return true;
        }
        return false;
    }
    private String getSchemasId(Course course, Employee employee){
        String schemasId = "";
        DetachedCriteria dCriteria = DetachedCriteria.forClass(Schema.class);
        dCriteria.add(Restrictions.eq("course", course));
        dCriteria.add(Restrictions.eq("employee", employee));
        List<Schema> schemasInTable = queryAllOfCondition(Schema.class, dCriteria);
        for (int i = 0; i <schemasInTable.size()-1 ; i++) {
            String schemaId = schemasInTable.get(i).getSchemaId();
            schemasId += schemaId+",";
        }
        String schemaIdLase = schemasInTable.get(schemasInTable.size()-1).getSchemaId();
        schemasId += schemaIdLase;
        return schemasId;
    }
}
