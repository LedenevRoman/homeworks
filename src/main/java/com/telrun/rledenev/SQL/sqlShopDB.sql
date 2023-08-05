create database shop;

use shop;

CREATE TABLE IF NOT EXISTS customers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(128),
  last_name VARCHAR(128),
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL,
  date_of_birth DATETIME  NOT NULL,
  gender CHAR(1)  NOT NULL,
  loyalty_program_id integer,
  start_date DATETIME  NOT NULL
);



INSERT INTO customers (first_name, last_name, email, address, phone, date_of_birth, gender, loyalty_program_id, start_date)
VALUES
  ('John', 'Doe', 'johndoe@example.com', '123 Main St', '555-1234', '1980-01-01', 'M', 2, '2018-01-01'),
  ('Jane', 'Smith', 'janesmith@example.com', '456 Elm St', '555-5678', '1985-02-02', 'F', 4, '2019-03-15'),
  ('Michael', 'Johnson', 'michaeljohnson@example.com', '789 Oak St', '555-9012', '1990-03-03', 'M',NULL, '2020-05-10'),
  ('Emily', 'Williams', 'emilywilliams@example.com', '321 Pine St', '555-3456', '1995-04-04', 'F', 3, '2018-12-20'),
  ('David', 'Brown', 'davidbrown@example.com', '1111 Cedar St', '555-7890', '1982-05-05', 'M', 1, '2021-02-28'),
  ('Jennifer', 'Taylor', 'jennifertaylor@example.com', '2222 Maple St', '555-2345', '1987-06-06', 'F', 3, '2019-07-05'),
  ('Christopher', 'Davis', 'christopherdavis@example.com', '3333 Oak St', '555-6789', '1992-07-07', 'M', 2, '2020-09-12'),
  ('Jessica', 'Miller', 'jessicamiller@example.com', '4444 Pine St', '555-0123', '1997-08-08', 'F', NULL, '2021-11-19'),
  ('Matthew', 'Wilson', 'matthewwilson@example.com', '5555 Cedar St', '555-4567', '1984-09-09', 'M', 2, '2018-03-25'),
  ('Amanda', 'Anderson', 'amandaanderson@example.com', '6666 Maple St', '555-8901', '1989-10-10', 'F', NULL, '2019-06-30'),
  ('Andrew', 'Thomas', 'andrewthomas@example.com', '7777 Oak St', '555-2345', '1994-11-11', 'M', 1, '2020-08-07'),
  ('Olivia', 'Martinez', 'oliviamartinez@example.com', '8888 Elm St', '555-6789', '1999-12-12', 'F', NULL, '2021-10-14'),
  ('William', 'Jones', 'williamjones@example.com', '9999 Cedar St', '555-0123', '1983-01-15', 'M', 5, '2018-06-18'),
  ('Sophia', 'Garcia', 'sophiagarcia@example.com', '1010 Maple St', '555-4567', '1988-02-16', 'F', 3, '2019-09-25'),
  ('Alexander', 'Martinez', 'alexandermartinez@example.com', '1111 Oak St', '555-8901', '1993-03-17', 'M', 3, '2020-12-02'),
  ('Abigail', 'Brown', 'abigailbrown@example.com', '1212 Pine St', '555-2345', '1998-04-18', 'F', NULL, '2022-03-11'),
  ('James', 'Taylor', 'jamestaylor@example.com', '1313 Cedar St', '555-6789', '1985-05-19', 'M', 5, '2018-08-18'),
  ('Charlotte', 'Clark', 'charlotteclark@example.com', '1414 Elm St', '555-0123', '1990-06-20', 'F', 4, '2019-11-25'),
  ('Daniel', 'Lee', 'daniellee@example.com', '1515 Oak St', '555-4567', '1995-07-21', 'M', NULL, '2021-02-02'),
  ('Elizabeth', 'Walker', 'elizabethwalker@example.com', '1616 Pine St', '555-8901', '2000-08-22', 'F', 1, '2022-05-11'),
  ('Benjamin', 'Hall', 'benjaminhall@example.com', '1717 Cedar St', '555-2345', '1982-09-23', 'M', 4, '2018-10-20'),
  ('Mia', 'Young', 'miayoung@example.com', '1818 Maple St', '555-6789', '1987-10-24', 'F', NULL, '2019-01-27'),
  ('Liam', 'Walker', 'liamwalker@example.com', '1919 Elm St', '555-0123', '1992-11-25', 'M', 2, '2018-12-29'),
  ('Emma', 'Harris', 'emmaharris@example.com', '2020 Oak St', '555-4567', '1997-12-31', 'F', 1, '2019-04-05'),
  ('Noah', 'Clark', 'noahclark@example.com', '2121 Pine St', '555-8901', '1984-01-01', 'M', NULL, '2020-06-11'),
  ('Isabella', 'Hall', 'isabellahall@example.com', '2222 Cedar St', '555-2345', '1989-02-02', 'F', 2, '2021-08-19'),
  ('Oliver', 'Young', 'oliveryoung@example.com', '2323 Maple St', '555-6789', '1994-03-03', 'M', 2, '2018-10-27'),
  ('Sophia', 'Lopez', 'sophialopez@example.com', '2424 Elm St', '555-0123', '1999-04-04', 'F', NULL, '2019-01-02'),
  ('Lucas', 'Green', 'lucasgreen@example.com', '2525 Oak St', '555-4567', '1986-05-05', 'M', 3, '2020-03-10'),
  ('Ava', 'Lewis', 'avalewis@example.com', '2626 Pine St', '555-8901', '1991-06-06', 'F', NULL, '2021-05-18'),
  ('Mason', 'Jackson', 'masonjackson@example.com', '2727 Cedar St', '555-2345', '1996-07-07', 'M', 1, '2018-07-26'),
  ('Charlotte', 'Hill', 'charlottehill@example.com', '2828 Maple St', '555-6789', '2001-08-08', 'F', 3, '2019-10-02'),
  ('Elijah', 'Robinson', 'elijahrobinson@example.com', '2929 Elm St', '555-0123', '1983-09-09', 'M', 2, '2020-12-10'),
  ('Amelia', 'Carter', 'ameliacarter@example.com', '3030 Oak St', '555-4567', '1988-10-10', 'F', 3, '2022-02-18'),
  ('Harper', 'Phillips', 'harperphillips@example.com', '3131 Pine St', '555-8901', '1993-11-11', 'M', NULL, '2018-05-27'),
  ('Liam', 'Flores', 'liamflores@example.com', '3232 Cedar St', '555-2345', '1998-12-12', 'F', 4, '2019-08-03');
  
  CREATE TABLE IF NOT EXISTS loyalty_programs (
  id INT AUTO_INCREMENT PRIMARY KEY,
  program_name VARCHAR(255) NOT NULL,
  discount DECIMAL(5,2) NOT NULL
);

INSERT INTO loyalty_programs (program_name, discount)
VALUES
  ('Bronze', 5),
  ('Silver', 10),
  ('Gold', 15),
  ('Platinum', 20),
  ('Diamond', 25);
  
  create table order_details(
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id integer,
  product_id integer,
  product_count integer
);


-- Добавление 150 записей в таблицу order_details
INSERT INTO order_details (order_id, product_id, product_count)
VALUES
  (1, 1, 5),
  (1, 2, 3),
  (1, 4, 2),
  (2, 5, 1),
  (2, 6, 4),
  (2, 8, 7),
  (3, 9, 2),
  (3, 10, 5),
  (3, 11, 3),
  (4, 13, 6),
  (4, 14, 4),
  (4, 15, 2),
  (5, 16, 3),
  (5, 18, 1),
  (5, 19, 5),
  (6, 20, 4),
  (6, 21, 7),
  (6, 22, 2),
  (7, 23, 1),
  (7, 24, 4),
  (7, 26, 3),
  (8, 27, 6),
  (8, 28, 4),
  (8, 30, 2),
  (9, 1, 3),
  (9, 2, 1),
  (9, 4, 5),
  (10, 5, 4),
  (10, 6, 7),
  (10, 8, 2),
  (11, 9, 1),
  (11, 10, 4),
  (11, 11, 3),
  (12, 13, 6),
  (12, 14, 4),
  (12, 15, 2),
  (13, 16, 3),
  (13, 18, 5),
  (13, 19, 1),
  (14, 20, 4),
  (14, 21, 7),
  (14, 22, 2),
  (15, 23, 1),
  (15, 24, 3),
  (15, 26, 4),
  (16, 27, 6),
  (16, 28, 4),
  (16, 30, 3),
  (17, 1, 1),
  (17, 2, 4),
  (17, 4, 5),
  (18, 5, 4),
  (18, 6, 2),
  (18, 8, 7),
  (19, 9, 1),
  (19, 10, 3),
  (19, 11, 5),
  (20, 13, 6),
  (20, 14, 2),
  (20, 15, 4),
  (21, 16, 1),
  (21, 18, 3),
  (21, 19, 5),
  (22, 20, 4),
  (22, 21, 7),
  (22, 22, 2),
  (23, 23, 1),
  (23, 24, 3),
  (23, 26, 6),
  (24, 27, 4),
  (24, 28, 3),
  (24, 30, 2),
  (25, 1, 4),
  (25, 2, 1),
  (25, 4, 5),
  (26, 5, 2),
  (26, 6, 7),
  (26, 8, 3),
  (27, 9, 1),
  (27, 10, 6),
  (27, 11, 4),
  (28, 13, 3),
  (28, 14, 6),
  (28, 15, 2),
  (29, 16, 5),
  (29, 18, 1),
  (29, 19, 4),
  (30, 20, 7),
  (30, 21, 2),
  (30, 22, 4),
  (31, 23, 1),
  (31, 24, 3),
  (31, 26, 6),
  (32, 27, 4),
  (32, 28, 3),
  (32, 30, 2),
  (33, 1, 4),
  (33, 2, 1),
  (33, 4, 5),
  (34, 5, 2),
  (34, 6, 7),
  (34, 8, 3),
  (35, 9, 1),
  (35, 10, 6),
  (35, 11, 4),
  (36, 13, 3),
  (36, 14, 6),
  (36, 15, 2),
  (37, 16, 5),
  (37, 18, 1),
  (37, 19, 4),
  (38, 20, 7),
  (38, 21, 2),
  (38, 22, 4),
  (39, 23, 1),
  (39, 24, 3),
  (39, 26, 6),
  (40, 27, 4),
  (40, 28, 3),
  (40, 30, 2),
  (41, 1, 4),
  (41, 2, 1),
  (41, 4, 5),
  (42, 5, 2),
  (42, 6, 7),
  (42, 8, 3),
  (43, 9, 1),
  (43, 10, 6),
  (43, 11, 4),
  (44, 13, 3),
  (44, 14, 6),
  (44, 15, 2),
  (45, 16, 5),
  (45, 18, 1),
  (45, 19, 4),
  (46, 20, 7),
  (46, 21, 2),
  (46, 22, 4),
  (47, 23, 1),
  (47, 24, 3),
  (47, 26, 6),
  (48, 27, 4),
  (48, 28, 3),
  (48, 30, 2),
  (49, 1, 4),
  (49, 2, 1),
  (49, 4, 5),
  (50, 5, 2),
  (50, 6, 7),
  (50, 8, 3),
  (51, 9, 1),
  (51, 10, 6),
  (51, 11, 4),
  (52, 13, 3),
  (52, 14, 6),
  (52, 15, 2),
  (53, 16, 5),
  (53, 18, 1),
  (53, 19, 4),
  (54, 20, 7),
  (54, 21, 2),
  (54, 22, 4),
  (55, 23, 1),
  (55, 24, 3),
  (55, 26, 6),
  (56, 27, 4),
  (56, 28, 3),
  (56, 30, 2),
  (57, 1, 4),
  (57, 2, 1),
  (57, 4, 5),
  (58, 5, 2),
  (58, 6, 7),
  (58, 8, 3),
  (59, 9, 1),
  (59, 10, 6),
  (59, 11, 4),
  (60, 13, 3),
  (60, 14, 6),
  (60, 15, 2),
  (61, 16, 5),
  (61, 18, 1),
  (61, 19, 4),
  (62, 20, 7),
  (62, 21, 2),
  (62, 22, 4),
  (63, 23, 1),
  (63, 24, 3),
  (63, 26, 6),
  (64, 27, 4),
  (64, 28, 3),
  (64, 30, 2);

CREATE TABLE IF NOT EXISTS orders (
	id INT AUTO_INCREMENT PRIMARY KEY,
	customer_id integer,
	paid_flg char(1),
	order_date DATETIME NOT NULL
);

INSERT INTO orders (customer_id, paid_flg, order_date)
VALUES
  (1, 'Y', '2021-01-15 10:30:00'),
  (2, 'N', '2021-02-18 14:45:00'),
  (3, 'Y', '2021-03-22 09:15:00'),
  (5, 'N', '2021-04-25 16:20:00'),
  (6, 'Y', '2021-05-29 11:55:00'),
  (8, 'N', '2021-06-02 13:10:00'),
  (9, 'Y', '2021-07-06 15:25:00'),
  (11, 'N', '2021-08-10 17:40:00'),
  (12, 'Y', '2021-09-14 12:05:00'),
  (13, 'N', '2021-10-18 10:30:00'),
  (14, 'Y', '2021-11-21 08:45:00'),
  (15, 'N', '2021-12-25 17:00:00'),
  (16, 'Y', '2022-01-29 14:25:00'),
  (17, 'N', '2022-03-04 09:50:00'),
  (18, 'Y', '2022-04-07 11:05:00'),
  (19, 'N', '2022-05-11 15:20:00'),
  (20, 'Y', '2022-06-15 12:45:00'),
  (21, 'N', '2022-07-19 10:00:00'),
  (23, 'Y', '2022-08-23 17:15:00'),
  (24, 'N', '2022-09-27 13:40:00'),
  (25, 'Y', '2022-10-31 09:05:00'),
  (26, 'N', '2022-12-04 14:20:00'),
  (27, 'Y', '2023-01-07 12:45:00'),
  (28, 'N', '2023-02-10 08:10:00'),
  (29, 'Y', '2023-03-15 16:25:00'),
  (30, 'N', '2023-04-18 13:50:00'),
  (31, 'Y', '2023-05-22 11:15:00'),
  (32, 'N', '2023-06-26 15:30:00'),
  (33, 'Y', '2023-07-30 12:55:00'),
  (34, 'N', '2023-09-03 10:20:00'),
  (35, 'Y', '2023-10-07 17:35:00'),
  (36, 'N', '2023-11-11 14:00:00'),
  (1, 'Y', '2021-01-20 09:30:00'),
  (2, 'N', '2021-02-24 13:45:00'),
  (3, 'Y', '2021-03-29 11:15:00'),
  (5, 'N', '2021-05-01 15:20:00'),
  (6, 'Y', '2021-06-03 10:55:00'),
  (8, 'N', '2021-07-08 13:10:00'),
  (9, 'Y', '2021-08-12 15:25:00'),
  (11, 'N', '2021-09-16 17:40:00'),
  (12, 'Y', '2021-10-21 12:05:00'),
  (13, 'N', '2021-11-25 10:30:00'),
  (14, 'Y', '2021-12-29 08:45:00'),
  (15, 'N', '2022-02-02 17:00:00'),
  (16, 'Y', '2022-03-08 14:25:00'),
  (17, 'N', '2022-04-12 09:50:00'),
  (18, 'Y', '2022-05-16 11:05:00'),
  (19, 'N', '2022-06-20 15:20:00'),
  (20, 'Y', '2022-07-24 12:45:00'),
  (21, 'N', '2022-08-28 10:00:00'),
  (23, 'Y', '2022-09-30 17:15:00'),
  (24, 'N', '2022-11-04 13:40:00'),
  (25, 'Y', '2022-12-08 09:05:00'),
  (26, 'N', '2023-01-11 14:20:00'),
  (27, 'Y', '2023-02-15 12:45:00'),
  (28, 'N', '2023-03-21 08:10:00'),
  (29, 'Y', '2023-04-24 16:25:00'),
  (30, 'N', '2023-05-28 13:50:00'),
  (31, 'Y', '2023-06-30 11:15:00'),
  (32, 'N', '2023-08-04 15:30:00'),
  (33, 'Y', '2023-09-07 12:55:00'),
  (34, 'N', '2023-10-11 10:20:00'),
  (35, 'Y', '2023-11-15 17:35:00'),
  (36, 'N', '2023-12-19 14:00:00');
  
  CREATE TABLE IF NOT EXISTS products (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  price DECIMAL(8,2) NOT NULL,
  description TEXT,
  supplier_id integer,
  amount INTEGER,
  in_stoke CHAR(1)
);


-- Добавление 30 продуктов в таблицу products.txt
INSERT INTO products (name, price, description, supplier_id, amount, in_stoke)
VALUES
  ('T-shirt', 19.99, 'A comfortable and stylish t-shirt for everyday wear.', 3, 100, 'Y'),
  ('Jeans', 49.99, 'High-quality jeans that provide both style and comfort.', 3, 50, 'Y'),
  ('Sneakers', 79.99, 'Trendy sneakers with excellent cushioning and support.', 2, 75, 'Y'),
  ('Watch', 129.99, 'A sleek and elegant watch that complements any outfit.', 1, 30, 'Y'),
  ('Backpack', 39.99, 'A durable and spacious backpack for all your travel needs.', 2, 0, 'N'),
  ('Headphones', 89.99, 'Wireless headphones with noise-cancellation technology.', 2, 50, 'Y'),
  ('Laptop', 999.99, 'A powerful and versatile laptop for work and entertainment.', 2, 10, 'Y'),
  ('Smartphone', 799.99, 'The latest smartphone with advanced features and a stunning display.', 3, 15, 'Y'),
  ('Camera', 499.99, 'A high-resolution camera for capturing your most memorable moments.', 2, 25, 'Y'),
  ('Speaker', 149.99, 'A portable speaker that delivers rich and immersive sound.', 4, 40, 'Y'),
  ('Dress', 69.99, 'An elegant dress for special occasions and formal events.', 2, 60, 'Y'),
  ('Suit', 199.99, 'A well-tailored suit that exudes sophistication and style.', 1, 30, 'Y'),
  ('Running Shoes', 89.99, 'Lightweight and supportive running shoes for optimal performance.', 4, 0, 'N'),
  ('Guitar', 299.99, 'A versatile guitar that produces rich and vibrant tones.', 5, 15, 'Y'),
  ('Hiking Boots', 119.99, 'Sturdy and comfortable hiking boots for outdoor adventures.', 1, 25, 'Y'),
  ('Perfume', 59.99, 'A captivating fragrance that leaves a lasting impression.', 3, 50, 'Y'),
  ('Cosmetic Set', 79.99, 'A collection of high-quality cosmetics for a complete makeup look.', 4, 40, 'Y'),
  ('Sports Bag', 29.99, 'A spacious sports bag to carry your gear in style.', 4, 0, 'N'),
  ('Wristwatch', 149.99, 'A classic wristwatch that adds a touch of elegance to any outfit.', 3, 20, 'Y'),
  ('Sunglasses', 39.99, 'Stylish sunglasses that provide UV protection and a fashionable look.', 3, 60, 'Y'),
  ('Wallet', 49.99, 'A sleek and functional wallet to keep your essentials organized.', 2, 35, 'Y'),
  ('Fitness Tracker', 79.99, 'A wearable device that monitors your fitness and tracks your progress.', 3, 45, 'Y'),
  ('Yoga Mat', 24.99, 'A comfortable and non-slip yoga mat for your workout sessions.', 5, 50, 'Y'),
  ('Cookware Set', 199.99, 'A comprehensive set of high-quality cookware for your kitchen.', 5, 10, 'Y'),
  ('Vacuum Cleaner', 149.99, 'A powerful vacuum cleaner that makes cleaning effortless.', 2, 20, 'Y'),
  ('Tennis Racket', 79.99, 'A lightweight and durable tennis racket for improved performance.', 1, 30, 'Y'),
  ('Dumbbell Set', 99.99, 'A set of adjustable dumbbells for strength training at home.', 3, 15, 'Y'),
  ('Smart TV', 799.99, 'A smart TV with a high-resolution display and built-in streaming services.', 2, 0, 'N'),
  ('Digital Camera', 599.99, 'An advanced digital camera with professional-level features.', 4, 10, 'Y'),
  ('Hair Dryer', 49.99, 'A high-performance hair dryer for fast and efficient drying.', 1, 30, 'Y');
  
  CREATE TABLE IF NOT EXISTS suppliers (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL
);

-- Добавление 5 записей в таблицу suppliers
INSERT INTO suppliers (name, email, phone)
VALUES
  ('ABC Distributors', 'abc.distributors@example.com', '+1 (123) 456-7890'),
  ('Global Imports', 'global.imports@example.com', '+1 (987) 654-3210'),
  ('Quality Goods Co.', 'quality.goods@example.com', '+1 (456) 789-0123'),
  ('Preferred Supplies', 'preferred.supplies@example.com', '+1 (012) 345-6789'),
  ('Elite Trading', 'elite.trading@example.com', '+1 (876) 543-2109');
  
  
  select t1.first_name,
	t1.last_name,
	case
    when t1.loyalty_program_id is null
    then 'программы лояльности нет'
    else t2.program_name
    end as program
  from customers t1
  left join loyalty_programs t2
  on t1.loyalty_program_id = t2.id;
  
SELECT 
    supplier_id, 
    COUNT(*) AS count
FROM
    products
GROUP BY supplier_id;

select t1.name,
		t2.count
from suppliers t1
inner join (SELECT 
    supplier_id, 
    COUNT(*) AS count
FROM
    products
GROUP BY supplier_id) t2
on t1.id = t2.supplier_id;

select t1.name as product_name,
		t2.name as supplier_name,
        t2.phone
from products t1
inner join suppliers t2
on t1.supplier_id = t2.id
where t1.in_stoke = 'N';