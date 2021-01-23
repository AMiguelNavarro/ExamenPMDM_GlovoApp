-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-01-2021 a las 11:56:24
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `glovo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `idCategoria` int(11) NOT NULL,
  `categoria` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`idCategoria`, `categoria`) VALUES
(1, 'Fast Food'),
(2, 'Americana'),
(3, 'China'),
(4, 'Japonesa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `menus`
--

CREATE TABLE `menus` (
  `idMenu` int(11) NOT NULL,
  `idRestaurante` int(11) NOT NULL,
  `primero` varchar(50) NOT NULL,
  `segundo` varchar(50) NOT NULL,
  `postre` varchar(50) NOT NULL,
  `precio` double NOT NULL,
  `nombreMenu` varchar(50) DEFAULT NULL,
  `imagenMenu` varchar(500) DEFAULT NULL,
  `bebida` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `menus`
--

INSERT INTO `menus` (`idMenu`, `idRestaurante`, `primero`, `segundo`, `postre`, `precio`, `nombreMenu`, `imagenMenu`, `bebida`) VALUES
(1, 1, 'Hamburguesa Pollo', 'Patatas Fritas', 'McFlurry Oreo', 7.5, 'Big Mac', 'https://thumbs.dreamstime.com/b/mosc%C3%BA-rusia-el-de-febrero-men%C3%BA-la-hamburguesa-del-big-mac-en-mcdonald-es-consiste-dos-carne-vaca-lechuga-queso-salmueras-y-las-139250776.jpg', 'Agua'),
(2, 1, 'Hamburguesa Pollo', 'Patatas Fritas', 'McFlurry Oreo', 8.5, 'Cuarto de Libra', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSf9_o8RThvI5q7WN6BsbNEhOZ_xoEsbECJvw&usqp=CAU', 'Coca-Cola'),
(3, 6, 'Makis variados', 'Gyozas', 'Dorayakis', 20, 'Menu semana', 'https://s3-eu-west-1.amazonaws.com/data.public.bokoto/images/carta/bokoto-carta-03-Ok.jpg', 'Vino blanco, agua o refresco'),
(4, 3, 'Patatas Cheese & Bacon', 'Medio Costillar con salsa bbq', 'Tarta de queso', 18.5, 'Menu semana', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS3vgkkdUiDZic_WCsHzHOt5owpvovueIkvOw&usqp=CAU', 'Resfresco o agua'),
(5, 3, 'Nachos con guacamole', 'Hamburguesa de la casa', 'Coulant de chocolate', 15.9, 'Menu Burguers', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ0kFDcxwOziuytVadN9NHHQ01AnuTI5XpFA&usqp=CAU', 'Refresco o agua'),
(6, 12, 'Aros de cebolla fritos', 'Alitas de pollo fritas', 'Helado', 12, 'Fritazos', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxSlOSQ9MTETKYLriMLkRCfQD07Zem4vRZCg&usqp=CAU', 'Refresco o agua'),
(7, 13, 'Makis', 'Suchis', 'Helado', 25, 'Sushi semana', 'https://s3.eu-west-1.amazonaws.com/cdn.spydeals.nl/images/uploads/WE5XyCTlNqyqvJxZg7wrLnhKZla0Sf2XI141JobF.jpeg', 'Vino, agua o refresco');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `idPedido` int(11) NOT NULL,
  `idRestaurante` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurantes`
--

CREATE TABLE `restaurantes` (
  `idRestaurante` int(11) NOT NULL,
  `idCategoria` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `imagen` varchar(500) NOT NULL,
  `descripcion` varchar(200) NOT NULL,
  `numVentas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `restaurantes`
--

INSERT INTO `restaurantes` (`idRestaurante`, `idCategoria`, `nombre`, `imagen`, `descripcion`, `numVentas`) VALUES
(1, 1, 'Mcdonalds', 'https://images.squarespace-cdn.com/content/v1/5266a779e4b09e5c3d8d3902/1449179535906-XZ5SLIGE2HJGAKCCQGLG/ke17ZwdGBToddI8pDm48kIona_Yldnu4yG8uqp3snjh7gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QPOohDIaIeljMHgDF5CVlOqpeNLcJ80NK65_fV7S1UTZa5ye72jMOxyceRQqo5ILX7W5uT7O_9LzEXviT0rfFW07ycm2Trb21kYhaLJjddA/image-asset.png', 'Restaurante de comida rápida de burgers', 10),
(2, 1, 'Burger King', 'https://storage.googleapis.com/www-paredro-com/uploads/2019/02/La-evolucio%CC%81n-del-logo-de-Burger-King-es-un-sol-un-rey-y-una-hamburguesa.jpg', 'Restaurante de comida rápida de burgers', 5),
(3, 2, 'Fosters Hollywood', 'https://www.emprendedores.es/wp-content/uploads/2015/11/fosterhollywood-logo-1542103518-1024x512.jpg', 'Restaurante de comida Americana', 30),
(6, 4, 'Bokoto', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR457SNJyyPvDQ2N_Ivk5bXHFhRBBStvXz_qQ&usqp=CAU', 'Retsaurante de comida Japonesa', 6),
(7, 2, 'Jack Bull ', 'https://cdn1.centralapp.com/api/v1/media/logo-medium/place-7172-j7m5lux50ie6s6ljeeay.jpeg', 'Restaurante de comida Americana, especialidad hamburguesas', 40),
(8, 2, 'Tommy Mel\'s', 'https://www.telefonoatencionclientes.com/wp-content/uploads/2019/07/Tel%C3%A9fono-Gratuito-Tommy-Mels.jpg', 'Restaurante de comida americana con ambientación vintage', 87),
(9, 3, 'Cielo Dragón', 'https://www.restauranteschinos.net/wp-content/files_mf/1344cielo-dragon-zaragoza.jpg', 'Restaurante de comida china', 20),
(10, 1, 'Taco Bell', 'https://images-na.ssl-images-amazon.com/images/I/61W5bUinREL._AC_SX425_.jpg', 'Restaurante de comida rápida, especialidad burritos', 0),
(11, 4, 'Uasabi', 'https://www.igastroaragon.com/wp-content/uploads/2020/02/87976778_2838646426216317_6776695117269958656_o.jpg', 'Restaurante de comida japonesa', 78),
(12, 1, 'KFC', 'https://i.pinimg.com/originals/4f/a2/91/4fa291fc7c8d2811958c1f8f06e70cdd.jpg', 'Restaurante de comida rápida especialidad fritos', 12),
(13, 4, 'Miss Sushi', 'https://es.menus.net/files/public/restaurantes/214307/logo-miss-sushi-serrano.WDhWYTFMN0hpWm5nM1JiUC8vMTQ1Mzk5NDE4My8.png', 'Restaurante de comida japonesa', 56);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idUsuario`, `nombre`, `apellido`, `email`, `usuario`, `password`) VALUES
(1, 'Alberto', 'Miguel', 'prueba@gmail.com', 'Alberto', 'Alberto'),
(2, 'Javier', 'Javier', 'prueba@gmail.com', 'Javier', 'Javier'),
(3, 'Alejandro', 'Alejandro', 'prueba@gmail.com', 'Alejandro', 'Alejandro'),
(4, 'Celia', 'Celia', 'prueba@gmail.com', 'Celia', 'Celia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoraciones`
--

CREATE TABLE `valoraciones` (
  `idValoracion` int(11) NOT NULL,
  `idRestaurante` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `puntuacion` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `valoraciones`
--

INSERT INTO `valoraciones` (`idValoracion`, `idRestaurante`, `idUsuario`, `puntuacion`) VALUES
(2, 2, 3, 4),
(3, 6, 1, 3),
(4, 3, 4, 5),
(5, 7, 1, 4),
(6, 9, 1, 1),
(7, 3, 2, 2),
(8, 11, 1, 5),
(9, 2, 4, 3),
(10, 12, 3, 5),
(11, 1, 2, 2),
(12, 13, 3, 5),
(13, 8, 1, 3),
(14, 3, 4, 2),
(15, 2, 1, 5),
(16, 10, 1, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`idCategoria`);

--
-- Indices de la tabla `menus`
--
ALTER TABLE `menus`
  ADD PRIMARY KEY (`idMenu`),
  ADD KEY `idRestaurante` (`idRestaurante`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`idPedido`),
  ADD KEY `idRestaurante` (`idRestaurante`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  ADD PRIMARY KEY (`idRestaurante`),
  ADD KEY `idCategoria` (`idCategoria`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD PRIMARY KEY (`idValoracion`),
  ADD KEY `idRestaurante` (`idRestaurante`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `idCategoria` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `menus`
--
ALTER TABLE `menus`
  MODIFY `idMenu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `idPedido` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  MODIFY `idRestaurante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  MODIFY `idValoracion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `menus`
--
ALTER TABLE `menus`
  ADD CONSTRAINT `menus_ibfk_1` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurantes` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurantes` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pedidos_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `restaurantes`
--
ALTER TABLE `restaurantes`
  ADD CONSTRAINT `restaurantes_ibfk_1` FOREIGN KEY (`idCategoria`) REFERENCES `categorias` (`idCategoria`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD CONSTRAINT `valoraciones_ibfk_1` FOREIGN KEY (`idRestaurante`) REFERENCES `restaurantes` (`idRestaurante`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `valoraciones_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
