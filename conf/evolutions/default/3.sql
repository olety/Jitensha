-- Rename primary keys

# --- !Ups
-- Really stupid way to drop all constraints because you cannot tell what the foreign key constraint will be called
CREATE TABLE Compatibility_temp AS SELECT * FROM Compatibility;
CREATE TABLE Products_temp AS SELECT * FROM Products;
CREATE TABLE Subcategories_temp AS SELECT * FROM Subcategories;
CREATE TABLE Categories_temp AS SELECT * FROM Categories;
CREATE TABLE Users_temp AS SELECT * FROM Users;

DROP TABLE Compatibility;
DROP TABLE Products;
DROP TABLE Subcategories;
DROP TABLE Categories;
DROP TABLE Users;

CREATE TABLE Compatibility AS SELECT * FROM Compatibility_temp;
CREATE TABLE Products AS SELECT * FROM Products_temp;
CREATE TABLE Subcategories AS SELECT * FROM Subcategories_temp;
CREATE TABLE Categories AS SELECT * FROM Categories_temp;
CREATE TABLE Users AS SELECT * FROM Users_temp;

DROP TABLE Compatibility_temp;
DROP TABLE Products_temp;
DROP TABLE Subcategories_temp;
DROP TABLE Categories_temp;
DROP TABLE Users_temp;
-- End of "Really stupid way..."

ALTER TABLE Categories RENAME COLUMN CategoryID TO ID;
ALTER TABLE Subcategories RENAME COLUMN SubcategoryID TO ID;
ALTER TABLE Products RENAME COLUMN ProductID TO ID;
ALTER TABLE Users RENAME COLUMN UserID TO ID;

ALTER TABLE Subcategories ADD PRIMARY KEY (ID);
ALTER TABLE Categories ADD PRIMARY KEY (ID);
ALTER TABLE Products ADD PRIMARY KEY (ID);
ALTER TABLE Users ADD PRIMARY KEY (ID);

ALTER TABLE Products ADD CONSTRAINT fk_products_subcategories FOREIGN KEY (SubcategoryID) REFERENCES Subcategories(ID);
ALTER TABLE Subcategories ADD CONSTRAINT fk_subcategories_categories FOREIGN KEY (CategoryID) REFERENCES Categories(ID);
ALTER TABLE Compatibility ADD CONSTRAINT fk_products_has_products_products1 FOREIGN KEY (BikeProductID) REFERENCES Products(ID);
ALTER TABLE Compatibility ADD CONSTRAINT fk_products_has_products_products2 FOREIGN KEY (ComponentProductID) REFERENCES Products(ID);

# --- !Downs
-- Really stupid way to drop all constraints because you cannot tell what the foreign key constraint will be called
CREATE TABLE Compatibility_temp AS SELECT * FROM Compatibility;
CREATE TABLE Products_temp AS SELECT * FROM Products;
CREATE TABLE Subcategories_temp AS SELECT * FROM Subcategories;
CREATE TABLE Categories_temp AS SELECT * FROM Categories;
CREATE TABLE Users_temp AS SELECT * FROM Users;

DROP TABLE Compatibility;
DROP TABLE Products;
DROP TABLE Subcategories;
DROP TABLE Categories;
DROP TABLE Users;

CREATE TABLE Compatibility AS SELECT * FROM Compatibility_temp;
CREATE TABLE Products AS SELECT * FROM Products_temp;
CREATE TABLE Subcategories AS SELECT * FROM Subcategories_temp;
CREATE TABLE Categories AS SELECT * FROM Categories_temp;
CREATE TABLE Users AS SELECT * FROM Users_temp;

DROP TABLE Compatibility_temp;
DROP TABLE Products_temp;
DROP TABLE Subcategories_temp;
DROP TABLE Categories_temp;
DROP TABLE Users_temp;
-- End of "Really stupid way..."

ALTER TABLE Categories RENAME COLUMN ID TO CategoryID;
ALTER TABLE Subcategories RENAME COLUMN ID TO SubcategoryID;
ALTER TABLE Products RENAME COLUMN ID TO ProductID;
ALTER TABLE Users RENAME COLUMN ID TO UserID;

ALTER TABLE Subcategories ADD PRIMARY KEY (SubcategoryID);
ALTER TABLE Categories ADD PRIMARY KEY (CategoryID);
ALTER TABLE Products ADD PRIMARY KEY (ProductID);
ALTER TABLE Users ADD PRIMARY KEY (UserID);

ALTER TABLE Products ADD CONSTRAINT fk_products_subcategories FOREIGN KEY (SubcategoryID) REFERENCES Subcategories(CategoryID);
ALTER TABLE Subcategories ADD CONSTRAINT fk_subcategories_categories FOREIGN KEY (CategoryID) REFERENCES Categories(SubcategoryID);
ALTER TABLE Compatibility ADD CONSTRAINT fk_products_bike_product_products FOREIGN KEY (BikeProductID) REFERENCES Products(ProductID);
ALTER TABLE Compatibility ADD CONSTRAINT fk_products_compononet_product_products FOREIGN KEY (ComponentProductID) REFERENCES Products(ProductID);
