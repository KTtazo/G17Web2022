SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

SET NAMES utf8mb4;

CREATE DATABASE `gestionPracticas` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `gestionPracticas`;

DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno` (
  `persona_usuario` varchar(255) NOT NULL,
  `carrera` varchar(255) DEFAULT NULL,
  `creditos_cursados` smallint(6) DEFAULT NULL,
  `nota_media` float DEFAULT NULL,
  `oferta_practicasid_oferta_practicas` int(11) DEFAULT NULL,
  PRIMARY KEY (`persona_usuario`),
  KEY `FKave3o1qne49jr9jqxq4sw6me0` (`oferta_practicasid_oferta_practicas`),
  CONSTRAINT `FKave3o1qne49jr9jqxq4sw6me0` FOREIGN KEY (`oferta_practicasid_oferta_practicas`) REFERENCES `oferta_practicas` (`id_oferta_practicas`),
  CONSTRAINT `FKedd8dk6bgfvhkd83vkbi8afpt` FOREIGN KEY (`persona_usuario`) REFERENCES `persona` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `alumno` (`persona_usuario`, `carrera`, `creditos_cursados`, `nota_media`, `oferta_practicasid_oferta_practicas`) VALUES
('alejandro.mendez',	'Ingenieria en Sistemas de Informacion',	180,	6.7,	NULL),
('alumno',	'prueba',	0,	0,	NULL),
('andres.hernandez',	'Ingenieria Informatica',	180,	9.6,	NULL),
('bernardos.lopez',	'Ingenieria Telematica',	190,	6.9,	NULL),
('carla.vazquez',	'Ingenieria en Sistemas de Informacion',	180,	8.5,	NULL),
('carlos.cetino',	'Ingenieria en Sistemas de Informacion',	180,	8.5,	NULL),
('cristina.sanchez',	'Ingenieria Informatica',	220,	5.7,	NULL),
('elena.gutierrez',	'Ingenieria Informatica',	216,	6.3,	NULL),
('ibrahim.alcaide',	'Ingenieria Informatica',	175,	5.4,	NULL),
('jaime.tripi',	'Ingenieria Informatica',	180,	7.6,	NULL),
('jesus.berlanga',	'Ingenieria Telematica',	190,	8.2,	NULL),
('juan.carlos.herranz',	'Ingenieria en Sistemas de Informacion',	188,	9.3,	NULL),
('juan.olmeda',	'Ingenieria Informatica',	180,	8.6,	NULL),
('juan.palomo',	'Ingenieria en Sistemas de Informacion',	182,	6.9,	NULL),
('lucia.perez',	'Ingenieria Telematica',	170,	6.8,	NULL),
('luis.miguel',	'Ingenieria Telematica',	190,	7.5,	11),
('luis.pinto',	'Ingenieria Informatica',	200,	6.8,	11),
('marta.saez',	'Ingenieria Informatica',	210,	7.2,	NULL),
('pedro.juan',	'Ingenieria Telematica',	210,	8.1,	12),
('ruben.parras',	'Ingenieria en Sistemas de Informacion',	170,	9.8,	NULL),
('sonia.garcia',	'Ingenieria Informatica',	200,	7.5,	NULL),
('sonia.ochante',	'Ingenieria Telematica',	200,	8.3,	NULL);

DROP TABLE IF EXISTS `empresa`;
CREATE TABLE `empresa` (
  `cif` varchar(255) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `sector` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cif`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `empresa` (`cif`, `nombre`, `sector`) VALUES
('A54357254',	'Deloitte',	'Consultora informatica'),
('A58818501',	'Indra Sistemas',	'Consultoria tecnologica'),
('A63546546',	'Accenture',	'Consultora informatica'),
('L65463456',	'Infoges Seidor',	'Empresa Ciberseguridad'),
('xxxxxxxxx',	'prueba',	'prueba');

DROP TABLE IF EXISTS `informe_practicas`;
CREATE TABLE `informe_practicas` (
  `alumno_persona_usuario` varchar(255) NOT NULL,
  `tutor_persona_usuario` varchar(255) NOT NULL,
  `comentarios` varchar(255) DEFAULT NULL,
  `nota` float DEFAULT NULL,
  `tutor_empresa_cif` varchar(255) NOT NULL,
  PRIMARY KEY (`alumno_persona_usuario`,`tutor_persona_usuario`),
  KEY `FKcaowq1nall54aewn6s8i4mx1` (`tutor_empresa_cif`,`tutor_persona_usuario`),
  CONSTRAINT `FKcaowq1nall54aewn6s8i4mx1` FOREIGN KEY (`tutor_empresa_cif`, `tutor_persona_usuario`) REFERENCES `tutor` (`empresa_cif`, `persona_usuario`),
  CONSTRAINT `FKjdse5j7o8spnxfm4wq0s6b5c5` FOREIGN KEY (`alumno_persona_usuario`) REFERENCES `alumno` (`persona_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `informe_practicas` (`alumno_persona_usuario`, `tutor_persona_usuario`, `comentarios`, `nota`, `tutor_empresa_cif`) VALUES
('luis.miguel',	'alberto.torres',	'Muy buen comportamiento',	8,	'A54357254'),
('luis.pinto',	'alberto.torres',	'El alumno ha realizado las practicas de manera excelente',	10,	'A54357254'),
('pedro.juan',	'pepe.matamoros',	'Trabajo satisfactorio',	6,	'A58818501');

DROP TABLE IF EXISTS `oferta_practicas`;
CREATE TABLE `oferta_practicas` (
  `id_oferta_practicas` int(11) NOT NULL AUTO_INCREMENT,
  `curso` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `duracion` smallint(6) DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `hora_inicio` time DEFAULT NULL,
  `hora_salida` time DEFAULT NULL,
  `idiomas` varchar(255) DEFAULT NULL,
  `plazas` smallint(6) DEFAULT NULL,
  `requisitos` varchar(255) DEFAULT NULL,
  `salario` smallint(6) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `tutor_empresa_cif` varchar(255) NOT NULL,
  `tutor_persona_usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`id_oferta_practicas`),
  KEY `FKskua9d48h0rvp5gv5r4nb2f5p` (`tutor_empresa_cif`,`tutor_persona_usuario`),
  CONSTRAINT `FKskua9d48h0rvp5gv5r4nb2f5p` FOREIGN KEY (`tutor_empresa_cif`, `tutor_persona_usuario`) REFERENCES `tutor` (`empresa_cif`, `persona_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `oferta_practicas` (`id_oferta_practicas`, `curso`, `descripcion`, `duracion`, `fecha_inicio`, `hora_inicio`, `hora_salida`, `idiomas`, `plazas`, `requisitos`, `salario`, `titulo`, `tutor_empresa_cif`, `tutor_persona_usuario`) VALUES
(1,	'2022/2023',	'',	35,	'2023-02-01',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	2,	'Participacion en torneos CTF y experiencia en pentesting en paginas como HacktheBox',	1200,	'Pentesting auditoria',	'A58818501',	'alba.ramos'),
(2,	'2022/2023',	'',	35,	'2023-02-01',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	1,	'Sin experiencia previa',	1000,	'Documentacion Ciberseguridad',	'A58818501',	'alba.ramos'),
(3,	'2022/2023',	'',	35,	'2023-02-05',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	2,	'Sin experiencia previa',	1100,	'Configuracion equipos',	'A58818501',	'pepe.matamoros'),
(4,	'2022/2023',	'',	25,	'2023-03-01',	'00:00:00',	'00:00:00',	'espanol C2, ingles C1',	1,	'Sin experiencia previa',	700,	'Desarrollo CRM',	'A54357254',	'juan.tome'),
(5,	'2022/2023',	'',	25,	'2023-02-07',	'00:00:00',	'00:00:00',	'espanol C2',	3,	'Conocimientos en html, css y javascript asi como el framework Spring',	700,	'Aplicaciones Web',	'A63546546',	'jose.juan'),
(6,	'2022/2023',	'',	25,	'2023-02-15',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	1,	'Conocimientos basicos en python y java',	600,	'Desarrollo Software',	'A63546546',	'jose.juan'),
(7,	'2022/2023',	'',	30,	'2023-02-01',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	1,	'Conocimientos en java',	600,	'Programacion',	'L65463456',	'daniel.garcia'),
(8,	'2022/2023',	'',	25,	'2023-03-01',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	2,	'Sin experiencia previa',	600,	'Gestion Ciberseguridad',	'A54357254',	'juan.tome'),
(9,	'2022/2023',	'',	35,	'2023-03-08',	'00:00:00',	'00:00:00',	'espanol C2, ingles B2',	2,	'Experiencia con python y c++',	900,	'Desarrollo Software',	'L65463456',	'daniel.garcia'),
(10,	'2022/2023',	'',	25,	'2023-03-05',	'00:00:00',	'00:00:00',	'espanol C2, ingles C1',	4,	'Conocimientos bash de Linux',	800,	'Scripts automatizacion',	'A58818501',	'pepe.matamoros'),
(11,	'2022/2023',	'',	35,	'2022-10-02',	'00:00:00',	'00:00:00',	'espanol C2, ingles C1',	2,	'Conocimientos Java',	900,	'Programacion Java',	'A54357254',	'alberto.torres'),
(12,	'2022/2023',	'',	35,	'2022-09-20',	'00:00:00',	'00:00:00',	'espanol C2, ingles C1',	1,	'Sin experiencia previa',	800,	'Big Data',	'A58818501',	'pepe.matamoros');

DROP TABLE IF EXISTS `oferta_practicas_has_alumno`;
CREATE TABLE `oferta_practicas_has_alumno` (
  `alumno_persona_usuario` varchar(255) NOT NULL,
  `oferta_practicas_id_oferta_practicas` int(11) NOT NULL,
  `prioridad` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`alumno_persona_usuario`,`oferta_practicas_id_oferta_practicas`),
  KEY `FK93v30s5tt7van4pbqyr77eth9` (`oferta_practicas_id_oferta_practicas`),
  CONSTRAINT `FK93v30s5tt7van4pbqyr77eth9` FOREIGN KEY (`oferta_practicas_id_oferta_practicas`) REFERENCES `oferta_practicas` (`id_oferta_practicas`),
  CONSTRAINT `FKrxt5lcrb18qo6wf1m5jslhgyj` FOREIGN KEY (`alumno_persona_usuario`) REFERENCES `alumno` (`persona_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `oferta_practicas_has_alumno` (`alumno_persona_usuario`, `oferta_practicas_id_oferta_practicas`, `prioridad`) VALUES
('alejandro.mendez',	1,	1),
('alejandro.mendez',	3,	2),
('alejandro.mendez',	5,	3),
('andres.hernandez',	1,	1),
('bernardos.lopez',	2,	1),
('bernardos.lopez',	4,	2),
('carla.vazquez',	4,	1),
('carla.vazquez',	5,	2),
('carlos.cetino',	2,	2),
('carlos.cetino',	6,	1),
('cristina.sanchez',	4,	3),
('cristina.sanchez',	7,	1),
('cristina.sanchez',	8,	2),
('elena.gutierrez',	4,	2),
('elena.gutierrez',	5,	3),
('elena.gutierrez',	9,	1),
('ibrahim.alcaide',	4,	4),
('ibrahim.alcaide',	10,	1),
('ibrahim.alcaide',	11,	2),
('ibrahim.alcaide',	12,	3),
('jaime.tripi',	2,	4),
('jaime.tripi',	4,	3),
('jaime.tripi',	6,	2),
('jaime.tripi',	7,	1),
('jaime.tripi',	11,	5),
('jesus.berlanga',	5,	2),
('jesus.berlanga',	12,	1),
('juan.carlos.herranz',	6,	1),
('juan.olmeda',	5,	1),
('juan.palomo',	2,	2),
('juan.palomo',	7,	1),
('lucia.perez',	9,	1),
('luis.miguel',	11,	1),
('luis.miguel',	12,	2),
('luis.pinto',	11,	1),
('luis.pinto',	12,	2),
('marta.saez',	3,	2),
('marta.saez',	11,	1),
('pedro.juan',	12,	1),
('ruben.parras',	4,	1),
('sonia.garcia',	1,	1),
('sonia.ochante',	2,	1);

DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona` (
  `usuario` varchar(255) NOT NULL,
  `contrasena` varchar(255) DEFAULT NULL,
  `nif` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `persona` (`usuario`, `contrasena`, `nif`) VALUES
('admin',	'1000:f6a9f76f9a90fdd0a45945f7957fb551:5fd52298f6e7c7127576b25a77fb928a53239a8de6756dc9d21380bd615fc25eef9c8ebf9efc4dd88b41713ff7d1389a0eadeaf8a1d2e61ba4ac59f9e50d435b',	'xxxxxxxxx'),
('alba.ramos',	'1000:21dab995242070b696c7522135d0e549:1a7747b47ba942821beda50c5607ff9063e043f417fa19b7e1f56627eb8df14c1d08404150fe40b1bf0065cebf94b4f4eb0198da49cc33f56873df6e4e67fe6c',	'12345678A'),
('alberto.torres',	'1000:ccc265a7e9d9a25d836fcbbe5acfb151:b1b6755925cbfd832a53173769baf9248472d9c83fd73e3e8b2df73cac806bb06bb843799cd6b272c18f6144562698ca2c12edc7837e07280e94cb3af358528b',	'12332456A'),
('alejandro.mendez',	'1000:f0073d812661d6608865da97f75f9f61:b9f544ad895108b5aae4ebc03d90541da9200382927923741e3dcf29467315e206e93636b9b77544c3f26ed97bdcdb78e8e5d62782882862f3062d3f2b8ccdff',	'98798754A'),
('alumno',	'1000:d3ebd50fddd1495b4968a093596bfb5c:f0b6584f3b281c084400b654ceee80b8b744d27248c0f830623c4fdd7fd51d79307ce8eef487e7e8da90348d1ab498c0b5ccca026e28f86c78ac77c8422c83cc',	'zzzzzzzzz'),
('andres.hernandez',	'1000:9158ebcaa7814414cce66373e3c64d6a:d2f671915ebe9d2fdf4c4d2fd8c5449cbdc831d5d7f8c5109f6a492eb978f22e83b41ff726143e31935270eb89d86ec30d8d6c9757c5f610fab449d9b1f6a4e5',	'76547566M'),
('bernardos.lopez',	'1000:374a407fcbcb59eef0811467cb8e6092:889c63903c5784c10b7f9e588e70c2032fbc7d0a4b59d1429727d63d467b99d1026b4d585e2cda435d669655926809cfcfa504260ee8fdea99062e408811a21e',	'45455524J'),
('carla.vazquez',	'1000:2a8526b997cb9d95af29c5ab37b95fc1:5263e0739f6d21b70be5a440ae122dd2db5212eecb1906a84f7ac61c06de377a02d1ee5693fc54e71c87ca32de39861aee34f9388332a21b23a80a81085a247c',	'00986745B'),
('carlos.cetino',	'1000:b6a6daffd07328b2f585f3fa59162fe6:8630d6db993252ea9c59ea2d795c37e243f1f812745cd0f587a28a8ed179dd4c01c9bf0a00d56e80d963fa8c30a5d3dcdc64e00072c018cb93caa1b90b4f4544',	'90689954K'),
('cristina.sanchez',	'1000:fda3bfa9030f90c15c27fb83831d0142:68b829a9080be86c78d63540181b5d15ff97ab334ccc584d344793697471479bac350a070e49ebfefd387fbb98e1d9de37dab2c4f31c947ea62d04cd2709517f',	'97658976C'),
('daniel.garcia',	'1000:d2ece4fc0d7f5b93448fb533a44ccb6d:3d390530cd6ef4aa34d777806685289e7f5409a3a0b74d56d64ad82da843d65731ee4523998682e1a280233d7d2d25cf3b9ec3db4c2a5331c4918a0431c362e2',	'34573689M'),
('elena.gutierrez',	'1000:5237638f4c46de044ac5908b1005794d:baf498bf10599e4513cc4e63cde85191838b3f342dfab643563c10fa5c4881a6157d5573bf30cbb7f8b5806b7bc278b5b40d370c0432faea664a4e37d0ba7c19',	'53457824M'),
('ibrahim.alcaide',	'1000:bb2e108c6f1cdef8ecf81ed52fd56ba5:776d46120eda21b5b76e0c932aebbc74971b979eac87042e95c1196f2d1d52b0d2ec762167c009834fc295feaf2e95c3e0ff4a7cb389e93937d213a9fdc16b80',	'48593453H'),
('jaime.tripi',	'1000:8db3e64faa1b3c8f84aa0c2b6f4fc203:c1f657d7869ce074d87433154d8a4661e1c16a9ea8529136913b31ce654d47e7b2c777857f2452e4cc70ba78fbfea321da7b3385d0ed5d0ffa63fd5b6e9db8fc',	'77653676H'),
('jesus.berlanga',	'1000:1fe418117883d738f23a66625554e956:dadc875f4b2357494c8623443dd2f98068909110e04bf282ea03743bf9dfea62eb5520f568ff0ef6410c1f92c97d7c37516061ad4ea017085d0f2bb3b1f18442',	'76547567K'),
('jose.juan',	'1000:0cd09a15bbcf5a0f8cc16d687218c3b7:5436f98e4a65b5b56ec3ee8cfe7a21c56f330f3358ea2f82b487007adb3de8d29d10b2ee6008710f68318f38368d3e28457c18d2c11ae2479c502d79d9f6e0cb',	'77684645Y'),
('juan.alberto',	'1000:f628c979d6585894517dde574271ec64:4b9e4bedabc49174ecaf35049a4fb4994a5c15824c644432cf961b8cf3d8ae6bf65274cbcd1acb027eba0a4af92dc1abc125f625a5ba2f79d20940f20907d8ca',	'23111232B'),
('juan.carlos.herranz',	'1000:1e4896a522c355d562f025f9015dd8e0:0dc47478ffb2a28e6e71cecaa8a0d429f38d0aeef2049044e1ab663f769a8bfd86ac2ff771842a7a79a339b7d447be801c9a37660757e92755e44669eaeff8c0',	'56435643Y'),
('juan.olmeda',	'1000:2470a90f220a897fc0252da96e56f6ff:16ffd380a1c2db0cb98c5efaa149fe1bc28511d316e421505e34c617c9bb6492009158e1c109c9de2b906d6af61290238733bee3510823a54745ce153157c510',	'44534724D'),
('juan.palomo',	'1000:67c3d02c41721ea30c2213a0b076696e:07a079733684b5cc9df3aeb76e02599864a7068c7f2cc922b6a900a27e02bd080e75f77b4fa2e0aa3e34f196d47cfc3ac066e26d90e8de03cbcfc7f856775676',	'67546776G'),
('juan.tome',	'1000:3c6ff51e33be1e6f7d3d9c915c634841:10f32aa3d1487b01015d7b4c0155ceaab25698e4653dede398d09002be911157aa7968df680168f2c1abe63856f2aa2d234c6bc79df80174e85f60a1609cfa87',	'64888832C'),
('lucia.perez',	'1000:491ba9428bcdd3df98cb8c506fc19f77:9608ea50b054d3fc7ae346c11f65e0cf3ea87d618847318ae6882a993696a4a1fd632c59400d06ae3e00f9dc8874e8b470c294f7c9a8f80d993de07a3bdb5aed',	'53559084J'),
('luis.miguel',	'1000:490d9c892818c632ea1f102497dddd68:2d75d32207d8f122ee869a9fbbd116af11ff9ddf89ade5f395aef1e94f1bba04b35ba8b89449dbe5e6855088739642014a87ff5335fa77999aca088ff3325363',	'54444345M'),
('luis.pinto',	'1000:9256b9d54ecc617e6bab1c39656974ad:3b64eec76d58c1619155516fbdf7ae98365968412188ead60bf888bf4abc623efb735bb5885ce7d54630b672a932580c839f21bba43e5f7314c95260c77f400c',	'34434232N'),
('marta.saez',	'1000:4eff5cda9528f510ee6e7f3930a74e8b:38364f8b99edb37ee32cda3413dbe5f1fdb23d5938491c2a8512a44aef2c6238b316dc41abe087a6894e6826fb1f84235e65f472781b3c8862158842efbb0e14',	'35464444C'),
('pedro.juan',	'1000:bed8253928d0c4bff6a1cbbcae34566d:0ffb50c0462a8a352ba347663109783ea2f0b768b8c2a8d939f9b61acd3747bf61fb5a9f6930d88cdbb1ef30ff9b1ff52c98bb967a79cbe51a2d9d59079ae3e0',	'544456B'),
('pepe.matamoros',	'1000:e4c01bd504914333303b74a72a6e02e3:86084467682db3b3ea7621bbb3c5a5c141a8be436ca570947eba03490d723bfc8dcdf005a4987764e15a3044c2fc2d48787cc95742cf3593d4198f28869d6e61',	'12333256G'),
('ruben.parras',	'1000:a1c09540c948a53964ae83ad49ab9ab1:0af2e8ec94c2c1c33bf900df63d263f91f24939fa2204fcd3d14b6e5badb3336f43df5db7cc0a92272b13a2fad511433b825268f00840d6e7a93950b3ae4c446',	'22342564M'),
('sonia.garcia',	'1000:474713e041ed7857b5a17af86c6f1307:4af84f09da8a20d5fbbb5acfc462c9c1bccad833db17e77a92cfc16c02f49233291c1674bc22cc371b5da8b716810485e6700aa526810fcf493dc8ba25ba7421',	'10023545C'),
('sonia.ochante',	'1000:4c71d95ebd6e8681606b260dd9d94142:b5309f84cc3fa09145356fc72edbba2fbf63a8c888850f96da4811f9d424aab3c9576dcc4f94700a01bd5c847f835b6ab19302b08d86e90fc6bad0963b44aa4e',	'63637543N'),
('tutor',	'1000:51d6bdc8890c8c985936f61e879c577b:c29cb814602f9c659753faf8222d8515ec0ebedb894b61cdf9a565348061977d41845f11c47c2176984cd23e208e8b96cdef2efaa186e214f929bdd42e01f799',	'yyyyyyyyy');

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE `responsable` (
  `persona_usuario` varchar(255) NOT NULL,
  PRIMARY KEY (`persona_usuario`),
  CONSTRAINT `FK1gbt83os11etso3spcy7cp1ka` FOREIGN KEY (`persona_usuario`) REFERENCES `persona` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `responsable` (`persona_usuario`) VALUES
('admin');

DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor` (
  `empresa_cif` varchar(255) NOT NULL,
  `persona_usuario` varchar(255) NOT NULL,
  `cargo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`empresa_cif`,`persona_usuario`),
  KEY `FK98l2b4i9wii8d4hkegd5i55ge` (`persona_usuario`),
  CONSTRAINT `FK1kxa05lih0u8w4yg24i2equ7d` FOREIGN KEY (`empresa_cif`) REFERENCES `empresa` (`cif`),
  CONSTRAINT `FK98l2b4i9wii8d4hkegd5i55ge` FOREIGN KEY (`persona_usuario`) REFERENCES `persona` (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `tutor` (`empresa_cif`, `persona_usuario`, `cargo`) VALUES
('A54357254',	'alberto.torres',	'Responsable Sistemas'),
('A54357254',	'juan.tome',	'Responsable Departamento Espacio'),
('A58818501',	'alba.ramos',	'Director Ciberseguridad'),
('A58818501',	'pepe.matamoros',	'Responsable Redes y Sistemas'),
('A63546546',	'jose.juan',	'Jefe Programacion'),
('L65463456',	'daniel.garcia',	'Responsable Departamento Software'),
('xxxxxxxxx',	'tutor',	'prueba');