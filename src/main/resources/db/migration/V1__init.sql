-- table creates
create table restaurant
(
    id uuid primary key not null,
    name varchar2(75) not null,
    created_time timestamp not null
);

create table restaurant_table
(
    id uuid primary key not null,
    restaurant_id uuid not null,
    friendly_name varchar(50) not null,
    available_seats integer not null,
    foreign key (restaurant_id) references restaurant(id)
);

create table restaurant_menu
(
    id uuid primary key not null,
    restaurant_id uuid not null,
    name varchar(50) not null,
    foreign key (restaurant_id) references restaurant(id)
);

create table restaurant_menu_item
(
    id uuid primary key not null,
    restaurant_menu_id uuid not null,
    name varchar(50) not null,
    description varchar(255) not null,
    price decimal not null,
    image_uri varchar(255) null,
    foreign key (restaurant_menu_id) references restaurant_menu(id)
);

create table restaurant_order
(
    id uuid primary key not null,
    restaurant_table_id uuid not null,
    order_status varchar(50) not null,
    created_time timestamp not null,
    updated_time timestamp null,
    foreign key (restaurant_table_id) references restaurant_table(id)
);

create table restaurant_order_item
(
    restaurant_order_id uuid not null,
    restaurant_menu_item_id uuid not null,
    foreign key (restaurant_order_id) references restaurant_order(id),
    foreign key (restaurant_menu_item_id) references restaurant_menu_item(id)
);

create table restaurant_table_request
(
    id uuid primary key not null,
    restaurant_table_id uuid not null,
    description varchar(255) not null,
    created_time timestamp not null,
    foreign key (restaurant_table_id) references restaurant_table(id)
);