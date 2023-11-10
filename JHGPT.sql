-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ssafit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ssafit` DEFAULT CHARACTER SET utf8mb3 ;
USE `ssafit` ;

-- -----------------------------------------------------
-- Table `ssafit`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  `role` VARCHAR(50) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafit`.`board`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`board` (
  `board_id` INT NOT NULL AUTO_INCREMENT,
  `author_id` INT NULL DEFAULT NULL,
  `post_content` TEXT NULL DEFAULT NULL,
  `post_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`board_id`),
  INDEX `author_id` (`author_id` ASC) VISIBLE,
  CONSTRAINT `board_ibfk_1`
    FOREIGN KEY (`author_id`)
    REFERENCES `ssafit`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafit`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`comments` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `board_id` INT NULL DEFAULT NULL,
  `author_id` INT NULL DEFAULT NULL,
  `comment_content` TEXT NULL DEFAULT NULL,
  `comment_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_id`),
  INDEX `board_id` (`board_id` ASC) VISIBLE,
  INDEX `author_id` (`author_id` ASC) VISIBLE,
  CONSTRAINT `comments_ibfk_1`
    FOREIGN KEY (`board_id`)
    REFERENCES `ssafit`.`board` (`board_id`),
  CONSTRAINT `comments_ibfk_2`
    FOREIGN KEY (`author_id`)
    REFERENCES `ssafit`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafit`.`member`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`member` (
  `member_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `profile_info` TEXT NULL DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `member_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafit`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafit`.`trainer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`trainer` (
  `trainer_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `description` TEXT NULL DEFAULT NULL,
  `uploaded_videos` INT NULL DEFAULT NULL,
  PRIMARY KEY (`trainer_id`),
  INDEX `user_id` (`user_id` ASC) VISIBLE,
  CONSTRAINT `trainer_ibfk_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `ssafit`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafit`.`video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`video` (
  `video_id` INT NOT NULL AUTO_INCREMENT,
  `trainer_id` INT NULL DEFAULT NULL,
  `video_title` VARCHAR(255) NULL DEFAULT NULL,
  `video_url` VARCHAR(255) NULL DEFAULT NULL,
  `price` DECIMAL(10,2) NULL DEFAULT NULL,
  PRIMARY KEY (`video_id`),
  INDEX `trainer_id` (`trainer_id` ASC) VISIBLE,
  CONSTRAINT `video_ibfk_1`
    FOREIGN KEY (`trainer_id`)
    REFERENCES `ssafit`.`trainer` (`trainer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `ssafit`.`review`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ssafit`.`review` (
  `review_id` INT NOT NULL AUTO_INCREMENT,
  `video_id` INT NULL DEFAULT NULL,
  `member_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(255) NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `rating` INT NULL DEFAULT NULL,
  PRIMARY KEY (`review_id`),
  INDEX `video_id` (`video_id` ASC) VISIBLE,
  INDEX `member_id` (`member_id` ASC) VISIBLE,
  CONSTRAINT `review_ibfk_1`
    FOREIGN KEY (`video_id`)
    REFERENCES `ssafit`.`video` (`video_id`),
  CONSTRAINT `review_ibfk_2`
    FOREIGN KEY (`member_id`)
    REFERENCES `ssafit`.`member` (`member_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
