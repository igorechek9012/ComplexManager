create index IX_156B711E on GM_Geozone (geozoneId);
create index IX_58D1C120 on GM_Geozone (groupId);
create index IX_71DDA3E on GM_Geozone (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_FE33D840 on GM_Geozone (uuid_[$COLUMN_LENGTH:75$], groupId);