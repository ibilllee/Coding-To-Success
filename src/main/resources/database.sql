DROP DATABASE cts;
CREATE DATABASE IF NOT EXISTS cts DEFAULT CHARSET utf8mb4;
USE cts;

DROP TABLE IF EXISTS bulletin;
DROP TABLE IF EXISTS answer;
DROP TABLE IF EXISTS problem;
DROP TABLE IF EXISTS comment;
DROP TABLE IF EXISTS tutorial;
DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS data;

CREATE TABLE IF NOT EXISTS user
(
    user_id      VARCHAR(255) PRIMARY KEY,
    password     TEXT NOT NULL,
    STATUS       BOOL,
    head_address TEXT         NOT NULL
);

CREATE TABLE IF NOT EXISTS admin
(
    admin_id VARCHAR(20) PRIMARY KEY,
    password TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS tutorial
(
    tuto_id       INT PRIMARY KEY auto_increment,
    title_content VARCHAR(255),
    title_num     DOUBLE NOT NULL UNIQUE,
    content       LONGTEXT
);

CREATE TABLE IF NOT EXISTS comment
(
    comment_id      INT AUTO_INCREMENT PRIMARY KEY,
    comment_tuto_id INT         NOT NULL,
    comment_user_id VARCHAR(20) NOT NULL,
    content         TEXT,
    reply_to        INT,
    reply_order     INT,

    FOREIGN KEY (comment_tuto_id)
        REFERENCES tutorial (tuto_id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT,

    FOREIGN KEY (comment_user_id)
        REFERENCES user (user_id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS problem
(
    prob_id      INT PRIMARY KEY,
    prob_tuto_id INT NOT NULL,
    content      TEXT,

    FOREIGN KEY (prob_tuto_id)
        REFERENCES tutorial (tuto_id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS answer
(
    ans_prob_id INT PRIMARY KEY,
    content     TEXT,

    FOREIGN KEY (ans_prob_id)
        REFERENCES problem (prob_id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS data
(
    id           INT PRIMARY KEY auto_increment,
    data_prob_id INT,
    data_id      INT,
    data_in      LONGTEXT,
    data_out     LONGTEXT,

    FOREIGN KEY (data_prob_id)
        REFERENCES problem (prob_id)
        ON DELETE RESTRICT
        ON UPDATE RESTRICT
);

CREATE TABLE IF NOT EXISTS bulletin
(
    bulletin_id INT AUTO_INCREMENT PRIMARY KEY,
    content     TEXT
);

INSERT INTO user
VALUES ("user", "7hHLsZBS5AsHqsDKBgwj7g==", TRUE, "adress");
INSERT INTO tutorial
VALUES (1, "??????", 1.0, "??????");
INSERT INTO problem
VALUES (1, 1, "??????");
INSERT INTO answer
VALUES (1, "??????");
INSERT INTO comment
VALUES (NULL, 1, "user", "??????1", NULL, NULL);
INSERT INTO comment
VALUES (NULL, 1, "user", "??????2", 2, 1);

INSERT INTO admin
VALUES ("admin", "ISMvKXpXpadDiUoOSoAfww==");

INSERT INTO user
VALUES ("CLOSED_ACCOUNT", "CLOSED_ACCOUNT", 3, "NULL");