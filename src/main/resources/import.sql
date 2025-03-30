INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_USER');

INSERT INTO tb_user (email, password, preferred_units) VALUES ('user1@gmail.com', '$2a$10$mHu4T.xwlWny.rU3JcqZo.B2L/T/l35q/GUnqLircqDeKCWeh3d/K', 'Kg,L,Hz,N');
INSERT INTO tb_user (email, password, preferred_units) VALUES ('user2@gmail.com', '$2a$10$mHu4T.xwlWny.rU3JcqZo.B2L/T/l35q/GUnqLircqDeKCWeh3d/K', 'Kg,m,L,W');


INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_ingredient (name, type) VALUES ('Alho', 'Tempero');
INSERT INTO tb_ingredient (name, type) VALUES ('Sal', 'Tempero');
INSERT INTO tb_ingredient (name, type) VALUES ('Açucar', 'Tempero');
INSERT INTO tb_ingredient (name, type) VALUES ('Tomate', 'Fruta');
INSERT INTO tb_ingredient (name, type) VALUES ('Maçã', 'Fruta');
INSERT INTO tb_ingredient (name, type) VALUES ('Massa de macarrão', 'Massa');
INSERT INTO tb_ingredient (name, type) VALUES ('Queijo prato', 'Frios');

INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (1, 1);
INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (1, 2);
INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (1, 3);
INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (2, 1);
INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (2, 2);
INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (2, 4);
INSERT INTO tb_user_ingredient (user_id, ingredient_id) VALUES (2, 6);

INSERT INTO tb_dish_nutrition_facts (calories) VALUES (1500);
INSERT INTO tb_dish_nutrition_facts (calories) VALUES (700);

INSERT INTO tb_dish (name, prep_time, cook_time, instructions, nutrition_facts_id) VALUES ('Macarrão', 30, 20, 'Cozinhar na panela', 1);
INSERT INTO tb_dish (name, prep_time, cook_time, instructions, nutrition_facts_id) VALUES ('Pão de queijo', 50, 40, 'Fazer a massa e assar', 2);

INSERT INTO tb_recipe_ingredient (dish_id, ingredient_id, amount) VALUES (1, 6, 1);
INSERT INTO tb_recipe_ingredient (dish_id, ingredient_id, amount) VALUES (1, 2, 2);
INSERT INTO tb_recipe_ingredient (dish_id, ingredient_id, amount) VALUES (1, 4, 3);
INSERT INTO tb_recipe_ingredient (dish_id, ingredient_id, amount) VALUES (2, 7, 5);

INSERT INTO tb_user_dish (user_id, dish_id) VALUES (1, 1);
INSERT INTO tb_user_dish (user_id, dish_id) VALUES (2, 1);
INSERT INTO tb_user_dish (user_id, dish_id) VALUES (2, 2);

INSERT INTO tb_user_groceries_list (user_id, recipe_ingredient_id) VALUES (2, 1);
INSERT INTO tb_user_groceries_list (user_id, recipe_ingredient_id) VALUES (2, 2);
INSERT INTO tb_user_groceries_list (user_id, recipe_ingredient_id) VALUES (2, 3);

INSERT INTO tb_dietary_restriction (name) VALUES ('Intolerância à lactose');
INSERT INTO tb_dietary_restriction (name) VALUES ('Intolerância ao glúten');
INSERT INTO tb_dietary_restriction (name) VALUES ('Diabetes');

INSERT INTO tb_user_dietary_restriction (user_id, dietary_restriction_id) VALUES (2, 3);

INSERT INTO tb_ingredient_dietary_restriction (ingredient_id, dietary_restriction_id) VALUES (7, 1);
INSERT INTO tb_ingredient_dietary_restriction (ingredient_id, dietary_restriction_id) VALUES (3, 3);
