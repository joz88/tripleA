insert into aseguradoras (id,nombre,RFC,razon_social) values(1,'ACE SEGUROS S. A.','ASE901221SM4','ACE SEGUROS S. A.');
insert into aseguradoras (id,nombre,RFC,razon_social) values(2,'ZURICH COMPAÑIA DE SEGUROS SA','ZSE950306M48','ZURICH COMPAÑIA DE SEGUROS SA');
insert into aseguradoras (id,nombre,RFC,razon_social) values(3,'CHUBB SEGUROS MEXICO SA','ASE901221SM4','CHUBB SEGUROS MEXICO SA');
insert into aseguradoras (id,nombre,RFC,razon_social) values(4,'SEGUROS SURA, S.A. de C.V.','R&S811221KR6','SEGUROS SURA, S.A. de C.V.');
insert into aseguradoras (id,nombre,RFC,razon_social) values(5,'AXA SEGUROS SA DE CV','ASE931116231','AXA SEGUROS SA DE CV');
insert into aseguradoras (id,nombre,RFC,razon_social) values(6,'ABA SEGUROS S.A DE C.V.','ABA920310QW0','ABA SEGUROS S.A DE C.V.');

insert into tickets (numero_siniestro,asegurado,estatus,telefono_contacto,poliza,inciso,aseguradora_id) values('123456','Josue Rivera','abierto','8123913040','poliza SEGUROS','123',1);

insert into tareas (DESCRIPCION, ESTATUS, NOMBRE_TAREA, PUBLICAR, SECUENCIA, ID_TICKET) values('descripcion de primer ticket','abierto','primera tarea','S',1,1);
insert into tareas (DESCRIPCION, ESTATUS, NOMBRE_TAREA, PUBLICAR, SECUENCIA, ID_TICKET) values('descripcion de segundo ticket','abierto','segunda tarea','S',2,1);
insert into tareas (DESCRIPCION, ESTATUS, NOMBRE_TAREA, PUBLICAR, SECUENCIA, ID_TICKET) values('descripcion de tercer ticket','abierto','tercer tarea','S',2,1);