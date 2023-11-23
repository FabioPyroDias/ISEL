-- DDL para eliminação das tabelas

use health_clubs;

-- Primeiro apagar tabelas que não contenham chaves estrangeiras a referênciá-las.
-- Depois apagar aquelas que tinham outra que faziam referência, mas já foram apagadas.

drop table if exists personal_cliente_equipamento;
drop table if exists equipamento_multimedia;
drop table if exists equipamento;
drop table if exists cliente_ocorrencia;
drop table if exists contacto;
drop table if exists objetivo;
drop table if exists patologia;
drop table if exists clube_horario;
drop table if exists clube_personal;
drop table if exists horario;
drop table if exists multimedia;
drop table if exists tipo_equipamento;
drop table if exists ocorrencia;
drop table if exists atividade;
drop table if exists tipo_contacto;
drop table if exists cliente;
drop table if exists personal_trainer;
drop table if exists utilizador;
drop table if exists sala;
drop table if exists clube;




