DROP DATABASE cts;
CREATE DATABASE IF NOT EXISTS  cts DEFAULT charset utf8mb4;
USE cts;

DROP TABLE IF EXISTS bulletin;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS problem;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS tutorial;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS user;

CREATE TABLE IF NOT EXISTS  user(
	user_id varchar(20) primary key,
	password varchar(20) not null,
	status bool);

CREATE TABLE IF NOT EXISTS  admin(
	admin_id varchar(20) primary key,
	password varchar(20) not null);
	
CREATE TABLE IF NOT EXISTS  tutorial(
	tuto_id int primary key,
	title varchar(255),
	title_num double not null,
	content LONGTEXT);
	
CREATE TABLE IF NOT EXISTS  comment(
	comment_id int AUTO_INCREMENT primary key,
	comment_tuto_id int,
	comment_user_id varchar(20),
	content TEXT,
	reply_to int,
	reply_order int,

	FOREIGN KEY (comment_tuto_id)
	REFERENCES tutorial(tuto_id)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT,

	FOREIGN KEY (comment_user_id)
	REFERENCES user(user_id)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT
	);

CREATE TABLE IF NOT EXISTS  problem(
	prob_id int primary key,
	prob_tuto_id int,
	content TEXT,

	FOREIGN KEY (prob_tuto_id)
	REFERENCES tutorial(tuto_id)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT
	);

CREATE TABLE IF NOT EXISTS answer(
	ans_prob_id int primary key,
	content TEXT,

	FOREIGN KEY (ans_prob_id)
	REFERENCES problem(prob_id)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT
	);

CREATE TABLE IF NOT EXISTS  bulletin(
	bulletin_id int AUTO_INCREMENT primary key,
	content TEXT);

INSERT INTO user VALUES("user","user",true);
INSERT INTO tutorial VALUES(1,"标题",1.0,"内容");
INSERT INTO problem VALUES(1,1,"内容");
INSERT INTO answer VALUES(1,"内容");
INSERT INTO comment VALUES(NULL ,1,"user","内容1",NULL,NULL);
INSERT INTO comment VALUES(NULL ,1,"user","内容2",2,1);