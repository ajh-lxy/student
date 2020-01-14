<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2019/12/11
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>

<link type="text/css" href="/css/style.css" rel="stylesheet"/>
<link rel="stylesheet" href="/commons/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/shop/ztree/bootstrapStyle.css">
<link href="/commons/datatable/DataTables-1.10.18/css/dataTables.bootstrap.min.css" rel="stylesheet"/>

<script type="text/javascript" src="/js/jquery.min.js"></script>


<body>
<input type="button" class="btn btn-default" value="学生展示" onclick="queryDrugButton()"/>
<input type="button" class="btn btn-default" value="地区展示" onclick="queryDrugButton1()"/>
</body>
<script type="text/javascript">

    function queryDrugButton() {

        location.href="view/student.html";

    }
    function queryDrugButton1() {

        location.href="view/area.html";

    }
</script>
</html>