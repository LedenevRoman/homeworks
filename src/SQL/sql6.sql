create database youtube;

use youtube;

create table if not exists users(
    user_id int primary key auto_increment,
    created_at timestamp default current_timestamp,
	country varchar(64) not null,
	username varchar(64) not null,
	is_blocked bool default false
);
    
CREATE TABLE if not exists videos (
    video_id INT PRIMARY KEY AUTO_INCREMENT, 
    created_at timestamp default current_timestamp,
    title VARCHAR(256),
    author_id INT not null,
    is_public bool default true,
    duration_sec INT not null,
    foreign key (author_id) references users(user_id)
);
