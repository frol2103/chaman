-- Field

-- !Ups

CREATE TABLE field_data_deleted (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      fk_field_data_id bigint(20) NOT NULL REFERENCES field_data(id),
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)
);

CREATE TABLE item_deleted (
                                  id bigint(20) NOT NULL AUTO_INCREMENT,
                                  fk_item_id bigint(20) NOT NULL REFERENCES item(id),
                                  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (id)
);

CREATE TABLE field_deleted (
                                  id bigint(20) NOT NULL AUTO_INCREMENT,
                                  fk_field_id bigint(20) NOT NULL REFERENCES field(id),
                                  `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                  PRIMARY KEY (id)
);
