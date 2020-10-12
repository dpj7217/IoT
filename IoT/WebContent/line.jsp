<%@ page import="java.util.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>

<jsp:include page="../WEB-INF/pages/template.jsp">
	<jsp:param value="Line Chart" name="pageTitle"/>
	<jsp:param value="<div id='chartContainer'/>" name="content"/> 	
</jsp:include>
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

map = new HashMap<Object,Object>(); map.put("x", 1);  map.put("y", 0);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 2);  map.put("y", 0);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 3);  map.put("y", 0);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 4);  map.put("y", 0);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 5);  map.put("y", 2);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 6);  map.put("y", 5);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 7);  map.put("y", 6);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 8);  map.put("y", 5);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 9);  map.put("y", 10);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 10);  map.put("y", 11);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 11);  map.put("y", 12);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 12);  map.put("y", 11);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 13);  map.put("y", 12);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 14);  map.put("y", 13);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 15);  map.put("y", 10);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 16);  map.put("y", 5);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 17);  map.put("y", 4);list.add(map);
map = new HashMap<Object,Object>(); map.put("x",18);  map.put("y", 3);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 20);  map.put("y", 2);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 22);  map.put("y", 0);list.add(map);
map = new HashMap<Object,Object>(); map.put("x", 24);  map.put("y", 0);list.add(map);

String dataPoints = gsonObj.toJson(list);
%>

<script type="text/javascript">

   $(function () {
       var chart = new CanvasJS.Chart("chartContainer", {
           theme: "light2",
           zoomEnabled: true,
           animationEnabled: true,
           title: {
               text: "Audio recieved from PIE#1"
           },
           subtitles: [
               {
                   text: "Bird Chirp Detector"
               }
           ],
           data: [{
               type: "line",
               dataPoints: <%out.print(dataPoints);%>
           }]
       });
       chart.render();
   });
</script>