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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Geozone service. Represents a row in the &quot;GM_Geozone&quot; database table, with each column mapped to a property of this class.
 *
 * @author Ershov
 * @see GeozoneModel
 * @see com.bmstu.geofence.manager.core.model.impl.GeozoneImpl
 * @see com.bmstu.geofence.manager.core.model.impl.GeozoneModelImpl
 * @generated
 */
@ImplementationClassName("com.bmstu.geofence.manager.core.model.impl.GeozoneImpl")
@ProviderType
public interface Geozone extends GeozoneModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.bmstu.geofence.manager.core.model.impl.GeozoneImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Geozone, Long> GEOZONE_ID_ACCESSOR = new Accessor<Geozone, Long>() {
			@Override
			public Long get(Geozone geozone) {
				return geozone.getGeozoneId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Geozone> getTypeClass() {
				return Geozone.class;
			}
		};
}