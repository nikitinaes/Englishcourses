create table if not exists course
(
    id                 serial primary key,
    course_name        varchar(50) unique not null,
    course_description varchar (500) not null,
    course_price       numeric(6, 2) not null check (course_price > 0)
);

insert into course (course_name, course_description, course_price) values
                       (
        'General English', 'English for business people with basic knowledge of English', 2000
                       );

