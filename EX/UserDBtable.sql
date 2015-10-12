新建USER表
CREATE TABLE UserTable(
UserId int(10) NOT NULL auto_increment,
UserName varchar(20) NOT NULL UNIQUE,
Password varchar(32),
MailAdd varchar(25) NOT NULL UNIQUE,
VerifyCode  varchar(32),
Status int(1) NOT NULL,
Description varchar(80) Default 'Blank Description',
PRIMARY KEY  (UserId)
);

插入新用户到USER表
INSERT INTO UserTable set UserName='limitwh',Password='5a690d842935c51f26f473e025c1b97a',
MailAdd='limitwh@163.com',Status=0,Description='User table test limitwh';
INSERT INTO UserTable set UserName='limitem',Password='e6a52c828d56b46129fbf85c4cd164b3',
MailAdd='limitem@163.com',Status=0,Description='User table test limitem';

建立试图：
CREATE VIEW UserView AS SELECT UserId,UserName,MailAdd,VerifyCode,Status,Description FROM UserTable;

CREATE VIEW UserPSWView AS SELECT UserName,Password FROM UserTable;

CREATE VIEW UserVerifyView AS SELECT UserName,VerifyCode FROM UserTable;

新建用户并授权
GRANT USAGE ON *.* TO 'useradminH'@'localhost' IDENTIFIED BY '123456' WITH GRANT OPTION;
GRANT SELECT,INSERT,UPDATE,DELETE,CREATE,DROP ON userdb.*  TO 'useradminA'@'localhost' IDENTIFIED BY '123456';
GRANT SELECT ON userdb.*  TO 'useradminH'@'localhost' IDENTIFIED BY '123456';

SHOW GRANTS for 'useradminH'@'localhost';

Delete FROM user Where User='useradminH' and Host='localhost';

Drop view userpswview;
Drop view userverifyview;
Drop table usertable;

在命令行中输入下列，以useradminH登录mysql
mysql -u useradminH -p