CREATE TABLE IF NOT EXISTS Prices (
     id          INTEGER AUTO_INCREMENT,
     brand_id    INTEGER NOT NULL,
     start_date  VARCHAR(19) NOT NULL,
     end_date    VARCHAR(19) NOT NULL,
     price_list  INTEGER NOT NULL,
     product_id  VARCHAR(5) NOT NULL,
     priority    INTEGER NOT NULL,
     price       DOUBLE NOT NULL,
     curr        VARCHAR(3) NOT NULL
);