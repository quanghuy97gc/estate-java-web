<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta http-equiv="Content Type" content="text/html; charset=UTF-8" />
		<title><dec:title default="Admin page" /></title>
		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="<c:url value="/template/admin/assets/css/bootstrap.min.css" />" />
		<link rel="stylesheet" href="<c:url value="/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css" />" />
		
		<!-- page specific plugin styles -->
		<link rel="stylesheet" href="<c:url value="/template/admin/assets/css/bootstrap-select.css" />" />
		
		<!-- text fonts -->
		<link rel="stylesheet" href="<c:url value="/template/admin/assets/fonts/fonts.googleapis.com.css" />" />
		
		<!-- ace styles -->
		<link rel="stylesheet" href="<c:url value="/template/admin/assets/css/ace.min.css" />" class="ace-main-stylesheet" id="main-ace-style" />
			
		<!-- ace settings handler -->
		<script src="<c:url value="/template/admin/assets/js/ace-extra.min.js" />"></script>
</head>
<body class="no-skin">
	
<!-- Begin Header -->
<%@include file="/common/admin/header.jsp" %>
<!-- End Header -->

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	<!-- Begin menu -->
		<%@include file="/common/admin/menu.jsp" %>
	<!-- End menu -->
	
	<!-- Begin body -->
	<dec:body/>
	<!-- Begin body -->

	<!-- Begin footer -->
		<%@include file="/common/admin/footer.jsp" %>
	<!-- Begin footer -->
	
	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
</div>

<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
<script src="<c:url value="/template/admin/assets/js/bootstrap-select.js" />"></script>
<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>
<script src="<c:url value='/template/admin/js/building-list.js' />"></script>
<script src="<c:url value='/template/admin/js/building-edit.js' />"></script>

</body>
</html>