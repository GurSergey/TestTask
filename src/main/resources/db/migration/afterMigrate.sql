INSERT INTO task.department VALUES (1, '2004-12-17', 'Департамент серверной разработки'),
(2, '2008-12-17', 'Департамент мобильной разработки'), 
(3, '2012-12-17', 'Депратмент фронтенда');

INSERT INTO task.foreign_language VALUES (1, 'Английский язык'),
(2, 'Китайский язык');

INSERT INTO task.grade VALUES (1, 'Intern'),
(2, 'Junior'),
(3, 'Middle'),
(4, 'Senior'),
(5, 'Lead');

INSERT INTO task."position" VALUES (1, 'Разработчик'),
(2, 'Аналитик'),
(3, 'Инженер качества ПО');

INSERT INTO task.proficiency_level VALUES (1, 'Elementary', 1),
(2, 'Intermediate', 1),
(3, 'Advance', 1),
(4, 'HSK-Level 1', 2),
(5, 'HSK-Level 2', 2),
(6, 'HSK-Level 3', 2);

INSERT INTO task.specialization VALUES (1, 'Android разработчик'),
(2, 'IOS разработчик'),
(3, 'Автоматизатор в тестировании Python'),
(4, 'Бизнес Аналитик'),
(5, 'Аналитик данных');

INSERT INTO task.type_education VALUES (1, 'Диплом о высшем образовании'),
(2, 'Курсы повышения квалификации'),
(3, 'Сертификаты о профессиональной подготовке');

INSERT INTO task.employee VALUES (1, 'Иванов','1980-12-17',  'Иванович', 1, 'Иван', '89170202020', 'test@mail.ru', '2007-12-17', null, 20000, false, 2, 1), 
(2, 'Сергеев','1989-12-17',  'Сергеевич', 1, 'Сергей', '89170202021', 'test1@mail.ru', '2008-12-17', null, 21000, true, null, 1),
(3, 'Михайлов','1990-12-17',  'Михайлович', 1, 'Михаил', '89170202026', 'test1@mail.ru', '2012-12-17', null, 22000, false, null, 2),
(4, 'Сидоров','1990-12-17',  'Сидорович', 1, 'Сидр', '89170202025', 'test2@mail.ru', '2012-12-17', null, 22000, false, null, 3),
(5, 'Manager','1990-12-17',  'Manager', 1, 'Manager', '89170202027', 'test3@mail.ru', '2014-12-17', null, 22000, false, null, 3);

INSERT INTO task.employee_to_proficiency_level VALUES (1, 1, 2),
(2, 1, 4),
(3, 2, 1),
(4, 3, 2),
(5, 4, 4);

INSERT INTO task.project VALUES (1, 5, 'Супер проект'),
(2, 5, 'Проект');

INSERT INTO task."role" VALUES (1, 1, 2, 1, 2),
(2, 2, 4, 1, 2),
(3, 3, 2, 2, 2),
(4, 4, 4, 2, 2);

INSERT INTO task.work_experience VALUES (1, 1, '2006-12-17', '2007-12-17', 'Рога и копыта', 'Уборщик');

INSERT INTO task.work_experience_in_company VALUES (1, '2007-12-17', '2008-12-17', 1, 1, 1),
(2, '2008-12-17', '2009-12-17', 2, 1, 1);

INSERT INTO task.education VALUES (1, 1, null, 1, 'Диплом инженера по вычислительной технике'),
(2, 1, null, 2, 'Диплом разработчика ...');
