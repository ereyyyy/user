CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    addresses_text TEXT,
    user_type VARCHAR(50) NOT NULL,
    password VARCHAR(255) NOT NULL
);

CREATE INDEX idx_users_email ON users(email);