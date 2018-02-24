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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Geozone}.
 * </p>
 *
 * @author Ershov
 * @see Geozone
 * @generated
 */
@ProviderType
public class GeozoneWrapper implements Geozone, ModelWrapper<Geozone> {
	public GeozoneWrapper(Geozone geozone) {
		_geozone = geozone;
	}

	@Override
	public Class<?> getModelClass() {
		return Geozone.class;
	}

	@Override
	public String getModelClassName() {
		return Geozone.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("geozoneId", getGeozoneId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("name", getName());
		attributes.put("area", getArea());
		attributes.put("calendarId", getCalendarId());
		attributes.put("description", getDescription());
		attributes.put("geozoneAttributes", getGeozoneAttributes());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long geozoneId = (Long)attributes.get("geozoneId");

		if (geozoneId != null) {
			setGeozoneId(geozoneId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String area = (String)attributes.get("area");

		if (area != null) {
			setArea(area);
		}

		Long calendarId = (Long)attributes.get("calendarId");

		if (calendarId != null) {
			setCalendarId(calendarId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String geozoneAttributes = (String)attributes.get("geozoneAttributes");

		if (geozoneAttributes != null) {
			setGeozoneAttributes(geozoneAttributes);
		}
	}

	@Override
	public Geozone toEscapedModel() {
		return new GeozoneWrapper(_geozone.toEscapedModel());
	}

	@Override
	public Geozone toUnescapedModel() {
		return new GeozoneWrapper(_geozone.toUnescapedModel());
	}

	/**
	* Returns <code>true</code> if this geozone is approved.
	*
	* @return <code>true</code> if this geozone is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _geozone.isApproved();
	}

	@Override
	public boolean isCachedModel() {
		return _geozone.isCachedModel();
	}

	/**
	* Returns <code>true</code> if this geozone is denied.
	*
	* @return <code>true</code> if this geozone is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _geozone.isDenied();
	}

	/**
	* Returns <code>true</code> if this geozone is a draft.
	*
	* @return <code>true</code> if this geozone is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _geozone.isDraft();
	}

	@Override
	public boolean isEscapedModel() {
		return _geozone.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this geozone is expired.
	*
	* @return <code>true</code> if this geozone is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _geozone.isExpired();
	}

	/**
	* Returns <code>true</code> if this geozone is inactive.
	*
	* @return <code>true</code> if this geozone is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _geozone.isInactive();
	}

	/**
	* Returns <code>true</code> if this geozone is incomplete.
	*
	* @return <code>true</code> if this geozone is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _geozone.isIncomplete();
	}

	@Override
	public boolean isNew() {
		return _geozone.isNew();
	}

	/**
	* Returns <code>true</code> if this geozone is pending.
	*
	* @return <code>true</code> if this geozone is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _geozone.isPending();
	}

	/**
	* Returns <code>true</code> if this geozone is scheduled.
	*
	* @return <code>true</code> if this geozone is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _geozone.isScheduled();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _geozone.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Geozone> toCacheModel() {
		return _geozone.toCacheModel();
	}

	@Override
	public int compareTo(Geozone geozone) {
		return _geozone.compareTo(geozone);
	}

	/**
	* Returns the status of this geozone.
	*
	* @return the status of this geozone
	*/
	@Override
	public int getStatus() {
		return _geozone.getStatus();
	}

	@Override
	public int hashCode() {
		return _geozone.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _geozone.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new GeozoneWrapper((Geozone)_geozone.clone());
	}

	/**
	* Returns the area of this geozone.
	*
	* @return the area of this geozone
	*/
	@Override
	public java.lang.String getArea() {
		return _geozone.getArea();
	}

	/**
	* Returns the description of this geozone.
	*
	* @return the description of this geozone
	*/
	@Override
	public java.lang.String getDescription() {
		return _geozone.getDescription();
	}

	/**
	* Returns the geozone attributes of this geozone.
	*
	* @return the geozone attributes of this geozone
	*/
	@Override
	public java.lang.String getGeozoneAttributes() {
		return _geozone.getGeozoneAttributes();
	}

	/**
	* Returns the name of this geozone.
	*
	* @return the name of this geozone
	*/
	@Override
	public java.lang.String getName() {
		return _geozone.getName();
	}

	/**
	* Returns the status by user name of this geozone.
	*
	* @return the status by user name of this geozone
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _geozone.getStatusByUserName();
	}

	/**
	* Returns the status by user uuid of this geozone.
	*
	* @return the status by user uuid of this geozone
	*/
	@Override
	public java.lang.String getStatusByUserUuid() {
		return _geozone.getStatusByUserUuid();
	}

	/**
	* Returns the user name of this geozone.
	*
	* @return the user name of this geozone
	*/
	@Override
	public java.lang.String getUserName() {
		return _geozone.getUserName();
	}

	/**
	* Returns the user uuid of this geozone.
	*
	* @return the user uuid of this geozone
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _geozone.getUserUuid();
	}

	/**
	* Returns the uuid of this geozone.
	*
	* @return the uuid of this geozone
	*/
	@Override
	public java.lang.String getUuid() {
		return _geozone.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _geozone.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _geozone.toXmlString();
	}

	/**
	* Returns the create date of this geozone.
	*
	* @return the create date of this geozone
	*/
	@Override
	public Date getCreateDate() {
		return _geozone.getCreateDate();
	}

	/**
	* Returns the modified date of this geozone.
	*
	* @return the modified date of this geozone
	*/
	@Override
	public Date getModifiedDate() {
		return _geozone.getModifiedDate();
	}

	/**
	* Returns the status date of this geozone.
	*
	* @return the status date of this geozone
	*/
	@Override
	public Date getStatusDate() {
		return _geozone.getStatusDate();
	}

	/**
	* Returns the calendar ID of this geozone.
	*
	* @return the calendar ID of this geozone
	*/
	@Override
	public long getCalendarId() {
		return _geozone.getCalendarId();
	}

	/**
	* Returns the company ID of this geozone.
	*
	* @return the company ID of this geozone
	*/
	@Override
	public long getCompanyId() {
		return _geozone.getCompanyId();
	}

	/**
	* Returns the geozone ID of this geozone.
	*
	* @return the geozone ID of this geozone
	*/
	@Override
	public long getGeozoneId() {
		return _geozone.getGeozoneId();
	}

	/**
	* Returns the group ID of this geozone.
	*
	* @return the group ID of this geozone
	*/
	@Override
	public long getGroupId() {
		return _geozone.getGroupId();
	}

	/**
	* Returns the primary key of this geozone.
	*
	* @return the primary key of this geozone
	*/
	@Override
	public long getPrimaryKey() {
		return _geozone.getPrimaryKey();
	}

	/**
	* Returns the status by user ID of this geozone.
	*
	* @return the status by user ID of this geozone
	*/
	@Override
	public long getStatusByUserId() {
		return _geozone.getStatusByUserId();
	}

	/**
	* Returns the user ID of this geozone.
	*
	* @return the user ID of this geozone
	*/
	@Override
	public long getUserId() {
		return _geozone.getUserId();
	}

	@Override
	public void persist() {
		_geozone.persist();
	}

	/**
	* Sets the area of this geozone.
	*
	* @param area the area of this geozone
	*/
	@Override
	public void setArea(java.lang.String area) {
		_geozone.setArea(area);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_geozone.setCachedModel(cachedModel);
	}

	/**
	* Sets the calendar ID of this geozone.
	*
	* @param calendarId the calendar ID of this geozone
	*/
	@Override
	public void setCalendarId(long calendarId) {
		_geozone.setCalendarId(calendarId);
	}

	/**
	* Sets the company ID of this geozone.
	*
	* @param companyId the company ID of this geozone
	*/
	@Override
	public void setCompanyId(long companyId) {
		_geozone.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this geozone.
	*
	* @param createDate the create date of this geozone
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_geozone.setCreateDate(createDate);
	}

	/**
	* Sets the description of this geozone.
	*
	* @param description the description of this geozone
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_geozone.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_geozone.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_geozone.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_geozone.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the geozone attributes of this geozone.
	*
	* @param geozoneAttributes the geozone attributes of this geozone
	*/
	@Override
	public void setGeozoneAttributes(java.lang.String geozoneAttributes) {
		_geozone.setGeozoneAttributes(geozoneAttributes);
	}

	/**
	* Sets the geozone ID of this geozone.
	*
	* @param geozoneId the geozone ID of this geozone
	*/
	@Override
	public void setGeozoneId(long geozoneId) {
		_geozone.setGeozoneId(geozoneId);
	}

	/**
	* Sets the group ID of this geozone.
	*
	* @param groupId the group ID of this geozone
	*/
	@Override
	public void setGroupId(long groupId) {
		_geozone.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this geozone.
	*
	* @param modifiedDate the modified date of this geozone
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_geozone.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this geozone.
	*
	* @param name the name of this geozone
	*/
	@Override
	public void setName(java.lang.String name) {
		_geozone.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_geozone.setNew(n);
	}

	/**
	* Sets the primary key of this geozone.
	*
	* @param primaryKey the primary key of this geozone
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_geozone.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_geozone.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the status of this geozone.
	*
	* @param status the status of this geozone
	*/
	@Override
	public void setStatus(int status) {
		_geozone.setStatus(status);
	}

	/**
	* Sets the status by user ID of this geozone.
	*
	* @param statusByUserId the status by user ID of this geozone
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_geozone.setStatusByUserId(statusByUserId);
	}

	/**
	* Sets the status by user name of this geozone.
	*
	* @param statusByUserName the status by user name of this geozone
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_geozone.setStatusByUserName(statusByUserName);
	}

	/**
	* Sets the status by user uuid of this geozone.
	*
	* @param statusByUserUuid the status by user uuid of this geozone
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_geozone.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Sets the status date of this geozone.
	*
	* @param statusDate the status date of this geozone
	*/
	@Override
	public void setStatusDate(Date statusDate) {
		_geozone.setStatusDate(statusDate);
	}

	/**
	* Sets the user ID of this geozone.
	*
	* @param userId the user ID of this geozone
	*/
	@Override
	public void setUserId(long userId) {
		_geozone.setUserId(userId);
	}

	/**
	* Sets the user name of this geozone.
	*
	* @param userName the user name of this geozone
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_geozone.setUserName(userName);
	}

	/**
	* Sets the user uuid of this geozone.
	*
	* @param userUuid the user uuid of this geozone
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_geozone.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this geozone.
	*
	* @param uuid the uuid of this geozone
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_geozone.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeozoneWrapper)) {
			return false;
		}

		GeozoneWrapper geozoneWrapper = (GeozoneWrapper)obj;

		if (Objects.equals(_geozone, geozoneWrapper._geozone)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _geozone.getStagedModelType();
	}

	@Override
	public Geozone getWrappedModel() {
		return _geozone;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _geozone.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _geozone.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_geozone.resetOriginalValues();
	}

	private final Geozone _geozone;
}