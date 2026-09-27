CREATE TABLE IF NOT EXISTS products (
    product_id SERIAL PRIMARY KEY,
    product_code VARCHAR(20) UNIQUE NOT NULL,
    product_name VARCHAR(150) NOT NULL,
    category VARCHAR(50) NOT NULL,
    price NUMERIC(12, 2) NOT NULL,
    stock_quantity INT NOT NULL DEFAULT 0,
    status VARCHAR(30) NOT NULL
    );

INSERT INTO products (product_code, product_name, category, price, stock_quantity, status)
VALUES
    ('P001', 'Laptop Dell Inspiron', 'LAPTOP', 15000000, 3, 'ACTIVE'),
    ('P002', 'Laptop Asus Vivobook', 'LAPTOP', 18000000, 5, 'ACTIVE'),
    ('P003', 'Laptop Lenovo ThinkBook', 'LAPTOP', 20000000, 2, 'ACTIVE'),
    ('P004', 'Laptop HP Pavilion', 'LAPTOP', 17000000, 10, 'ACTIVE'),
    ('P005', 'Mouse Logitech', 'ACCESSORY', 500000, 0, 'DISCONTINUED'),
    ('P006', 'Keyboard Dell', 'ACCESSORY', 700000, 0, 'DISCONTINUED');

SELECT * FROM products ORDER BY product_id;