package com.tw.core.service.schemaService;

import com.tw.core.bean.Schema;
import com.tw.core.bean.User;

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
}
