<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<%--    <meta charset="UTF-8">--%>
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
<%--    <meta http-equiv="pragma" content="no-cache">--%>
<%--    <meta http-equiv="cache-control" content="no-cache">--%>
<%--    <meta http-equiv="expires" content="0">--%>
    <title>��¼����</title>
    <link href="css/default.css" rel="stylesheet" type="text/css" />
    <!--��Ҫ��ʽ-->
    <link href="css/styles.css" rel="stylesheet" type="text/css" />
    <link href="css/demo.css" rel="stylesheet" type="text/css" />
    <link href="css/loaders.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div class='login'>
    <div class='login_title'>
        <span>����Ա��¼</span>
    </div>
    <div class='login_fields'>
        <div class='login_fields__user'>
            <div class='icon'>
                <img alt="" src='img/user_icon_copy.png'>
            </div>
            <input name="login" placeholder='�û���' maxlength="16" type='text' autocomplete="off" value="123456"/>
            <div class='validation'>
                <img alt="" src='img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='img/lock_icon_copy.png'>
            </div>
            <input name="pwd" placeholder='����' maxlength="16" type='text' autocomplete="off">
            <div class='validation'>
                <img alt="" src='img/tick.png'>
            </div>
        </div>
        <div class='login_fields__password'>
            <div class='icon'>
                <img alt="" src='img/key.png'>
            </div>
            <input name="code" placeholder='��֤��' maxlength="4" type='text' name="ValidateNum" autocomplete="off">
            <div class='validation' style="opacity: 1; right: -5px;top: -3px;">
                <canvas class="J_codeimg" id="myCanvas" onclick="Code();">�Բ��������������֧��canvas�����������°������!</canvas>
            </div>
        </div>
        <div class='login_fields__submit'>
            <input type='button' value='��¼'>
        </div>
    </div>
    <div class='success'>
    </div>
</div>
<div class='authent'>
    <div class="loader" style="height: 44px;width: 44px;margin-left: 28px;">
        <div class="loader-inner ball-clip-rotate-multiple">
            <div></div>
            <div></div>
            <div></div>
        </div>
    </div>
    <p>��֤��...</p>
</div>
<div class="OverWindows"></div>

<link href="layui/css/layui.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<script type="text/javascript" src='js/stopExecutionOnTimeout.js?t=1'></script>
<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript" src="js/Particleground.js"></script>
<script type="text/javascript" src="js/Treatment.js"></script>
<script type="text/javascript" src="js/jquery.mockjax.js"></script>
<script type="text/javascript">
    var canGetCookie = 0;//�Ƿ�֧�ִ洢Cookie 0 ��֧�� 1 ֧��
    var ajaxmockjax = 1;//�Ƿ���������Ajax�������� 0 ������  1 ����
    //Ĭ���˺�����

    var truelogin = "123456";
    var truepwd = "123456";

    var CodeVal = 0;
    Code();
    function Code() {
        if(canGetCookie == 1){
            createCode("AdminCode");
            var AdminCode = getCookieValue("AdminCode");
            showCheck(AdminCode);
        }else{
            showCheck(createCode(""));
        }
    }
    function showCheck(a) {
        CodeVal = a;
        var c = document.getElementById("myCanvas");
        var ctx = c.getContext("2d");
        ctx.clearRect(0, 0, 1000, 1000);
        ctx.font = "80px 'Hiragino Sans GB'";
        ctx.fillStyle = "#E8DFE8";
        ctx.fillText(a, 0, 100);
    }
    $(document).keypress(function (e) {
        // �س����¼�
        if (e.which == 13) {
            $('input[type="button"]').click();
        }
    });
    //���ӱ�����Ч
    $('body').particleground({
        dotColor: '#E8DFE8',
        lineColor: '#133b88'
    });
    $('input[name="pwd"]').focus(function () {
        $(this).attr('type', 'password');
    });
    $('input[type="text"]').focus(function () {
        $(this).prev().animate({ 'opacity': '1' }, 200);
    });
    $('input[type="text"],input[type="password"]').blur(function () {
        $(this).prev().animate({ 'opacity': '.5' }, 200);
    });
    $('input[name="login"],input[name="pwd"]').keyup(function () {
        var Len = $(this).val().length;
        if (!$(this).val() == '' && Len >= 5) {
            $(this).next().animate({
                'opacity': '1',
                'right': '30'
            }, 200);
        } else {
            $(this).next().animate({
                'opacity': '0',
                'right': '20'
            }, 200);
        }
    });
    var open = 0;
    layui.use('layer', function () {
        var msgalert = 'Ĭ���˺�:' + truelogin + '<br/> Ĭ������:' + truepwd;
        var index = layer.alert(msgalert, { icon: 6, time: 4000, offset: 't', closeBtn: 0, title: '������ʾ', btn: [], anim: 2, shade: 0 });
        layer.style(index, {
            color: '#777'
        });
        //�ǿ���֤
        $('input[type="button"]').click(function () {
            var login = $('input[name="login"]').val();
            var pwd = $('input[name="pwd"]').val();
            var code = $('input[name="code"]').val();
            if (login == '') {
                ErroAlert('�����������˺�');
            } else if (pwd == '') {
                ErroAlert('����������');
            } else if (code == '' || code.length != 4) {
                ErroAlert('������֤��');
            } else {
                //��֤��..
                fullscreen();
                $('.login').addClass('test'); //��б��Ч
                setTimeout(function () {
                    $('.login').addClass('testtwo'); //ƽ����Ч
                }, 300);
                setTimeout(function () {
                    $('.authent').show().animate({ right: -320 }, {
                        easing: 'easeOutQuint',
                        duration: 600,
                        queue: false
                    });
                    $('.authent').animate({ opacity: 1 }, {
                        duration: 200,
                        queue: false
                    }).addClass('visible');
                }, 500);

                //��¼
                var JsonData = { login: login, pwd: pwd, code: code };
                //�˴���Ϊajax�ڲ��ж�
                var url = "";
                if(JsonData.login == truelogin && JsonData.pwd == truepwd && JsonData.code.toUpperCase() == CodeVal.toUpperCase()){
                    url = "Ajax/Login";
                }else{
                    url = "Ajax/LoginFalse";
                }


                AjaxPost(url, JsonData,
                    function () {
                        //ajax������
                    },
                    function (data) {
                        //ajax����
                        //��֤���
                        setTimeout(function () {
                            $('.authent').show().animate({ right: 90 }, {
                                easing: 'easeOutQuint',
                                duration: 600,
                                queue: false
                            });
                            $('.authent').animate({ opacity: 0 }, {
                                duration: 200,
                                queue: false
                            }).addClass('visible');
                            $('.login').removeClass('testtwo'); //ƽ����Ч
                        }, 2000);
                        setTimeout(function () {
                            $('.authent').hide();
                            $('.login').removeClass('test');
                            if (data.Status == 'ok') {
                                //��¼�ɹ�
                                $('.login div').fadeOut(100);
                                $('.success').fadeIn(1000);
                                $('.success').html(data.Text);
                                //��ת����

                            } else {
                                AjaxErro(data);
                            }
                        }, 2400);
                    })
            }
        })
    })
    var fullscreen = function () {
        elem = document.body;
        if (elem.webkitRequestFullScreen) {
            elem.webkitRequestFullScreen();
        } else if (elem.mozRequestFullScreen) {
            elem.mozRequestFullScreen();
        } else if (elem.requestFullScreen) {
            elem.requestFullscreen();
        } else {
            //�������֧��ȫ��API���ѱ�����
        }
    }
    if(ajaxmockjax == 1){
        $.mockjax({
            url: 'Ajax/Login',
            status: 200,
            responseTime: 50,
            responseText: {"Status":"ok","Text":"��¼�ɹ�<br /><br />��ӭ����"}
        });
        $.mockjax({
            url: 'Ajax/LoginFalse',
            status: 200,
            responseTime: 50,
            responseText: {"Status":"Erro","Erro":"�˺������������֤������"}
        });
    }
</script>

</body>
</html>
