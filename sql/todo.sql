CREATE TABLE todo(
	TODO_ID INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	TITLE VARCHAR(100) NOT NULL,
	DETAIL VARCHAR(300) NOT NULL,
	IMPORTANCE VARCHAR(3) NOT NULL,
	DEADLINE DATE
);

INSERT INTO todo
VALUES('1','サンプルA','aaaaaaaaaaaaa','★★★','2018-05-29');
INSERT INTO todo
VALUES('2','サンプルB','bbbbbbbbbbbbb','★','2018-05-29');
INSERT INTO todo
VALUES('3','サンプルC','ccccccccccccc','★★★','2018-05-29');
INSERT INTO todo
VALUES('4','サンプルD','ddddddddddddd','★★',NULL);