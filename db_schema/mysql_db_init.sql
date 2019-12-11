use buttondb;

-- Инициализация таблицы product
insert into product (name) values ('груша');
insert into product (name) values ('яблоко');
insert into product (name) values ('картошка');
insert into product (name) values ('морковь');
insert into product (name) values ('лук');
insert into product (name) values ('молоко');

-- Инициализация таблицы product_list
insert into product_list (name) values ('список1');
insert into product_list (name) values ('список2');
insert into product_list (name) values ('список3');

-- Инициализация таблицы product_property
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (1, 1, 3, 'шт', 0);
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (1, 2, 1, 'кг', 0);
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (2, 2, 2, 'шт', 0);
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (3, 2, 3, 'кг', 0);
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (4, 3, 3, 'шт', 0);
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (5, 3, 300, 'гр', 0);
insert into product_property (product_id, product_list_id, quantity, units, state) 
values (6, 3, 1, 'л', 0);

-- Инициализация таблицы users
insert into users (login, name, surname, disabled)
values ('vasya', 'Василий', 'Иванов', false);
insert into users (login, name, surname, disabled)
values ('tanya', 'Татьяна', 'Иванова', false);
insert into users (login, name, surname, disabled)
values ('ivan', 'Иван', 'Петров', true);

-- Инициализация таблицы user_product_list
insert into users_product_list (product_list_id, user_id)
values (1, 1);
insert into users_product_list (product_list_id, user_id)
values (2, 1);
insert into users_product_list (product_list_id, user_id)
values (1, 2);
insert into users_product_list (product_list_id, user_id)
values (3, 3);
