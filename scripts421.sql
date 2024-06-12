ALTER table students
ADD CONSTRAINT age CHECK ( age > 17 ),
ADD CONSTRAINT name UNIQUE (name),
alter COLUMN name SET NOT NULL,
ADD CONSTRAINT age set DEFAULT 20;


