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

import com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException;
import com.bmstu.geofence.manager.core.model.Geozone;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the geozone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ershov
 * @see com.bmstu.geofence.manager.core.service.persistence.impl.GeozonePersistenceImpl
 * @see GeozoneUtil
 * @generated
 */
@ProviderType
public interface GeozonePersistence extends BasePersistence<Geozone> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GeozoneUtil} to access the geozone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the geozones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching geozones
	*/
	public java.util.List<Geozone> findByUuid(java.lang.String uuid);

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
	public java.util.List<Geozone> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Geozone> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

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
	public java.util.List<Geozone> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the first geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Returns the last geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the last geozone in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Returns the geozones before and after the current geozone in the ordered set where uuid = &#63;.
	*
	* @param geozoneId the primary key of the current geozone
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public Geozone[] findByUuid_PrevAndNext(long geozoneId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Removes all the geozones where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of geozones where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching geozones
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the geozone where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchGeozoneException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchGeozoneException;

	/**
	* Returns the geozone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the geozone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the geozone where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the geozone that was removed
	*/
	public Geozone removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchGeozoneException;

	/**
	* Returns the number of geozones where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching geozones
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the geozones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching geozones
	*/
	public java.util.List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

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
	public java.util.List<Geozone> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the first geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Returns the last geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the last geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

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
	public Geozone[] findByUuid_C_PrevAndNext(long geozoneId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Removes all the geozones where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of geozones where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching geozones
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the geozones where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching geozones
	*/
	public java.util.List<Geozone> findByGroupId(long groupId);

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
	public java.util.List<Geozone> findByGroupId(long groupId, int start,
		int end);

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
	public java.util.List<Geozone> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

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
	public java.util.List<Geozone> findByGroupId(long groupId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the first geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByGroupId_First(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Returns the last geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the last geozone in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByGroupId_Last(long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Returns the geozones before and after the current geozone in the ordered set where groupId = &#63;.
	*
	* @param geozoneId the primary key of the current geozone
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public Geozone[] findByGroupId_PrevAndNext(long geozoneId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Removes all the geozones where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	*/
	public void removeByGroupId(long groupId);

	/**
	* Returns the number of geozones where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching geozones
	*/
	public int countByGroupId(long groupId);

	/**
	* Returns all the geozones where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @return the matching geozones
	*/
	public java.util.List<Geozone> findByGeozoneId(long geozoneId);

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
	public java.util.List<Geozone> findByGeozoneId(long geozoneId, int start,
		int end);

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
	public java.util.List<Geozone> findByGeozoneId(long geozoneId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

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
	public java.util.List<Geozone> findByGeozoneId(long geozoneId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByGeozoneId_First(long geozoneId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the first geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByGeozoneId_First(long geozoneId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Returns the last geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone
	* @throws NoSuchGeozoneException if a matching geozone could not be found
	*/
	public Geozone findByGeozoneId_Last(long geozoneId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException;

	/**
	* Returns the last geozone in the ordered set where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	*/
	public Geozone fetchByGeozoneId_Last(long geozoneId,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

	/**
	* Removes all the geozones where geozoneId = &#63; from the database.
	*
	* @param geozoneId the geozone ID
	*/
	public void removeByGeozoneId(long geozoneId);

	/**
	* Returns the number of geozones where geozoneId = &#63;.
	*
	* @param geozoneId the geozone ID
	* @return the number of matching geozones
	*/
	public int countByGeozoneId(long geozoneId);

	/**
	* Caches the geozone in the entity cache if it is enabled.
	*
	* @param geozone the geozone
	*/
	public void cacheResult(Geozone geozone);

	/**
	* Caches the geozones in the entity cache if it is enabled.
	*
	* @param geozones the geozones
	*/
	public void cacheResult(java.util.List<Geozone> geozones);

	/**
	* Creates a new geozone with the primary key. Does not add the geozone to the database.
	*
	* @param geozoneId the primary key for the new geozone
	* @return the new geozone
	*/
	public Geozone create(long geozoneId);

	/**
	* Removes the geozone with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone that was removed
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public Geozone remove(long geozoneId) throws NoSuchGeozoneException;

	public Geozone updateImpl(Geozone geozone);

	/**
	* Returns the geozone with the primary key or throws a {@link NoSuchGeozoneException} if it could not be found.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone
	* @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	*/
	public Geozone findByPrimaryKey(long geozoneId)
		throws NoSuchGeozoneException;

	/**
	* Returns the geozone with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param geozoneId the primary key of the geozone
	* @return the geozone, or <code>null</code> if a geozone with the primary key could not be found
	*/
	public Geozone fetchByPrimaryKey(long geozoneId);

	@Override
	public java.util.Map<java.io.Serializable, Geozone> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the geozones.
	*
	* @return the geozones
	*/
	public java.util.List<Geozone> findAll();

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
	public java.util.List<Geozone> findAll(int start, int end);

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
	public java.util.List<Geozone> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator);

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
	public java.util.List<Geozone> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the geozones from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of geozones.
	*
	* @return the number of geozones
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}