DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `person_id` bigint(10) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;