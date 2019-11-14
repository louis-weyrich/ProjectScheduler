#MYSQL ROOT USER
#user = root
#password = TheMyth02

DROP DATABASE IF EXISTS `project_scheduler`;

CREATE DATABASE `project_scheduler`;

DROP USER IF EXISTS 'pscheduler'@'localhost';

CREATE USER 'pscheduler'@'localhost' IDENTIFIED BY '!Sch3dul3r!';
GRANT SELECT, INSERT, UPDATE, DELETE ON project_scheduler.* TO 'pscheduler'@'localhost';