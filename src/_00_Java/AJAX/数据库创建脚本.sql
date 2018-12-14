-- 一、删除数据库
DROP DATABASE IF EXISTS ajax;
-- 二、创建数据库
CREATE DATABASE ajax CHARACTER SET UTF8;
-- 三、使用ajax数据库
USE ajax;
-- 四、删除数据表
DROP TABLE IF EXISTS member ;
-- 五、创建数据表
CREATE TABLE member(
	mid			VARCHAR(50),
	password	VARCHAR(32)	NOT NULL,
	CONSTRAINT pk_mid PRIMARY KEY(mid)
) ;
-- 六、增加测试数据
--'password' 通过MD5加密后的内容= '5d41402abc4b2a76b9719d911017c592' ;
--'java' 通过MD5加密后的内容= '93f725a07423fe1c889f448b33d21f46' ;
INSERT INTO member(mid,password) VALUES('admin','5d41402abc4b2a76b9719d911017c592') ;
INSERT INTO member(mid,password) VALUES('pp','93f725a07423fe1c889f448b33d21f46') ;
-- 七、事务提交
COMMIT ;



show tables;
select * from member;
