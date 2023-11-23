-- DDL para definição de dados

-- Cria Base de Dados
create database if not exists health_clubs;
use health_clubs;

-- Criar tabelas sem Chaves Estrangeiras
create table if not exists Clube(
	nif varchar(12),
    designacao varchar(25),
    morada varchar(150),
    num_porta varchar(5) not null,
    localidade varchar(20) not null,
    cidade varchar(20) not null,
    longitude varchar(9) not null,
    latitude varchar(9) not null,
    
	primary key (nif, designacao)
);

create table if not exists Horario(
    dia_semana varchar(10),
    hora time,
    is_abertura boolean,
    
    primary key (dia_semana, hora, is_abertura)
);

create table if not exists Utilizador(
	nif varchar(12) primary key,
    nome varchar(255) not null
);

create table if not exists Tipo_Contacto(
	tipo varchar(20) primary key
);

create table if not exists Tipo_Equipamento(
	tipo varchar(20) primary key
);

-- Criar tabelas que tenham referência a outras na ordem correta
create table if not exists Sala(
    clube_nif varchar(12) not null,
    clube_nome varchar(25) not null,
    nome varchar(30) unique,
    estado enum('funcional', 'manutencao') not null default 'funcional',
    ocupacao smallint not null,
    
    primary key(clube_nif, clube_nome, nome),
    foreign key (clube_nif, clube_nome) references Clube(nif, designacao)
);


create table if not exists Clube_Horario(
    clube_nif varchar(12) not null,
    dia_semana varchar(10) not null,
    hora time not null,
    is_abertura boolean  not null,
    
    primary key(clube_nif, dia_semana, hora, is_abertura),
    foreign key (clube_nif) references Clube(nif),
    foreign key (dia_semana, hora, is_abertura) references Horario(dia_semana, hora, is_abertura)
);

create table if not exists Personal_Trainer(
	nif varchar(12) primary key,
    foreign key(nif) references Utilizador(nif)
);

create table if not exists Clube_Personal(
	clube_nif varchar(12) not null,
    clube_nome varchar(25) not null,
    personal_nif varchar(12) not null,
    
    primary key(clube_nif, clube_nome, personal_nif),
    foreign key (clube_nif, clube_nome) references Clube(nif, designacao),
    foreign key (personal_nif) references Personal_Trainer(nif)
);

create table if not exists Cliente(
	nif varchar(12) primary key,
    data_nasc date not null,
    clube_nif varchar(12) not null,
    clube_nome varchar(25) not null,
    
    foreign key (clube_nif, clube_nome) references Clube(nif, designacao),
    foreign key(nif) references Utilizador(nif)
);

create table if not exists Patologia(
	cod_cliente varchar(12),
    nome varchar(50) not null,
    
    primary key(cod_cliente, nome),
    foreign key(cod_cliente) references Cliente(nif)
);

create table if not exists Objetivo(
	cod_cliente varchar(12),
    nome varchar(50),
    d_conclusao date,
    
    primary key(cod_cliente, nome),
    foreign key(cod_cliente) references Cliente(nif)
);

create table if not exists Contacto(
	tipo_contacto varchar(20),
    valor varchar(64),
    clube_nif varchar(12),
    clube_nome varchar(25),
    user_nif varchar(12),
    
    primary key (tipo_contacto, valor),
    foreign key (tipo_contacto) references Tipo_Contacto(tipo),
    foreign key (clube_nif , clube_nome) references Clube(nif, designacao),
    foreign key(user_nif) references Utilizador(nif),
    
    check( -- permite que apena 1 tipo crie um registo de contacto
		(clube_nif is not null and clube_nome is not null and user_nif is null) or
        (clube_nif is null and clube_nome is null and user_nif is not null)
    )
);

create table if not exists Atividade(
	nome varchar(75) primary key,
    frequencia enum('semanal', 'eventual') not null default 'eventual',
    clube_nif varchar(12) not null,
    clube_nome varchar(25) not null,
    personal_nif varchar(12) not null,
    sala varchar(30) not null,
    
    foreign key (clube_nif , clube_nome) references Clube(nif, designacao),
    foreign key (personal_nif) references Personal_Trainer(nif),
    foreign key (sala) references Sala(nome)
    
); 

create table if not exists Ocorrencia(
	atividade varchar(75),
    `data` date not null,
    hora time not null,
    is_group boolean,
    pax_min smallint not null check(pax_min > 0),
    pax_max smallint not null check(pax_max > 0),
    idade_min smallint not null check(idade_min > 0),
    idade_max smallint not null check(idade_max > 0),
    
    primary key (atividade, `data`, hora, is_group),
    foreign key (atividade) references Atividade(nome)
);

create table if not exists Cliente_Ocorrencia(
	cliente_nif varchar(12),
    atividade varchar(75),
    `data` date,
    hora time,
    is_group boolean,
    estado enum('reservado', 'pre_cancelado', 'cancelado') not null default 'reservado',
    registo timestamp not null,
    
    primary key(cliente_nif, atividade, `data`, hora, is_group),
	foreign key(cliente_nif) references Cliente(nif),
    foreign key(atividade, `data`, hora, is_group) references Ocorrencia (atividade, `data`, hora, is_group)
);

create table if not exists Equipamento(
	num_serie varchar(50),
    tipo varchar(50),
    clube_nif varchar(12) not null,
    clube_nome varchar(25) not null,
    estado enum('funcional', 'avariado') not null default 'funcional',
    atividade varchar(75) not null,
    
    primary key(num_serie, tipo),
    foreign key (atividade) references Atividade(nome),
    foreign key (clube_nif, clube_nome) references Clube(nif, designacao)
);

create table if not exists Multimedia(
	file_path varchar(150) primary key,
    file_type varchar(20) not null,
    filename varchar(50) not null,
    personal_nif varchar(12),
    
    foreign key (personal_nif) references Personal_Trainer(nif)
);

create table if not exists Equipamento_Multimedia(
	codigo varchar(50),
    tipo varchar(50),
    file_path varchar(150),
    
    primary key(codigo, tipo, file_path),
    foreign key(codigo, tipo) references Equipamento(num_serie, tipo),
    foreign key(file_path) references Multimedia(file_path)
);


create table if not exists Personal_Cliente_Equipamento(
	personal_nif varchar(12),
    cliente_nif varchar(12),
    tipo varchar(50),
    recomendado boolean not null,
    
    primary key(personal_nif, cliente_nif, tipo),
    foreign key (personal_nif) references Personal_Trainer(nif),
    foreign key(cliente_nif) references Cliente(nif),
    foreign key(tipo) references Tipo_Equipamento(tipo)
);

/*
select count(*) as num_tabelas from information_schema.tables
where table_schema = 'health_clubs';
*/

/*the end*/