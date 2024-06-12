create table peoples(
id real primary key ,
age integer,
name_people text,
drivers_license boolean,
cars_id real references cars(id)
);
create table cars(
id real primary key ,
mark varchar(10),
model varchar(10),
price integer
);

