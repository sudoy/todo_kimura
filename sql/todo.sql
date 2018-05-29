CREATE TABLE todo(
	TODO_ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	TITLE VARCHAR(100) NOT NULL,
	DETAIL VARCHAR(300) NOT NULL,
	IMPORTANCE VARCHAR(3) NOT NULL,
	DEADLINE DATE
);

INSERT INTO todo
VALUES('1','�T���v��A','aaaaaaaaaaaaa','������','2018-05-29');
INSERT INTO todo
VALUES('2','�T���v��B','bbbbbbbbbbbbb','��','2018-05-29');
INSERT INTO todo
VALUES('3','�T���v��C','ccccccccccccc','������','2018-05-29');
INSERT INTO todo
VALUES('4','�T���v��D','ddddddddddddd','����',NULL);