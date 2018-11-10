-- table creates
create table orderstatus
(
    id smallint primary key not null,
    status varchar(25) not null
);

create table `table`
(
    id uuid primary key not null,
    friendlyname varchar(50) not null,
    availableseats integer not null
);

create table item
(
    id uuid primary key not null,
    name varchar(50) not null,
    description varchar(255) not null,
    price decimal not null,
    imageuri varchar(255) null
);

create table `order`
(
    id uuid primary key not null,
    tableid uuid not null,
    orderstatusid smallint not null,
    foreign key (tableid) references `table`(id),
    foreign key (orderstatusid) references orderstatus(id)
);

create table orderitem
(
    orderid uuid not null,
    itemid uuid not null,
    foreign key (orderid) references `order`(id),
    foreign key (itemid) references item(id)
);

-- table inserts
insert into orderstatus(id, status)
values (0, 'CREATED'),
       (1, 'PREPARING'),
       (2, 'FULFILLED');