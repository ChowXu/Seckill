<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>秒杀商品详情</title>
<#include "common/head.ftl" >

</head>
<body>

<div class="container">

    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>秒杀列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover">
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
                    <td>
                        <a class="btn btn-info" href="/seckill/${seckill.seckillId?c}/detail" target="_blank">秒杀</a>
                    </td>
                </tr>
                </#list>

                </tbody>

            </table>
        </div>
    </div>

<#-- bean size 的用法 -->
<#--<#if seckillLists?size gt 0>-->
<#--找不到合适的秒杀对象-->
<#--</#if>-->

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</div>
</body>
</html>