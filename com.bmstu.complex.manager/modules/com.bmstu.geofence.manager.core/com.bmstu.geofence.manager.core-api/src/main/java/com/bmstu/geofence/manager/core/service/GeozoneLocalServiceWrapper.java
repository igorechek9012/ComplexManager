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

package com.bmstu.geofence.manager.core.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link GeozoneLocalService}.
 *
 * @author Ershov
 * @see GeozoneLocalService
 * @generated
 */
@ProviderType
public class GeozoneLocalServiceWrapper implements GeozoneLocalService,
	ServiceWrapper<GeozoneLocalService> {
	public GeozoneLocalServiceWrapper(GeozoneLocalService geozoneLocalService) {
		_geozoneLocalService = geozoneLocalService;
	}

	/**
	* Adds the geozone to the database. Also notifies the appropriate model listeners.
	*
	* @param geozone the geozone
	* @return the geozone that was added
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone addGeozone(
		com.bmstu.geofence.manager.core.model.Geozone geozone) {
		return _geozoneLocalService.addGeozone(geozone);
	}

	@Override
	public com.bmstu.geofence.manager.core.model.Geozone addGeozone(
		long userId, java.lang.String name, java.lang.String description,
		java.lang.String area, long calendarId,
		java.lang.String geozoneAttributes,
		com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geozoneLocalService.addGeozone(userId, name, description, area,
			calendarId, geozoneAttributes, serviceContext);
	}

	/**
	* Creates a new geozone with the primary key. Does not add the geozone to the database.
	*
	* @param geozoneId the primary key for the new geozone
	* @return the new geozone
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone createGeozone(
		long geozoneId) {
		return _geozoneLocalService.createGeozone(geozoneId);
	}

	/**
	* Deletes the geozone from the database. Also notifies the appropriate model listeners.
	*
	* @param geozone the geozone
	* @return the geozone that was removed
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone deleteGeozone(
		com.bmstu.geofence.manager.core.model.Geozone geozone) {
		return _geozoneLocalService.deleteGeozone(geozone);
	}

	/**
	* Deletes the geozone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone that was removed
	* @throws PortalException if a geozone with the primary key could not be found
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone deleteGeozone(
		long geozoneId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geozoneLocalService.deleteGeozone(geozoneId);
	}

	@Override
	public com.bmstu.geofence.manager.core.model.Geozone fetchGeozone(
		long geozoneId) {
		return _geozoneLocalService.fetchGeozone(geozoneId);
	}

	/**
	* Returns the geozone matching the UUID and group.
	*
	* @param uuid the geozone's UUID
	* @param groupId the primary key of the group
	* @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone fetchGeozoneByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _geozoneLocalService.fetchGeozoneByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the geozone with the primary key.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone
	* @throws PortalException if a geozone with the primary key could not be found
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone getGeozone(
		long geozoneId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geozoneLocalService.getGeozone(geozoneId);
	}

	/**
	* Returns the geozone matching the UUID and group.
	*
	* @param uuid the geozone's UUID
	* @param groupId the primary key of the group
	* @return the matching geozone
	* @throws PortalException if a matching geozone could not be found
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone getGeozoneByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geozoneLocalService.getGeozoneByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the geozone in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param geozone the geozone
	* @return the geozone that was updated
	*/
	@Override
	public com.bmstu.geofence.manager.core.model.Geozone updateGeozone(
		com.bmstu.geofence.manager.core.model.Geozone geozone) {
		return _geozoneLocalService.updateGeozone(geozone);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _geozoneLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _geozoneLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _geozoneLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _geozoneLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geozoneLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _geozoneLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public int getGeofenceCount() {
		return _geozoneLocalService.getGeofenceCount();
	}

	/**
	* Returns the number of geozones.
	*
	* @return the number of geozones
	*/
	@Override
	public int getGeozonesCount() {
		return _geozoneLocalService.getGeozonesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _geozoneLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _geozoneLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.geofence.manager.core.model.impl.GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _geozoneLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.geofence.manager.core.model.impl.GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _geozoneLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.bmstu.geofence.manager.core.model.Geozone> getGeofence(
		long groupId, int start, int end) {
		return _geozoneLocalService.getGeofence(groupId, start, end);
	}

	/**
	* Returns a range of all the geozones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.bmstu.geofence.manager.core.model.impl.GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @return the range of geozones
	*/
	@Override
	public java.util.List<com.bmstu.geofence.manager.core.model.Geozone> getGeozones(
		int start, int end) {
		return _geozoneLocalService.getGeozones(start, end);
	}

	/**
	* Returns all the geozones matching the UUID and company.
	*
	* @param uuid the UUID of the geozones
	* @param companyId the primary key of the company
	* @return the matching geozones, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.bmstu.geofence.manager.core.model.Geozone> getGeozonesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _geozoneLocalService.getGeozonesByUuidAndCompanyId(uuid,
			companyId);
	}

	/**
	* Returns a range of geozones matching the UUID and company.
	*
	* @param uuid the UUID of the geozones
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching geozones, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.bmstu.geofence.manager.core.model.Geozone> getGeozonesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.bmstu.geofence.manager.core.model.Geozone> orderByComparator) {
		return _geozoneLocalService.getGeozonesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _geozoneLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _geozoneLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public GeozoneLocalService getWrappedService() {
		return _geozoneLocalService;
	}

	@Override
	public void setWrappedService(GeozoneLocalService geozoneLocalService) {
		_geozoneLocalService = geozoneLocalService;
	}

	private GeozoneLocalService _geozoneLocalService;
}