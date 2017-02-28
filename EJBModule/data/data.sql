DROP TABLE IF EXISTS student;

CREATE TABLE student (
  studentid char(7) PRIMARY KEY,
  name char(255) NOT NULL,
  password char(20) NOT NULL,
  accountid char(9),
  vip int DEFAULT 0,
  point double DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO student(studentid,name,password) VALUES ('1234567','司马懿','123456');
INSERT INTO student(studentid,name,password) VALUES ('1000001','诸葛亮','123456');
INSERT INTO student(studentid,name,password) VALUES ('1000002','曹植','123456');
INSERT INTO student(studentid,name,password) VALUES ('1000003','刘庆','123456');

DROP TABLE IF EXISTS account;
CREATE TABLE account (
  accountid char(9) PRIMARY KEY,
  bankcardid char(20),
  money double DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS bankcard;
CREATE TABLE bankcard (
  bankcardid char(20) PRIMARY KEY,
  balance double DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO bankcard VALUES ('12345678901234567890',1998);
INSERT INTO bankcard VALUES ('12345678901234567891',11888);
INSERT INTO bankcard VALUES ('12345678901234567892',8888);
INSERT INTO bankcard VALUES ('12345678901234567893',128888.7);
INSERT INTO bankcard VALUES ('12345678901234567894',6900.7);
INSERT INTO bankcard VALUES ('12345678901234567895',46900);

DROP TABLE IF EXISTS institution;
CREATE TABLE institution(
 institutionid char(7) PRIMARY KEY,
 name char(255) NOT NULL,
 password char(50) NOT NULL ,
 accountid char(27)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO institution(institutionid, name, password, accountid) VALUES ('9000001','蓝翔职业技术学院','123456','900000112345678901234567891');
INSERT INTO institution(institutionid, name, password) VALUES ('9000002','新东方','123456');


DROP TABLE IF EXISTS course;
CREATE TABLE course(
 courseid char(8) PRIMARY KEY,
 coursename char(255) NOT NULL,
 starttime date,
 endtime date,
 teacher char(255),
 institutionid char(7) NOT NULL ,
 price double DEFAULT 0,
 approveState int DEFAULT 0,
 reserveNum int DEFAULT 0,
 dropReserveNum int DEFAULT 0,
 dropNum int DEFAULT 0,
 income double DEFAULT 0,
 unIncome DOUBLE DEFAULT 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO course(courseid, coursename, starttime, endtime, teacher, institutionid, price) VALUES ('10000001','J2EE与中间件','2017-01-22','2017-04-23','李华','9000001',398);
INSERT INTO course(courseid, coursename, starttime, endtime, teacher, institutionid, price) VALUES ('10000002','嵌入式','2017-02-22','2017-05-23','刘欢','9000001',198);

DROP TABLE IF EXISTS manager;
CREATE TABLE manager(
  managerid char(7) PRIMARY KEY,
  name char(255) NOT NULL,
  password char(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO manager(managerid, name, password) VALUES ('5000001','刘峰','123456');


DROP TABLE IF EXISTS stud_cour;
CREATE TABLE stud_cour(
  id char(15) PRIMARY KEY,
  studentid char(7) NOT NULL ,
  courseid char(8) NOT NULL ,
  sctime date,
  grade double,
  state int
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO stud_cour(id, studentid, courseid, sctime, state) VALUES ('100000110000001','1000001','10000001','2016-12-23',0);

DROP TABLE IF EXISTS generatorBean;
CREATE TABLE generatorBean(
  id char(3) PRIMARY KEY ,
  studentid char(7) NOT NULL ,
  institutionid char(7) NOT NULL,
  courseid char(8) NOT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO generatorBean(id, studentid, institutionid, courseid) VALUES ('000','1000006','9000005','10000009');