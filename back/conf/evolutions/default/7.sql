-- tags

-- !Ups

CREATE TABLE field_tag
(
    id          bigint(20) NOT NULL AUTO_INCREMENT,
    field_uuid  varchar(36) NOT NULL,
    value       varchar(1000) NOT NULL,
    author      varchar(36) NOT NULL,
    `timestamp` timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    INDEX(field_uuid)
);

