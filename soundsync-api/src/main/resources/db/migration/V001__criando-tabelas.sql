create table artista (
   id bigint not null auto_increment primary key,
   artista_nome varchar(60) not null,
   origem varchar(60) not null,
   biografia varchar(450) not null
) engine=InnoDB default charset=utf8;

create table album (
   id bigint not null auto_increment primary key,
   artista_id bigint not null,
   titulo varchar(100) not null,
   ano_lancamento varchar(15) not null,
   genero VARCHAR(50)not null
)engine=InnoDB default charset=utf8;

create table musica (
   id bigint not null auto_increment primary key,
   album_id bigint not null,
   titulo varchar(100) not null,
   duracao int(200) not null
)engine=InnoDB default charset=utf8;


alter table album add constraint fk_album_artista
foreign key (artista_id) references artista(id);

alter table musica add constraint fk_musica_album
foreign key (album_id) references album(id);