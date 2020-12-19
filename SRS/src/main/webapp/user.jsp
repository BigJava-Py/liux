<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta charset="UTF-8">
            <title>个人中心</title>
            <link rel="stylesheet" href="css/userManage.css" />
            <script type="text/javascript" src="js/jquery-3.5.0.min.js"></script>
            <script type="text/javascript" src="js/user.js"></script>
        </head>

        <body>
            <form id="searchForm">
                <input type="text" id="oldpassword" name="oldpassword" placeholder="输入旧密码" />
                <input type="text" id="password" name="password" placeholder="输入新密码" />
                <input type="text" id="password1" name="password1" placeholder="确认密码" />
                <input type="button" id="btOK" name="btOK" value="确定" onclick="changePassword();"></>
            </form>
        </body>

        </html>