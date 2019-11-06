-- -----------------------------------------------------
-- Table `Recurso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Recurso` (
  `id` NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50)  NOT NULL,
  `tipo` VARCHAR(500)  NOT NULL,
  `ubicacion` VARCHAR(500)  NOT NULL,
  `estado`  BOOLEAN NOT NULL,
  `capacidad` INT(11) NOT NULL,
  `disponibilidad` INT(11) NOT NULL);

