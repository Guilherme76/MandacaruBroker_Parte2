CREATE TABLE stock(
    id VARCHAR PRIMARY KEY,
    symbol VARCHAR NOT NULL,
    company_name VARCHAR NOT NULL,
    price FLOAT NOT NULL
);

CREATE TABLE users (
    id VARCHAR PRIMARY KEY,
    login VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    role VARCHAR NOT NULL
);
