-- Annex

-- !Ups

CREATE TABLE annex (
                       id bigint(20) NOT NULL AUTO_INCREMENT,
                       uuid varchar(36) NOT NULL,
                       item_uuid varchar(36) NOT NULL,
                       fileSha varchar(40) NOT NULL,
                       name varchar(255) NOT NULL,
                       mimeType varchar(255) NOT NULL,
                       author varchar(36) NOT NULL,
                       `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                       PRIMARY KEY (id)
);

create table annex_removed (
                               fk_annex_id bigint(20) NOT NULL REFERENCES field(id),
                               author varchar(36) NOT NULL,
                               `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                               PRIMARY KEY (fk_annex_id)
);

