USE bdd_sm_student;

CREATE TABLE IF NOT EXISTS student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL
);

INSERT INTO student (name, surname, birth_date) VALUES
('Jon', 'Doe', '2010-05-12'),
('Anna', 'Smith', '2009-11-03'),
('Liam', 'Johnson', '2011-08-25'),
('Emma', 'Brown', '2010-02-14'),
('Noah', 'Jones', '2009-07-30'),
('Olivia', 'Garcia', '2011-09-09'),
('William', 'Martinez', '2010-04-22'),
('Ava', 'Rodriguez', '2009-10-19'),
('James', 'Hernandez', '2011-03-07'),
('Sophia', 'Lopez', '2010-01-01'),
('Benjamin', 'Gonzalez', '2011-12-16'),
('Isabella', 'Wilson', '2009-06-28'),
('Lucas', 'Anderson', '2010-07-11'),
('Mia', 'Thomas', '2011-04-06'),
('Henry', 'Taylor', '2009-09-17'),
('Charlotte', 'Moore', '2010-08-21'),
('Alexander', 'Jackson', '2011-05-13'),
('Amelia', 'Martin', '2010-02-24'),
('Michael', 'Lee', '2009-11-10'),
('Harper', 'Perez', '2011-03-31');
