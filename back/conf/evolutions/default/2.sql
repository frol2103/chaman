-- Field

-- !Ups

CREATE TABLE field (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      uuid varchar(36)NOT NULL,
                      reference varchar(255) NOT NULL,
                      datatype varchar(255) NOT NULL,
                      label varchar(255) NOT NULL,
                      author varchar(36) NOT NULL,
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      config TEXT NULL,
                      PRIMARY KEY (id),
                      INDEX(uuid)
);


