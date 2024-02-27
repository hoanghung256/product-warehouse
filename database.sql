CREATE TABLE product (
	id INT NOT NULL IDENTITY,
	name NVARCHAR(20) NOT NULL,
	quantity int,
	price int,
	image nvarchar(500) DEFAULT 'https://th.bing.com/th/id/OIP.nvdM5sEm4DqG8oZb8nNStQHaHa?rs=1&pid=ImgDetMain',
	PRIMARY KEY(id)
)

INSERT INTO product (name, quantity, price)
VALUES 
    ('Iphone 13', 1500, 1100),
    ('Iphone 13 PRO', 1500, 1150),
    ('Iphone 8', 1500, 700),
    ('Iphone 8 Plus', 1500, 750),
    ('Iphone 11', 1500, 800),
    ('Iphone 12', 1500, 900),
    ('Iphone 11 Pro', 1500, 850),
    ('Iphone 14', 1500, 1700),
    ('Iphone 8', 1500, 500),
    ('Iphone X', 1500, 700),
    ('Iphone 7', 1500, 500),
    ('Iphone 13 Pro Max', 1500, 1200)
