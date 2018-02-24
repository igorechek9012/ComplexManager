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

package com.bmstu.geofence.manager.core.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.bmstu.geofence.manager.core.exception.NoSuchGeozoneException;
import com.bmstu.geofence.manager.core.model.Geozone;
import com.bmstu.geofence.manager.core.model.impl.GeozoneImpl;
import com.bmstu.geofence.manager.core.model.impl.GeozoneModelImpl;
import com.bmstu.geofence.manager.core.service.persistence.GeozonePersistence;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the geozone service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Ershov
 * @see GeozonePersistence
 * @see com.bmstu.geofence.manager.core.service.persistence.GeozoneUtil
 * @generated
 */
@ProviderType
public class GeozonePersistenceImpl extends BasePersistenceImpl<Geozone>
	implements GeozonePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GeozoneUtil} to access the geozone persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GeozoneImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			GeozoneModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the geozones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching geozones
	 */
	@Override
	public List<Geozone> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Geozone> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Geozone> findByUuid(String uuid, int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Geozone> findByUuid(String uuid, int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Geozone> list = null;

		if (retrieveFromCache) {
			list = (List<Geozone>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Geozone geozone : list) {
					if (!Objects.equals(uuid, geozone.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GEOZONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeozoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geozone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByUuid_First(String uuid,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByUuid_First(uuid, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the first geozone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByUuid_First(String uuid,
		OrderByComparator<Geozone> orderByComparator) {
		List<Geozone> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geozone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByUuid_Last(String uuid,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByUuid_Last(uuid, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the last geozone in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByUuid_Last(String uuid,
		OrderByComparator<Geozone> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Geozone> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Geozone[] findByUuid_PrevAndNext(long geozoneId, String uuid,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = findByPrimaryKey(geozoneId);

		Session session = null;

		try {
			session = openSession();

			Geozone[] array = new GeozoneImpl[3];

			array[0] = getByUuid_PrevAndNext(session, geozone, uuid,
					orderByComparator, true);

			array[1] = geozone;

			array[2] = getByUuid_PrevAndNext(session, geozone, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geozone getByUuid_PrevAndNext(Session session, Geozone geozone,
		String uuid, OrderByComparator<Geozone> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOZONE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeozoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geozone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geozone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geozones where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Geozone geozone : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(geozone);
		}
	}

	/**
	 * Returns the number of geozones where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching geozones
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEOZONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "geozone.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "geozone.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(geozone.uuid IS NULL OR geozone.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			GeozoneModelImpl.UUID_COLUMN_BITMASK |
			GeozoneModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the geozone where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchGeozoneException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByUUID_G(String uuid, long groupId)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByUUID_G(uuid, groupId);

		if (geozone == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchGeozoneException(msg.toString());
		}

		return geozone;
	}

	/**
	 * Returns the geozone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the geozone where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Geozone) {
			Geozone geozone = (Geozone)result;

			if (!Objects.equals(uuid, geozone.getUuid()) ||
					(groupId != geozone.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_GEOZONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<Geozone> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Geozone geozone = list.get(0);

					result = geozone;

					cacheResult(geozone);

					if ((geozone.getUuid() == null) ||
							!geozone.getUuid().equals(uuid) ||
							(geozone.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, geozone);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Geozone)result;
		}
	}

	/**
	 * Removes the geozone where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the geozone that was removed
	 */
	@Override
	public Geozone removeByUUID_G(String uuid, long groupId)
		throws NoSuchGeozoneException {
		Geozone geozone = findByUUID_G(uuid, groupId);

		return remove(geozone);
	}

	/**
	 * Returns the number of geozones where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching geozones
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOZONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "geozone.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "geozone.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(geozone.uuid IS NULL OR geozone.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "geozone.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			GeozoneModelImpl.UUID_COLUMN_BITMASK |
			GeozoneModelImpl.COMPANYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the geozones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching geozones
	 */
	@Override
	public List<Geozone> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Geozone> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Geozone> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Geozone> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Geozone> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Geozone> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Geozone> list = null;

		if (retrieveFromCache) {
			list = (List<Geozone>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Geozone geozone : list) {
					if (!Objects.equals(uuid, geozone.getUuid()) ||
							(companyId != geozone.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_GEOZONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeozoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Geozone findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the first geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Geozone> orderByComparator) {
		List<Geozone> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Geozone findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the last geozone in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Geozone> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Geozone> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Geozone[] findByUuid_C_PrevAndNext(long geozoneId, String uuid,
		long companyId, OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = findByPrimaryKey(geozoneId);

		Session session = null;

		try {
			session = openSession();

			Geozone[] array = new GeozoneImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, geozone, uuid,
					companyId, orderByComparator, true);

			array[1] = geozone;

			array[2] = getByUuid_C_PrevAndNext(session, geozone, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geozone getByUuid_C_PrevAndNext(Session session, Geozone geozone,
		String uuid, long companyId,
		OrderByComparator<Geozone> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GEOZONE_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeozoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geozone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geozone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geozones where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Geozone geozone : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(geozone);
		}
	}

	/**
	 * Returns the number of geozones where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching geozones
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GEOZONE_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "geozone.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "geozone.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(geozone.uuid IS NULL OR geozone.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "geozone.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			GeozoneModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the geozones where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching geozones
	 */
	@Override
	public List<Geozone> findByGroupId(long groupId) {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Geozone> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Geozone> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Geozone> findByGroupId(long groupId, int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Geozone> list = null;

		if (retrieveFromCache) {
			list = (List<Geozone>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Geozone geozone : list) {
					if ((groupId != geozone.getGroupId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GEOZONE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeozoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geozone in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByGroupId_First(long groupId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByGroupId_First(groupId, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the first geozone in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByGroupId_First(long groupId,
		OrderByComparator<Geozone> orderByComparator) {
		List<Geozone> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geozone in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByGroupId_Last(long groupId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByGroupId_Last(groupId, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the last geozone in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByGroupId_Last(long groupId,
		OrderByComparator<Geozone> orderByComparator) {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Geozone> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Geozone[] findByGroupId_PrevAndNext(long geozoneId, long groupId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = findByPrimaryKey(geozoneId);

		Session session = null;

		try {
			session = openSession();

			Geozone[] array = new GeozoneImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, geozone, groupId,
					orderByComparator, true);

			array[1] = geozone;

			array[2] = getByGroupId_PrevAndNext(session, geozone, groupId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Geozone getByGroupId_PrevAndNext(Session session,
		Geozone geozone, long groupId,
		OrderByComparator<Geozone> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GEOZONE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(GeozoneModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(geozone);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Geozone> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the geozones where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Geozone geozone : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(geozone);
		}
	}

	/**
	 * Returns the number of geozones where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching geozones
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEOZONE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "geozone.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GEOZONEID =
		new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGeozoneId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEOZONEID =
		new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, GeozoneImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGeozoneId",
			new String[] { Long.class.getName() },
			GeozoneModelImpl.GEOZONEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GEOZONEID = new FinderPath(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGeozoneId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the geozones where geozoneId = &#63;.
	 *
	 * @param geozoneId the geozone ID
	 * @return the matching geozones
	 */
	@Override
	public List<Geozone> findByGeozoneId(long geozoneId) {
		return findByGeozoneId(geozoneId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Geozone> findByGeozoneId(long geozoneId, int start, int end) {
		return findByGeozoneId(geozoneId, start, end, null);
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
	@Override
	public List<Geozone> findByGeozoneId(long geozoneId, int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return findByGeozoneId(geozoneId, start, end, orderByComparator, true);
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
	@Override
	public List<Geozone> findByGeozoneId(long geozoneId, int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEOZONEID;
			finderArgs = new Object[] { geozoneId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GEOZONEID;
			finderArgs = new Object[] { geozoneId, start, end, orderByComparator };
		}

		List<Geozone> list = null;

		if (retrieveFromCache) {
			list = (List<Geozone>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Geozone geozone : list) {
					if ((geozoneId != geozone.getGeozoneId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_GEOZONE_WHERE);

			query.append(_FINDER_COLUMN_GEOZONEID_GEOZONEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(GeozoneModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(geozoneId);

				if (!pagination) {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first geozone in the ordered set where geozoneId = &#63;.
	 *
	 * @param geozoneId the geozone ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByGeozoneId_First(long geozoneId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByGeozoneId_First(geozoneId, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("geozoneId=");
		msg.append(geozoneId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the first geozone in the ordered set where geozoneId = &#63;.
	 *
	 * @param geozoneId the geozone ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByGeozoneId_First(long geozoneId,
		OrderByComparator<Geozone> orderByComparator) {
		List<Geozone> list = findByGeozoneId(geozoneId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last geozone in the ordered set where geozoneId = &#63;.
	 *
	 * @param geozoneId the geozone ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone
	 * @throws NoSuchGeozoneException if a matching geozone could not be found
	 */
	@Override
	public Geozone findByGeozoneId_Last(long geozoneId,
		OrderByComparator<Geozone> orderByComparator)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByGeozoneId_Last(geozoneId, orderByComparator);

		if (geozone != null) {
			return geozone;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("geozoneId=");
		msg.append(geozoneId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchGeozoneException(msg.toString());
	}

	/**
	 * Returns the last geozone in the ordered set where geozoneId = &#63;.
	 *
	 * @param geozoneId the geozone ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching geozone, or <code>null</code> if a matching geozone could not be found
	 */
	@Override
	public Geozone fetchByGeozoneId_Last(long geozoneId,
		OrderByComparator<Geozone> orderByComparator) {
		int count = countByGeozoneId(geozoneId);

		if (count == 0) {
			return null;
		}

		List<Geozone> list = findByGeozoneId(geozoneId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the geozones where geozoneId = &#63; from the database.
	 *
	 * @param geozoneId the geozone ID
	 */
	@Override
	public void removeByGeozoneId(long geozoneId) {
		for (Geozone geozone : findByGeozoneId(geozoneId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(geozone);
		}
	}

	/**
	 * Returns the number of geozones where geozoneId = &#63;.
	 *
	 * @param geozoneId the geozone ID
	 * @return the number of matching geozones
	 */
	@Override
	public int countByGeozoneId(long geozoneId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GEOZONEID;

		Object[] finderArgs = new Object[] { geozoneId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GEOZONE_WHERE);

			query.append(_FINDER_COLUMN_GEOZONEID_GEOZONEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(geozoneId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GEOZONEID_GEOZONEID_2 = "geozone.geozoneId = ?";

	public GeozonePersistenceImpl() {
		setModelClass(Geozone.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("uuid", "uuid_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the geozone in the entity cache if it is enabled.
	 *
	 * @param geozone the geozone
	 */
	@Override
	public void cacheResult(Geozone geozone) {
		entityCache.putResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneImpl.class, geozone.getPrimaryKey(), geozone);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { geozone.getUuid(), geozone.getGroupId() }, geozone);

		geozone.resetOriginalValues();
	}

	/**
	 * Caches the geozones in the entity cache if it is enabled.
	 *
	 * @param geozones the geozones
	 */
	@Override
	public void cacheResult(List<Geozone> geozones) {
		for (Geozone geozone : geozones) {
			if (entityCache.getResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
						GeozoneImpl.class, geozone.getPrimaryKey()) == null) {
				cacheResult(geozone);
			}
			else {
				geozone.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all geozones.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GeozoneImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the geozone.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Geozone geozone) {
		entityCache.removeResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneImpl.class, geozone.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((GeozoneModelImpl)geozone, true);
	}

	@Override
	public void clearCache(List<Geozone> geozones) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Geozone geozone : geozones) {
			entityCache.removeResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
				GeozoneImpl.class, geozone.getPrimaryKey());

			clearUniqueFindersCache((GeozoneModelImpl)geozone, true);
		}
	}

	protected void cacheUniqueFindersCache(GeozoneModelImpl geozoneModelImpl) {
		Object[] args = new Object[] {
				geozoneModelImpl.getUuid(), geozoneModelImpl.getGroupId()
			};

		finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
			geozoneModelImpl, false);
	}

	protected void clearUniqueFindersCache(GeozoneModelImpl geozoneModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] {
					geozoneModelImpl.getUuid(), geozoneModelImpl.getGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}

		if ((geozoneModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					geozoneModelImpl.getOriginalUuid(),
					geozoneModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new geozone with the primary key. Does not add the geozone to the database.
	 *
	 * @param geozoneId the primary key for the new geozone
	 * @return the new geozone
	 */
	@Override
	public Geozone create(long geozoneId) {
		Geozone geozone = new GeozoneImpl();

		geozone.setNew(true);
		geozone.setPrimaryKey(geozoneId);

		String uuid = PortalUUIDUtil.generate();

		geozone.setUuid(uuid);

		geozone.setCompanyId(companyProvider.getCompanyId());

		return geozone;
	}

	/**
	 * Removes the geozone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param geozoneId the primary key of the geozone
	 * @return the geozone that was removed
	 * @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	 */
	@Override
	public Geozone remove(long geozoneId) throws NoSuchGeozoneException {
		return remove((Serializable)geozoneId);
	}

	/**
	 * Removes the geozone with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the geozone
	 * @return the geozone that was removed
	 * @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	 */
	@Override
	public Geozone remove(Serializable primaryKey)
		throws NoSuchGeozoneException {
		Session session = null;

		try {
			session = openSession();

			Geozone geozone = (Geozone)session.get(GeozoneImpl.class, primaryKey);

			if (geozone == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGeozoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(geozone);
		}
		catch (NoSuchGeozoneException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Geozone removeImpl(Geozone geozone) {
		geozone = toUnwrappedModel(geozone);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(geozone)) {
				geozone = (Geozone)session.get(GeozoneImpl.class,
						geozone.getPrimaryKeyObj());
			}

			if (geozone != null) {
				session.delete(geozone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (geozone != null) {
			clearCache(geozone);
		}

		return geozone;
	}

	@Override
	public Geozone updateImpl(Geozone geozone) {
		geozone = toUnwrappedModel(geozone);

		boolean isNew = geozone.isNew();

		GeozoneModelImpl geozoneModelImpl = (GeozoneModelImpl)geozone;

		if (Validator.isNull(geozone.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			geozone.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (geozone.getCreateDate() == null)) {
			if (serviceContext == null) {
				geozone.setCreateDate(now);
			}
			else {
				geozone.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!geozoneModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				geozone.setModifiedDate(now);
			}
			else {
				geozone.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (geozone.isNew()) {
				session.save(geozone);

				geozone.setNew(false);
			}
			else {
				geozone = (Geozone)session.merge(geozone);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!GeozoneModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { geozoneModelImpl.getUuid() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
				args);

			args = new Object[] {
					geozoneModelImpl.getUuid(), geozoneModelImpl.getCompanyId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
				args);

			args = new Object[] { geozoneModelImpl.getGroupId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
				args);

			args = new Object[] { geozoneModelImpl.getGeozoneId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_GEOZONEID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEOZONEID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((geozoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { geozoneModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { geozoneModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((geozoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geozoneModelImpl.getOriginalUuid(),
						geozoneModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						geozoneModelImpl.getUuid(),
						geozoneModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((geozoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geozoneModelImpl.getOriginalGroupId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { geozoneModelImpl.getGroupId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((geozoneModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEOZONEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						geozoneModelImpl.getOriginalGeozoneId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GEOZONEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEOZONEID,
					args);

				args = new Object[] { geozoneModelImpl.getGeozoneId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_GEOZONEID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GEOZONEID,
					args);
			}
		}

		entityCache.putResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
			GeozoneImpl.class, geozone.getPrimaryKey(), geozone, false);

		clearUniqueFindersCache(geozoneModelImpl, false);
		cacheUniqueFindersCache(geozoneModelImpl);

		geozone.resetOriginalValues();

		return geozone;
	}

	protected Geozone toUnwrappedModel(Geozone geozone) {
		if (geozone instanceof GeozoneImpl) {
			return geozone;
		}

		GeozoneImpl geozoneImpl = new GeozoneImpl();

		geozoneImpl.setNew(geozone.isNew());
		geozoneImpl.setPrimaryKey(geozone.getPrimaryKey());

		geozoneImpl.setUuid(geozone.getUuid());
		geozoneImpl.setGeozoneId(geozone.getGeozoneId());
		geozoneImpl.setGroupId(geozone.getGroupId());
		geozoneImpl.setCompanyId(geozone.getCompanyId());
		geozoneImpl.setUserId(geozone.getUserId());
		geozoneImpl.setUserName(geozone.getUserName());
		geozoneImpl.setCreateDate(geozone.getCreateDate());
		geozoneImpl.setModifiedDate(geozone.getModifiedDate());
		geozoneImpl.setStatus(geozone.getStatus());
		geozoneImpl.setStatusByUserId(geozone.getStatusByUserId());
		geozoneImpl.setStatusByUserName(geozone.getStatusByUserName());
		geozoneImpl.setStatusDate(geozone.getStatusDate());
		geozoneImpl.setName(geozone.getName());
		geozoneImpl.setArea(geozone.getArea());
		geozoneImpl.setCalendarId(geozone.getCalendarId());
		geozoneImpl.setDescription(geozone.getDescription());
		geozoneImpl.setGeozoneAttributes(geozone.getGeozoneAttributes());

		return geozoneImpl;
	}

	/**
	 * Returns the geozone with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the geozone
	 * @return the geozone
	 * @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	 */
	@Override
	public Geozone findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGeozoneException {
		Geozone geozone = fetchByPrimaryKey(primaryKey);

		if (geozone == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGeozoneException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return geozone;
	}

	/**
	 * Returns the geozone with the primary key or throws a {@link NoSuchGeozoneException} if it could not be found.
	 *
	 * @param geozoneId the primary key of the geozone
	 * @return the geozone
	 * @throws NoSuchGeozoneException if a geozone with the primary key could not be found
	 */
	@Override
	public Geozone findByPrimaryKey(long geozoneId)
		throws NoSuchGeozoneException {
		return findByPrimaryKey((Serializable)geozoneId);
	}

	/**
	 * Returns the geozone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the geozone
	 * @return the geozone, or <code>null</code> if a geozone with the primary key could not be found
	 */
	@Override
	public Geozone fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
				GeozoneImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Geozone geozone = (Geozone)serializable;

		if (geozone == null) {
			Session session = null;

			try {
				session = openSession();

				geozone = (Geozone)session.get(GeozoneImpl.class, primaryKey);

				if (geozone != null) {
					cacheResult(geozone);
				}
				else {
					entityCache.putResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
						GeozoneImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
					GeozoneImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return geozone;
	}

	/**
	 * Returns the geozone with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param geozoneId the primary key of the geozone
	 * @return the geozone, or <code>null</code> if a geozone with the primary key could not be found
	 */
	@Override
	public Geozone fetchByPrimaryKey(long geozoneId) {
		return fetchByPrimaryKey((Serializable)geozoneId);
	}

	@Override
	public Map<Serializable, Geozone> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Geozone> map = new HashMap<Serializable, Geozone>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Geozone geozone = fetchByPrimaryKey(primaryKey);

			if (geozone != null) {
				map.put(primaryKey, geozone);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
					GeozoneImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Geozone)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_GEOZONE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Geozone geozone : (List<Geozone>)q.list()) {
				map.put(geozone.getPrimaryKeyObj(), geozone);

				cacheResult(geozone);

				uncachedPrimaryKeys.remove(geozone.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(GeozoneModelImpl.ENTITY_CACHE_ENABLED,
					GeozoneImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the geozones.
	 *
	 * @return the geozones
	 */
	@Override
	public List<Geozone> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Geozone> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Geozone> findAll(int start, int end,
		OrderByComparator<Geozone> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Geozone> findAll(int start, int end,
		OrderByComparator<Geozone> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Geozone> list = null;

		if (retrieveFromCache) {
			list = (List<Geozone>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GEOZONE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GEOZONE;

				if (pagination) {
					sql = sql.concat(GeozoneModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Geozone>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the geozones from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Geozone geozone : findAll()) {
			remove(geozone);
		}
	}

	/**
	 * Returns the number of geozones.
	 *
	 * @return the number of geozones
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GEOZONE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GeozoneModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the geozone persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(GeozoneImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_GEOZONE = "SELECT geozone FROM Geozone geozone";
	private static final String _SQL_SELECT_GEOZONE_WHERE_PKS_IN = "SELECT geozone FROM Geozone geozone WHERE geozoneId IN (";
	private static final String _SQL_SELECT_GEOZONE_WHERE = "SELECT geozone FROM Geozone geozone WHERE ";
	private static final String _SQL_COUNT_GEOZONE = "SELECT COUNT(geozone) FROM Geozone geozone";
	private static final String _SQL_COUNT_GEOZONE_WHERE = "SELECT COUNT(geozone) FROM Geozone geozone WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "geozone.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Geozone exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Geozone exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(GeozonePersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}