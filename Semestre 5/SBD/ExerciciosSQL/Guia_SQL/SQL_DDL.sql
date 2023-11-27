use aula_pratica;

drop table if exists disciplina;

create table disciplina
(
	codigo char(4) not null,
    designacao varchar(100) not null,
    constraint pk_disciplina primary key (codigo)
);

	drop table if exists inscricao;

	create table inscricao
	(
		numero int not null,
		codigo char(4) not null,
		ano int not null,
		nota numeric(3,1) null,
		constraint pk_inscricao primary key (ano, numero, codigo)
	);

drop table if exists aluno;

create table aluno
(
	numero int not null,
    nome varchar(100) not null,
    nascido datetime not null,
    genero varchar(1) not null,
    constraint pk_aluno primary key (numero)
);

-- Change inscricao constraints

alter table inscricao add constraint fk_aluno foreign key (numero) references aluno (numero);
alter table inscricao add constraint fk_disciplina foreign key (codigo) references disciplina (codigo);