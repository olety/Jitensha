-- Auto increment ids

# --- !Ups
CREATE SEQUENCE BasketIDSeq;

ALTER TABLE Baskets ALTER ID SET DEFAULT nextval('BasketIDSeq');

# --- !Downs
ALTER TABLE Baskets ALTER ID DROP DEFAULT;

DROP SEQUENCE BasketIDSeq;
