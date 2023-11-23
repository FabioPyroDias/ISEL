-- DML para manipulação de dados

use health_clubs;

insert into clube values 
('512345678', 'FitnessHut Amoreiras', 'Rua das Amoreiras', '25', 'Amoreiras', 'Lisboa', '38.123456', '-9.123456'),
('512345678', 'FitnessHut Saldanha', 'Rua do Saldanha', '21', 'Saldanha', 'Lisboa', '39.123456', '-8.123456'),
('512345678', 'FitnessHut Porto', 'Rua do Porto', '90', 'Cantanhede', 'Porto', '40.123456', '-7.123456'),
('587654321', 'Pump Odivelas', 'Rua do Principal', '10', 'Olivais de Bastos', 'Odivelas', '41.123456', '-6.123456');

insert into horario values 
('Segunda', '09:00', true),
('Segunda', '22:30', false),
('Sábado', '10:00', true),
('Sábado', '20:00', false);

insert into utilizador values
('210000001', 'Harry Potter'),
('210000002', 'Hermione Granger'),
('210000003', 'Ron Weasley'),
('210000004', 'Bruce Wayne'),
('210000005', 'Clark Kent'),
('210000006', 'Tony Stark');

insert into tipo_contacto values
('Email'),
('Telefone'),
('Telemóvel');

insert into tipo_equipamento values
('Supino'),
('Esteira'),
('Remo');

insert into sala values
('512345678', 'FitnessHut Amoreiras', 'Musculação', 'funcional', 30),
('512345678', 'FitnessHut Amoreiras', 'Cross Fit', 'funcional', 35),
('512345678', 'FitnessHut Amoreiras', 'Kick Box', 'funcional', 20);

insert into clube_horario values
('512345678', 'Segunda', '09:00', true),
('512345678', 'Segunda', '22:30', false),
('587654321', 'Sábado', '10:00', true),
('587654321', 'Sábado', '20:00', false);

insert into personal_trainer values
('210000004'),
('210000005'),
('210000006');

insert into clube_personal values
('512345678', 'FitnessHut Amoreiras', '210000004'),
('587654321', 'Pump Odivelas', '210000004'),
('512345678', 'FitnessHut Porto', '210000005'),
('512345678', 'FitnessHut Porto', '210000006');

insert into cliente values
('210000001', '1990-07-25', '512345678', 'FitnessHut Amoreiras'),
('210000002', '1991-08-26', '512345678', 'FitnessHut Amoreiras'),
('210000003', '1992-09-27', '587654321', 'Pump Odivelas');

insert into patologia values
('210000001', 'Lúpus Eritematoso Sistémico LES'),
('210000001', 'Miopia'),
('210000003', 'Analgésia Congênita');

insert into objetivo values
('210000002', 'Ganho de massa múscular', null),
('210000002', 'Ganho de força', null),
('210000001', 'Perda de peso', null);

insert into contacto values
('Email', 'amoreiras@hut.com','512345678', 'FitnessHut Amoreiras', null),
('Email', 'odivelas@pump.com','587654321', 'Pump Odivelas', null),
('Telefone', '219876543', null, null, '210000003'),
('Telemóvel', '919876543', null, null, '210000001');

insert into atividade values
('Treino de força', 'semanal', '512345678', 'FitnessHut Amoreiras', '210000004', 'Musculação'),
('Treino de velocidade', 'semanal', '512345678', 'FitnessHut Amoreiras', '210000005', 'Cross Fit'),
('Combate 101', 'eventual', '587654321', 'Pump Odivelas', '210000006', 'Kick Box');

insert into ocorrencia values
('Treino de força', '2023-11-17', '09:00', true, 2, 10, 16, 65),
('Treino de velocidade', '2023-11-18', '10:00', false, 1, 1, 18, 45),
('Combate 101', '2023-11-19', '19:30', false, 2, 10, 18, 45);

insert into cliente_ocorrencia values
('210000001', 'Treino de força', '2023-11-17', '09:00', true, 'reservado', now()),
('210000003', 'Treino de força', '2023-11-17', '09:00', true, 'reservado', now()),
('210000003', 'Treino de velocidade', '2023-11-18', '10:00', false, 'reservado', now());

insert into equipamento values
('12345678987', 'Supino', '512345678', 'FitnessHut Amoreiras',  'funcional', 'Treino de força'),
('98765432112', 'Esteira', '512345678', 'FitnessHut Amoreiras',  'funcional', 'Treino de velocidade'),
('74125896336', 'Remo', '587654321', 'Pump Odivelas',  'funcional', 'Combate 101');

insert into multimedia values
('C:\\work\\faculdade\\Semestre_5\\SDB\\TP1\\foto.png', 'image/png', 'Bruce', '210000004'),
('C:\\work\\faculdade\\Semestre_5\\SDB\\TP1\\equipamento.jpg', 'image/jpg', 'Esteira', null),
('C:\\work\\faculdade\\Semestre_5\\SDB\\TP1\\equipamento2.jpg', 'image/jpg', 'Supino', null),
('C:\\work\\faculdade\\equipamento3.jpg', 'image/jpg', 'Remo', null),
('C:\\work\\faculdade\\Semestre_5\\SDB\\TP1\\foto2.png', 'image/png', 'Clark', '210000005');

insert into equipamento_multimedia values
('98765432112', 'Esteira', 'C:\\work\\faculdade\\Semestre_5\\SDB\\TP1\\equipamento.jpg'),
('12345678987', 'Supino', 'C:\\work\\faculdade\\Semestre_5\\SDB\\TP1\\equipamento2.jpg'),
('74125896336', 'Remo', 'C:\\work\\faculdade\\equipamento3.jpg');

insert into personal_cliente_equipamento values
('210000004', '210000001', 'Supino', true),
('210000005', '210000002', 'Esteira', true),
('210000006', '210000003', 'Remo', false);


