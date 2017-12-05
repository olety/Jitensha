-- Initial version

# --- !Ups
CREATE TABLE Categories (
  CategoryID INT NOT NULL,
  Name       VARCHAR(45) NOT NULL,
  PRIMARY KEY (CategoryID)
);

CREATE TABLE Subcategories (
  SubcategoryID INT NOT NULL,
  CategoryID    INT NOT NULL,
  Name          VARCHAR(45) NOT NULL,
  PRIMARY KEY (SubcategoryID),
  CONSTRAINT fk_Subcategories_Categories1 FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE Products (
  ProductID     INT         NOT NULL,
  SubcategoryID INT         NOT NULL,
  Name          VARCHAR(45) NOT NULL,
  Size          DECIMAL(16, 8) DEFAULT NULL,
  SizeUnit      VARCHAR(10)    DEFAULT NULL,
  Weight        DECIMAL(16, 8) DEFAULT NULL,
  Cost          DECIMAL(16, 8) DEFAULT NULL,
  Price         DECIMAL(16, 8) DEFAULT NULL,
  Stock         INT            DEFAULT NULL,
  Color         VARCHAR(45)    DEFAULT NULL,
  Material      VARCHAR(45)    DEFAULT NULL,
  Manufacturer  VARCHAR(45)    DEFAULT NULL,
  PRIMARY KEY (ProductID),
  CONSTRAINT fk_Products_Subcategories FOREIGN KEY (SubcategoryID) REFERENCES Subcategories (SubcategoryID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

CREATE TABLE Compatibility (
  BikeProductID      INT NOT NULL,
  ComponentProductID INT NOT NULL,
  PRIMARY KEY (BikeProductID, ComponentProductID),
  CONSTRAINT fk_Products_has_Products_Products1 FOREIGN KEY (BikeProductID) REFERENCES Products (ProductID) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT fk_Products_has_Products_Products2 FOREIGN KEY (ComponentProductID) REFERENCES Products (ProductID) ON DELETE NO ACTION ON UPDATE NO ACTION
);

# --- !Downs
DROP TABLE Compatibility;
DROP TABLE Products;
DROP TABLE Subcategories;
DROP TABLE Categories;
