SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `javamud` ;
USE `javamud` ;

-- -----------------------------------------------------
-- Table `javamud`.`gebruiker`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javamud`.`gebruiker` ;

CREATE TABLE IF NOT EXISTS `javamud`.`gebruiker` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `emailadres` VARCHAR(50) NOT NULL,
  `voornaam` VARCHAR(50) NOT NULL,
  `naam` VARCHAR(50) NOT NULL,
  `paswoord` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `javamud`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javamud`.`item` ;

CREATE TABLE IF NOT EXISTS `javamud`.`item` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Omschrijving` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `javamud`.`lokatie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javamud`.`lokatie` ;

CREATE TABLE IF NOT EXISTS `javamud`.`lokatie` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `Beschrijving` VARCHAR(140) NOT NULL DEFAULT 'geen omschrijving',
  PRIMARY KEY (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `javamud`.`karakter`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javamud`.`karakter` ;

CREATE TABLE IF NOT EXISTS `javamud`.`karakter` (
  `Id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `gebruikerId` INT(10) UNSIGNED NOT NULL,
  `lokatieId` INT(10) UNSIGNED NOT NULL,
  `naam` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `KarakterGebruiker` (`gebruikerId` ASC),
  INDEX `KarakterLokatie` (`lokatieId` ASC),
  CONSTRAINT `KarakterGebruikerFK`
    FOREIGN KEY (`gebruikerId`)
    REFERENCES `javamud`.`gebruiker` (`Id`),
  CONSTRAINT `KarakterLokatieFK`
    FOREIGN KEY (`lokatieId`)
    REFERENCES `javamud`.`lokatie` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `javamud`.`heeftitems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javamud`.`heeftitems` ;

CREATE TABLE IF NOT EXISTS `javamud`.`heeftitems` (
  `Id` INT(10) UNSIGNED NOT NULL,
  `ItemID` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`ItemID`, `Id`),
  CONSTRAINT `ItemFK`
    FOREIGN KEY (`Id`)
    REFERENCES `javamud`.`item` (`Id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `ItemKarakterFK`
    FOREIGN KEY (`Id`)
    REFERENCES `javamud`.`karakter` (`Id`),
  CONSTRAINT `ItemLokatieFK`
    FOREIGN KEY (`Id`)
    REFERENCES `javamud`.`lokatie` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `javamud`.`lokatiebestemmingen`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `javamud`.`lokatiebestemmingen` ;

CREATE TABLE IF NOT EXISTS `javamud`.`lokatiebestemmingen` (
  `LokatieId` INT(10) UNSIGNED NOT NULL,
  `BestemmingId` INT(10) UNSIGNED NOT NULL,
  `Omschrijving` VARCHAR(150) NOT NULL DEFAULT 'geen omschrijving',
  PRIMARY KEY (`LokatieId`, `BestemmingId`),
  INDEX `BestemmingKey` (`BestemmingId` ASC),
  CONSTRAINT `BestemmingKeyFK`
    FOREIGN KEY (`BestemmingId`)
    REFERENCES `javamud`.`lokatie` (`Id`),
  CONSTRAINT `LokatieKeyFK`
    FOREIGN KEY (`LokatieId`)
    REFERENCES `javamud`.`lokatie` (`Id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
