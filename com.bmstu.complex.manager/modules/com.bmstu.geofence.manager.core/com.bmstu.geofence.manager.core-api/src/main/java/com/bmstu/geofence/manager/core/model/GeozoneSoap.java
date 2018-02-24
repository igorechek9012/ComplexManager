/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.bmstu.geofence.manager.core.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.bmstu.geofence.manager.core.service.http.GeozoneServiceSoap}.
 *
 * @author Ershov
 * @see com.bmstu.geofence.manager.core.service.http.GeozoneServiceSoap
 * @generated
 */
@ProviderType
public class GeozoneSoap implements Serializable {
	public static GeozoneSoap toSoapModel(Geozone model) {
		GeozoneSoap soapModel = new GeozoneSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setGeozoneId(model.getGeozoneId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setName(model.getName());
		soapModel.setArea(model.getArea());
		soapModel.setCalendarId(model.getCalendarId());
		soapModel.setDescription(model.getDescription());
		soapModel.setGeozoneAttributes(model.getGeozoneAttributes());

		return soapModel;
	}

	public static GeozoneSoap[] toSoapModels(Geozone[] models) {
		GeozoneSoap[] soapModels = new GeozoneSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GeozoneSoap[][] toSoapModels(Geozone[][] models) {
		GeozoneSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GeozoneSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GeozoneSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GeozoneSoap[] toSoapModels(List<Geozone> models) {
		List<GeozoneSoap> soapModels = new ArrayList<GeozoneSoap>(models.size());

		for (Geozone model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GeozoneSoap[soapModels.size()]);
	}

	public GeozoneSoap() {
	}

	public long getPrimaryKey() {
		return _geozoneId;
	}

	public void setPrimaryKey(long pk) {
		setGeozoneId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getGeozoneId() {
		return _geozoneId;
	}

	public void setGeozoneId(long geozoneId) {
		_geozoneId = geozoneId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getArea() {
		return _area;
	}

	public void setArea(String area) {
		_area = area;
	}

	public long getCalendarId() {
		return _calendarId;
	}

	public void setCalendarId(long calendarId) {
		_calendarId = calendarId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getGeozoneAttributes() {
		return _geozoneAttributes;
	}

	public void setGeozoneAttributes(String geozoneAttributes) {
		_geozoneAttributes = geozoneAttributes;
	}

	private String _uuid;
	private long _geozoneId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _name;
	private String _area;
	private long _calendarId;
	private String _description;
	private String _geozoneAttributes;
}