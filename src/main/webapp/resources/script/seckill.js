/**
 * Created by zhouxi on 16/12/19.
 * 模块化  js 模块化
 * JAVA 代码可以分包
 * JS 代码 Json 表示对象的方式
 * seckill.detail.init()
 *  规划好 JS
 *
 */

var seckill = {

    //封装 秒杀相关ajax的url
    URL: {
        now: "/seckill/time/now",
        exposure: function (seckillId) {
            return '/seckill/' + seckillId + '/exposure';
        },
        execution: function (seckillId, md5) {
            return '/seckill/' + seckillId + '/' + md5 + '/execution';
        }
    },


    //handlerSeckillkill
    handlerSeckillkill: function (seckillId, node) {
        //获取秒杀地址 控制显示逻辑, 执行秒杀
        node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
        $.post(seckill.URL.exposure(seckillId), {}, function (result) {
            //在回调函数中 执行交互流程
            if (result && result['success']) {
                var exposure = result['data'];
                if (exposure['exposure']) {
                    //start seckill 
                    var md5 = exposure['md5'];
                    var killUrl = seckill.URL.execution(seckillId, md5);
                    console.log(killUrl);
                    //绑定一次点击时间 防止重复秒杀
                    $('#killBtn').one('click', function () {
                        //1. 禁用按钮
                        $(this).addClass('disable');
                        //2. 发送秒杀请求
                        $.post(killUrl, {}, function (result) {
                            if (result) {
                                var killReslut = result['data'];
                                var state = killReslut['state'];
                                var stateInfo = killReslut['stateInfo'];
                                // 显示秒杀结果
                                if (result['success']) {
                                    node.html('<span class="label label-success">' + stateInfo + '</span>');
                                }
                                else {
                                    node.html('<span class="label label-warning">' + stateInfo + '</span>');
                                }
                            }

                        })

                    });
                }
                else {
                    //seckill not open   重新进入计时逻辑
                    var now = exposure['now'];
                    var start = exposure['start'];
                    var end = exposure['end'];
                    seckill.countdown(seckillId, start, end, now);
                }
            } else {
                console.log("result" + result);
            }

        })
        node.show(300);
    },

    //validate phone number
    validatePhone: function (phone) {
        if (phone && phone.length == 11 && !isNaN(phone)) {
            return true;
        }
        else
            return false;
    },
    //
    countdown: function (seckillId, startTime, endTime, nowTime) {

        var seckillBox = $('#seckill-box');
        //judging time
        if (nowTime < startTime) {
            var killTime = new Date(startTime + 1000);

            seckillBox.countdown(killTime, function (event) {
                //时间 格式
                var format = event.strftime('秒杀计时: %D天 %H时 %M分 %S秒')
                seckillBox.html(format);
            }).on('finish.countdown', function () {
                // 回调秒杀开始逻辑
                seckill.handlerSeckillkill(seckillId, seckillBox);

            });

            //秒杀结束
        }
        else if (nowTime > endTime) {
            seckillBox.html('秒杀结束');
        }
        else {
            seckill.handlerSeckillkill(seckillId, seckillBox);
        }


    },

    //详情页秒杀逻辑
    detail: {
        //详情页初始化
        init: function (params) {
            //手机验证和登录, 计时交互
            //规划我们的交互流程
            //在cookie 中查找手机号
            var killPhone = $.cookie('killPhone');
            var startTime = new Date(params['startTime']).getTime();
            var endTime = new Date(params['endTime']).getTime();
            var seckillId = params['seckillId'];
            console.log(seckillId);

            //validate phone number
            if (!seckill.validatePhone(killPhone)) {
                // 绑定手机号
                //控制输出
                var killPhoneModal = $('#killPhoneModal');
                //显示弹出层
                killPhoneModal.modal({
                    show: true,    //显示弹出层
                    backdrop: 'static',  // 禁止位置关闭
                    keyboard: false   //关闭键盘事件
                });
                $('#killPhoneBtn').click(function () {
                    var inputPhone = $('#killPhoneKey').val();
                    if (seckill.validatePhone(inputPhone)) {
                        // 刷新页面
                        $.cookie('killPhone', inputPhone, {expires: 7, path: "/seckill"});
                        //refresh
                        window.location.reload();
                    }
                    else {
                        $('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>>').show(300);
                    }
                });

            }
            //have login in   执行秒杀逻辑
            //caculate time
            $.get(seckill.URL.now, {}, function (result) {
                if (result && result['success']) {
                    var nowTime = result['data'];
                    seckill.countdown(seckillId, startTime, endTime, nowTime);

                }
                else {
                    console.log('result' + result);
                }
            })


        }

    }

}

