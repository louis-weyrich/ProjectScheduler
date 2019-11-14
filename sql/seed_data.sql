#SET SQL_SAFE_UPDATES=0;
#SET FOREIGN_KEY_CHECKS=0;





INSERT INTO `project_scheduler`.`permission`
	(`permission_name`, `permission_type`)
VALUES
	('create_user','ADMIN'),
    ('view_user','ADMIN'),
    ('update_user','ADMIN'),
    ('delete_user','ADMIN'),
    ('project_admin','ADMIN'),
    ('create_permission','ADMIN'),
    ('view_permission','ADMIN'),
    ('create_role','ADMIN'),
    ('view_role','ADMIN'),
    ('user_login','ADMIN');



INSERT INTO `project_scheduler`.`role`
	(`role_name`, `role_type`)
VALUES
	('user_admin','ADMIN'),
    ('project_admin','ADMIN'),
    ('permission_admin','ADMIN'),
    ('role_admin','ADMIN'),
    ('general_user','ADMIN'),
    ('advanced_user','ADMIN');




INSERT INTO `project_scheduler`.`role_permission`
	(`permission_id`, `role_id`)
VALUES
	(1,1),
    (2,1),
    (3,1),
    (4,1),
    (5,2),
    (6,3),
    (7,3),
    (8,4),
    (9,4),
    (10,5);




INSERT INTO authenticated_user 
	(`user_name`, `password_hash`, `full_name`, `user_email`)
values
	('administrator','$2a$10$hA8ZxNDjCr3HPLdgk158CebHJS6GjNdPA8SHLCTnZ3d7Vu8bJmYJW','Project Administrator','project_admin@gmail.com');
# password is admin_role



INSERT INTO `project_scheduler`.`user_role`
	(`role_id`,`user_id`)
VALUES
	(1,1),
    (2,1),
    (3,1),
    (4,1);