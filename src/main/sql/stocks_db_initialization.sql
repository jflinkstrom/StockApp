/** create the stocks database */
DROP TABLE IF EXISTS stocks.person_quote CASCADE;
DROP TABLE IF EXISTS stocks.person CASCADE;
DROP TABLE IF EXISTS stocks.quotes CASCADE;

CREATE TABLE quotes(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);


CREATE TABLE stocks.person
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);


CREATE TABLE stocks.person_quote
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  quotes_id INT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID),
  FOREIGN KEY (quotes_id) REFERENCES quotes (ID)
);

INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('GOOG','2015-05-03 00:00:01','363.21');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('APPL','2000-01-05 00:00:01','100.10');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('APPL','2014-03-10 00:00:01','110.12');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2013-04-11 00:00:01','201.09');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2012-05-12 00:00:01','90.87');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2011-06-13 00:00:01','345.45');
INSERT INTO stocks.quotes (symbol,time,price) VALUES ('AMZN','2010-07-14 00:00:01','363.21');

INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Jason','Flinkstrom','1989/07/017');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Lang', 'Heckman', '1959/11/11');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Stew', 'Hammer', '1990/3/28');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Dan', 'Lane', '1986/4/18');
INSERT INTO stocks.person (first_name,last_name,birth_date) VALUES ('Drew', 'Hope', '1999/10/10');

INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (1, 1, 2);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (2, 1, 1);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (3, 2, 1);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (4, 3, 1);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (5, 3, 3);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (6, 3, 3);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (7, 4, 4);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (8, 5, 5);
INSERT INTO stocks.person_quote (ID, person_id, quotes_id) VALUES (9, 5, 5);