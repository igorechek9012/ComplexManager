package com.bmstu.geofence.manager.web.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.bmstu.geofence.manager.core.model.Geozone;
import com.bmstu.geofence.manager.core.service.GeozoneLocalService;
import com.bmstu.geofence.manager.web.constants.GeofenceManagerPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

/**
 * 
 * Geofence manager portlet. Can add geofence.
 * 
 * @author Ershov
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Traccar",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Geofence Manager",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + GeofenceManagerPortletKeys.GeofenceManager,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class GeofenceManagerPortlet extends MVCPortlet {
	
	private GeozoneLocalService geozoneLocalService;

	/**
	 * 
	 * Adds geozone to data base.
	 * 
	 * @param request
	 *            - request. Can't be <code>null</code>.
	 * @param response
	 *            - response. Can't be <code>null</code>
	 * 
	 * @throws PortalException
	 */
	public void addGeozone(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Geozone.class.getName(), request);

		String geozoneName = ParamUtil.getString(request, "name");
		String geozoneDescription = ParamUtil.getString(request, "description");
		String geozoneAreaNumber = ParamUtil.getString(request, "area");
		long geozoneCalendarId = ParamUtil.getLong(request, "calendarId");
		String geozoneAttributes = ParamUtil.getString(request, "geozoneAttributes");

		try {
			geozoneLocalService.addGeozone(serviceContext.getUserId(), geozoneName, geozoneDescription,
					geozoneAreaNumber, geozoneCalendarId, geozoneAttributes, serviceContext);
			SessionMessages.add(request, "Geozone Added");
		} catch (Exception e) {
			System.out.println(e);
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/edit_geozone.jsp");
		}
	}
	
	/**
	 * 
	 * Removes geozone from data base.
	 * 
	 * @param request
	 *            - request. Can't be <code>null</code>.
	 * @param response
	 *            - response. Can't be <code>null</code>
	 * 
	 * @throws PortalException
	 */
	public void deleteGeozone(ActionRequest request, ActionResponse response) throws PortalException {
		long geozoneId = ParamUtil.getLong(request, "geozoneId");

		try {
			geozoneLocalService.deleteGeozone(geozoneId);
			SessionMessages.add(request, "Geozone deleted");
		} catch (Exception e) {
			System.out.println(e);
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/view.jsp");
		}
	}

	/**
	 * 
	 * Binds geozone service.
	 * 
	 */
	@Reference(unbind = "-")
	protected void bindGeozoneService(GeozoneLocalService geozoneLocalService) {
		this.geozoneLocalService = geozoneLocalService;
	}
}