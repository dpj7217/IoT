<%@ page import="java.util.*" %>

<jsp:include page="../WEB-INF/pages/template.jsp">
	<jsp:param value="Audio over Time" name="pageTitle"/>
	<jsp:param value="<div id='chartContainer'/>" name="content"/> 	
</jsp:include>

<script type="text/javascript">

   $(function () {
       var chart = new CanvasJS.Chart("chartContainer", {
           theme: "light2",
           zoomEnabled: true,
           animationEnabled: true,
           title: {
               text: "Audio Over Time"
           },
           subtitles: [
               {
                   text: "Audio Amplitude (Y) Time (X)"
               }
           ],
           data: [{
               type: "line",
               dataPoints:out.print(${audio});
           }]
       });
       chart.render();
   });
</script>