insert into LOCATION_MASTER (locationId, parentLocationId, area, code, latitude, longitude) values (101, 101, 'Hyderabad', 'HYD', '20.385181', '72.911453');
insert into REPORT_CATEGORY (categoryId, reportCategory) values (101, 'Population');
insert into REPORT_ASSOCIATION (categoryId, locationId, reportId, categoryField, categoryValue) values (101, 101, 101, 'No. of Persons', '20890');