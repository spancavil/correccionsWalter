 CREATE TABLE cliente (id_cliente int NOT NULL,
  nombre VARCHAR(150) NOT NULL, 
    apellido VARCHAR(150) NULL, 
    documento INT not null, 
	PRIMARY KEY(id_cliente));
    
    CREATE TABLE producto (
    id_producto int NOT NULL,
	titulo VACHAR(300)NOT NULL,
      descripcion
      VARCHAR(300)NOT NULL,
      codigo int NOT NULL,
      stock int NOT NULL,
      precio_producto float NOT NULL,
      PRIMARY KEY(id_producto));
      
