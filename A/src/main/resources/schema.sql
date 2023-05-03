
CREATE TABLE IF NOT EXISTS cars (
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                                     vin VARCHAR(17) NOT NULL,
                                     number VARCHAR(8) NOT NULL,
                                     creator VARCHAR(50),
                                     year_of_manufacture Integer,
                                     CONSTRAINT cars_pk PRIMARY KEY (id),
                                     CONSTRAINT VIN UNIQUE (VIN),
                                     CONSTRAINT  number UNIQUE ( number)
);

--DELETE FROM FILMS;
--ALTER TABLE FILMS ALTER COLUMN ID RESTART WITH 1;

CREATE TABLE IF NOT EXISTS details (
                                     id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
                                     serial_number Integer,
                                     type VARCHAR(50),
                                     CONSTRAINT user_pk PRIMARY KEY (id),
                                     CONSTRAINT serial_number UNIQUE (serial_number)
);
--
-- --DELETE FROM users;
-- --ALTER TABLE users ALTER COLUMN ID RESTART WITH 1;
--
--
--
--
CREATE TABLE IF NOT EXISTS cars_details (

    id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,

                                     CONSTRAINT rate_pk PRIMARY KEY (id),
                                     car_id bigint        not null
                                         references cars
                                             on delete cascade,

                                     detail_id   bigint        not null
                                         references details
                                             on delete cascade

);