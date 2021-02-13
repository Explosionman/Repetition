PGDMP     &                    y            test    10.14    10.14     �
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                        0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    100222    test    DATABASE     �   CREATE DATABASE test WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE test;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false                       0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12924    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false                       0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �            1259    100225 	   films_tbl    TABLE     }   CREATE TABLE public.films_tbl (
    id smallint NOT NULL,
    title_fld character varying(255),
    duration_fld smallint
);
    DROP TABLE public.films_tbl;
       public         postgres    false    3            �            1259    100223    films_tbl_id_seq    SEQUENCE     �   CREATE SEQUENCE public.films_tbl_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.films_tbl_id_seq;
       public       postgres    false    197    3                       0    0    films_tbl_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.films_tbl_id_seq OWNED BY public.films_tbl.id;
            public       postgres    false    196            �            1259    100235    movie_schedule_tbl    TABLE     �   CREATE TABLE public.movie_schedule_tbl (
    id smallint NOT NULL,
    price_fld smallint,
    visitors_fld smallint,
    start_datetime_fld timestamp without time zone,
    film_id smallint NOT NULL
);
 &   DROP TABLE public.movie_schedule_tbl;
       public         postgres    false    3            �            1259    100233    movie_schedule_tbl_film_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movie_schedule_tbl_film_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.movie_schedule_tbl_film_id_seq;
       public       postgres    false    200    3                       0    0    movie_schedule_tbl_film_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.movie_schedule_tbl_film_id_seq OWNED BY public.movie_schedule_tbl.film_id;
            public       postgres    false    199            �            1259    100231    movie_schedule_tbl_id_seq    SEQUENCE     �   CREATE SEQUENCE public.movie_schedule_tbl_id_seq
    AS smallint
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.movie_schedule_tbl_id_seq;
       public       postgres    false    200    3                       0    0    movie_schedule_tbl_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.movie_schedule_tbl_id_seq OWNED BY public.movie_schedule_tbl.id;
            public       postgres    false    198            v
           2604    100228    films_tbl id    DEFAULT     l   ALTER TABLE ONLY public.films_tbl ALTER COLUMN id SET DEFAULT nextval('public.films_tbl_id_seq'::regclass);
 ;   ALTER TABLE public.films_tbl ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    196    197    197            w
           2604    100238    movie_schedule_tbl id    DEFAULT     ~   ALTER TABLE ONLY public.movie_schedule_tbl ALTER COLUMN id SET DEFAULT nextval('public.movie_schedule_tbl_id_seq'::regclass);
 D   ALTER TABLE public.movie_schedule_tbl ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    198    200    200            x
           2604    100239    movie_schedule_tbl film_id    DEFAULT     �   ALTER TABLE ONLY public.movie_schedule_tbl ALTER COLUMN film_id SET DEFAULT nextval('public.movie_schedule_tbl_film_id_seq'::regclass);
 I   ALTER TABLE public.movie_schedule_tbl ALTER COLUMN film_id DROP DEFAULT;
       public       postgres    false    199    200    200            �
          0    100225 	   films_tbl 
   TABLE DATA                     public       postgres    false    197   b       �
          0    100235    movie_schedule_tbl 
   TABLE DATA                     public       postgres    false    200   R                  0    0    films_tbl_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.films_tbl_id_seq', 5, true);
            public       postgres    false    196                       0    0    movie_schedule_tbl_film_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.movie_schedule_tbl_film_id_seq', 1, false);
            public       postgres    false    199            	           0    0    movie_schedule_tbl_id_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.movie_schedule_tbl_id_seq', 13, true);
            public       postgres    false    198            z
           2606    100230    films_tbl films_tbl_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.films_tbl
    ADD CONSTRAINT films_tbl_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.films_tbl DROP CONSTRAINT films_tbl_pkey;
       public         postgres    false    197            |
           2606    100241 *   movie_schedule_tbl movie_schedule_tbl_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.movie_schedule_tbl
    ADD CONSTRAINT movie_schedule_tbl_pkey PRIMARY KEY (id);
 T   ALTER TABLE ONLY public.movie_schedule_tbl DROP CONSTRAINT movie_schedule_tbl_pkey;
       public         postgres    false    200            }
           2606    100242    movie_schedule_tbl film_fk    FK CONSTRAINT     }   ALTER TABLE ONLY public.movie_schedule_tbl
    ADD CONSTRAINT film_fk FOREIGN KEY (film_id) REFERENCES public.films_tbl(id);
 D   ALTER TABLE ONLY public.movie_schedule_tbl DROP CONSTRAINT film_fk;
       public       postgres    false    2682    197    200            �
   �   x��пj�P�=Oq6D�lqrp�j�,��]��Bgus!�_�;o����������|�?����ӑ,~f����9���߳@�/�ÉT[u�`�[����E�
2�"�Ec�T��j�j}�+���������J��ku�[J��-�v!C���΃�F�`��ͲTר#dL�ӽ�î����zD��Zq�9�CN9b{��������j�M      �
   �   x���O�0�b�
,��ݖ:u� �AZ� �����&������l�Y��
�fŖ��SS����UW�Gy��mS���֛}��)�� ԋ|6! �͑D1�z&>���K�PҞB�H1�U�I�4�������d�ʮ�#):�K��Ed���o�zΑ��R?T!��\�G:���4���>�FQ�Ԫ4.*���� �� �^U?����}Vi��n�/5���ѵ&@     