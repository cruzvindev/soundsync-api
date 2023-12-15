set foreign_key_checks = 0;

delete from album;
delete from artista;
delete from musica;

set foreign_key_checks = 1;

alter table album auto_increment = 1;
alter table musica auto_increment = 1;
alter table artista auto_increment = 1;

insert into artista(id, artista_nome, origem, biografia) values (1, 'Michael Jackson', 'United States', 'Michael Joseph Jackson foi um cantor, compositor e dançarino estadunidense. Apelidado de ''Rei do Pop'', foi um dos ícones culturais mais importantes e influentes de todos os tempos e um dos maiores artistas da história da música');
insert into artista(id, artista_nome, origem, biografia) values (2, 'Madonna', 'United States', 'Madonna Louise Veronica Ciccone é uma cantora, compositora, atriz e empresária norte-americana. Conhecida como a "Rainha do Pop", Madonna é uma das artistas musicais mais bem-sucedidas e influentes de todos os tempos.');
insert into artista(id, artista_nome, origem, biografia) values (3, 'Eminem', 'United States', 'Eminem, cujo nome verdadeiro é Marshall Mathers III, é um rapper e compositor americano. Eminem é um dos artistas de rap mais bem-sucedidos e influentes da história.');
insert into artista(id, artista_nome, origem, biografia) values (4, 'Beyoncé', 'United States', 'Beyoncé Giselle Knowles-Carter é uma cantora, compositora e atriz norte-americana. Ela se tornou uma das artistas mais aclamadas e influentes da música contemporânea, com sucessos que abrangem diversos gêneros.');
insert into artista(id, artista_nome, origem, biografia) values (5, 'Ed Sheeran', 'United Kingdom', 'Ed Sheeran é um cantor e compositor britânico. Com sua voz única e habilidades em tocar violão, ele se tornou um dos artistas mais populares da música pop atual, com várias músicas de sucesso e uma legião de fãs em todo o mundo.');
insert into artista(id, artista_nome, origem, biografia) values (6, 'Shakira', 'Colombia', 'Shakira Isabel Mebarak Ripoll é uma cantora, compositora e dançarina colombiana. Conhecida por sua voz única e suas habilidades de dança, Shakira conquistou o público global e se tornou uma das artistas latinas de maior sucesso no cenário internacional.');

insert into album(id, artista_id, titulo, ano_lancamento, genero) values (1, 1, 'Bad', '1987', 'Pop');
insert into album(id, artista_id, titulo, ano_lancamento, genero) values (2, 1, 'Dangerous', '1991', 'Pop');
insert into album(id, artista_id, titulo, ano_lancamento, genero) values (3, 3, 'The Eminem Show', '2002', 'Rap');
insert into album(id, artista_id, titulo, ano_lancamento, genero) values (4, 5, 'X', '2014', 'Pop');

insert into musica(id, album_id, titulo, duracao) values (1, 1, 'Smooth Criminal', 251);
insert into musica(id, album_id, titulo, duracao) values (2, 2, 'Jam', 339);