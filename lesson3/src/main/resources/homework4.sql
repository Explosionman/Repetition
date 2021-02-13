CREATE TABLE public.films_tbl
(
    id           smallint NOT NULL DEFAULT nextval('films_tbl_id_seq'::regclass),
    title_fld    character varying(255) COLLATE pg_catalog."default",
    duration_fld smallint,
    CONSTRAINT films_tbl_pkey PRIMARY KEY (id)
);

CREATE TABLE public.movie_schedule_tbl
(
    id                 smallint NOT NULL DEFAULT nextval('movie_schedule_tbl_id_seq'::regclass),
    price_fld          smallint,
    visitors_fld       smallint,
    start_datetime_fld timestamp without time zone,
    film_id            smallint NOT NULL DEFAULT nextval('movie_schedule_tbl_film_id_seq'::regclass),
    CONSTRAINT movie_schedule_tbl_pkey PRIMARY KEY (id),
    CONSTRAINT film_fk FOREIGN KEY (film_id)
        REFERENCES public.films_tbl (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


insert into films_tbl (title_fld, duration_fld)
values ('Дьявол в деталях', 127),
       ('Охотник на монстров', 85),
       ('Дикая парочка', 100),
       ('Родные', 70),
       ('Приворот. Черное венчание', 93);

insert into movie_schedule_tbl (price_fld, visitors_fld, start_datetime_fld, film_id)
values (200, 22, '2021-02-12 09:00:00', 1),
       (220, 43, '2021-02-12 12:30:00', 1),
       (300, 35, '2021-02-12 18:30:00', 1),
       (200, 27, '2021-02-12 09:00:00', 2),
       (220, 50, '2021-02-12 11:00:00', 2),
       (250, 49, '2021-02-12 13:30:00', 2),
       (350, 27, '2021-02-12 19:00:00', 2),
       (400, 35, '2021-02-12 21:00:00', 2),
       (270, 46, '2021-02-12 14:30:00', 3),
       (370, 53, '2021-02-12 22:30:00', 3),
       (400, 27, '2021-02-12 20:00:00', 4),
       (320, 27, '2021-02-12 15:30:00', 5),
       (370, 27, '2021-02-12 17:30:00', 5);


-- Задание 1. Ошибки в расписании (фильмы накладываются друг на друга), отсортированные по возрастанию времени.
select a.fiml1,
       a.film1_time,
       a.film1_duration,
       b.film2_time,
       b.film2_time - a.film1_time as break_time
from (
         select f.title_fld as fiml1, m.start_datetime_fld as film1_time, f.duration_fld as film1_duration
         from films_tbl as f
                  join movie_schedule_tbl as m on (f.id = m.film_id)
     ) a
         cross join
     (
         select m.start_datetime_fld as film2_time
         from movie_schedule_tbl as m
     ) b
where a.film1_time < b.film2_time
  and (b.film2_time - a.film1_time) >= interval '30 minutes'
order by break_time desc;


-- Задание 2. Перерывы 30 минут и более между фильмами — выводить по уменьшению длительности перерыва.
select a.fiml1,
       a.film1_time,
       a.film1_duration,
       b.film2_time,
       b.film2_time - a.film1_time as break_time
from (
         select f.title_fld as fiml1, m.start_datetime_fld as film1_time, f.duration_fld as film1_duration
         from films_tbl as f
                  join movie_schedule_tbl as m on (f.id = m.film_id)
     ) a
         cross join
     (
         select m.start_datetime_fld as film2_time
         from movie_schedule_tbl as m
     ) b
where a.film1_time <= b.film2_time
order by break_time desc;

-- Задание 3. Cписок фильмов, для каждого — с указанием общего числа посетителей за все время, среднего числа зрителей
--            за сеанс и общей суммы сборов по каждому фильму (отсортировать по убыванию прибыли).


-- не смог додуматься,  как отфильтровать итоговые суммы, при этом оставить поле "Итого" внизу"
SELECT COALESCE(title, 'Итого: ') as title,
       sum(a.visitors)            as total_visitors,
       avg(a.visitors)::int       as avg_visitors,
       sum(a.visitors * a.price)  as total_sum
from (
         select f.title_fld as title, m.visitors_fld as visitors, m.price_fld as price
         from films_tbl as f
                  join movie_schedule_tbl as m on (f.id = m.film_id)
     ) a
group by grouping sets ( title, ())
order by total_sum;

-- Задание 4. Число посетителей и кассовые сборы, сгруппированные по времени начала фильма:
-- с 9 до 15, с 15 до 18, с 18 до 21, с 21 до 00:00 (сколько посетителей пришло с 9 до 15 часов и т.д.).

select sum(a.visitors) as visitors, sum(a.price * visitors) as money, a.start_datetime_fld as time
from (
         select m.visitors_fld as visitors,
                m.price_fld    as price,
                case
                    when m.start_datetime_fld >= '2021-02-12 08:59:59' and m.start_datetime_fld < '2021-02-12 15:00:00'
                        then 'from 09 to 15'
                    when m.start_datetime_fld >= '2021-02-12 15:00:00' and m.start_datetime_fld < '2021-02-12 18:00:00'
                        then 'from 15 to 18'
                    when m.start_datetime_fld >= '2021-02-12 18:00:00' and m.start_datetime_fld < '2021-02-12 21:00:00'
                        then 'from 18 to 21'
                    when m.start_datetime_fld >= '2021-02-12 21:00:00' and m.start_datetime_fld < '2021-02-13 00:00:00'
                        then 'from 21 to 24'
                    END           start_datetime_fld
         from movie_schedule_tbl as m
         group by (visitors, price, start_datetime_fld)
     ) a
group by (a.start_datetime_fld)
order by time