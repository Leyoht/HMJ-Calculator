ALTER TABLE BEER DROP CONSTRAINT beer_fk;
ALTER TABLE WINE DROP CONSTRAINT wine_fk;
ALTER TABLE HARD_LIQUOR DROP CONSTRAINT hard_fk;
ALTER TABLE MIX_DRINK DROP CONSTRAINT mix_fk;
ALTER TABLE WELL_DRINK DROP CONSTRAINT well_fk;
ALTER TABLE SPECIALITY_DRINK DROP CONSTRAINT special_fk;
ALTER TABLE BAR DROP CONSTRAINT bar_fk;
DROP TABLE DRINK;
DROP TABLE WINE;
DROP TABLE HARD_LIQUOR;
DROP TABLE MIX_DRINK;
DROP TABLE WELL_DRINK;
DROP TABLE SPECIALITY_DRINK;
DROP TABLE BEER;

CREATE TABLE DRINK
(DrinkID int, 
DrinkType varchar2(25), 
CONSTRAINT drink_pk PRIMARY KEY(DrinkID)
); 

INSERT ALL 
INTO DRINK 
VALUES(1, 'Beer')
INTO DRINK 
VALUES(2, 'Wine')
INTO DRINK
VALUES(3, 'Hard Liquor') 
INTO DRINK 
VALUES(4, 'Mix Drink')
SELECT 1 FROM DUAL;

CREATE TABLE BEER 
(DrinkID int, 
BeerID decimal,
DrinkName varchar2(25),
DrinkAbv decimal,
Volume decimal,
CONSTRAINT beer_pk PRIMARY KEY(BeerID),
CONSTRAINT beer_fk FOREIGN KEY(DrinkID) REFERENCES DRINK(DrinkID)
);

INSERT ALL 
INTO BEER 
VALUES(1, 1.1,  'Bud Light', 4.1, 12)
INTO BEER 
VALUES(1, 1.2, 'Coors Light', 4.2, 12) 
INTO BEER 
VALUES(1, 1.3, 'Corona Light', 4.1, 12) 
INTO BEER 
VALUES(1, 1.4, 'Miller Light', 4.2, 12)
INTO BEER 
VALUES(1, 1.5, 'Natty Light', 4.2, 12)
INTO BEER 
VALUES(1, 1.6, 'Blue Moon Belgian White', 5.36, 12) 
INTO BEER 
VALUES(1, 1.7, 'Sam Adams Ale', 5.4, 12)
INTO BEER 
VALUES(1, 1.8, 'Guinness Stout', 7.5, 12)
SELECT 1 FROM DUAL;

INSERT ALL 
INTO BEER
VALUES(1, 1.1,  'Bud Light', 4.1, 12)
INTO BEER
VALUES(1, 1.2, 'Coors Light', 4.2, 12)
INTO BEER
VALUES(1, 1.3, 'Corona Light', 4.1, 12)
INTO BEER
VALUES(1, 1.4, 'Miller Light', 4.2, 12)
INTO BEER
VALUES(1, 1.5, 'Natty Light', 4.2, 12)
INTO BEER
VALUES(1, 1.6, 'Blue Moon Belgian White', 5.36, 12)
INTO BEER
VALUES(1, 1.7, 'Sam Adams Ale', 5.4, 12)
INTO BEER
VALUES(1, 1.8, 'Guinness Stout', 7.5, 12)
SELECT 1 FROM DUAL;

CREATE TABLE WINE 
( DrinkID int, 
WineID decimal, 
DrinkName varchar2(25),
DrinkAbv decimal,
Volume decimal,
CONSTRAINT wine_pk PRIMARY KEY(DrinkID, WineID), 
CONSTRAINT wine_fk FOREIGN KEY(DrinkID) REFERENCES DRINK(DrinkID)
); 

INSERT INTO WINE 
VALUES(2, 2.1, 'French Roses', 12.7, 8), 
(2, 2.2, 'Spanish Albarino', 12.9, 8), 
(2, 2.3, 'Argentine Malbec', 13.8, 8), 
(2, 2.4, 'Italian Barolo', 14.1, 8), 
(2, 2.5, 'Spanish Sherry', 14.5, 8), 
(2, 2.6, 'Portuguese Madeira', 14.7, 8), 
(2, 2.7, 'California Zinfandel', 15.0, 8), 
(2, 2.8, 'Italian Amarone', 15.3, 8); 

CREATE TABLE HARD_LIQUOR
( DrinkID int, 
HardID decimal, 
DrinkName varchar2(25),
DrinkAbv decimal,
Volume decimal,
CONSTRAINT hard_pk PRIMARY KEY(DrinkID, HardID), 
CONSTRAINT hard_fk FOREIGN KEY(DrinkID) REFERENCES DRINK(DrinkID)
); 

INSERT INTO HARD_LIQUOR
VALUES(3, 3.1, 'Captain Morgan', 35, 2 ),
(3, 3.2, 'Svedka', 40, 2), 
(3, 3.3, 'Bacardi Rum', 40, 2), 
(3, 3.4, 'Malibu Rum', 40, 2), 
(3, 3.4, 'Jameson', 40, 2), 
(3, 3.5, 'Jack Daniel's, 40, 2), 
(3, 3.6, 'Fireball', 40, 2), 
(3, 3.7, 'Genevieve', 47.3, 2), 
(3, 3.8, 'Hendricks Gin', 44, 2); 

CREATE TABLE MIX_DRINK
(DrinkID int, 
MixID decimal, 
CONSTRAINT mix_pk PRIMARY KEY(DrinkID, MixID), 
CONSTRAINT mix_fk FOREIGN KEY(DrinkID) REFERENCES DRINK(DrinkID)
); 

INSERT INTO MIX_DRINK 
VALUES(4, 4.1)

CREATE TABLE WELL_DRINK 
(DrinkID int,
MixID decimal, 
WellDrinkID decimal,
DrinkName varchar2(25),
DrinkAbv decimal,
Volume decimal,
CONSTRAINT well_pk PRIMARY KEY(WellDrinkID),
CONSTRAINT well_fk FOREIGN KEY(MixID, DrinkID) REFERENCES MIX_DRINK(MixID, DrinkID)
);

INSERT INTO WELL_DRINK 
VALUES(4.1, 4.11, 'Long Island Iced Tea', 25, 12), 
(4.1, 4.12, 'Rum and Coke', 18, 12),
(4.1, 4.13, 'Gin and Tonic', 18, 12),
(4.1, 4.14, 'Vodka Tonic', 18, 12), 
(4.1, 4.15, 'Scotch and Soda', 18, 12),
(4.1, 4.15, 'Vodka Cranberry', 18, 12), 
(4.1, 4.16, 'Tequila Cola', 18, 12), 
(4.1, 4.17, 'Vodka Lime', 18, 12), 
(4.1, 4.18, 'Vodka Orange', 18, 12);

CREATE TABLE SPECIALITY_DRINK
(DrinkID int,
MixID decimal, 
SpecialID decimal,
DrinkName varchar2(25),
DrinkAbv decimal,
Volume decimal,
CONSTRAINT special_pk PRIMARY KEY(MixID, SpecialID),
CONSTRAINT special_fk FOREIGN KEY(MixID, DrinkID) REFERENCES MIX_DRINK(MixID, DrinkID)
);

INSERT INTO SPECIALITY_DRINK
VALUES(4.2, 4.21, 'Margarita', 18, 12),
(4.2, 4.22, 'Irish Coffee', 18, 12 ),
(4.2, 4.23, 'Ramos Gin Fizz', 20, 12), 
(4.2, 4.24, 'Bloody Mary', 18, 12), 
(4.2, 4.25, 'Brooklyn', 20, 12), 
(4.2, 4.26, 'Mai Tai', 21, 12), 
(4.2, 4.27, 'Cosmopolitan', 19, 12), 
(4.2, 4.28, 'Pisco Sour', 20, 12); 

/*
CREATE TABLE FAVORITE_DRINK
(DrinkID int, 
FavID decimal, 
DrinkName varchar2(25),
DrinkAbv decimal,
Volume decimal,
CONSTRAINT favorite_pk PRIMARY KEY(DrinkID, FavID)
);  
not in current app.
*/ 

CREATE TABLE BAR
(BarID int,
LocationID int,
BarName varchar(25), 
Street1 varchar2(50),
Street2 varchar2(50), 
CONSTRAINT bar_pk PRIMARY KEY(BarID),
CONSTRAINT bar_fk FOREIGN KEY(LocationID) 
REFERENCES LOCATION(LocationID)
);

INSERT INTO BAR 
VALUES(90, 111, 'Harrys'),
VALUES(91, 111, 'Brothers'), 
VALUES(92, 111, 'Where Else'), 
VALUES(93, 111, 'Neon Cactus'), 
VALUES(94, 111, 'The Pint'),
VALUES(95, 112, 'Vault'), 
VALUES(96, 112, 'Blind Pig'),
VALUES(97, 112, 'Black Sparrow');

CREATE TABLE LOCATION 
(LocationID int,
City varchar2(25), 
State varchar2(25),
CONSTRAINT location_pk PRIMARY KEY(LocationID)
);

INSERT INTO LOCATION
VALUES(111, 'West Lafayette', 'IN'), 
(112, 'Lafayette', 'IN');

CREATE TABLE PERSON 
(PersonID int, 
PersonName Varchar2(50), 
Weight decimal, 
Sex int, 
DesiredDrunkness int, 
HowLongDrinking decimal, 
IsLegal int, 
PrefDrink Varchar2(25), 
CONSTRAINT person_pk PRIMARY KEY(PersonID)
);
