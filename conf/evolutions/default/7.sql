-- Add Baskets table

# --- !Ups
CREATE TABLE Baskets (
  UserID    INT NOT NULL,
  ProductID INT NOT NULL,
  Quantity  INT,
  PRIMARY KEY (UserID, ProductID),
  CONSTRAINT fk_Baskets_Users FOREIGN KEY (UserID) REFERENCES Users (ID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Baskets_Products FOREIGN KEY (ProductID) REFERENCES Products (ID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

# --- !Downs
DROP TABLE Baskets;
