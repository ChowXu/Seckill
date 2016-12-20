<!DOCTYPE html>
<html>
<head>
    <title>秒杀详情</title>
<#include "common/head.ftl">

</head>
<body>
<div class="container">
    <div class="panel panel-default text-center">
        <div class="panel-heading">${seckill.name}</div>
        <div class="panel-body">
            <h2 class="text-danger">
            <#--show time icon-->
                <span class="glyphicon glyphicon-time"></span>
            <#--show time line icon-->
                <span class="glyphicon" id="seckill-box"></span>
            </h2>
        </div>
    </div>
</div>

<#--弹出层, 输入电话号码-->
<#--一套完整的 midel组建 -->
<div id="killPhoneModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title text-center">
                    <span class="glyphicon glyphicon-phone"></span>
                </h3>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-xs-8 col-xs-offset-2">
                        <input type="text" name="killPhone" id="killPhoneKey"
                               placeholder="phoneNum" class="form-control"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <sapn id="killPhoneMessage" class="glyphicon"></sapn>
                <button type="button" class="btn btn-btn-success" id="killPhoneBtn">
                    <span calss="glyphicon glyphicon-phone"></span>
                    Submit
                </button>
            </div>
        </div>
    </div>
</div>


<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<#--jquery Cookie 插件-->
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.js"></script>
<#-- jquery countdown 插件-->
<script src="https://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.js"></script>
<script src="/resources/script/seckill.js" type="text/javascript"></script>
<script type="text/javascript">

    $(function () {

        //使用EL 表达式传入时间
        seckill.detail.init({
            seckillId: "${seckill.seckillId?c}",
            startTime: "${seckill.startTime?datetime}",
            endTime: "${seckill.endTime?datetime}"

        });



    })


</script>
</body>
</html>