CREATE TABLE if not exists orders (
    id serial,
    name VARCHAR(50),
    description VARCHAR(50),
    created timestamp,
    PRIMARY KEY (id)
);