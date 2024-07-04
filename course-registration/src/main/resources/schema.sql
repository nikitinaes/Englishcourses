CREATE TABLE if not exists teachers (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          email VARCHAR(255),
                          phone_number VARCHAR(255)
);

CREATE TABLE if not exists students (
                          id SERIAL PRIMARY KEY,
                          first_name VARCHAR(255),
                          last_name VARCHAR(255),
                          email VARCHAR(255),
                          phone_number VARCHAR(255)
);

CREATE TABLE course_registrations (
                                      id SERIAL PRIMARY KEY,
                                      course_id BIGINT,
                                      student_id BIGINT REFERENCES students(id),
                                      teacher_id BIGINT REFERENCES teachers(id),
                                      registered_at TIMESTAMP
);