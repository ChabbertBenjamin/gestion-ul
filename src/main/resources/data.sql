INSERT INTO student (id, firstname, lastname) VALUES
      ('1','test','toto'),
      ('2','test','tata'),
      ('3','test','titi');

INSERT INTO course (id, name, capacity) VALUES
    ('1','math',20),
    ('2','histoire',30),
    ('3','anglais',25);

INSERT INTO render (id, file, dead_line, student_id, course_id) VALUES
    ('1','file1','13-06-2022','1','1'),
    ('2','file2','10-05-2022','1','2'),
    ('3','file3','02-03-2022','2','3');