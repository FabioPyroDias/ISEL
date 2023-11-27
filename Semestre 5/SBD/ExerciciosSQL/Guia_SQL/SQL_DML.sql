use aula_pratica;

-- disciplina

-- insert into disciplina values ('SBD','Sistemas de Bases de Dados');
-- insert into disciplina values ('ICD','Infraestuturas Computacionais Distribuídos');
-- insert into disciplina values ('TI', 'Tecnologias de Informação');
-- insert into disciplina values ('FSO', 'Fundamentos de Sistemas Operativos');
-- insert into disciplina values ('SMI', 'Sistemas Multimédia para a Internet');

-- inscricao

-- insert into inscricao (numero, ano, nota, codigo) values (1, 2022, NULL, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (2, 2021, 10.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (3, 2022, 15.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (4, 2020, 10.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (6, 2020, NULL, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (7, 2022, 18.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (8, 2021, 15.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (9, 2015, 13.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (10,2020, NULL, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (11,2022, 14.2, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (12,2021, 18.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (13,2019, 16.0, 'SBD');
-- insert into inscricao (numero, ano, nota, codigo) values (14,2020, 14.0, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (15,2018, 15.0, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (16,2017, 11.0, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (18,2015, 11.0, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (19,2015, 13.1, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (20,2014, 16.0, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (21,2013, 17.0, 'ICD');
-- insert into inscricao (numero, ano, nota, codigo) values (22,2014, 13.0, 'ICD');

-- aluno

-- select * from aluno
-- where aluno.numero = 22;

-- delete from aluno where aluno.numero = 20;

insert into aluno (numero, nome, genero, nascido) values (1,'ABEL ALVES BOTELHO','M','20021020');
insert into aluno (numero, nome, genero, nascido) values (20,'Álvaro Silva d''''Almeida','M','19980907');
insert into aluno (numero, nome, genero, nascido) values (22,'Abreu Oliveira Antunes','M','20000107');


insert into aluno (numero, nome, genero, nascido) values (42921, 'Fabio Dias', 'M', '19961230');
insert into inscricao (numero, ano, nota, codigo) values (42921, 2023, NULL, 'SBD');

update inscricao
set nota = 20.0
where numero = 42921 and codigo = 'SBD';