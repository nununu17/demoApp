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
  , my_recommend smallint default 0
  , halt_flag smallint default 0
  , genre integer
  , area integer
  , today_comment character varying(100)
  , recommend_comment character varying(100)
  , facility_comment character varying(100)
  , primary key (id)
  ,foreign key (genre) references genre(num)
  ,foreign key (area) references area(num)
);