CREATE TABLE `person` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `adress` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `fisrt_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `gender` varchar(1) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(50) COLLATE utf8_bin NOT NULL,
  `address` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
  )