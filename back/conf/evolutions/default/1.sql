-- User

-- !Ups

CREATE TABLE user (
                      id bigint(20) NOT NULL AUTO_INCREMENT,
                      uuid varchar(36)NOT NULL,
                      username varchar(255) NOT NULL,
                      openidconnectiss varchar(255) NOT NULL,
                      openidconnectsub varchar(255) NOT NULL,
                      `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      PRIMARY KEY (id)
);

