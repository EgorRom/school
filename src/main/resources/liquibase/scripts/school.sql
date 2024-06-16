-- liquibase formatted sql

-- changeset eromantsov:1
create index student_name_index on students(name);
-- changeset eromantsov:2
create index faculty_color_index on faculties(color);

