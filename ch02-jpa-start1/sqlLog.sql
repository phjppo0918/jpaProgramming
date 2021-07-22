
CREATE SCHEMA `jpaschema`;
USE `jpaschema`;

CREATE TABLE `member` (
                          `id` varchar(255) NOT NULL,
                          `name` varchar(255) DEFAULT NULL,
                          `age` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci