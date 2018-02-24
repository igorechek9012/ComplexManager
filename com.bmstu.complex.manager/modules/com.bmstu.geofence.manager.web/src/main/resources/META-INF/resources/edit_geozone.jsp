<%@include file="/init.jsp"%>

<%
	Geozone geozone = null;
%>

<portlet:renderURL var="viewURL">

	<portlet:param name="mvcPath" value="/view.jsp" />

</portlet:renderURL>

<portlet:actionURL name="addGeozone" var="addGeozoneURL" />

<aui:form action="<%=addGeozoneURL%>" name="<portlet:namespace />fm">

	<aui:model-context bean="<%=geozone%>"
		model="<%=Geozone.class%>" />

	<aui:fieldset>

		<aui:input name="name" />
		<aui:input name="description" />
		<aui:input name="area" />
		<aui:input name="calendarId" />
		<aui:input name="geozoneAttributes" />

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit" />
		<aui:button type="cancel" onClick="<%= viewURL.toString() %>" />

	</aui:button-row>
</aui:form>