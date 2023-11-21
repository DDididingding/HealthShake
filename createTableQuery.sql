DROP DATABASE IF EXISTS jhgpt_db;

-- Create the database
CREATE DATABASE IF NOT EXISTS jhgpt_db;

-- Use the created database
USE jhgpt_db;

-- Create the Member table
CREATE TABLE IF NOT EXISTS Member (
    member_code INT PRIMARY KEY AUTO_INCREMENT,
    member_id VARCHAR(255) NOT NULL,
    member_password VARCHAR(255) NOT NULL,
    member_name VARCHAR(255) NOT NULL,
    member_nickname VARCHAR(255) NOT NULL,
    member_age INT,
    member_gender VARCHAR(10),
    member_profile_pic VARCHAR(255),
    member_status INT DEFAULT 3
);

-- Create the User table
CREATE TABLE IF NOT EXISTS User (
    member_code INT PRIMARY KEY,
    prefer_part VARCHAR(255),
    prefer_gender VARCHAR(10),
    prefer_style VARCHAR(255),
    prefer_goal VARCHAR(255),
    user_readme TEXT,
    FOREIGN KEY (member_code) REFERENCES Member(member_code)
);

-- Create the Trainer table
CREATE TABLE IF NOT EXISTS Trainer (
    member_code INT PRIMARY KEY,
    provide_part VARCHAR(255),
    provide_style VARCHAR(255),
    provide_goal VARCHAR(255),
    video_list TEXT,
    trainer_readme TEXT,
    trainer_price INT,
    trainer_review TEXT,
    trainer_rating FLOAT,
    FOREIGN KEY (member_code) REFERENCES Member(member_code)
);

-- Create the Video table
CREATE TABLE IF NOT EXISTS Video (
    video_code INT PRIMARY KEY AUTO_INCREMENT,
    video_title VARCHAR(255) NOT NULL,
    video_readme TEXT,
    video_url VARCHAR(255) NOT NULL,
    video_viewcnt INT DEFAULT 0,
    video_uploader INT,
    FOREIGN KEY (video_uploader) REFERENCES Member(member_code)
);

-- Create the BuyList table
CREATE TABLE IF NOT EXISTS Buylist (
    buylist_code INT PRIMARY KEY AUTO_INCREMENT,
    user_member_code INT,
    trainer_member_code INT,
    buy_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (user_member_code) REFERENCES User(member_code),
    FOREIGN KEY (trainer_member_code) REFERENCES Trainer(member_code)
);

-- Create the Board table
CREATE TABLE IF NOT EXISTS Board (
    board_code INT PRIMARY KEY AUTO_INCREMENT,
    member_code INT,
    board_title VARCHAR(255) NOT NULL,
    board_content TEXT,
    board_uploader INT,
    board_viewcnt INT DEFAULT 0,
    board_uploadtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    board_modify_status BOOLEAN DEFAULT 0,
    FOREIGN KEY (member_code) REFERENCES Member(member_code)
);

-- Create the Review table
CREATE TABLE IF NOT EXISTS Review (
    review_code INT PRIMARY KEY AUTO_INCREMENT,
    member_code INT,
    review_rating INT,
    review_content TEXT,
    review_uploadtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    review_like INT DEFAULT 0,
    review_dislike INT DEFAULT 0,
    review_writer INT,
    FOREIGN KEY (member_code) REFERENCES Member(member_code),
    FOREIGN KEY (review_writer) REFERENCES User(member_code)
);
