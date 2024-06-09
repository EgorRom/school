--1. Получить всех студентов, возраст которых находится между 10 и 20 (можно подставить любые числа, главное, чтобы нижняя граница была меньше верхней).
select *from students where age between 19 and 20
--2. Получить всех студентов, но отобразить только список их имен.
select name from students
--3. Получить всех студентов, у которых в имени присутствует буква «О» (или любая другая).
select * from students where name like '%о%'
--4. Получить всех студентов, у которых возраст меньше идентификатора.
select * from students where age < id
--5. Получить всех студентов упорядоченных по возрасту.
select * from students order by "age"
SELECT COUNT(id) FROM students
SELECT AVG(age) FROM students
select * from students order by id desc limit 5
