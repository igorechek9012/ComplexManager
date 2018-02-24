<%@include file="/init.jsp"%>

<%
	Geozone geozoneVar = null;
%>

<aui:button-row cssClass="traccar-buttons">

	<portlet:renderURL var="addGeozoneURL">
		<portlet:param name="mvcPath" value="/edit_geozone.jsp" />
	</portlet:renderURL>

	<aui:button onClick="<%=addGeozoneURL.toString()%>" value="Add Geozone"></aui:button>

</aui:button-row>

<liferay-ui:search-container
	total="<%=GeozoneLocalServiceUtil.getGeofenceCount()%>">
	<liferay-ui:search-container-results
		results="<%=GeozoneLocalServiceUtil.getGeofence(scopeGroupId.longValue(), searchContainer.getStart(),
						searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.bmstu.geofence.manager.core.model.Geozone"
		modelVar="geozone">

		<liferay-ui:search-container-column-text property="geozoneId" />

		<liferay-ui:search-container-column-text property="name" />

		<liferay-ui:search-container-column-text property="description" />

		<liferay-ui:search-container-column-text property="area" />

		<liferay-ui:search-container-column-text property="calendarId" />

		<liferay-ui:search-container-column-text property="geozoneAttributes" />

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />

</liferay-ui:search-container>

<portlet:actionURL name="deleteGeozone" var="deleteGeozoneURL" />
<aui:form action="<%=deleteGeozoneURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=geozoneVar%>" model="<%=Geozone.class%>" />

	<aui:fieldset>

		<aui:input name="geozoneId" label="ID" type="clear" />

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit" value="delete" />

	</aui:button-row>
</aui:form>