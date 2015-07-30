INSERT INTO users VALUES (1, 'mkyong', 'mkyong@gmail.com');
INSERT INTO users VALUES (2, 'alex', 'alex@yahoo.com');
INSERT INTO users VALUES (3, 'joel', 'joel@gmail.com');

insert into LOCATION_MASTER (area, code, latitude, longitude, parentLocationId, locationId) values ('Hyderabad', 'HYD', '20.385181', '72.911453', 1, 1);
insert into REPORT_CATEGORY (reportCategory, categoryId) values ('Accident', 1);
insert into REPORT_ASSOCIATION (categoryId, categoryField, categoryValue, locationId, reportId) values (1, 'No. of Persons', '20890', 1, 1);
