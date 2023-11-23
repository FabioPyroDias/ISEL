use empresa;

select * 
from empregado ;

SELECT *
FROM departamento;

select e.nome, d.nome
from empregado e
	inner join departamento d 
		on e.num_dep = d.num_dep ;

select e.nome, d.nome
from empregado e
	  right outer join departamento d 
		on e.num_dep = d.num_dep ;
		
select ec.nome
from 
	(select e.nome, c.tipo, c.valor
	from empregado e
		left outer join contacto c
		on e.num_emp = c.numero_empregado) ec;
 
 select d.nome, e.contagem 
 from
	 (select num_dep, count(*) `contagem`
	 from empregado
     -- where idade = '20'
	 group by num_dep) e
     inner join departamento d
     on e.num_dep = d.num_dep;
     
 select num_dep, count(*) `contagem`
 from empregado
 -- where idade = '20'
 group by num_dep
 having contagem <> '1';
