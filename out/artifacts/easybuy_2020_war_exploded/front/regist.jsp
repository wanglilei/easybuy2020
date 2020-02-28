<%@ page import="com.buy.utils.RegUtils" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/2/24
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>

<%
    RegUtils regUtils = new RegUtils();
    request.setAttribute("regUtils",regUtils);
%>

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


    <title>易买网，注册</title>
</head>
<body>
<!--Begin Header Begin-->
<div class="soubg">
    <div class="sou">
        <span class="fr">
        	<span class="fl">你好，请<a href="${ctx}/login?action=login">登录</a>&nbsp;
                <a href="${ctx}/regist?action=toRegister" style="color:#ff4e00;">免费注册</a>&nbsp; </span>
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
        <div class="logo"><a href="${ctx}/front/home.jsp"><img src="${ctx}/images/logo.png" /></a></div>
    </div>
    <div class="regist">
        <div class="log_img"><img src="${ctx}/images/l_img.png" width="611" height="425" /></div>
        <div class="reg_c">
            <form>
                <table border="0" style="width:420px; font-size:14px; margin-top:20px;" cellspacing="0" cellpadding="0">
                    <tr height="50" valign="top">
                        <td width="95">&nbsp;</td>
                        <td>
                            <span class="fl" style="font-size:24px;">注册</span>
                            <span class="fr">已有商城账号，<a href="Login.html" style="color:#ff4e00;">我要登录</a></span>
                        </td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;登陆名 &nbsp;</td>
                        <td><input type="text" value="" class="l_user" id="loginName"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;用户名 &nbsp;</td>
                        <td><input type="text" value="" class="l_user" id="userName"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;密码 &nbsp;</td>
                        <td><input type="password" value="" class="l_pwd" id="ped" /></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;确认密码 &nbsp;</td>
                        <td><input type="password" value="" class="l_pwd" id="rePwd"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;邮箱 &nbsp;</td>
                        <td><input type="text" value="" class="l_email" id="email"/></td>
                    </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>&nbsp;手机 &nbsp;</td>
                        <td><input type="text" value="" class="l_tel" id="phone"/></td>
                    </tr>
                    <tr height="50">
                    <td align="right"><font color="#ff4e00">*</font>&nbsp;性别 &nbsp;</td>
                    <td>
<%--                        checked--%>
                        <form action="" method="get" id="sex">
                            <input name="sex" type="radio" value="0" checked/>男&emsp;
                            <input name="sex" type="radio" value="1" />女
                        </form>
                    </td>
                </tr>
                    <tr height="50">
                        <td align="right"><font color="#ff4e00">*</font>身份证号 &nbsp;</td>
                        <td><input type="text" value="" class="l_num" id="idCode"/></td>
                    </tr>
<%--                    <tr height="50">--%>
<%--                        <td align="right"> <font color="#ff4e00">*</font>&nbsp;验证码 &nbsp;</td>--%>
<%--                        <td>--%>
<%--                            <input type="text" value="" class="l_ipt" />--%>
<%--                            <a href="#" style="font-size:12px; font-family:'宋体';">换一张</a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
                    <tr>
                        <td>&nbsp;</td>
                        <td style="font-size:12px; padding-top:20px;">
                	<span style="font-family:'宋体';" class="fl">
                    	<label class="r_rad"><input type="checkbox" /></label><label class="r_txt">我已阅读并接受《用户协议》</label>
                    </span>
                        </td>
                    </tr>
                    <tr height="60">
                        <td>&nbsp;</td>
                        <td><input type="submit" value="立即注册" class="s_btn" onclick="reg();"/></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>

<script>
    function reg() {
        //获取相关字段的值
        var loginName = $("#loginName").val();
        var userName = $("#userName").val();
        var password = $("#ped").val();
        var confirmPassword = $("#rePwd").val();
        var email = $("#email").val();
        var mobile = $("#phone").val();
        var identityCode = $("#idCode").val();
        var sex = $("input[name='sex']:checked").val();
        alert(loginName+"\n"+userName+"\n"+password+"\n"+confirmPassword+"\n"+email+"\n"+mobile+"\n"+identityCode+"\n"+sex);
        // 判断密码是否一致
        // if(loginName!=null && loginName!=""){
        //     alert("用户名不能为空.");
        //     return;
        // }
        // if(loginName.length<2 || loginName>10){
        //     alert("登录名不能小于两个字符或者大于十个字符.");
        //     return;
        // }
        // if(userName!=null && userName!=""){
        //     alert("真实姓名不能为空.");
        //     return;
        // }
        // if(userName.length<2 || userName>10){
        //     alert("真实姓名不能小于两个字符或者大于十个字符.");
        //     return;
        // }
        // if (password != confirmPassword) {
        //     alert("两次输入的密码不一致.");
        //     return;
        //     //判断密码是否为空
        // }
        // if (password !="") {
        //     alert("密码不能为空");
        //     return;
        //     //验证邮箱格式
        // }
        // if(email!=null && email!=""){
        //     alert("邮箱不能为空");
        //     return;
        //     //验证邮箱格式
        // }
        // if(mobile!=null && mobile!=""){
        //     alert("手机不能为空");
        //     return;
        //     //验证邮箱格式
        // }
        // if(identityCode!=null && identityCode!=""){
        //     alert("身份证号不能为空");
        //     return;
        // }
        $.ajax({
            url:"${ctx}/regist",
            dataType:"json",
            type:"get",
            data: {loginName:loginName, userName:userName, pwd:password, sex:sex, email:email,
                phone:mobile, idCode:identityCode, action:"doRegister"},
            success:function (json) {
                alert("json");
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

