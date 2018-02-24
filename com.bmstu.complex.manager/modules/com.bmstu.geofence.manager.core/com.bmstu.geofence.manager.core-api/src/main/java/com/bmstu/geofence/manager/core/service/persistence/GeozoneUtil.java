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

package com.bmstu.geofence.manager.core.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.bmstu.geofence.manager.core.model.Geozone;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the geozone service. This utility wraps {@link com.bmstu.geofence.manager.core.service.persistence.impl.GeozonePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ershov
 * @see GeozonePersistence
 * @see com.bmstu.geofence.manager.core.service.persistence.impl.GeozonePersistenceImpl
 * @generated
 */
@ProviderType
public class GeozoneUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Geozone geozone) {
		getPersistence().clearCache(geozone);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Geozone> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Geozone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Geozone> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Geozone update(Geozone geozone) {
		return getPersistence().update(geozone);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Geozone update(Geozone geozone, ServiceContext serviceContext) {
		return getPersistence().update(geozone, serviceContext);
	}

	/**
	* Returns all the geozones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching geozones
	*/
	public static List<Geozone> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the geozones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @return the range of matching geozones
	*/
	public static List<Geozone> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the geozones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Geozone> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the geozones where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByUuid_First(java.lang.String uuid,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the geozones before and after the current geozone in the ordered set where uuid = &#63;.
	*
	* @param geozoneId the primary key of the current geozone
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public static Geozone[] findByUuid_PrevAndNext(long geozoneId,
		java.lang.String uuid, OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByUuid_PrevAndNext(geozoneId, uuid, orderByComparator);
	}

	/**
	* Removes all the geozones where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of geozones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching geozones
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the geozone where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchGeozoneException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByUUID_G(java.lang.String uuid, long groupId)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the geozone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the geozone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the geozone where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the geozone that was removed
	*/
	public static Geozone removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of geozones where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching geozones
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the geozones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching geozones
	*/
	public static List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the geozones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @return the range of matching geozones
	*/
	public static List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the geozones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the geozones where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the geozones before and after the current geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param geozoneId the primary key of the current geozone
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public static Geozone[] findByUuid_C_PrevAndNext(long geozoneId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(geozoneId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the geozones where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of geozones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching geozones
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the geozones where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching geozones
	*/
	public static List<Geozone> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the geozones where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @return the range of matching geozones
	*/
	public static List<Geozone> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the geozones where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the geozones where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByGroupId_First(long groupId,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByGroupId_First(long groupId,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByGroupId_Last(long groupId,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByGroupId_Last(long groupId,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the geozones before and after the current geozone in the ordered set where groupId = &#63;.
	*
	* @param geozoneId the primary key of the current geozone
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public static Geozone[] findByGroupId_PrevAndNext(long geozoneId,
		long groupId, OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(geozoneId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the geozones where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of geozones where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching geozones
	*/
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the geozones where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @return the matching geozones
	*/
	public static List<Geozone> findByGeozoneId(long geozoneId) {
		return getPersistence().findByGeozoneId(geozoneId);
	}

	/**
	* Returns a range of all the geozones where geozoneId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param geozoneId the geozone ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @return the range of matching geozones
	*/
	public static List<Geozone> findByGeozoneId(long geozoneId, int start,
		int end) {
		return getPersistence().findByGeozoneId(geozoneId, start, end);
	}

	/**
	* Returns an ordered range of all the geozones where geozoneId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param geozoneId the geozone ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByGeozoneId(long geozoneId, int start,
		int end, OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .findByGeozoneId(geozoneId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the geozones where geozoneId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param geozoneId the geozone ID
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching geozones
	*/
	public static List<Geozone> findByGeozoneId(long geozoneId, int start,
		int end, OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByGeozoneId(geozoneId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByGeozoneId_First(long geozoneId,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByGeozoneId_First(geozoneId, orderByComparator);
	}

	/**
	* Returns the first geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByGeozoneId_First(long geozoneId,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .fetchByGeozoneId_First(geozoneId, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public static Geozone findByGeozoneId_Last(long geozoneId,
		OrderByComparator<Geozone> orderByComparator)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence()
				   .findByGeozoneId_Last(geozoneId, orderByComparator);
	}

	/**
	* Returns the last geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public static Geozone fetchByGeozoneId_Last(long geozoneId,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence()
				   .fetchByGeozoneId_Last(geozoneId, orderByComparator);
	}

	/**
	* Removes all the geozones where geozoneId = &#63; from the database.
	*
	* @param geozoneId the geozone ID
	*/
	public static void removeByGeozoneId(long geozoneId) {
		getPersistence().removeByGeozoneId(geozoneId);
	}

	/**
	* Returns the number of geozones where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @return the number of matching geozones
	*/
	public static int countByGeozoneId(long geozoneId) {
		return getPersistence().countByGeozoneId(geozoneId);
	}

	/**
	* Caches the geozone in the entity cache if it is enabled.
	*
	* @param geozone the geozone
	*/
	public static void cacheResult(Geozone geozone) {
		getPersistence().cacheResult(geozone);
	}

	/**
	* Caches the geozones in the entity cache if it is enabled.
	*
	* @param geozones the geozones
	*/
	public static void cacheResult(List<Geozone> geozones) {
		getPersistence().cacheResult(geozones);
	}

	/**
	* Creates a new geozone with the primary key. Does not add the geozone to the database.
	*
	* @param geozoneId the primary key for the new geozone
	* @return the new geozone
	*/
	public static Geozone create(long geozoneId) {
		return getPersistence().create(geozoneId);
	}

	/**
	* Removes the geozone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone that was removed
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public static Geozone remove(long geozoneId)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().remove(geozoneId);
	}

	public static Geozone updateImpl(Geozone geozone) {
		return getPersistence().updateImpl(geozone);
	}

	/**
	* Returns the geozone with the primary key or throws a {@link NoSuchGeozoneException} if it could not be found.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public static Geozone findByPrimaryKey(long geozoneId)
		throws com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException {
		return getPersistence().findByPrimaryKey(geozoneId);
	}

	/**
	* Returns the geozone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone, or <code>null</code> if a geozone with the primary key could not be found
	*/
	public static Geozone fetchByPrimaryKey(long geozoneId) {
		return getPersistence().fetchByPrimaryKey(geozoneId);
	}

	public static java.util.Map<java.io.Serializable, Geozone> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the geozones.
	*
	* @return the geozones
	*/
	public static List<Geozone> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the geozones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @return the range of geozones
	*/
	public static List<Geozone> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the geozones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of geozones
	*/
	public static List<Geozone> findAll(int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the geozones.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link GeozoneModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of geozones
	* @param end the upper bound of the range of geozones (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of geozones
	*/
	public static List<Geozone> findAll(int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the geozones from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of geozones.
	*
	* @return the number of geozones
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static GeozonePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<GeozonePersistence, GeozonePersistence> _serviceTracker =
		ServiceTrackerFactory.open(GeozonePersistence.class);
}