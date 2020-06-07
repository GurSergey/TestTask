-- CREATE SCHEMA task;

CREATE TABLE task.department ( 
	id                   integer  NOT NULL ,
	date_create          date  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT pk_department_id PRIMARY KEY ( id )
 );

CREATE TABLE task.foreign_language ( 
	id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT pk_foreign_language_id PRIMARY KEY ( id )
 );

CREATE TABLE task.grade ( 
	id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT pk_grade_id PRIMARY KEY ( id )
 );

CREATE TABLE task."position" ( 
	id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT unq_position_id UNIQUE ( id ) ,
	CONSTRAINT pk_position_id PRIMARY KEY ( id )
 );

CREATE TABLE task.proficiency_level ( 
	id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	id_language          integer  NOT NULL ,
	CONSTRAINT pk_proficiency_level_id PRIMARY KEY ( id )
 );

CREATE TABLE task.specialization ( 
	id                   integer  NOT NULL ,
	name                 varchar(100)  NOT NULL ,
	CONSTRAINT pk_specialization_id PRIMARY KEY ( id )
 );

CREATE TABLE task.type_education ( 
	id                   integer  NOT NULL ,
	title                varchar(100)  NOT NULL ,
	CONSTRAINT unq_type_education_id UNIQUE ( id ) ,
	CONSTRAINT pk_type_education_id PRIMARY KEY ( id )
 );

CREATE TABLE task.employee ( 
	id                   integer  NOT NULL ,
	family               varchar(60)  NOT NULL ,
	birthday             date  NOT NULL ,
	patronymic           varchar(60)   ,
	gender               integer  NOT NULL ,
	name                 varchar(60)  NOT NULL ,
	phone                varchar(11)  NOT NULL ,
	email                varchar(60)  NOT NULL ,
	employment_date      date  NOT NULL ,
	dismosal_date        date   ,
	salary               integer  NOT NULL ,
	head                 bool  NOT NULL ,
	line_manager         integer   ,
	id_department        integer  NOT NULL ,
	CONSTRAINT pk_employe_id PRIMARY KEY ( id )
 );

CREATE TABLE task.employee_to_proficiency_level ( 
	id                   integer  NOT NULL ,
	id_employee          integer  NOT NULL ,
	id_level             integer  NOT NULL ,
	CONSTRAINT pk_employee_to_proficiency_level_id PRIMARY KEY ( id )
 );

CREATE TABLE task.project ( 
	id                   integer  NOT NULL ,
	id_manager           integer  NOT NULL ,
	name_project         varchar(100)  NOT NULL ,
	CONSTRAINT pk_poject_id PRIMARY KEY ( id )
 );

CREATE TABLE task."role" ( 
	id                   integer  NOT NULL ,
	employee_id          integer  NOT NULL UNIQUE ,
	id_grade             integer  NOT NULL ,
	id_position          integer  NOT NULL ,
	id_specialization    integer  NOT NULL ,
	CONSTRAINT pk_role_id PRIMARY KEY ( id )
 );

CREATE TABLE task.work_experience ( 
	id                   integer  NOT NULL ,
	id_employee          integer  NOT NULL ,
	data_reciept         date  NOT NULL ,
	date_dismossal       date   ,
	name_of_company      varchar(100)  NOT NULL ,
	name_position        varchar(100)  NOT NULL ,
	CONSTRAINT pk_work_experience_id PRIMARY KEY ( id )
 );

CREATE TABLE task.work_experience_in_company ( 
	id                   integer  NOT NULL ,
	date_start           date  NOT NULL ,
	date_end             date   ,
	id_project           integer  NOT NULL ,
	id_employee          integer  NOT NULL ,
	"role"               integer  NOT NULL ,
	CONSTRAINT pk_work_experience_in_company_id PRIMARY KEY ( id )
 );

CREATE TABLE task.education ( 
	id                   integer  NOT NULL ,
	id_employee          integer  NOT NULL ,
	path_img             varchar(100)   ,
	type_education       integer  NOT NULL ,
	title                varchar(100)  NOT NULL ,
	CONSTRAINT pk_education_id PRIMARY KEY ( id )
 );

ALTER TABLE task.education ADD CONSTRAINT fk_education_employee FOREIGN KEY ( id_employee ) REFERENCES task.employee( id );

ALTER TABLE task.education ADD CONSTRAINT fk_education_type_education FOREIGN KEY ( type_education ) REFERENCES task.type_education( id );

ALTER TABLE task.employee ADD CONSTRAINT fk_employee_department FOREIGN KEY ( id_department ) REFERENCES task.department( id );

-- ALTER TABLE task.employee ADD CONSTRAINT fk_employee_position FOREIGN KEY ( position_employee ) REFERENCES task."position"( id );

ALTER TABLE task.employee ADD CONSTRAINT fk_employee_employee FOREIGN KEY ( line_manager ) REFERENCES task.employee( id );

ALTER TABLE task.employee_to_proficiency_level ADD CONSTRAINT fk_employee_to_proficiency_level_employee FOREIGN KEY ( id_employee ) REFERENCES task.employee( id );

ALTER TABLE task.employee_to_proficiency_level ADD CONSTRAINT fk_employee_to_proficiency_level_proficiency_level FOREIGN KEY ( id_level ) REFERENCES task.proficiency_level( id );

ALTER TABLE task.proficiency_level ADD CONSTRAINT fk_proficiency_level_foreign_language FOREIGN KEY ( id_language ) REFERENCES task.foreign_language( id );

ALTER TABLE task.project ADD CONSTRAINT fk_poject_employee FOREIGN KEY ( id_manager ) REFERENCES task.employee( id );

ALTER TABLE task."role" ADD CONSTRAINT fk_role_grade FOREIGN KEY ( id_grade ) REFERENCES task.grade( id );

ALTER TABLE task."role" ADD CONSTRAINT fk_role_position FOREIGN KEY ( id_position ) REFERENCES task."position"( id );

ALTER TABLE task."role" ADD CONSTRAINT fk_role_specialization FOREIGN KEY ( id_specialization ) REFERENCES task.specialization( id );

ALTER TABLE task.work_experience ADD CONSTRAINT fk_work_experience_employee FOREIGN KEY ( id_employee ) REFERENCES task.employee( id );

ALTER TABLE task.work_experience_in_company ADD CONSTRAINT fk_work_experience_in_company_poject FOREIGN KEY ( id_project ) REFERENCES task.project( id );

ALTER TABLE task.work_experience_in_company ADD CONSTRAINT fk_work_experience_in_company_employee FOREIGN KEY ( id_employee ) REFERENCES task.employee( id );

ALTER TABLE task.work_experience_in_company ADD CONSTRAINT fk_work_experience_in_company_role FOREIGN KEY ( "role" ) REFERENCES task."role"( id );


CREATE SEQUENCE task.department_id_seq MINVALUE 10
CREATE SEQUENCE task.foreign_language_id_seq MINVALUE 10
CREATE SEQUENCE task.grade_id_seq MINVALUE 10
CREATE SEQUENCE task.proficiency_level_id_seq MINVALUE 10
CREATE SEQUENCE task.specialization_id_seq MINVALUE 10
CREATE SEQUENCE task.type_education_id_seq MINVALUE 10
CREATE SEQUENCE task.employee_id_seq MINVALUE 10
CREATE SEQUENCE task.employee_to_proficiency_level_id_seq MINVALUE 10
CREATE SEQUENCE task.project_id_seq MINVALUE 10
CREATE SEQUENCE task.role_id_seq MINVALUE 10
CREATE SEQUENCE task.work_experience_id_seq MINVALUE 10
CREATE SEQUENCE task.work_experience_in_company_id_seq MINVALUE 10
CREATE SEQUENCE task.work_experience_in_company_id_seq MINVALUE 10
ALTER TABLE task.department ALTER id SET DEFAULT nextval('department_id_seq')
ALTER TABLE task.foreign_language ALTER id SET DEFAULT nextval('foreign_language_id_seq')
ALTER TABLE task.grade ALTER id SET DEFAULT nextval('grade_id_seq')
ALTER TABLE task.employee ALTER id SET DEFAULT nextval('task.employee_id_seq')

CREATE EXTENSION pg_trgm;
CREATE INDEX trgm_idx_employee_family ON task.employee USING gin (family gin_trgm_ops);