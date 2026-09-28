CREATE TABLE IF NOT EXISTS product (
                                       product_id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
                                       product_name VARCHAR(100) NOT NULL UNIQUE,
    product_price DOUBLE PRECISION NOT NULL CHECK (product_price > 0),
    product_title VARCHAR(200) NOT NULL,
    product_created DATE NOT NULL,
    product_catalog VARCHAR(100) NOT NULL,
    product_status BOOLEAN DEFAULT TRUE
    );

CREATE OR REPLACE PROCEDURE get_all_products(INOUT p_cursor REFCURSOR)
LANGUAGE plpgsql
AS $$
BEGIN
OPEN p_cursor FOR
SELECT *
FROM product
ORDER BY product_id;
END;
$$;

CREATE OR REPLACE PROCEDURE check_catalog_exists(
    IN p_catalog VARCHAR,
    INOUT p_exists BOOLEAN
)
LANGUAGE plpgsql
AS $$
BEGIN
SELECT EXISTS(
    SELECT 1
    FROM product
    WHERE LOWER(product_catalog) = LOWER(p_catalog)
)
INTO p_exists;
END;
$$;

CREATE OR REPLACE PROCEDURE add_product(
    IN p_name VARCHAR,
    IN p_price DOUBLE PRECISION,
    IN p_title VARCHAR,
    IN p_created DATE,
    IN p_catalog VARCHAR,
    IN p_status BOOLEAN
)
LANGUAGE plpgsql
AS $$
BEGIN
INSERT INTO product (
    product_name,
    product_price,
    product_title,
    product_created,
    product_catalog,
    product_status
)
VALUES (
           p_name,
           p_price,
           p_title,
           p_created,
           p_catalog,
           p_status
       );
END;
$$;

CREATE OR REPLACE PROCEDURE update_product(
    IN p_id INT,
    IN p_name VARCHAR,
    IN p_price DOUBLE PRECISION,
    IN p_title VARCHAR,
    IN p_created DATE,
    IN p_catalog VARCHAR,
    IN p_status BOOLEAN
)
LANGUAGE plpgsql
AS $$
BEGIN
UPDATE product
SET product_name = p_name,
    product_price = p_price,
    product_title = p_title,
    product_created = p_created,
    product_catalog = p_catalog,
    product_status = p_status
WHERE product_id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE delete_product(IN p_id INT)
LANGUAGE plpgsql
AS $$
BEGIN
DELETE FROM product
WHERE product_id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE get_product_by_id(
    IN p_id INT,
    INOUT p_cursor REFCURSOR
)
LANGUAGE plpgsql
AS $$
BEGIN
OPEN p_cursor FOR
SELECT *
FROM product
WHERE product_id = p_id;
END;
$$;

CREATE OR REPLACE PROCEDURE search_product_by_name(
    IN p_name VARCHAR,
    INOUT p_cursor REFCURSOR
)
LANGUAGE plpgsql
AS $$
BEGIN
OPEN p_cursor FOR
SELECT *
FROM product
WHERE LOWER(product_name) LIKE '%' || LOWER(p_name) || '%'
ORDER BY product_id;
END;
$$;

CREATE OR REPLACE PROCEDURE statistic_product_by_catalog(
    INOUT p_cursor REFCURSOR
)
LANGUAGE plpgsql
AS $$
BEGIN
OPEN p_cursor FOR
SELECT product_catalog, COUNT(*) AS total
FROM product
GROUP BY product_catalog
ORDER BY total DESC;
END;
$$;

INSERT INTO product (
    product_name,
    product_price,
    product_title,
    product_created,
    product_catalog,
    product_status
)
VALUES
    ('Laptop Dell', 15000000, 'Laptop Dell Inspiron', CURRENT_DATE, 'Laptop', TRUE),
    ('iPhone 16', 22000000, 'Apple iPhone 16', CURRENT_DATE, 'Phone', TRUE),
    ('Samsung S25', 19000000, 'Samsung Galaxy S25', CURRENT_DATE, 'Phone', TRUE),
    ('Asus Vivobook', 18000000, 'Laptop Asus Vivobook', CURRENT_DATE, 'Laptop', TRUE),
    ('Logitech G304', 750000, 'Chuột Logitech G304', CURRENT_DATE, 'Accessory', TRUE)
    ON CONFLICT (product_name) DO NOTHING;

SELECT * FROM product ORDER BY product_id;