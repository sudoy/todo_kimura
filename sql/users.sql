CREATE TABLE users(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL,
	name VARCHAR(100) NOT NULL
);

INSERT INTO users(id, email, password, name)
VALUES('1', 'kimura@gmail.com', MD5('kimura'), '木村');

INSERT INTO users(id, email, password, name)
VALUES('2', 'tanaka@gmail.com', MD5('tanaka'), '田中');

INSERT INTO users(id, email, password, name)
VALUES('3', 'akiyama@gmail.com', MD5('akiyama'), '秋山');