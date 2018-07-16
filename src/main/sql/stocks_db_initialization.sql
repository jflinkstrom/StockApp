/** create the stocks database */

DROP TABLE IF EXISTS quotes CASCADE;
CREATE TABLE quotes(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-05-03 00:00:01','363.21');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-05 00:00:01','100.10');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2014-03-10 00:00:01','110.12');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2013-04-11 00:00:01','201.09');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2012-05-12 00:00:01','90.87');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2011-06-13 00:00:01','345.45');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2010-07-14 00:00:01','363.21');