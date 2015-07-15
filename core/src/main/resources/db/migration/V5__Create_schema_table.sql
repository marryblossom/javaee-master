SET FOREIGN_KEY_CHECKS=0;
CREATE TABLE schemaTable (
  schemaId char(40) NOT NULL DEFAULT '',
  date date DEFAULT NULL,
  customerId char(40) DEFAULT NULL,
  courseId char(40) DEFAULT NULL,
  state varchar(10) DEFAULT NULL,
  type varchar(10) DEFAULT NULL,
  emloyeeId char(40) DEFAULT NULL,
  PRIMARY KEY (schemaId),
  KEY R_3 (customerId),
  KEY R_5 (courseId),
  KEY R_4 (emloyeeId),
  CONSTRAINT schema_ibfk_3 FOREIGN KEY (emloyeeId) REFERENCES employee (emloyeeId),
  CONSTRAINT schema_ibfk_1 FOREIGN KEY (customerId) REFERENCES customer (customerId),
  CONSTRAINT schema_ibfk_2 FOREIGN KEY (courseId) REFERENCES course (courseId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;