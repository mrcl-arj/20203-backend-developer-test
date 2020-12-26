drop table if exists survivor cascade;

CREATE TABLE survivor (
 	id 				INT AUTO_INCREMENT PRIMARY KEY,
  	name 			VARCHAR(250) NOT NULL,
  	gender 			VARCHAR(1) NOT NULL,
  	date_of_birth 	DATE NULL,
  	healthy			BOOLEAN,
  	latitude 		FLOAT NOT NULL,
  	longitude 		FLOAT NOT NULL
);

CREATE TABLE type_item (
 	id 				INT AUTO_INCREMENT PRIMARY KEY,
  	name 			VARCHAR(250) NOT NULL,
  	point			int NOT NULL
);

CREATE TABLE item (
 	id 				INT AUTO_INCREMENT PRIMARY KEY,
  	name 			VARCHAR(250) NOT NULL,
  	point			int NOT NULL
);

INSERT INTO survivor (name, gender, date_of_birth, healthy, latitude, longitude) VALUES ('Rick Grimes', 'M', '1981-12-25', true, 1000, 2000);

INSERT INTO item (name,point) VALUES ('Water',4), ('Food',3), ('Medicine',2), ('Ammo',1);