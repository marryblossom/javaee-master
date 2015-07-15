/*
MySQL Data Transfer
Source Host: localhost
Source Database: adduser
Target Host: localhost
Target Database: adduser
Date: 2015/7/15 21:48:10
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for course
-- ----------------------------
CREATE TABLE course (
  courseId char(40) NOT NULL DEFAULT '',
  name varchar(40) DEFAULT NULL,
  introduction text,
  state varchar(10) DEFAULT NULL,
  type varchar(10) DEFAULT NULL,
  PRIMARY KEY (courseId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
CREATE TABLE customer (
  customerId char(40) NOT NULL DEFAULT '',
  name varchar(40) DEFAULT NULL,
  gender varchar(40) DEFAULT NULL,
  state varchar(10) DEFAULT NULL,
  type varchar(10) DEFAULT NULL,
  introduction varchar(40) DEFAULT NULL,
  PRIMARY KEY (customerId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
CREATE TABLE employee (
  gender varchar(10) DEFAULT NULL,
  email varchar(40) DEFAULT NULL,
  introduction varchar(40) DEFAULT NULL,
  state varchar(10) DEFAULT NULL,
  type varchar(10) DEFAULT NULL,
  emloyeeId char(40) NOT NULL,
  employeeName varchar(40) DEFAULT NULL,
  PRIMARY KEY (emloyeeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
CREATE TABLE user (
  userId char(40) NOT NULL DEFAULT '',
  userName varchar(40) DEFAULT NULL,
  password varchar(40) DEFAULT NULL,
  state varchar(40) DEFAULT NULL,
  type varchar(40) DEFAULT NULL,
  emloyeeId char(40) NOT NULL,
  PRIMARY KEY (userId),
  KEY R_6 (emloyeeId),
  CONSTRAINT user_ibfk_1 FOREIGN KEY (emloyeeId) REFERENCES employee (emloyeeId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
