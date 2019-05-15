-- create schema as "test_schema"

create table STUDENT 
(
  ID VARCHAR(20),
  FIRST_NAME VARCHAR(20)
);

INSERT INTO STUDENT (FIRST_NAME, ID) values ('Madhu','M-103');
INSERT INTO STUDENT (FIRST_NAME, ID) values ('Lakshmi','L-105');
INSERT INTO STUDENT (FIRST_NAME, ID) values ('Kanu','K-104');

commit;

SELECT * FROM test_schema.STUDENT;


