package com.tw.core.service.schemaService.schemaServiceImpl;

import com.tw.core.bean.Schema;
import com.tw.core.service.baseService.impl.BaseServiceImpl;
import com.tw.core.service.schemaService.SchemaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by marry on 7/19/15.
 */
@Service
public class SchemaServiceImpl extends BaseServiceImpl implements SchemaService{

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
}
