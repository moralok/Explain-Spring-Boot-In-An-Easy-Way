<%--
  Created by IntelliJ IDEA.
  User: moralok
  Date: 2019/8/12
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>购买产品测试</title>
</head>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
    for (var i=1; i<1500; i++) {
        var params = {
            userId : i,
            productId : 1,
            quantity : 1
        }
        // 通过 POST 请求后端
        $.post("./purchase", params, function (result) {

        })
    }
</script>
<body>
    <h1>抢购产品测试</h1>
</body>
</html>
