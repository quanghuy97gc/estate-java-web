use estatejdbc82019;

CREATE TABLE role(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NOT NULL,
    code VARCHAR(255) NOT NULL,
    
    createdDate DATETIME NULL,
    modifiedDate DATETIME NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);
	
CREATE TABLE user(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(255) NULL,
    status INT NOT NULL,
    
    createdDate DATETIME NULL,
    modifiedDate DATETIME NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE user_role(
	id bigint NOT NULL PRIMARY KEY auto_increment,
	userid bigint NOT NULL,
    roleid bigint NOT NULL
);

ALTER TABLE user_role ADD CONSTRAINT fk_userrole_role FOREIGN KEY (roleid) REFERENCES role(id);
ALTER TABLE user_role ADD CONSTRAINT fk_userrole_user FOREIGN KEY (userid) REFERENCES user(id);

CREATE TABLE building(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    name VARCHAR(255) NULL,
	numberofbasement INT NULL,
    buildingarea INT NULL,
    district VARCHAR(100) NULL,
    ward VARCHAR(100) NULL,
    street VARCHAR(100) NULL,
    structure VARCHAR(100) NULL,
    costrent INT NULL,
    costdescription TEXT NULL,
    servicecost VARCHAR(255) NULL,
    carcost VARCHAR(255) NULL,
    motorbikecost VARCHAR(255) NULL,
    overtimecost VARCHAR(255) NULL,
    electricitycost VARCHAR(255) NULL,
    deposit VARCHAR(255) NULL,
    payment VARCHAR(255) NULL,
    timerent VARCHAR(255) NULL,
    timedecorator VARCHAR(255) NULL,
    managername VARCHAR(255) NULL,
    managerphone VARCHAR(255) NULL,
    type TEXT NULL,
    
    createdDate DATETIME NULL,
    modifiedDate DATETIME NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

CREATE TABLE assignmentstaff(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    buildingid bigint NOT NULL,
    userid bigint NOT NULL
);

ALTER TABLE assignmentstaff ADD CONSTRAINT fk_assignmentstaff_building FOREIGN KEY (buildingid) REFERENCES building(id);
ALTER TABLE assignmentstaff ADD CONSTRAINT fk_assignmentstaff_user FOREIGN KEY (userid) REFERENCES user(id);

CREATE TABLE rentarea(
	id bigint NOT NULL PRIMARY KEY auto_increment,
    value INT NULL,
    buildingid bigint NOT NULL,
    
    createdDate DATETIME NULL,
    modifiedDate DATETIME NULL,
    createdBy VARCHAR(255) NULL,
    modifiedBy VARCHAR(255) NULL
);

ALTER TABLE rentarea ADD CONSTRAINT fk_rentarea_building FOREIGN KEY (buildingid) REFERENCES building(id);