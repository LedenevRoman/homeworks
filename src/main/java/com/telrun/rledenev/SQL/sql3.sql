create database tmp;

use tmp;

create table employee(
    id integer primary key,
    name varchar(128) not null,
    lastname varchar(128) not null,
    salary integer check(salary >= 0) default 0,
    manager_id integer,
    department_id integer
);

insert into employee values (1, 'Thomas'   , 'Nelson'     , 150000, null, 1 );
insert into employee values (2, 'Willie'   , 'Mitchell'   , 90000 , 1,    3 );
insert into employee values (3, 'David'    , 'Garrett'    , 170000, 2,    2 );
insert into employee values (4, 'Gary'     , 'Richardson' , 140000, 1,    5 );
insert into employee values (5, 'Donald'   , 'Stewart'    , 100000, 3,    5 );
insert into employee values (6, 'Frederick', 'White'      , 70000 , 2,    3 );
insert into employee values (7, 'Willie'   , 'Gonzales'   , 12000 , 1,    1 );
insert into employee values (8, 'Angel'    , 'Carter'     , 990000, 3,    3 );

create table tasks(
    id integer,
    title varchar(128),
    employee_id integer,
    payment integer,
    done_flg integer
);

insert into tasks values(1,  'Task # 616', 1,   367,  1);
insert into tasks values(2,  'Task # 741', 4,   430,  1);
insert into tasks values(3,  'Task # 526', 4,   173,  0);
insert into tasks values(4,  'Task # 588', 1,   141,  1);
insert into tasks values(5,  'Task # 964', 2,   506,  0);
insert into tasks values(6,  'Task # 282', 4,   404,  0);
insert into tasks values(7,  'Task # 350', 5,   339,  0);
insert into tasks values(8,  'Task # 523', 7,   130,  1);
insert into tasks values(9,  'Task # 776', 2,   439,  1);
insert into tasks values(10, 'Task # 155', 2,   467,  1);
insert into tasks values(11, 'Task # 348', 4,   570,  0);
insert into tasks values(12, 'Task # 703', 3,   574,  1);
insert into tasks values(13, 'Task # 727', 6,   116,  0);
insert into tasks values(14, 'Task # 131', 5,   497,  0);
insert into tasks values(15, 'Task # 166', 10,  218,   0);
insert into tasks values(16, 'Task # 167', 10,  263,   1);
insert into tasks values(17, 'Task # 168', 10,  334,   0);