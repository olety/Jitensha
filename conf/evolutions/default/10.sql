-- Add unique key to Baskets

# --- !Ups
DROP TABLE Baskets;
CREATE TABLE Baskets (
  ID        SERIAL PRIMARY KEY,
  UserID    INT NOT NULL,
  ProductID INT NOT NULL
);

# --- !Downs
DROP TABLE Baskets;
CREATE TABLE Baskets (
  ID        SERIAL PRIMARY KEY,
  UserID    INT NOT NULL,
  ProductID INT NOT NULL
);