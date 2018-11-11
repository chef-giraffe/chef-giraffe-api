insert into restaurant(id, name, created_time)
values ('a5eea915-128e-40b0-963c-e61164750511','Darnell''s Darn Good!','2018-11-11');

insert into restaurant_table(id, restaurant_id, friendly_name, available_seats)
values ('127e65d0-13a0-4be2-9b5a-ed0635b9c5ce','a5eea915-128e-40b0-963c-e61164750511','table 0',5),
       ('9ace77d1-fdc2-4272-9106-a5ce2cd96cc9','a5eea915-128e-40b0-963c-e61164750511','table 1',5),
       ('fcff4911-1b2a-42e6-8590-e6cbecee2675','a5eea915-128e-40b0-963c-e61164750511','table 2',5),
       ('986f4c43-24f6-4692-81ca-2f98ed34306c','a5eea915-128e-40b0-963c-e61164750511','table 3',3),
       ('e17dd5be-ac44-4868-a0e8-9a8668798aa0','a5eea915-128e-40b0-963c-e61164750511','table 4',3),
       ('f872d58a-eacd-4b4d-ad33-8e9b6a140b02','a5eea915-128e-40b0-963c-e61164750511','table 5',3),
       ('49c40776-3811-4e36-b5dd-1ee074a79915','a5eea915-128e-40b0-963c-e61164750511','table 6',3),
       ('f454634a-b744-4960-ab51-353c80d20fcc','a5eea915-128e-40b0-963c-e61164750511','table 7',8),
       ('ab9c1206-dc9d-4a05-b0c6-eb14cd484272','a5eea915-128e-40b0-963c-e61164750511','table 8',8),
       ('c7fd08b1-7f00-4faf-b6ad-8b32e73d35cb','a5eea915-128e-40b0-963c-e61164750511','table 9',8);

insert into restaurant_menu(id, restaurant_id, name)
values ('2ea2f2c9-bfc3-4ec3-b568-82c21130fc10','a5eea915-128e-40b0-963c-e61164750511','Darnell''s Delicious Apps'),
       ('19fd1573-ed74-4b0d-bdd2-12d09ce5c0d8','a5eea915-128e-40b0-963c-e61164750511','Darnell''s Crispy Entrees'),
       ('459fe504-3f39-42f5-8590-79c975c28c93','a5eea915-128e-40b0-963c-e61164750511','Darnell''s Provocative Desserts');

insert into restaurant_menu_item(id, restaurant_menu_id, name, description, price, image_uri)
values ('9d725f88-3f9f-477f-af88-3a8f09dbb6fb','2ea2f2c9-bfc3-4ec3-b568-82c21130fc10','Beer Nachos','An unreal combination of beer and nachos.  What more do you want?',4.99,null),
       ('f97d5635-c1b3-420b-8178-3102dad63ccd','2ea2f2c9-bfc3-4ec3-b568-82c21130fc10','Ballin Quesodillas','Quesodillas so hard, you might break your ankles.',6.95,null),
       ('75381cac-06ce-4d80-a26a-4ba62158b989','2ea2f2c9-bfc3-4ec3-b568-82c21130fc10','Hottest Damn Wings','You''ve been warned.',5.99,null),
       ('f3d36f9e-814d-48d4-96ad-e40196aaf64e','19fd1573-ed74-4b0d-bdd2-12d09ce5c0d8','Darnell''s Favorite Steak','Darnell''s steak cooked just like his momma makes it.',24.95,null),
       ('0c8f0c69-8ea2-4b34-aa97-fa0252cc871b','19fd1573-ed74-4b0d-bdd2-12d09ce5c0d8','Super Good Chicken Soup','',11.99,null),
       ('a4d2453e-637b-4f07-be0e-abcd546aac11','19fd1573-ed74-4b0d-bdd2-12d09ce5c0d8','Real Home Down Grilled Cheese','',9.49,null),
       ('544305ca-3526-47d1-9b9e-6aca1bf8cdeb','19fd1573-ed74-4b0d-bdd2-12d09ce5c0d8','Double Crisp Tendies','Tendies crisped twice.',14.99,null),
       ('cabecd42-43e6-49a2-a952-007bbae894bc','19fd1573-ed74-4b0d-bdd2-12d09ce5c0d8','Juicy Cheese Burger','You think you''ve had a juicy burger, but, you''ve never had Darnell''s',14.99,null),
       ('c7758283-d8d3-4fd8-b424-30280df28f29','459fe504-3f39-42f5-8590-79c975c28c93','Melt In Your Mouth Chocolate Cake','An warm, soft, irresistible slice of chocolate heaven.',8.95,null),
       ('df1b0fca-6b4c-437d-ac4d-bfa66e1adf27','459fe504-3f39-42f5-8590-79c975c28c93','Strawberry Sensation','Sensory overload that''s best shared with your partner.',13.49,null);

insert into restaurant_order(id, restaurant_table_id, order_status, created_time)
values ('8d01c930-2421-4d62-94ad-2e2a64b15fbd','127e65d0-13a0-4be2-9b5a-ed0635b9c5ce','CREATED','2018-11-11'),
       ('c3888649-3a17-42ce-a26c-f97b7c8db13f','9ace77d1-fdc2-4272-9106-a5ce2cd96cc9','PREPARING','2018-11-11');

insert into restaurant_order_item(restaurant_order_id, restaurant_menu_item_id)
values ('8d01c930-2421-4d62-94ad-2e2a64b15fbd','9d725f88-3f9f-477f-af88-3a8f09dbb6fb'),
       ('8d01c930-2421-4d62-94ad-2e2a64b15fbd','75381cac-06ce-4d80-a26a-4ba62158b989'),
       ('8d01c930-2421-4d62-94ad-2e2a64b15fbd','544305ca-3526-47d1-9b9e-6aca1bf8cdeb'),
       ('c3888649-3a17-42ce-a26c-f97b7c8db13f','f97d5635-c1b3-420b-8178-3102dad63ccd'),
       ('c3888649-3a17-42ce-a26c-f97b7c8db13f','f3d36f9e-814d-48d4-96ad-e40196aaf64e'),
       ('c3888649-3a17-42ce-a26c-f97b7c8db13f','df1b0fca-6b4c-437d-ac4d-bfa66e1adf27');