CREATE DATABASE `buttondb` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
  
CREATE TABLE `product_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `product_property` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `product_list_id` int(11) NOT NULL,
  `quantity` float DEFAULT NULL,
  `units` varchar(10) DEFAULT NULL,
  `state` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `product_id_idx` (`product_id`),
  KEY `product_list_id_idx` (`product_list_id`),
  CONSTRAINT `product_id_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `product_list_id_1` FOREIGN KEY (`product_list_id`) REFERENCES `product_list` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `surname` varchar(20) DEFAULT NULL,
  `disabled` tinyint(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8

CREATE TABLE `users_product_list` (
  `product_list_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`product_list_id`,`user_id`),
  KEY `id_idx` (`user_id`),
  CONSTRAINT `product_list_id` FOREIGN KEY (`product_list_id`) REFERENCES `product_list` (`id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8