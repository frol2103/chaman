-- Annex

-- !Ups

CREATE TABLE link (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       uuid varchar(36) NOT NULL,
                       item_uuid_1 varchar(36) NOT NULL,
                       item_uuid_2 varchar(36) NOT NULL,
                       author varchar(36) NOT NULL,
                       `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (id),
                       index(item_uuid_1, item_uuid_2)
);

create table link_removed (
                               fk_link_id bigint(20) NOT NULL REFERENCES field(id),
                               author varchar(36) NOT NULL,
                               `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               PRIMARY KEY (fk_link_id)
);

