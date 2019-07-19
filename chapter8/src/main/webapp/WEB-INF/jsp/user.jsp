<%--
  Created by IntelliJ IDEA.
  User: moralok
  Date: 2019/7/15
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Hello Spring Boot</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript">
        function post(user) {
            var url = "./save"
            $.post({
                url : url,
                // 此处需要告知传递参数类型为 JSON，不能缺少
                contentType : "application/json",
                // 将 json 转化为 字符串传递
                data : JSON.stringify(user),
                // 成功后的方法
                success : function (result, status) {
                    if (result == null || result.id == null) {
                        alert("插入失败");
                        return;
                    }
                }
            });
        }
        for (var i = 1; i <= 10; i++) {
            var user = {
                'id' : i,
                'userName' : 'user_name_' + i,
                'note' : 'note_' + i,
                'roles' : [{
                    'id' : i,
                    'roleName' : 'role_' + i,
                    'note' : 'note_' + i,
                }, {
                    'id' : i+1,
                    'roleName' : 'role_' + (i+1),
                    'note' : 'note_' + (i+1),
                }]
            };
            post(user);
        }
    </script>
</head>
<body>
    <h1>操作 MongoDB 文档</h1>
</body>
</html>