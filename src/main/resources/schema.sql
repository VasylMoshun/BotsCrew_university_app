CREATE TABLE `lectors` (
                           `salary` decimal(38,2) DEFAULT NULL,
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `degree` enum('ASSISTANT','ASSOCIATE_PROFESSOR','PROFESSOR') DEFAULT NULL,
                           `firstname` varchar(255) DEFAULT NULL,
                           `lastname` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `departments` (
                               `head_of_department_id` bigint DEFAULT NULL,
                               `id` bigint NOT NULL AUTO_INCREMENT,
                               `name` varchar(255) DEFAULT NULL,
                               PRIMARY KEY (`id`),
                               UNIQUE KEY `UK_rfnsv2ay8ellqaesawo78owom` (`head_of_department_id`),
                               CONSTRAINT `FK2vg5b7cndx04ue0eplk3lmbx1` FOREIGN KEY (`head_of_department_id`) REFERENCES `lectors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `departments_personnel` (
                                         `department_id` bigint NOT NULL,
                                         `personnel_id` bigint NOT NULL,
                                         PRIMARY KEY (`department_id`,`personnel_id`),
                                         KEY `FKqeoqj19r9t34i1wddtsu991l0` (`personnel_id`),
                                         CONSTRAINT `FKj4ilfi1gembynu9x3kxr8626r` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`),
                                         CONSTRAINT `FKqeoqj19r9t34i1wddtsu991l0` FOREIGN KEY (`personnel_id`) REFERENCES `lectors` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


