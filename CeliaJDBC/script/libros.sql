

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Autor`
--

CREATE TABLE `Autor` (
  `Id_Autor` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Nacionalidad` varchar(25) NOT NULL,
  `FNacimiento` date
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `Autor` (`Id_Autor`, `Nombre`, `Nacionalidad`, `FNacimiento`) VALUES
(5, 'Agatha Christie', 'Britanica', '1890-09-15'),
(6, 'Benito Taibo', 'Mexicana', '1960-09-15'),
(7, 'Frida Kahlo', 'Mexicana', '1907-07-06'),
(8, 'Octavio Paz', 'Mexicana', '1914-06-15'),
(9, 'Ken Follet', 'Britanica', '1949-06-05'),
(10, 'Federico Garcia Lorca', 'Española', '1936-08-18'),
(11, 'Juan Ramon Jimenez', 'Española', '1958-05-29'),
(12, 'Rosalia de Castro', 'Española', '1890-09-15');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Libro`
--

CREATE TABLE `Libro` (
  `Isbn` int(11) NOT NULL,
  `Editorial` varchar(50) NOT NULL,
  `Titulo` varchar(100) NOT NULL,
  `Idioma` varchar(50) NOT NULL,
  `Id_Autor` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Autor`
--
ALTER TABLE `Autor`
  ADD PRIMARY KEY (`Id_Autor`);

--
-- Indices de la tabla `Libro`
--
ALTER TABLE `Libro`
  ADD PRIMARY KEY (`Isbn`),
  ADD KEY `fk_idA` (`Id_Autor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Autor`
--
ALTER TABLE `Autor`
  MODIFY `Id_Autor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Libro`
--
ALTER TABLE `Libro`
  ADD CONSTRAINT `fk_idA` FOREIGN KEY (`Id_Autor`) REFERENCES `Autor` (`Id_Autor`) ON DELETE CASCADE ON UPDATE CASCADE;

INSERT INTO `Libro` (`Isbn`, `Editorial`, `Titulo`, `Idioma`, `Id_Autor`, `tipo`) VALUES
(22, 'Circulo de Lectores', 'Asesinato en el Orient Express', 'Frances', 5, 'POLICIACO'),
(33, 'Quate', 'Persona Normal', 'Ingles', 6, 'HISTORICO'),
(44, 'Circulo de Lectores', 'La columna Partida', 'Español', 7, 'HISTORICO'),
(55, 'Odisea', 'El mono gramatico', 'Frances', 8, 'AVENTURA'),
(66, 'Planeta', 'Los pilares de la tierra', 'Ingles', 9, 'HISTORICO'),
(77, 'Odisea', 'Romancero Gitano', 'Español', 10, 'ROMANTICO'),
(88, 'Circulo de lectores', 'Plateri y tu', 'Ingles', 11, 'HISTORICO'),
(222, 'France', 'Diez Negritos', 'Frances', 5, 'POLICIACO'),
(333, 'France', 'Corazonadas', 'Frances', 6, 'ROMANTICO'),
(444, 'Quate', 'Las dos Fridas', 'Ingles', 7, 'ROMANTICO'),
(555, 'Planeta', 'Piedra de Sol', 'Ingles', 8, 'HISTORICO'),
(666, 'Odisea', 'El invierno del mundo', 'Español', 9, 'ROMANTICO'),
(777, 'Planeta', 'Un poeta en Nueva York', 'Frances', 10, 'HISTORICO'),
(2222, 'VidaRock', 'Muerte en el nilo', 'Español', 5, 'ROMANTICO'),
(3333, 'Planeta', 'Desde mi Muro', 'Ingles', 6, 'AVENTURA'),
(3434, 'nuevito', 'titulito', 'ingles', 6, 'HISTORICO'),
(4444, 'Quate', 'Diego y yo', 'Español', 7, 'ROMANTICO'),
(6666, 'Circulo de Lectores', 'Un mundo sin fin', 'Frances', 9, 'POLICIACO'),
(22222, 'GolfFree', 'Asesinato en el campo de Golf', 'Español', 5, 'POLICIACO');



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
