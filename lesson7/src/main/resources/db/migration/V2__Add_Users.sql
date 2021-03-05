insert into users (id, password, username)
values (1, '$2b$10$1J.VsvA01zB89roDjH6c.uF2TuJY6cT.E.CdbLKHChpldL2a7ylca', 'Alex'),
       (2, '$2b$10$1J.VsvA01zB89roDjH6c.uF2TuJY6cT.E.CdbLKHChpldL2a7ylca', 'John');

insert into roles (id, title)
values (1, 'ROLE_ADMIN'), (2, 'ROLE_USER'),(3, 'READ_INFO');

insert into users_roles (user_id, role_id)
values (1, 1) , (2, 2), (1, 3);