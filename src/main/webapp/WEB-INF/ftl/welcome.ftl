<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<#--freemarker-->
    <meta http-equiv="Content-Type"
          content="text/html; charset=utf-8">
    <title>秒杀商品详情</title>

    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>

<#--登录时间：${userInfo.signinTime?string("yyyy-MM-dd HH:mm:ss")}  -->

<div class="container">

    <table class="table table-striped table-hover">
        <caption>秒杀库存表</caption>
        <thead>
        <tr>
            <th>商品名称</th>
            <th>库存数量</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>

        <tbody>
        <#list seckillLists  as seckill>
        <tr>
            <td>${seckill.name}</td>
            <td>${seckill.number}</td>
            <td>${seckill.startTime?string("yy-MM-dd HH:mm:ss")}</td>
            <td>${seckill.endTime?string("yy-MM-dd HH:mm:ss")}</td>
            <td>${seckill.createTime?string("yy-MM-dd HH:mm:ss")}</td>
            <td><a href="javascript:void(0)">秒杀</a></td>
        </tr>
        </#list>

        </tbody>

    </table>

<#-- bean size 的用法 -->
<#--<#if seckillLists?size gt 0>-->
    <#--找不到合适的秒杀对象-->
<#--</#if>-->

</div>
</body>
</html>