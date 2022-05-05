-- Table: public.customer

DROP TABLE IF EXISTS public.customer;

CREATE TABLE IF NOT EXISTS public.customer
(
    bronco_id integer NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    dob date NOT NULL,
    phone character varying COLLATE pg_catalog."default" NOT NULL,
    address character varying COLLATE pg_catalog."default" NOT NULL,
    username character varying COLLATE pg_catalog."default",
    password character varying COLLATE pg_catalog."default",
    CONSTRAINT bronco_id PRIMARY KEY (bronco_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.customer
    OWNER to postgres;

-- Table: public.activity

DROP TABLE IF EXISTS public.activity;

CREATE TABLE IF NOT EXISTS public.activity
(
    activity_id integer NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    price double precision NOT NULL,
    CONSTRAINT activity_pk PRIMARY KEY (activity_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.activity
    OWNER to postgres;

-- Table: public.contains

DROP TABLE IF EXISTS public.contains;

CREATE TABLE IF NOT EXISTS public.contains
(
    activity_id integer NOT NULL,
    order_id integer NOT NULL,
    CONSTRAINT contains_pk PRIMARY KEY (activity_id, order_id),
    CONSTRAINT activity_creates_fk FOREIGN KEY (activity_id)
        REFERENCES public.activity (activity_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT order_creates_fk FOREIGN KEY (order_id)
        REFERENCES public."order" (order_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contains
    OWNER to postgres;

-- Table: public.order

DROP TABLE IF EXISTS public."order";

CREATE TABLE IF NOT EXISTS public."order"
(
    order_id integer NOT NULL,
    date date NOT NULL,
    "time" time without time zone NOT NULL,
    total_price double precision NOT NULL,
    bronco_id integer NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (order_id),
    CONSTRAINT customer_order_fk FOREIGN KEY (bronco_id)
        REFERENCES public.customer (bronco_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."order"
    OWNER to postgres;

COMMENT ON COLUMN public."order".total_price
    IS 'attribute is dynamically calculated';

-- Table: public.professor

DROP TABLE IF EXISTS public.professor;

CREATE TABLE IF NOT EXISTS public.professor
(
    professor_id integer NOT NULL DEFAULT nextval('professor_professor_id_seq'::regclass),
    bronco_id integer NOT NULL,
    department character varying COLLATE pg_catalog."default" NOT NULL,
    office character varying COLLATE pg_catalog."default" NOT NULL,
    research character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT professor_pk PRIMARY KEY (professor_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.professor
    OWNER to postgres;

-- Table: public.student

DROP TABLE IF EXISTS public.student;

CREATE TABLE IF NOT EXISTS public.student
(
    student_id integer NOT NULL DEFAULT nextval('student_student_id_seq'::regclass),
    bronco_id integer NOT NULL,
    enter_date date NOT NULL,
    grad_date date NOT NULL,
    major character varying COLLATE pg_catalog."default" NOT NULL,
    minor character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT student_pk PRIMARY KEY (student_id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.student
    OWNER to postgres;