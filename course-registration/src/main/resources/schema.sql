CREATE TABLE if not exists teacher (
                          id BIGSERIAL PRIMARY KEY,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          email VARCHAR(255),
                          phone_number VARCHAR(255),
                          isClosedForNewStudents BOOLEAN
);

CREATE TABLE if not exists student (
                          id BIGSERIAL PRIMARY KEY,
                          firstName VARCHAR(255),
                          lastName VARCHAR(255),
                          email VARCHAR(255),
                          phoneNumber VARCHAR(255),
                          age INT NOT NULL

);

CREATE TABLE if not exists course_registration (
                                      id BIGSERIAL PRIMARY KEY,
                                      course_id BIGINT,
                                      student_id BIGINT REFERENCES student(id),
                                      teacher_id BIGINT REFERENCES teacher(id),
                                      registered_at TIMESTAMP
);
 CREATE TABLE if not exists lesson (
                            id BIGSERIAL PRIMARY KEY,
                            startTime timestamp,
                            endTime timestamp,
                            isAvailable BOOLEAN,
                            teacher_id serial references Teacher (id)
);
CREATE TABLE IF NOT EXISTS StudentLesson (
                               id BIGSERIAL PRIMARY KEY,
                               startTime TIMESTAMP,
                               endTime TIMESTAMP,
                               isReserved BOOLEAN,
                               student_id SERIAL REFERENCES Student(id)
)