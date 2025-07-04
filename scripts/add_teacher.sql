USE bdd_sm_teacher;

CREATE TABLE IF NOT EXISTS teacher (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL
);

INSERT INTO teacher (name, surname, birth_date) VALUES
('Olivier', 'Vanlerberge', '1989-12-13'),
('Sophie', 'Lemoine', '1985-06-24'),
('Marc', 'Dupont', '1979-11-05'),
('Claire', 'Martin', '1982-03-17'),
('Julien', 'Moreau', '1990-01-30');