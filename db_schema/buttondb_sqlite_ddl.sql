CREATE TABLE product (
    id           INTEGER PRIMARY KEY AUTOINCREMENT
                         NOT NULL
                         UNIQUE,
    name TEXT    NOT NULL
);

CREATE TABLE product_list (
    id   INTEGER PRIMARY KEY AUTOINCREMENT
                 NOT NULL,
    name TEXT    NOT NULL
);

CREATE TABLE product_property (
    id              INTEGER PRIMARY KEY AUTOINCREMENT
                            NOT NULL
                            UNIQUE,
    product_id      INTEGER NOT NULL
                            REFERENCES product (id),
    product_list_id INTEGER NOT NULL
                            REFERENCES product_list (id),
	quantity		FLOAT NOT NULL,
    units           INTEGER NOT NULL,
    state           BOOLEAN NOT NULL
					DEFAULT (false),
    FOREIGN KEY (
        product_list_id
    )
    REFERENCES product_list (id),
    FOREIGN KEY (
        product_id
    )
    REFERENCES product (id) 
);

CREATE TABLE users (
    id       INTEGER      PRIMARY KEY AUTOINCREMENT
                          UNIQUE
                          NOT NULL,
    login    VARCHAR (20) UNIQUE
                          NOT NULL,
    name     VARCHAR (20),
    surname  VARCHAR (20),
    disabled BOOLEAN      NOT NULL
                          DEFAULT (false) 
);

CREATE TABLE users_product_list (
    product_list_id INTEGER NOT NULL
                            REFERENCES product_list (id),
    user_id         INTEGER REFERENCES users (id) 
                            NOT NULL,
    PRIMARY KEY (
        product_list_id,
        user_id
    )
);