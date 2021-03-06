package com.bmstu.devices.manager.web.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.bmstu.devices.manager.core.model.Device;
import com.bmstu.devices.manager.core.service.DeviceLocalService;
import com.bmstu.devices.manager.web.constants.DevicesManagerPortletKeys;
import com.bmstu.geofence.manager.core.service.GeozoneLocalService;
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
 * Device manager portlet.
 * 
 * @author Strahov
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Traccar",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=Device Manager",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DevicesManagerPortletKeys.DevicesManager,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DevicesManagerPortlet extends MVCPortlet {

	private DeviceLocalService deviceLocalService;
	private GeozoneLocalService geozoneLocalService;

	/**
	 * 
	 * Adds device to data base.
	 * 
	 * @param request
	 *            - request. Can't be <code>null</code>.
	 * @param response
	 *            - response. Can't be <code>null</code>
	 * 
	 * @throws PortalException
	 */
	public void addDevice(ActionRequest request, ActionResponse response) throws PortalException {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(Device.class.getName(), request);

		String deviceName = ParamUtil.getString(request, "name");
		String uniqueId = ParamUtil.getString(request, "uniqueId");
		String deviceGroup = ParamUtil.getString(request, "group");
		String devicePhoneNumber = ParamUtil.getString(request, "phoneNumber");
		String deviceModel = ParamUtil.getString(request, "model");
		String deviceContact = ParamUtil.getString(request, "contact");
		String deviceCategory = ParamUtil.getString(request, "category");
		String deviceAttributes = ParamUtil.getString(request, "deviceAttributes");
		long geozoneId = ParamUtil.getLong(request, "geozoneId");

		if (!geozoneExists(geozoneId)) {
			SessionErrors.add(request, "geozoneId_error");
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/edit_device.jsp");
		} else {
			try {
				deviceLocalService.addDevice(serviceContext.getUserId(), deviceName, uniqueId, geozoneId, deviceGroup,
						devicePhoneNumber, deviceModel, deviceContact, deviceCategory, deviceAttributes,
						serviceContext);
				SessionMessages.add(request, "Device Added");
			} catch (Exception e) {
				System.out.println(e);
				SessionErrors.add(request, e.getClass().getName());
				PortalUtil.copyRequestParameters(request, response);
				response.setRenderParameter("mvcPath", "/edit_device.jsp");
			}
		}
	}

	/**
	 * 
	 * Removes device from data base.
	 * 
	 * @param request
	 *            - request. Can't be <code>null</code>.
	 * @param response
	 *            - response. Can't be <code>null</code>
	 * 
	 * @throws PortalException
	 */
	public void deleteDevice(ActionRequest request, ActionResponse response) throws PortalException {
		long deviceId = ParamUtil.getLong(request, "deviceId");

		try {
			deviceLocalService.deleteDevice(deviceId);
			SessionMessages.add(request, "Device deleted");
		} catch (Exception e) {
			System.out.println(e);
			SessionErrors.add(request, e.getClass().getName());
			PortalUtil.copyRequestParameters(request, response);
			response.setRenderParameter("mvcPath", "/view.jsp");
		}
	}

	/**
	 * 
	 * Binds device service.
	 * 
	 */
	@Reference(unbind = "-")
	protected void bindDeviceService(DeviceLocalService deviceLocalService) {
		this.deviceLocalService = deviceLocalService;
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

	private boolean geozoneExists(long geozoneId) {
		return geozoneLocalService.getGeozones(0, geozoneLocalService.getGeofenceCount()).stream()
				.anyMatch(geozone -> geozone.getGeozoneId() == geozoneId);
	}
}