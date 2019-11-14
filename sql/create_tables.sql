USE project_scheduler;

CREATE TABLE `project_scheduler`.`authenticated_user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(48) NOT NULL,
  `password_hash` VARCHAR(64) NOT NULL,
  `full_name` VARCHAR(26) NOT NULL,
  `user_email` VARCHAR(48) NOT NULL,
  `phone` VARCHAR(22),
  `status` TINYINT(1) DEFAULT 1,
  `date_active` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_deactivated` DATETIME,
  PRIMARY KEY (`user_name`),
  INDEX ndx_user_contact (user_id, full_name, user_email),
  CONSTRAINT unique_user_name_email UNIQUE(`user_name`,`user_email`)
 );




CREATE TABLE `project_scheduler`.`role` (
	`role_id` INT NOT NULL AUTO_INCREMENT,
  `role_name` VARCHAR(32) NOT NULL,
  `role_type` VARCHAR(16) NOT NULL DEFAULT 'project', # values ('ADMIN','PROJECT')
    PRIMARY KEY (`role_id`),
    CONSTRAINT unique_role UNIQUE(`role_name`)
);



CREATE TABLE `project_scheduler`.`user_role` (
	`role_id` INT NOT NULL,
    `user_id` INT NOT NULL,
    PRIMARY KEY (`role_id`,`user_id`),
    FOREIGN KEY(`user_id`) references `project_scheduler`.`authenticated_user`(`user_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY(`role_id`) references `project_scheduler`.`role`(`role_id`) ON UPDATE CASCADE ON DELETE RESTRICT
);



CREATE TABLE `project_scheduler`.`permission` (
	`permission_id` INT NOT NULL AUTO_INCREMENT,
    `permission_name` VARCHAR(48) NOT NULL,
    `permission_type` VARCHAR(16) NOT NULL DEFAULT 'project', # values ('ADMIN','PROJECT'),
    PRIMARY KEY (`permission_id`),
    CONSTRAINT unique_permission UNIQUE(`permission_name`)
);



CREATE TABLE `project_scheduler`.`role_permission` (
	`permission_id` INT NOT NULL,
    `role_id` INT NOT NULL,
    PRIMARY KEY (`permission_id`, `role_id`),
    FOREIGN KEY(`role_id`) references `project_scheduler`.`role`(`role_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY(`role_id`) references `project_scheduler`.`permission`(`permission_id`) ON UPDATE CASCADE ON DELETE RESTRICT
);



CREATE TABLE `project_scheduler`.`project_history`(
	`history_id` INT NOT NULL AUTO_INCREMENT,
	`history_type` VARCHAR(6) NOT NULL, /* INSERT, UPDATE, DELETE */
	`project_id` INT NOT NULL,
	`table_id` INT NOT NULL,
	`table_name` VARCHAR(32),
	`column_name` VARCHAR(32),
	`altered_by` INT NOT NULL,
	`old_value` VARCHAR(256),
	`new_value` VARCHAR(256),
	`date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`history_id`),
	FOREIGN KEY(`altered_by`) references `project_scheduler`.`authenticated_user`(`user_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
	INDEX ndx_history (`history_type`,`column_name`,`altered_by`)
);



CREATE TABLE `project_scheduler`.`projects` (
	`project_id` INT NOT NULL AUTO_INCREMENT,
	`parent_project_id` INT,
	`project_name` VARCHAR(48) NOT NULL,
	`date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`date_closed` DATETIME,
	`status` VARCHAR(12) NOT NULL DEFAULT 'OPEN',
	PRIMARY KEY (`project_id`),
	INDEX ndx_projects (`project_name`),
	CONSTRAINT unique_project UNIQUE(`project_name`)
);


CREATE TABLE `project_scheduler`.`project_details` (
    `project_id` INT NOT NULL,
	`short_desc` VARCHAR(256),
	`long_desc` TEXT,
	PRIMARY KEY (`project_id`),
	FOREIGN KEY(`project_id`) references `project_scheduler`.`projects`(`project_id`) ON UPDATE CASCADE ON DELETE RESTRICT
);


CREATE TABLE `project_scheduler`.`project_user` (
	`project_id`  INT NOT NULL,
	`user_id`  INT NOT NULL,
    `role_id` INT NOT NULL,
	PRIMARY KEY (`project_id`, `user_id`,`role_id`),
	FOREIGN KEY(`project_id`) references `project_scheduler`.`projects`(`project_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
	FOREIGN KEY(`user_id`) references `project_scheduler`.`authenticated_user`(`user_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
    FOREIGN KEY(`role_id`) references `project_scheduler`.`role`(`role_id`) ON UPDATE CASCADE ON DELETE RESTRICT
);

DELIMITER $$
CREATE TRIGGER trgr_projects_insert AFTER INSERT ON `project_scheduler`.`projects`
	FOR EACH ROW
	BEGIN
		INSERT INTO `project_scheduler`.`project_history`
			(`history_type`,`project_id`,`table_id`, `table_name`, `column_name`, `altered_by`,`new_value`)
		VALUES
			('INSERT', NEW.project_id, NEW.project_id, 'projects', 'project_id', NEW.user_id, NEW.project_id);
	END$$
DELIMITER ;



DELIMITER $$
CREATE TRIGGER trgr_projects_update BEFORE UPDATE ON `project_scheduler`.`projects`
	FOR EACH ROW
	BEGIN

		IF NEW.project_name <> OLD.project_name THEN
			INSERT INTO `project_scheduler`.`project_history`
				(`history_type`, `project_id`, `table_id`, `table_name`, `column_name`, `altered_by`, `old_value`, `new_value`)
			VALUES
				('UPDATE', OLD.project_id, OLD.project_id, 'projects', 'project_name', OLD.user_id, OLD.project_name, NEW.project_name);
		END IF;

		IF NEW.status <> OLD.status THEN
			INSERT INTO `project_scheduler`.`project_history`
				(`history_type`, `project_id`, `table_id`, `table_name`, `column_name`, `altered_by`, `old_value`, `new_value`)
			VALUES
				('UPDATE', OLD.project_id, OLD.project_id, 'projects', 'status', OLD.user_id, OLD.status, NEW.status);
		END IF;

	END;$$
DELIMITER ;



CREATE TABLE `project_scheduler`.`task_category` (
	`category_id`  INT NOT NULL AUTO_INCREMENT,
	`category_name` VARCHAR(32) NOT NULL,
	`category_description` TEXT,
	`category_status` TINYINT NOT NULL DEFAULT 1,
	PRIMARY KEY (`category_id`),
	INDEX ndx_task_category (`category_name`),
	CONSTRAINT unique_task_category UNIQUE(`category_name`)
);



CREATE TABLE `project_scheduler`.`task`(
	`task_id` INT NOT NULL AUTO_INCREMENT,
	`task_name` VARCHAR(48) NOT NULL,
	`project_id` INT NOT NULL,
	`category_id` INT,
	`expected_start_date` DATETIME NOT NULL,
	`expected_end_date` DATETIME NOT NULL,
	`actual_start_date` DATETIME NOT NULL,
	`actual_end_date` DATETIME NOT NULL,
	`status` VARCHAR(12) NOT NULL DEFAULT 'CREATED',
	PRIMARY KEY (`task_id`),
	FOREIGN KEY(`category_id`) references `project_scheduler`.`task_category`(`category_id`) ON UPDATE CASCADE ON DELETE RESTRICT,
	INDEX ndx_tasks (`task_name`),
	CONSTRAINT unique_task_name UNIQUE(`task_name`)
);



CREATE TABLE `project_scheduler`.`task_details`(
	`task_id` INT NOT NULL,
	`task_short_desc` VARCHAR(256),
	`task_long_desc` TEXT,
	PRIMARY KEY (`task_id`),
	FOREIGN KEY(`task_id`) references `project_scheduler`.`task`(`task_id`) ON UPDATE CASCADE ON DELETE RESTRICT
);
