-- Field

-- !Ups

CREATE TABLE field_data (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      field_uuid varchar(36) NOT NULL,
                      owner_uuid varchar(36) NOT NULL,
                      value_uuid varchar(36) NOT NULL,
                      value text NULL,
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)
);

CREATE TABLE item (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       uuid varchar(36)NOT NULL,
                       title varchar(255) NOT NULL,
                       description varchar(100) NOT NULL,
                       `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (id)
);


