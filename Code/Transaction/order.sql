begin;
create table customers(
    id int primary key ,
    name varchar,
    parent_id int default null references customers(id)
);
create table items (
    item_id serial primary key,
    name varchar,
    price int check ( price > 0 )
  );
create table orders (
        order_id serial primary key,
        customer_id int references customers(id)
);
create table order_items (
        order_id int references orders(order_id),
        item_id int references items(item_id),
        item_amount int check ( item_amount > 0 ),
        primary key (order_id, item_id)
);
insert into customers (id, name) values (1, 'Fei');
insert into customers (id, name) values (2, 'Longzhi');
insert into customers (id, name) values (3, 'Test');
insert into items (name, price) values ('PostgreSQL', 10);
insert into items (name, price) values ('MySQL', 20);
insert into items (name, price) values ('Oracle', 30);
insert into orders (customer_id) values (1);
insert into order_items (order_id, item_id,item_amount) values (1, 1, 10);
insert into order_items (order_id, item_id,item_amount) values (1, 2, 1);
insert into order_items (order_id, item_id,item_amount) values (1, 3, 5);
commit;
