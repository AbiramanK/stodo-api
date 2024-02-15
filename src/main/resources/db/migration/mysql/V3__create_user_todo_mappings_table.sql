CREATE TABLE `user_todo_mappings` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `todo_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`todo_id`, `user_id`),
  FOREIGN KEY (`todo_id`) REFERENCES `todos` (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
)