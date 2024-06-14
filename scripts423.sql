select students.name, faculties.name
from students
left outer join faculties on students.faculty_id = faculties."id";

select students.name , students.age
from students
inner join avatars on students."id" = avatars.student_id;


