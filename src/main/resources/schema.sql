CREATE TABLE if NOT EXISTS photos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    file_name VARCHAR(255),
    content_type VARCHAR(255),
    data BINARY
);
