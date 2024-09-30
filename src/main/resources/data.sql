
INSERT INTO users (first_name, last_name, gender, email, phone, password, created_at, updated_at, created_by, updated_by, is_deleted)
VALUES
    ('Candis', 'Cammoile', 'F', 'ccammoile0@wiley.com', '272-670-6664', 'sA9_"\!8pZ#RqS', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE),
    ('Rice', 'Petegree', 'M', 'rpetegree1@wordpress.com', '872-885-6482', 'kK1`Q>`}&9a', NOW(), NOW(), 'ADMIN', 'ADMIN', TRUE),
    ('Raine', 'Sultan', 'F', 'rsultan2@vkontakte.ru', '563-183-7895', 'kW7%zA<U!L', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE),
    ('Dwight', 'Renbold', 'M', 'drenbold3@naver.com', '906-691-8242', 'nE0/Ax6R(', NOW(), NOW(), 'ADMIN', 'ADMIN', TRUE),
    ('Larisa', 'Walsh', 'F', 'lwalsh4@netvibes.com', '456-345-4479', 'yN9.8T4hDP5q#J', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE),
    ('Jillene', 'Pepperell', 'F', 'jpepperell5@china.com.cn', '424-324-6755', 'aE1{r!P6', NOW(), NOW(), 'ADMIN', 'ADMIN', TRUE),
    ('Tracee', 'McDermid', 'F', 'tmcdermid6@fotki.com', '745-122-5923', 'bB9.d&|8@T6', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE),
    ('Torey', 'Lambricht', 'F', 'tlambricht7@webnode.com', '322-931-2750', 'iR3_X(YwQgY', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE),
    ('Kat', 'Oxtaby', 'M', 'koxtaby8@slate.com', '138-471-6161', 'lW9{N$LZ{xgS7', NOW(), NOW(), 'ADMIN', 'ADMIN', TRUE),
    ('Nicoli', 'O''Collopy', 'M', 'nocollopy9@discuz.net', '213-600-7773', 'tL2?P"QYP}zB', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE);

INSERT INTO categories (category_name, created_at, updated_at, created_by, updated_by, is_deleted)
VALUES
    ('Fruits', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE),
    ('Vegetables', NOW(), NOW(), 'ADMIN', 'ADMIN', FALSE);
