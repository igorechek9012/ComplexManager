create table GM_Geozone (
	uuid_ VARCHAR(75) null,
	geozoneId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null,
	name VARCHAR(75) null,
	area VARCHAR(75) null,
	calendarId LONG,
	description VARCHAR(75) null,
	geozoneAttributes VARCHAR(75) null
);