/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.25 : Database - school
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`school` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `school`;

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `class_id` int NOT NULL COMMENT '班级编号',
  `class_name` varchar(10) NOT NULL COMMENT '班级名字',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `class` */

insert  into `class`(`class_id`,`class_name`) values (1001,'软件工程1班'),(1002,'软件工程2班'),(1003,'软件工程3班'),(1005,'软件工程5班'),(2001,'人工智能1班'),(2002,'人工智能2班'),(2003,'计算机1班');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `student_id` int NOT NULL COMMENT '学号',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '学生姓名',
  `sex` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `phone` varchar(11) NOT NULL COMMENT '电话号码',
  `class_id` int NOT NULL COMMENT '班级编号',
  `enter_time` date NOT NULL COMMENT '进入班级的时间',
  PRIMARY KEY (`student_id`),
  KEY `fk_class_id` (`class_id`),
  CONSTRAINT `fk_class_id` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `student` */

insert  into `student`(`student_id`,`name`,`sex`,`phone`,`class_id`,`enter_time`) values (2222001,'','男','123555555',2001,'2023-01-11'),(2222002,'leili','男','12156151615',1001,'2023-01-11'),(2222003,'xiaoli','女','12345678901',1002,'2023-01-11'),(2222004,'xiaomei','女','6516515615',2001,'2023-01-11');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
