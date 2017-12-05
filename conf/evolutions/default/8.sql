-- Remove primary key constraint from Baskets table

# --- !Ups
ALTER TABLE Baskets
  DROP CONSTRAINT baskets_pkey;

# --- !Downs
ALTER TABLE Baskets
  ADD CONSTRAINT PRIMARY KEY (UserID, ProductID);
