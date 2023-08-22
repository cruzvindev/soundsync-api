create table artist (
   id bigint not null auto_increment,
   name varchar(60) not null,
   country varchar(60) not null,
   biography varchar(250) not null,

   primary key (id)
) engine=InnoDB default charset=utf8;

create table album (
   id bigint not null auto_increment,
   artist_id bigint not null,
   title varchar(100) not null,
   release_date datetime not null,
   genre VARCHAR(50)not null ,

   primary key (id)
)engine=InnoDB default charset=utf8;

create table music (
   id bigint not null auto_increment,
   album_id bigint not null,
   title varchar(100) not null,
   release_year varchar(10) not null,

   primary key (id)
)engine=InnoDB default charset=utf8;


alter table album add constraint fk_album_artist
foreign key (artist_id) references artist(id);

alter table music add constraint fk_music_album
foreign key (album_id) references album(id);