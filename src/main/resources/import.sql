INSERT INTO tb_role (id, created_on, updated_on, authority) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_ADMIN');
INSERT INTO tb_role (id, created_on, updated_on, authority) VALUES (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'ROLE_USER');

INSERT INTO tb_user (id, created_on, updated_on, email, password, preferred_units) VALUES (1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user1@gmail.com', '$2a$10$mHu4T.xwlWny.rU3JcqZo.B2L/T/l35q/GUnqLircqDeKCWeh3d/K', '');
INSERT INTO tb_user (id, created_on, updated_on, email, password, preferred_units) VALUES (2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'user2@gmail.com', '$2a$10$mHu4T.xwlWny.rU3JcqZo.B2L/T/l35q/GUnqLircqDeKCWeh3d/K', '');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
