CREATE TABLE tattoo(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    image VARCHAR(500) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE tattoo_scheduled_dates(
    tattoo_id INT NOT NULL,
    scheduled_date VARCHAR(10) NOT NULL,
    FOREIGN KEY (tattoo_id) REFERENCES tattoo(id)
);

