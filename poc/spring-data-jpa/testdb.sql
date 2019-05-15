-- create a database as "testdb"

create table student 
(
  ID VARCHAR(20),
  FIRST_NAME VARCHAR(20)
);

INSERT INTO student (FIRST_NAME, ID) values ('Madhu','M-103');
INSERT INTO student (FIRST_NAME, ID) values ('Lakshmi','L-105');
INSERT INTO student (FIRST_NAME, ID) values ('Kanu','K-104');

commit;

SELECT * FROM testdb.student;

