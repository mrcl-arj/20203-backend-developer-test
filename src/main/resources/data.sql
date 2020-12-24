CREATE TABLE survivor (
  id 			INT AUTO_INCREMENT PRIMARY KEY,
  name 			VARCHAR(250) NOT NULL,
  genre 		VARCHAR(1) NOT NULL,
  dateOfBirth 	DATE NULL,
  latitude 		FLOAT NOT NULL,
  longitude 	FLOAT NOT NULL
);