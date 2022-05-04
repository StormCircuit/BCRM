
CREATE TABLE BCRM.staff (
                staff_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                role VARCHAR NOT NULL,
                CONSTRAINT staff_pk PRIMARY KEY (staff_id)
);


CREATE TABLE BCRM.report (
                report_id INTEGER NOT NULL,
                month VARCHAR NOT NULL,
                revenue DOUBLE PRECISION NOT NULL,
                staff_id INTEGER NOT NULL,
                CONSTRAINT report_pk PRIMARY KEY (report_id)
);
COMMENT ON COLUMN BCRM.report.revenue IS 'attribute is dynamically calculated';


CREATE TABLE BCRM.activity (
                activity_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                price DOUBLE PRECISION NOT NULL,
                staff_id INTEGER NOT NULL,
                CONSTRAINT activity_pk PRIMARY KEY (activity_id)
);


CREATE TABLE BCRM.customer (
                bronco_id INTEGER NOT NULL,
                name VARCHAR NOT NULL,
                DOB DATE NOT NULL,
                phone VARCHAR NOT NULL,
                address VARCHAR NOT NULL,
                CONSTRAINT bronco_id PRIMARY KEY (bronco_id)
);


CREATE TABLE BCRM.order (
                order_id INTEGER NOT NULL,
                date DATE NOT NULL,
                time TIME NOT NULL,
                total_price DOUBLE PRECISION NOT NULL,
                bronco_id INTEGER NOT NULL,
                CONSTRAINT order_pk PRIMARY KEY (order_id)
);
COMMENT ON COLUMN BCRM.order.total_price IS 'attribute is dynamically calculated';


CREATE TABLE BCRM.contains (
                activity_id INTEGER NOT NULL,
                order_id INTEGER NOT NULL,
                CONSTRAINT contains_pk PRIMARY KEY (activity_id, order_id)
);


ALTER TABLE BCRM.activity ADD CONSTRAINT staff_activity_fk
FOREIGN KEY (staff_id)
REFERENCES BCRM.staff (staff_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE BCRM.report ADD CONSTRAINT staff_report_fk
FOREIGN KEY (staff_id)
REFERENCES BCRM.staff (staff_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE BCRM.contains ADD CONSTRAINT activity_creates_fk
FOREIGN KEY (activity_id)
REFERENCES BCRM.activity (activity_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE BCRM.order ADD CONSTRAINT customer_order_fk
FOREIGN KEY (bronco_id)
REFERENCES BCRM.customer (bronco_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE BCRM.contains ADD CONSTRAINT order_creates_fk
FOREIGN KEY (order_id)
REFERENCES BCRM.order (order_id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;
