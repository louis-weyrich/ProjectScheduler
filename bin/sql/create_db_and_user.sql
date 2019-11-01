MYSQL ROOT USER
user = root
password = Th3Myth02

CREATE DATABASE project_scheduler;

CREATE USER 'pscheduler'@'localhost' IDENTIFIED BY '!Sch3dul3r!';
GRANT SELECT, INSERT, UPDATE, DELETE ON project_scheduler.* TO 'pscheduler'@'localhost';

SELECT p.permission_name FROM project_user u INNER JOIN user_role ur ON(u.user_id=ur.user_id) INNER JOIN role r ON(ur.role_id=r.role_id) INNER JOIN role_permission rp ON(r.role_id=rp.role_id)INNER JOIN permission p ON(rp.permission_id=p.permission_id) WHERE u.username=?
