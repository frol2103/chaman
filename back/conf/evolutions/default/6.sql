--

-- !Ups

CREATE TABLE item_thumbnail (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       item_uuid varchar(36) NOT NULL,
                       annex_uuid varchar (36) NOT NULL,
                       x integer not null,
                       y integer not null,
                       width integer not null,
                       author varchar(36) NOT NULL,
                       `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (id),
                       INDEX(item_uuid)
);


