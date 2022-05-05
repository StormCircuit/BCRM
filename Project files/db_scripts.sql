-- Table: public.users

-- DROP TABLE public.users;

CREATE TABLE public.users
(
  id serial NOT NULL,
  username character varying NOT NULL,
  password character varying NOT NULL,
  dob date,
  CONSTRAINT users_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.users
  OWNER TO postgres;

-- Table: public.student

-- DROP TABLE public.student;

CREATE TABLE public.student
(
  id serial NOT NULL,
  first_name character varying,
  last_name character varying,
  email character varying,
  CONSTRAINT student_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.student
  OWNER TO postgres;

-- Table: public.instructor_detail

-- DROP TABLE public.instructor_detail;

CREATE TABLE public.instructor_detail
(
  id serial NOT NULL,
  youtube_channel character varying(128) DEFAULT NULL::character varying,
  hobby character varying(45) DEFAULT NULL::character varying,
  CONSTRAINT instructor_detail_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.instructor_detail
  OWNER TO postgres;

-- Table: public.instructor

-- DROP TABLE public.instructor;

CREATE TABLE public.instructor
(
  id serial NOT NULL,
  first_name character varying(45) DEFAULT NULL::character varying,
  last_name character varying(45) DEFAULT NULL::character varying,
  email character varying(45) DEFAULT NULL::character varying,
  instructor_detail_id integer,
  CONSTRAINT instructor_pkey PRIMARY KEY (id),
  CONSTRAINT instructor_instructor_detail_id_fkey FOREIGN KEY (instructor_detail_id)
      REFERENCES public.instructor_detail (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.instructor
  OWNER TO postgres;

-- Index: public.instructor_instructor_detail_id_idx

-- DROP INDEX public.instructor_instructor_detail_id_idx;

CREATE UNIQUE INDEX instructor_instructor_detail_id_idx
  ON public.instructor
  USING btree
  (instructor_detail_id);


-- Table: public.course

-- DROP TABLE public.course;  

CREATE TABLE public.course
(
  id serial NOT NULL,
  title character varying,
  instructor_id integer,
  CONSTRAINT course_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.course
  OWNER TO postgres;


-- Table: public.course_student

-- DROP TABLE public.course_student;

CREATE TABLE public.course_student
(
  course_id integer NOT NULL,
  student_id integer NOT NULL,
  CONSTRAINT course_student_pkey PRIMARY KEY (course_id, student_id),
  CONSTRAINT course_student_course_id_fkey FOREIGN KEY (course_id)
      REFERENCES public.course (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT course_student_student_id_fkey FOREIGN KEY (student_id)
      REFERENCES public.student (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.course_student
  OWNER TO postgres;
