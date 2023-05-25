/*
 insert into reservations"
				+ "(resNum,loc,date,memId,memName, "
				+ "memPhone,memEmail,resName,resPhone,"
				+ "totCnt, totPrice, resTime 
 */
SELECT * FROM reservations;

DELETE FROM RESERVATIONS WHERE RESNUM IS null;

CREATE TABLE reservations (
	resNum VARCHAR2(50) PRIMARY KEY,
	loc VARCHAR2(50) foreign key(deptno) references museums(musloc),
	can_date VARCHAR2(30),
	memId VARCHAR2(50) foreign key(deptno) references members(memId),
	memName VARCHAR2(50),
	memPhone VARCHAR2(50),
	memEmail VARCHAR2(50),
	resName VARCHAR2(50),
	resPhone VARCHAR2(50),
	totCnt NUMBER(30),
	totPrice NUMBER(30),
	resTime DATE
);