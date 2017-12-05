-- Add user

# --- !Ups
CREATE TABLE Users (
  UserID       INT          NOT NULL,
  Email        VARCHAR(254) NOT NULL,
  PasswordHash VARCHAR(45)  NOT NULL,
  FirstName    VARCHAR(45) DEFAULT NULL,
  LastName     VARCHAR(45) DEFAULT NULL,
  Address      VARCHAR(45) DEFAULT NULL,
  Apartment    VARCHAR(45) DEFAULT NULL,
  City         VARCHAR(45) DEFAULT NULL,
  PostCode     VARCHAR(45) DEFAULT NULL,
  Country      VARCHAR(45) DEFAULT NULL,
  PRIMARY KEY (UserID)
);

# --- !Downs
DROP TABLE Users;
