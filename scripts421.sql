ALTER TABLE student
ADD CONSTRAINT age_constraint CHECK ( age > 16 ),
ALTER COLUMN name SET NOT NULL,
ADD CONSTRAINT name_unique UNIQUE (name);



