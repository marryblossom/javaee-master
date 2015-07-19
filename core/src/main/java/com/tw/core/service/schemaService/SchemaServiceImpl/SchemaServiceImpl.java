package com.tw.core.service.schemaService.schemaServiceImpl;

import com.tw.core.bean.Course;
import com.tw.core.bean.Employee;
import com.tw.core.bean.Schema;
import com.tw.core.bean.SchemaTable;
import com.tw.core.service.baseService.impl.BaseServiceImpl;
import com.tw.core.service.schemaService.SchemaService;
import com.tw.core.util.StringSplitHelper;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
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
                schemaTables.add(schemaTable);
            }
        }
        return schemaTables;
    }

    @Override
    public void deleteAllSchema(String schemasId){
        String[] schemasIds = schemasId.split("\\,");
        logger.info("this is schemasIds" + schemasIds[0]);
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
