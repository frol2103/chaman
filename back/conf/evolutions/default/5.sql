-- Field

-- !Ups


CREATE TABLE template_parent (
                          id bigint(20) NOT NULL AUTO_INCREMENT,
                          parent_reference varchar(255) NOT NULL,
                          child_reference varchar(255) NOT NULL,
                          `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          PRIMARY KEY (id)
);

CREATE TABLE template_parent_deleted (
                                 id bigint(20) NOT NULL AUTO_INCREMENT,
                                 fk_template_parent_id bigint(20) NOT NULL REFERENCES template_parent(id),
                                 `timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                                 PRIMARY KEY (id)
);
