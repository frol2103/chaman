-- Field

-- !Ups

CREATE TABLE field_data (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      field_uuid varchar(36) NOT NULL,
                      reference_uuid varchar(36) NOT NULL,
                      value text NULL,
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)
);

CREATE TABLE template (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       uuid varchar(36)NOT NULL,
                       reference varchar(255) NOT NULL,
                       label varchar(255) NOT NULL,
                       `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (id)
);


