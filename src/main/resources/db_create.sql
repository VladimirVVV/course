-- DROP TABLE phone;
CREATE SEQUENCE auto_id_phones;
CREATE TABLE phone
(
  "id" INTEGER NOT NULL DEFAULT nextval('auto_id_phones'),
  "name" VARCHAR (255),
  "price" INTEGER
);
