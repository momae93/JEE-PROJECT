-- MySQL Script generated by MySQL Workbench
-- Thu Jul 12 19:14:58 2018
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
-- Table `youtubelikedb`.`Friendship`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Friendship` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Friendship` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `id_user_friend` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_friend_idx` (`id_user_friend` ASC),
  CONSTRAINT `FK_friendiduser_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_friendidfriend_User`
    FOREIGN KEY (`id_user_friend`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Video`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Video` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Video` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(45) NOT NULL,
  `id_user` INT NOT NULL,
  `stream` LONGBLOB NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  INDEX `id_user_idx` (`id_user` ASC),
  CONSTRAINT `FK_videoiduser_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Like`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Like` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Like` (
  `id` INT NOT NULL,
  `id_user` INT NOT NULL,
  `id_video` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `id_user_idx` (`id_user` ASC),
  INDEX `id_video_idx` (`id_video` ASC),
  CONSTRAINT `FK_likeiduser_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_likeidvideo_Video`
    FOREIGN KEY (`id_video`)
    REFERENCES `youtubelikedb`.`Video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Playlist` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_user` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `token` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_Playlistiduser_User_idx` (`id_user` ASC),
  UNIQUE INDEX `token_UNIQUE` (`token` ASC),
  CONSTRAINT `FK_Playlistiduser_User`
    FOREIGN KEY (`id_user`)
    REFERENCES `youtubelikedb`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `youtubelikedb`.`Video_Playlist`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `youtubelikedb`.`Video_Playlist` ;

CREATE TABLE IF NOT EXISTS `youtubelikedb`.`Video_Playlist` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_video` INT NOT NULL,
  `id_playlist` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_playlistvideo_Video_idx` (`id_video` ASC),
  INDEX `FK_playlistplaylist_Playlist_idx` (`id_playlist` ASC),
  CONSTRAINT `FK_playlistvideo_Video`
    FOREIGN KEY (`id_video`)
    REFERENCES `youtubelikedb`.`Video` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_playlistplaylist_Playlist`
    FOREIGN KEY (`id_playlist`)
    REFERENCES `youtubelikedb`.`Playlist` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
