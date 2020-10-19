<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>

<html>
<head>
<script	src="../assets/script/jquery-1.12.4.min.js"	type="text/javascript"></script>
<script	src="../assets/script/bootstrap.min.js"	type="text/javascript"></script>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js" type="text/javascript"></script>	
<meta charset="ISO-8859-1">
<title>${param.pageTitle}</title>
</head>
<body>
	<jsp:include page="header.jsp" />	
	<div id="page-content-wrapper" class="page-content-toggle">
		<div class="container-fluid">
			<h1>${param.pageTitle}</h1>

			<div class="row">
				<div id="content" class="col-md-8 col-md-offset-1 col-xs-12">
					${param.content}
				</div>
			</div>
			<!-- /row -->
		</div>
		<jsp:include page="/WEB-INF/pages/footer.jsp" />
	</div>
</body>
</html>