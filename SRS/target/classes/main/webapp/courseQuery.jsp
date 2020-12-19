<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>课程查询</title>
 	<link rel="stylesheet" href="css/userManage.css" />
	<script type="text/javascript" src="js/jquery-3.5.0.min.js"></script>
	<script type="text/javascript" src="js/courseQuery.js"></script>
</head>
<body>
	<div id="container">
		
			 <div id="search">
                            <div id="bt">
                                <a href="#" id="btAdd">增加</a>
                            </div>
             </div>
			<table>
				<thead>
					<tr>
						<th width="40"><input type="checkbox" id="ckAll" title="选择" /></th>
						<th width="70">课程号</th>
						<th width="110">课程名</th>
						<th width="70">"学分</th>
						<th width="70">课时</th>
						<th width="70">任课教师</th>
					</tr>
				</thead>
				<tbody>

				</tbody>
			</table>
		
	</div>
</body>
</html>