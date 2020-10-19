<%@ page import="java.util.*" %>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<jsp:include page="../WEB-INF/pages/template.jsp">
	<jsp:param value="Audio over Time" name="pageTitle"/>
	<jsp:param value="<div id='chartContainer'/>" name="content"/> 	
</jsp:include>
<%
%>
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {  
	theme: "light2",
	title: {
		text: "Audio consumed this week"
	},
	subtitles: [{
		text: "Decibels Observed over time"
	}],
	toolTip: {
		shared: true
	},
	legend:{
		cursor: "pointer",
		itemclick: toggleDataSeries
	},
	data: [{
		type: "area",
		name: "Environment",
		showInLegend: true,
		xValueType: "dateTime",
		xValueFormatString: "DDDD MMM YYYY HH:mm:ss k",
		dataPoints: out.print(${data[1]});
	},
	{
		type: "area",
		name: "Birds",
		showInLegend: true,
		xValueType: "dateTime",
		xValueFormatString: "DDDD MMM YYYY HH:mm:ss k",
		dataPoints: out.print(${data[2]});
	}]
});
 
chart.render();
 
function toggleDataSeries(e){
	if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
		e.dataSeries.visible = false;
	}
	else{
		e.dataSeries.visible = true;
	}
	chart.render();
}
 
}
</script>