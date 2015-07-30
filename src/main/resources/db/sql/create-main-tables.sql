-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2015-07-29 12:04:56.058




-- sequences
-- Sequence: categoryId
-- 


CREATE SEQUENCE categoryId
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;


-- Sequence: locationId
-- 


CREATE SEQUENCE locationId
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;


-- Sequence: reportId
-- 


CREATE SEQUENCE reportId
      INCREMENT BY 1
      NO MINVALUE
      NO MAXVALUE
      START WITH 1
      NO CYCLE
;


-- Table: LOCATION_MASTER
CREATE TABLE LOCATION_MASTER (
    locationId int  NOT NULL,
    parentLocationId int  NOT NULL,
    area varchar(50)  NOT NULL,
    code varchar(10)  NOT NULL,
    latitude varchar(20)  NOT NULL,
    longitude varchar(20)  NOT NULL,
   CONSTRAINT LOCATION_MASTER_pk PRIMARY KEY (locationId)
);

CREATE INDEX LocationMaster_idx_1 on LOCATION_MASTER (area ASC);



-- Table: REPORT_ASSOCIATION
CREATE TABLE REPORT_ASSOCIATION (
    categoryField varchar(20)  NOT NULL,
    categoryValue varchar(20)  NOT NULL,
    reportId int  NOT NULL,
    categoryId int  NOT NULL,
    locationId int  NOT NULL,
   CONSTRAINT REPORT_ASSOCIATION_pk PRIMARY KEY (reportId)
);

-- Table: REPORT_CATEGORY
CREATE TABLE REPORT_CATEGORY (
    reportCategory varchar(100)  NOT NULL,
    categoryId int  NOT NULL,
   CONSTRAINT REPORT_CATEGORY_pk PRIMARY KEY (categoryId)
);





-- foreign keys

-- Reference:  REPORT_ASSOCIATION_LOCATION_MASTER (table: REPORT_ASSOCIATION)


ALTER TABLE REPORT_ASSOCIATION ADD CONSTRAINT REPORT_ASSOCIATION_LOCATION_MASTER 
    FOREIGN KEY (locationId)
    REFERENCES LOCATION_MASTER (locationId)
;

-- Reference:  REPORT_ASSOCIATION_REPORT_CATEGORY (table: REPORT_ASSOCIATION)


ALTER TABLE REPORT_ASSOCIATION ADD CONSTRAINT REPORT_ASSOCIATION_REPORT_CATEGORY 
    FOREIGN KEY (categoryId)
    REFERENCES REPORT_CATEGORY (categoryId)
;





-- End of file.

