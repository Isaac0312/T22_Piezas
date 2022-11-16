DROP TABLE IF EXISTS piezas;

CREATE table piezas (
	codigo int not null AUTO_INCREMENT,
    nombre char(100),
    PRIMARY KEY(codigo)
);

DROP TABLE IF EXISTS proveedores;

CREATE table proveedores (
	id int not null AUTO_INCREMENT,
    nombre char(100),
    PRIMARY KEY(id)
);

DROP TABLE IF EXISTS suministra;

CREATE table suministra (
	codigo_pieza int not null,
    id_proveedor int not null,
    precio int,
    PRIMARY KEY(codigo_pieza,id_proveedor),
    FOREIGN KEY(codigo_pieza) REFERENCES piezas(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
	FOREIGN KEY(id_proveedor) REFERENCES proveedores(id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into piezas(nombre)values('Rueda');
insert into piezas(nombre)values('Puerta');

insert into proveedores(nombre)values('BMW');
insert into proveedores(nombre)values('AUDI');

insert into suministra(codigo_pieza,id_proveedor,precio) values(1,1,100);
insert into suministra(codigo_pieza,id_proveedor,precio) values(2,2,200);