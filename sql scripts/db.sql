PGDMP         5                z           brcm    14.2    14.2 &    *           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            +           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ,           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            -           1262    16456    brcm    DATABASE     Y   CREATE DATABASE brcm WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.UTF-8';
    DROP DATABASE brcm;
                postgres    false            ?            1259    16501    activity    TABLE     ?   CREATE TABLE public.activity (
    activity_id integer NOT NULL,
    name character varying NOT NULL,
    price double precision NOT NULL
);
    DROP TABLE public.activity;
       public         heap    postgres    false            ?            1259    16513    contains    TABLE     b   CREATE TABLE public.contains (
    activity_id integer NOT NULL,
    order_id integer NOT NULL
);
    DROP TABLE public.contains;
       public         heap    postgres    false            ?            1259    16457    customer    TABLE       CREATE TABLE public.customer (
    bronco_id integer NOT NULL,
    name character varying NOT NULL,
    dob date NOT NULL,
    phone character varying NOT NULL,
    address character varying NOT NULL,
    username character varying,
    password character varying
);
    DROP TABLE public.customer;
       public         heap    postgres    false            ?            1259    16475    hibernate_sequence    SEQUENCE     {   CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.hibernate_sequence;
       public          postgres    false            ?            1259    16508    order    TABLE     ?   CREATE TABLE public."order" (
    order_id integer NOT NULL,
    date date NOT NULL,
    total_price double precision NOT NULL,
    status character varying,
    bronco_id integer
);
    DROP TABLE public."order";
       public         heap    postgres    false            .           0    0    COLUMN "order".total_price    COMMENT     W   COMMENT ON COLUMN public."order".total_price IS 'attribute is dynamically calculated';
          public          postgres    false    213            ?            1259    16640 	   professor    TABLE     ?   CREATE TABLE public.professor (
    professor_id integer NOT NULL,
    bronco_id integer NOT NULL,
    department character varying NOT NULL,
    office character varying NOT NULL,
    research character varying NOT NULL
);
    DROP TABLE public.professor;
       public         heap    postgres    false            ?            1259    16639    professor_professor_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.professor_professor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.professor_professor_id_seq;
       public          postgres    false    218            /           0    0    professor_professor_id_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE public.professor_professor_id_seq OWNED BY public.professor.professor_id;
          public          postgres    false    217            ?            1259    16468    staff    TABLE     ?   CREATE TABLE public.staff (
    staff_id integer NOT NULL,
    name character varying NOT NULL,
    role character varying NOT NULL
);
    DROP TABLE public.staff;
       public         heap    postgres    false            ?            1259    16596    student    TABLE     ?   CREATE TABLE public.student (
    student_id integer NOT NULL,
    bronco_id integer NOT NULL,
    enter_date date NOT NULL,
    grad_date date NOT NULL,
    major character varying NOT NULL,
    minor character varying NOT NULL
);
    DROP TABLE public.student;
       public         heap    postgres    false            ?            1259    16595    student_student_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.student_student_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.student_student_id_seq;
       public          postgres    false    216            0           0    0    student_student_id_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.student_student_id_seq OWNED BY public.student.student_id;
          public          postgres    false    215            ?           2604    16643    professor professor_id    DEFAULT     ?   ALTER TABLE ONLY public.professor ALTER COLUMN professor_id SET DEFAULT nextval('public.professor_professor_id_seq'::regclass);
 E   ALTER TABLE public.professor ALTER COLUMN professor_id DROP DEFAULT;
       public          postgres    false    217    218    218            ?           2604    16599    student student_id    DEFAULT     x   ALTER TABLE ONLY public.student ALTER COLUMN student_id SET DEFAULT nextval('public.student_student_id_seq'::regclass);
 A   ALTER TABLE public.student ALTER COLUMN student_id DROP DEFAULT;
       public          postgres    false    215    216    216            !          0    16501    activity 
   TABLE DATA           <   COPY public.activity (activity_id, name, price) FROM stdin;
    public          postgres    false    212   ?)       #          0    16513    contains 
   TABLE DATA           9   COPY public.contains (activity_id, order_id) FROM stdin;
    public          postgres    false    214   
*                 0    16457    customer 
   TABLE DATA           \   COPY public.customer (bronco_id, name, dob, phone, address, username, password) FROM stdin;
    public          postgres    false    209   Y*       "          0    16508    order 
   TABLE DATA           Q   COPY public."order" (order_id, date, total_price, status, bronco_id) FROM stdin;
    public          postgres    false    213   ?*       '          0    16640 	   professor 
   TABLE DATA           Z   COPY public.professor (professor_id, bronco_id, department, office, research) FROM stdin;
    public          postgres    false    218   :+                 0    16468    staff 
   TABLE DATA           5   COPY public.staff (staff_id, name, role) FROM stdin;
    public          postgres    false    210   ?+       %          0    16596    student 
   TABLE DATA           ]   COPY public.student (student_id, bronco_id, enter_date, grad_date, major, minor) FROM stdin;
    public          postgres    false    216   ?+       1           0    0    hibernate_sequence    SEQUENCE SET     A   SELECT pg_catalog.setval('public.hibernate_sequence', 53, true);
          public          postgres    false    211            2           0    0    professor_professor_id_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('public.professor_professor_id_seq', 1, false);
          public          postgres    false    217            3           0    0    student_student_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.student_student_id_seq', 1, false);
          public          postgres    false    215            ?           2606    16507    activity activity_pk 
   CONSTRAINT     [   ALTER TABLE ONLY public.activity
    ADD CONSTRAINT activity_pk PRIMARY KEY (activity_id);
 >   ALTER TABLE ONLY public.activity DROP CONSTRAINT activity_pk;
       public            postgres    false    212            ?           2606    16463    customer bronco_id 
   CONSTRAINT     W   ALTER TABLE ONLY public.customer
    ADD CONSTRAINT bronco_id PRIMARY KEY (bronco_id);
 <   ALTER TABLE ONLY public.customer DROP CONSTRAINT bronco_id;
       public            postgres    false    209            ?           2606    16517    contains contains_pk 
   CONSTRAINT     e   ALTER TABLE ONLY public.contains
    ADD CONSTRAINT contains_pk PRIMARY KEY (activity_id, order_id);
 >   ALTER TABLE ONLY public.contains DROP CONSTRAINT contains_pk;
       public            postgres    false    214    214            ?           2606    16512    order order_pk 
   CONSTRAINT     T   ALTER TABLE ONLY public."order"
    ADD CONSTRAINT order_pk PRIMARY KEY (order_id);
 :   ALTER TABLE ONLY public."order" DROP CONSTRAINT order_pk;
       public            postgres    false    213            ?           2606    16647    professor professor_pk 
   CONSTRAINT     ^   ALTER TABLE ONLY public.professor
    ADD CONSTRAINT professor_pk PRIMARY KEY (professor_id);
 @   ALTER TABLE ONLY public.professor DROP CONSTRAINT professor_pk;
       public            postgres    false    218            ?           2606    16474    staff staff_pk 
   CONSTRAINT     R   ALTER TABLE ONLY public.staff
    ADD CONSTRAINT staff_pk PRIMARY KEY (staff_id);
 8   ALTER TABLE ONLY public.staff DROP CONSTRAINT staff_pk;
       public            postgres    false    210            ?           2606    16603    student student_pk 
   CONSTRAINT     X   ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pk PRIMARY KEY (student_id);
 <   ALTER TABLE ONLY public.student DROP CONSTRAINT student_pk;
       public            postgres    false    216            ?           2606    16528    contains activity_creates_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.contains
    ADD CONSTRAINT activity_creates_fk FOREIGN KEY (activity_id) REFERENCES public.activity(activity_id);
 F   ALTER TABLE ONLY public.contains DROP CONSTRAINT activity_creates_fk;
       public          postgres    false    214    212    3464            ?           2606    16538    contains order_creates_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.contains
    ADD CONSTRAINT order_creates_fk FOREIGN KEY (order_id) REFERENCES public."order"(order_id);
 C   ALTER TABLE ONLY public.contains DROP CONSTRAINT order_creates_fk;
       public          postgres    false    214    213    3466            !   3   x?3???O?v???M??K?44ճ??21?.????X?L??b???? ?7      #   ?   x?̱?0??/??X??^?????lt??x4??b?v???/???.|??s?]???%?*??         _   x?34635752???OU?MM??K?4200?50?5???4??5?0?5252?443?P????Q.)JM?Up)?,K??*ʅ?342?2??gA-?b???? ?$*z      "   b   x???1?0@??R??p7㪉????ؤ?o??0(?&???(??ޯ??՚iâ=?B?Tz?N?u??W< u??ī?ȼ|??/??kǅ?ŗO?      '   >   x?35?4463575??t??-(-I-RN?L?KN?tJIW0?t?LJ-
NM.-?,??????? ?]?            x?????? ? ?      %   B   x?36?44635752?420??5 "C ??H??T?Ȁ?9????$?H!8935/9?3/?/?+F??? ???     