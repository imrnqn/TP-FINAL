-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-11-2023 a las 21:31:36
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pfnutricionista`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comida`
--

CREATE TABLE `comida` (
  `idComida` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `detalle` varchar(15) NOT NULL,
  `horario` varchar(10) NOT NULL,
  `cantCalorias` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comida`
--

INSERT INTO `comida` (`idComida`, `nombre`, `detalle`, `horario`, `cantCalorias`, `estado`) VALUES
(1, 'PECHUGA A LA PLANCHA', '', 'CENA', 300, 1),
(2, 'ENSALADA LECHUGA Y TOMATE', '', 'ALMUERZO', 150, 1),
(4, 'FLAN CON DULCE DE LECHe', '', 'CENA', 1500, 1),
(5, 'HELADO ', 'MUY CALORICO \n', 'CENA', 2500, 1),
(14, 'HUEVO DURO ', 'HERVIR 10 MIN.', 'ALMUERZO', 250, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dieta`
--

CREATE TABLE `dieta` (
  `idDieta` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `fechaInicial` date NOT NULL,
  `pesoInicial` double NOT NULL,
  `pesoFinal` double DEFAULT NULL,
  `fechaFinal` date DEFAULT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dieta`
--

INSERT INTO `dieta` (`idDieta`, `nombre`, `idPaciente`, `fechaInicial`, `pesoInicial`, `pesoFinal`, `fechaFinal`, `estado`) VALUES
(1, 'DIETA BAJA EN CALORIAS', 1, '2023-09-01', 100.1, 70, '2023-10-03', 1),
(2, 'DIETA ESPECIAL', 2, '2023-08-01', 85, 75, '2023-10-03', 1),
(3, 'HIPERCALORICA ', 6, '2023-10-19', 50.5, 0, NULL, 1),
(5, 'BAJA EN CARBOHIDRATOS', 9, '2023-10-07', 100.5, 0, NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dietacomida`
--

CREATE TABLE `dietacomida` (
  `idDietaComida` int(11) NOT NULL,
  `idComida` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `dietacomida`
--

INSERT INTO `dietacomida` (`idDietaComida`, `idComida`, `idDieta`) VALUES
(2, 1, 1),
(5, 1, 2),
(1, 2, 1),
(4, 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `idHistorial` int(11) NOT NULL,
  `idDieta` int(11) NOT NULL,
  `peso` double NOT NULL,
  `fechaRegistro` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`idHistorial`, `idDieta`, `peso`, `fechaRegistro`) VALUES
(1, 1, 90, '2012-06-23'),
(4, 1, 98, '2012-07-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `idPaciente` int(11) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `dni` int(11) NOT NULL,
  `domicilio` varchar(25) NOT NULL,
  `telefono` varchar(25) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`idPaciente`, `apellido`, `nombre`, `dni`, `domicilio`, `telefono`, `estado`) VALUES
(1, 'Perez', 'Carlos', 1, 'Av. San Martina 530', '11-56934823', 1),
(2, 'VALENZUELA', 'Yanina', 28975365, 'Dorrego 250', '11-58965432', 1),
(4, 'Fernandez', 'Roberto', 25896387, 'Saavedra', '11-85522553', 1),
(6, 'Müller', 'Carla', 4, 'Los Olmos 75', '269-897456', 1),
(7, 'Hernandez', 'Sebastian', 6, 'Saez Peña 235', '11-9562471', 1),
(9, 'SAEZ ', 'JUAN JOSE ', 2, 'LAS CATITAS 141', '6664314840', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comida`
--
ALTER TABLE `comida`
  ADD PRIMARY KEY (`idComida`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- Indices de la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD PRIMARY KEY (`idDieta`),
  ADD UNIQUE KEY `idPaciente` (`idPaciente`),
  ADD UNIQUE KEY `nombre` (`nombre`,`idPaciente`);

--
-- Indices de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD PRIMARY KEY (`idDietaComida`),
  ADD UNIQUE KEY `idComida` (`idComida`,`idDieta`),
  ADD KEY `conDieta` (`idDieta`);

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`idHistorial`),
  ADD UNIQUE KEY `idDieta` (`idDieta`,`fechaRegistro`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comida`
--
ALTER TABLE `comida`
  MODIFY `idComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `dieta`
--
ALTER TABLE `dieta`
  MODIFY `idDieta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  MODIFY `idDietaComida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `idHistorial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `idPaciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `dieta`
--
ALTER TABLE `dieta`
  ADD CONSTRAINT `conPaciente` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`idPaciente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `dietacomida`
--
ALTER TABLE `dietacomida`
  ADD CONSTRAINT `conComida` FOREIGN KEY (`idComida`) REFERENCES `comida` (`idComida`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `conDieta` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `conDietas` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`idDieta`);


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para la tabla comida
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'pfnutricionista', 'comida', '{\"CREATE_TIME\":\"2023-10-10 16:47:23\"}', '2023-10-10 23:46:00');

--
-- Metadatos para la tabla dieta
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'pfnutricionista', 'dieta', '{\"sorted_col\":\"`dieta`.`fechaInicial` DESC\"}', '2023-10-18 23:10:22');

--
-- Metadatos para la tabla dietacomida
--

--
-- Metadatos para la tabla historial
--

--
-- Metadatos para la tabla paciente
--

--
-- Volcado de datos para la tabla `pma__table_uiprefs`
--

INSERT INTO `pma__table_uiprefs` (`username`, `db_name`, `table_name`, `prefs`, `last_update`) VALUES
('root', 'pfnutricionista', 'paciente', '{\"CREATE_TIME\":\"2023-10-02 19:55:43\",\"sorted_col\":\"`paciente`.`apellido` ASC\"}', '2023-10-06 23:28:46');

--
-- Metadatos para la base de datos pfnutricionista
--

--
-- Volcado de datos para la tabla `pma__pdf_pages`
--

INSERT INTO `pma__pdf_pages` (`db_name`, `page_descr`) VALUES
('pfnutricionista', 'DiseñoBDPFNutricion');

SET @LAST_PAGE = LAST_INSERT_ID();

--
-- Volcado de datos para la tabla `pma__table_coords`
--

INSERT INTO `pma__table_coords` (`db_name`, `table_name`, `pdf_page_number`, `x`, `y`) VALUES
('pfnutricionista', 'comida', @LAST_PAGE, 148, 62),
('pfnutricionista', 'dieta', @LAST_PAGE, 742, 71),
('pfnutricionista', 'dietacomida', @LAST_PAGE, 428, 84),
('pfnutricionista', 'historial', @LAST_PAGE, 1033, 137),
('pfnutricionista', 'paciente', @LAST_PAGE, 413, 239);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
