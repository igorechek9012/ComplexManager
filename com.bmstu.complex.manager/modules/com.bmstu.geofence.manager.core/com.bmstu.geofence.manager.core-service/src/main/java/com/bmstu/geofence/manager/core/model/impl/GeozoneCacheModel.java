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

package com.bmstu.geofence.manager.core.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.bmstu.geofence.manager.core.model.Geozone;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Geozone in entity cache.
 *
 * @author Ershov
 * @see Geozone
 * @generated
 */
@ProviderType
public class GeozoneCacheModel implements CacheModel<Geozone>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GeozoneCacheModel)) {
			return false;
		}

		GeozoneCacheModel geozoneCacheModel = (GeozoneCacheModel)obj;

		if (geozoneId == geozoneCacheModel.geozoneId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, geozoneId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", geozoneId=");
		sb.append(geozoneId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", area=");
		sb.append(area);
		sb.append(", calendarId=");
		sb.append(calendarId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", geozoneAttributes=");
		sb.append(geozoneAttributes);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Geozone toEntityModel() {
		GeozoneImpl geozoneImpl = new GeozoneImpl();

		if (uuid == null) {
			geozoneImpl.setUuid(StringPool.BLANK);
		}
		else {
			geozoneImpl.setUuid(uuid);
		}

		geozoneImpl.setGeozoneId(geozoneId);
		geozoneImpl.setGroupId(groupId);
		geozoneImpl.setCompanyId(companyId);
		geozoneImpl.setUserId(userId);

		if (userName == null) {
			geozoneImpl.setUserName(StringPool.BLANK);
		}
		else {
			geozoneImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			geozoneImpl.setCreateDate(null);
		}
		else {
			geozoneImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			geozoneImpl.setModifiedDate(null);
		}
		else {
			geozoneImpl.setModifiedDate(new Date(modifiedDate));
		}

		geozoneImpl.setStatus(status);
		geozoneImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			geozoneImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			geozoneImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			geozoneImpl.setStatusDate(null);
		}
		else {
			geozoneImpl.setStatusDate(new Date(statusDate));
		}

		if (name == null) {
			geozoneImpl.setName(StringPool.BLANK);
		}
		else {
			geozoneImpl.setName(name);
		}

		if (area == null) {
			geozoneImpl.setArea(StringPool.BLANK);
		}
		else {
			geozoneImpl.setArea(area);
		}

		geozoneImpl.setCalendarId(calendarId);

		if (description == null) {
			geozoneImpl.setDescription(StringPool.BLANK);
		}
		else {
			geozoneImpl.setDescription(description);
		}

		if (geozoneAttributes == null) {
			geozoneImpl.setGeozoneAttributes(StringPool.BLANK);
		}
		else {
			geozoneImpl.setGeozoneAttributes(geozoneAttributes);
		}

		geozoneImpl.resetOriginalValues();

		return geozoneImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		geozoneId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		name = objectInput.readUTF();
		area = objectInput.readUTF();

		calendarId = objectInput.readLong();
		description = objectInput.readUTF();
		geozoneAttributes = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(geozoneId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (area == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(area);
		}

		objectOutput.writeLong(calendarId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (geozoneAttributes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(geozoneAttributes);
		}
	}

	public String uuid;
	public long geozoneId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String name;
	public String area;
	public long calendarId;
	public String description;
	public String geozoneAttributes;
}