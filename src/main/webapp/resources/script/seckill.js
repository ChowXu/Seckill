/**
 * Created by zhouxi on 16/12/19.
 * 模块化  js 模块化
 * JAVA 代码可以分包
 * JS 代码 Json 表示对象的方式
 * seckill.detail.init()
 */

var seckill = {

    //封装 秒杀相关ajax的url
    URL: {},

    //validate phone number
    validatePhone: function (phone) {
        if (!phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        }
        else
            return false;
    },

    //详情页秒杀逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //手机验证和登录, 计时交互
            //规划我们的交互流程
            //在cookie 中查找手机号
            var killPhone = $.cookie('killPhone');
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckillId = params['seckillId'];

            //validate phone number
            if (!seckill.validatePhone(killPhone)) {
                // 绑定手机号
                //控制输出
                var killPhoneModal = $('#killPhoneModal');
                killphoneModal.modal({
                    show: true,
                    backdrop: 'static',
                    keyboard: false
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#KillPhoneKey').val();
                    if (seckill.validatePhone(inputPhone)) {
                        // 刷新页面
                        $.cookie('killPhone', inputPhone, {expires: 7, path: "/seckill"})
                        //refresh
                        window.location.reload();
                    }
                    else {
                        $('#killPhoneMessage').hide().html('<')
                    }
                })


            }


        }

    }

}

