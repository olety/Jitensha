-- Add photo column to product

# --- !Ups
ALTER TABLE Products
  ADD COLUMN Photo VARCHAR(2048) DEFAULT NULL;

# --- !Downs
ALTER TABLE Products
  DROP COLUMN Photo;
