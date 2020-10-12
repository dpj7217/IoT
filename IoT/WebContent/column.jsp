<%@ page import="java.util.*" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.JsonObject"%>

<jsp:include page="../WEB-INF/pages/template.jsp">
	<jsp:param value="Column Chart" name="pageTitle"/>
	<jsp:param value="<div id='chartContainer'/>" name="content"/> 	
</jsp:include>

<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();

map = new HashMap<Object,Object>(); map.put("labels", "Monday");	map.put("y",21); list.add(map);	
map = new HashMap<Object,Object>();	map.put("labels", "Tuesday");	map.put("y",14); list.add(map);	
map = new HashMap<Object,Object>();	map.put("labels", "Wednesday"); map.put("y",17); list.add(map);	
map = new HashMap<Object,Object>();	map.put("labels", "Thursday"); map.put("y",19); list.add(map);	
map = new HashMap<Object,Object>();	map.put("labels", "Friday");	map.put("y",22);	list.add(map);	
map = new HashMap<Object,Object>();	map.put("labels", "Saturday");	map.put("y",12);	list.add(map);	
map = new HashMap<Object,Object>(); map.put("labels", "Sunday"); map.put("y",19); list.add(map);	

String dataPoints = gsonObj.toJson(list);
%>
<script type="text/javascript">
    $(function () {
        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2",
            animationEnabled: true,
            title: {
                text: "Bird Chirps Per Day"
            },
            data: [{
                type: "column",
                dataPoints: <%out.print(dataPoints);%>
            }]
        });
        chart.render();
    });
</script>