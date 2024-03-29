-- MySQL Script generated by MySQL Workbench
-- Fri Jul 13 16:01:14 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema youtubelikedb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `youtubelikedb` ;

-- -----------------------------------------------------
-- Schema youtubelikedb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `youtubelikedb` DEFAULT CHARACTER SET utf8 ;
USE `youtubelikedb` ;

-- -----------------------------------------------------
-- Table `youtubelikedb`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`User` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`User` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `isActive` TINYINT NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Video` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(45) NOT NULL,
  `streamLink` VARCHAR(256) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id`, `id_user`),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  INDEX `fk_Video_User1_idx` (`id_user` ASC),
  CONSTRAINT `fk_Video_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Playlist` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `token` VARCHAR(45) NOT NULL,
  `id_user` INT NOT NULL,
  PRIMARY KEY (`id`, `id_user`),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  INDEX `fk_Playlist_User1_idx` (`id_user` ASC),
  CONSTRAINT `fk_Playlist_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`User_has_Playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`User_has_Playlist` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`User_has_Playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_playlist` INT NOT NULL,
  PRIMARY KEY (`id`, `id_user`, `id_playlist`),
  INDEX `fk_User_has_Playlist_Playlist1_idx` (`id_playlist` ASC),
  INDEX `fk_User_has_Playlist_User1_idx` (`id_user` ASC),
  CONSTRAINT `fk_User_has_Playlist_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Playlist_Playlist1`
    FOREIGN KEY (`id_playlist`)
    REFERENCES `youtubelikedb`.`Playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`User_like_Video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`User_like_Video` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`User_like_Video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_video` INT NOT NULL,
  PRIMARY KEY (`id`, `id_user`, `id_video`),
  INDEX `fk_User_has_Video_Video1_idx` (`id_video` ASC),
  INDEX `fk_User_has_Video_User1_idx` (`id_user` ASC),
  CONSTRAINT `fk_User_like_Video_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_like_Video_Video1`
    FOREIGN KEY (`id_video`)
    REFERENCES `youtubelikedb`.`Video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Playlist_has_Video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Playlist_has_Video` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Playlist_has_Video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_playlist` INT NOT NULL,
  `id_video` INT NOT NULL,
  PRIMARY KEY (`id`, `id_playlist`, `id_video`),
  INDEX `fk_Playlist_has_Video_Video1_idx` (`id_video` ASC),
  INDEX `fk_Playlist_has_Video_Playlist1_idx` (`id_playlist` ASC),
  CONSTRAINT `fk_Playlist_has_Video_Playlist1`
    FOREIGN KEY (`id_playlist`)
    REFERENCES `youtubelikedb`.`Playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Playlist_has_Video_Video1`
    FOREIGN KEY (`id_video`)
    REFERENCES `youtubelikedb`.`Video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Friendship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Friendship` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Friendship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_friend` INT NOT NULL,
  PRIMARY KEY (`id`, `id_user`, `id_friend`),
  INDEX `fk_User_has_User_User2_idx` (`id_friend` ASC),
  INDEX `fk_User_has_User_User1_idx` (`id_user` ASC),
  CONSTRAINT `fk_User_has_User_User1`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_User_User2`
    FOREIGN KEY (`id_friend`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
