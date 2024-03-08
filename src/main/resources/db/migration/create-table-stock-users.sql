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
    email VARCHAR(100) NOT NULL UNIQUE,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    birthDate DATE NOT NULL,
    balance FLOAT DEFAULT 0,
    role VARCHAR NOT NULL
);
