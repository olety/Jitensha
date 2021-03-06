-- Make all varchars huge

# --- !Ups
ALTER TABLE Categories ALTER COLUMN Name TYPE VARCHAR(2048);

ALTER TABLE Subcategories ALTER COLUMN Name TYPE VARCHAR(2048);

ALTER TABLE Products ALTER COLUMN Name TYPE VARCHAR(2048);
ALTER TABLE Products ALTER COLUMN SizeUnit TYPE VARCHAR(2048);
ALTER TABLE Products ALTER COLUMN Color TYPE VARCHAR(2048);
ALTER TABLE Products ALTER COLUMN Material TYPE VARCHAR(2048);
ALTER TABLE Products ALTER COLUMN Manufacturer TYPE VARCHAR(2048);

ALTER TABLE Users ALTER COLUMN Email TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN PasswordHash TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN FirstName TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN LastName TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN Address TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN Apartment TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN City TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN PostCode TYPE VARCHAR(2048);
ALTER TABLE Users ALTER COLUMN Country TYPE VARCHAR(2048);

# --- !Downs
ALTER TABLE Categories ALTER COLUMN Name TYPE VARCHAR(45);

ALTER TABLE Subcategories ALTER COLUMN Name TYPE VARCHAR(45);

ALTER TABLE Products ALTER COLUMN Name TYPE VARCHAR(45);
ALTER TABLE Products ALTER COLUMN SizeUnit TYPE VARCHAR(10);
ALTER TABLE Products ALTER COLUMN Color TYPE VARCHAR(45);
ALTER TABLE Products ALTER COLUMN Material TYPE VARCHAR(45);
ALTER TABLE Products ALTER COLUMN Manufacturer TYPE VARCHAR(45);

ALTER TABLE Users ALTER COLUMN Email TYPE VARCHAR(254);
ALTER TABLE Users ALTER COLUMN PasswordHash TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN FirstName TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN LastName TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN Address TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN Apartment TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN City TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN PostCode TYPE VARCHAR(45);
ALTER TABLE Users ALTER COLUMN Country TYPE VARCHAR(45);
