USE banco;

delete from user;

CREATE TABLE IF NOT EXISTS `user` (
    id INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(120) NOT NULL,
    session_id VARCHAR(120),
    password VARCHAR(40) NOT NULL
);