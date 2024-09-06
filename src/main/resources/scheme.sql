DROP IF EXISTS area;

create table public.area (
  num integer not null
  , disp_name character varying(20)
  , name character varying(20)
  , primary key (num)
);

DROP IF EXISTS genre;

create table public.genre (
  num integer not null
  , disp_name character varying(20)
  , name character varying(20)
  , primary key (num)
);

DROP IF EXISTS tds_info ;

create table public.tds_info (
  id integer not null
  , name character varying(80)
  , today smallint default 0
  , my_recommendatation smallint default 0
  , halt_flag smallint default 0
  , genre integer
  , area integer
  , primary key (id)
  ,foreign key (genre) references genre(num)
  ,foreign key (area) references area(num)
);