<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/24
  Time: 14:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link type="text/css" rel="stylesheet" href="${ctx}/css/style.css" />
    <!--[if IE 6]>
    <script src="${ctx}/js/iepng.js" type="text/javascript"></script>
    <script type="text/javascript">
        EvPNG.fix('div, ul, img, li, input, a');
    </script>
    <![endif]-->
    <script type="text/javascript" src="${ctx}/js/jquery-1.11.1.min_044d0927.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.bxslider_e88acd1b.js"></script>

    <script type="text/javascript" src="${ctx}/js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="${ctx}/js/menu.js"></script>

    <script type="text/javascript" src="${ctx}/js/select.js"></script>

    <script type="text/javascript" src="${ctx}/js/lrscroll.js"></script>

    <script type="text/javascript" src="${ctx}/js/iban.js"></script>
    <script type="text/javascript" src="${ctx}/js/fban.js"></script>
    <script type="text/javascript" src="${ctx}/js/f_ban.js"></script>
    <script type="text/javascript" src="${ctx}/js/mban.js"></script>
    <script type="text/javascript" src="${ctx}/js/bban.js"></script>
    <script type="text/javascript" src="${ctx}/js/hban.js"></script>
    <script type="text/javascript" src="${ctx}/js/tban.js"></script>

    <script type="text/javascript" src="${ctx}/js/lrscroll_1.js"></script>


    <title>易买网，登陆</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <span class="fr">
        	<span class="fl">你好，请<a href="${ctx}/front/login.jsp">登录</a>&nbsp; <a href="${ctx}/front/Regist.html" style="color:#ff4e00;">免费注册</a>&nbsp; </span>
            <span class="fl">|&nbsp;关注我们：</span>
            <span class="s_sh"><a href="#" class="sh1">新浪</a><a href="#" class="sh2">微信</a></span>
            <span class="fr">|&nbsp;<a href="#">手机版&nbsp;<img src="${ctx}/images/s_tel.png" align="absmiddle" /></a></span>
        </span>
    </div>
</div>
<!--End Header End-->
<!--Begin Login Begin-->

<div class="log_bg">
    <div class="top">
        <div class="logo"><a href="${ctx}/home?action=index"><img src="${ctx}/images/logo.png" /></a></div>
    </div>
    <div class="login">
        <div class="log_img"><img src="${ctx}/images/l_img.png" width="611" height="425" /></div>
        <div class="log_c">
            <form>
                <table border="0" style="width:370px; font-size:14px; margin-top:30px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="55">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">登录</span>
                            <span class="fr">还没有商城账号，<a href="${ctx}/regist?action=toRegister" style="color:#ff4e00;">立即注册</a></span>
                        </td>
                    </tr>
                    <tr height="70">
                        <td>用户名</td>
                        <td><input type="text" value="" class="l_user" id="loginName" /></td>
                    </tr>
                    <tr height="70">
                        <td>密&nbsp; &nbsp; 码</td>
                        <td><input type="password" value="" class="l_pwd" id="password"/></td>
                    </tr>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" /></label><label class="r_txt">请保存我这次的登录信息</label>
                    </span>
                            <span class="fr"><a href="#" style="color:#ff4e00;">忘记密码</a></span>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="button" value="登录" class="s_btn" onclick="login();"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
<script>
    function login() {
        // alert("开始登陆");
        var loginName = $("#loginName").val();
        var password = $("#password").val();
        // alert(loginName+"::::"+password);

        <%--location.href = "${ctx}/login?loginName = "+loginName+"&password="+password+"";--%>
        $.ajax({
            url:"${ctx}/login",
            dataType:"json",
            type:"get",
            data:{loginName:loginName,password:password,action:"login"},
            success:function (json) {
                // alert("json");
                if (json.status == 1){
                    alert("登陆成功");
                    location.href = "${ctx}/home?action=index"
                }else {
                    alert("登陆失败！");
                }
            },error:function () {
                alert("error");
            }
        })
    }
</script>
<!--End Login End-->
<!--Begin Footer Begin-->
<div class="btmbg">
    <div class="btm">
        备案/许可证编号：蜀ICP备12009302号-1-www.dingguagua.com   Copyright © 2015-2018 易买商城网 All Rights Reserved. 复制必究 , Technical Support: Dgg Group <br />
        <img src="${ctx}/images/b_1.gif" width="98" height="33" /><img src="${ctx}/images/b_2.gif" width="98" height="33" /><img src="${ctx}/images/b_3.gif" width="98" height="33" /><img src="${ctx}/images/b_4.gif" width="98" height="33" /><img src="${ctx}/images/b_5.gif" width="98" height="33" /><img src="${ctx}/images/b_6.gif" width="98" height="33" />
    </div>
</div>
<!--End Footer End -->

</body>


<!--[if IE 6]>
<script src="//letskillie6.googlecode.com/svn/trunk/2/zh_CN.js"></script>
<![endif]-->
</html>

