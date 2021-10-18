-- Field

-- !Ups

CREATE TABLE data (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      field_uuid varchar(36) NOT NULL,
                      owner_uuid varchar(36) NOT NULL,
                      value_uuid varchar(36) NOT NULL,
                      subreference_uuid varchar(36) NULL,
                      value text NULL,
                      author varchar(36) NOT NULL,
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id),
                      INDEX(owner_uuid)
);

CREATE TABLE item (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       uuid varchar(36)NOT NULL,
                       title varchar(255) NOT NULL,
                       description varchar(100) NOT NULL,
                       author varchar(36) NOT NULL,
                       `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (id),
                       INDEX(uuid)
);


