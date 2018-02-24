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

package com.bmstu.geofence.manager.core.service.impl;

import java.util.Date;
import java.util.List;

import com.bmstu.geofence.manager.core.model.Geozone;
import com.bmstu.geofence.manager.core.service.base.GeozoneLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;

/**
 * The implementation of the geozone local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.bmstu.geofence.manager.core.service.GeozoneLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Ershov
 * @see GeozoneLocalServiceBaseImpl
 * @see com.bmstu.geofence.manager.core.service.GeozoneLocalServiceUtil
 */
public class GeozoneLocalServiceImpl extends GeozoneLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.bmstu.geofence.manager.core.service.GeozoneLocalServiceUtil} to access the geozone local service.
	 */
	
	@Override
	public Geozone addGeozone(long userId, String name, String description, String area, long calendarId,
			String geozoneAttributes, ServiceContext serviceContext) throws PortalException {
		String finalName = nullToEmpty(name);
		String finalDescription = nullToEmpty(description);
		String finalArea = nullToEmpty(area);
		String finalGeozoneAttributes = nullToEmpty(geozoneAttributes);

		long groupId = serviceContext.getScopeGroupId();
		User user = userLocalService.getUserById(userId);
		Date currentDate = new Date();

		Geozone geozone = geozonePersistence.create(counterLocalService.increment());

		geozone.setUuid(serviceContext.getUuid());
		geozone.setUserId(userId);
		geozone.setGroupId(groupId);
		geozone.setCompanyId(user.getCompanyId());
		geozone.setUserName(user.getFullName());
		geozone.setCreateDate(serviceContext.getCreateDate(currentDate));
		geozone.setModifiedDate(serviceContext.getModifiedDate(currentDate));
		geozone.setName(finalName);
		geozone.setDescription(finalDescription);
		geozone.setArea(finalArea);
		geozone.setCalendarId(calendarId);
		geozone.setGeozoneAttributes(finalGeozoneAttributes);
		geozone.setExpandoBridgeAttributes(serviceContext);

		geozonePersistence.update(geozone);

		return geozone;
	}

	@Override
	public List<Geozone> getGeofence(long groupId, int start, int end) {

		return geozonePersistence.findByGroupId(groupId, start, end);
	}

	@Override
	public int getGeofenceCount() {
		return geozonePersistence.countAll();
	}

	private String nullToEmpty(String string) {
		return string == null ? "" : string;
	}
}