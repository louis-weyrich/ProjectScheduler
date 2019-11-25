#SET SQL_SAFE_UPDATES=0;


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
    ('create_project','ADMIN'),
    ('view_project','ADMIN'),
    ('update_project','ADMIN'),
    ('delete_project','ADMIN'),
    ('create_sub_project','PROJECT'),
    ('project_owner','PROJECT');



INSERT INTO `project_scheduler`.`role`
	(`role_name`, `role_type`)
VALUES
	('user_admin','ADMIN'),
    ('project_admin','ADMIN'),
    ('permission_admin','ADMIN'),
    ('role_admin','ADMIN'),
    ('general_user','ADMIN'),
    ('advanced_user','ADMIN'),
    ('project_user','PROJECT'),
    ('project_viewer','PROJECT');


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


INSERT INTO `project_scheduler`.`authenticated_user`
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
    
    
## Default project for testing administrator role


INSERT INTO `project_scheduler`.`projects`
	(`project_name`, `theme_name`,`resource_folder`)
VALUES
	('administrator Project','default_theme','administrator_Project'),
	('Sub Admin Project','default_theme','administrator_Project/Sub_Admin_Project');
	
	
INSERT INTO `project_scheduler`.`sub_projects`
	(`project_id`,`sub_project_id`)
VALUES
	(1,2);
	
	
INSERT INTO `project_scheduler`.`project_details`
	(`project_id`, `short_desc`, `long_desc`)
VALUES
	(1, 'Administrator Project Test','This project is created to test administrator project functions.'),
    (2, 'Administrator Sub Project Test','This project is created to test administrator sub project functions.');
	

	
INSERT INTO `project_scheduler`.`project_user`
	(`project_id`, `user_id`, `role_id`)
VALUES
	(1,1,2),
	(2,1,2);
	
	
## For testing user permissions


SELECT 
	p.permission_name 
FROM 
	`project_scheduler`.`authenticated_user` AS u 
INNER JOIN 
	`project_scheduler`.`user_role` AS ur 
ON
	(u.user_id=ur.user_id) 
INNER JOIN 
	`project_scheduler`.`role` AS r 
ON
	(ur.role_id=r.role_id) 
INNER JOIN 
	`project_scheduler`.`role_permission` AS rp 
ON
	(r.role_id=rp.role_id)
INNER JOIN 
	`project_scheduler`.`permission` AS p 
ON
	(rp.permission_id=p.permission_id) 
WHERE 
	u.user_name='administrator';