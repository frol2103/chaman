-- Field

-- !Ups

CREATE TABLE data_deleted (
                      fk_field_data_id bigint(20) NOT NULL REFERENCES field_data(id),
                      author varchar(36) NOT NULL,
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (fk_field_data_id)
);

CREATE TABLE item_deleted (
                                  fk_item_id bigint(20) NOT NULL REFERENCES item(id),
                                  author varchar(36) NOT NULL,
                                  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (fk_item_id)
);

CREATE TABLE field_deleted (
                                  fk_field_id bigint(20) NOT NULL REFERENCES field(id),
                                  author varchar(36) NOT NULL,
                                  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (fk_field_id)
);
