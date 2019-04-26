 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title>我的 - 吴扬</title>
    <style>

    </style>

<%
String username=(String)session.getAttribute("username");
String phone_number=(String)session.getAttribute("phone_number");
String lv=(String)session.getAttribute("lv");
String qr_url=(String)session.getAttribute("qr_url");
String leader=(String)session.getAttribute("leader");
String Enable=(String)session.getAttribute("Enable");

if(phone_number==null)
{
	response.sendRedirect("Login.jsp");
}

%>
<title><%=username%></title>
</head>

<body>

<div class="nav">
    <h1 class="nav-title">我的</h1>
</div>

<div class="cell-box ">
    <a href="salesman.php?mod=edit_information">
        <div class="cell">
            <div class="cell-icon">
                <img src="skin/images/salesman/head1.png" alt=""></div>
            <div class="cell-left">
                <span class="cell-label in-credit-label"></span>
            </div>
            <div class="cell-right">
                <span class="pay-total">吴扬(17508910598)<img src="../skin/images/m/more.png"
                                                                                 width="9" height="16"></span>
            </div>
        </div>
    </a>
        <marquee behavior="scroll" direction="left">
           <span style="color:red">通知：现代理商可查看名下推广用户的手机号</span>
        </marquee>
    <a href="salesman.php?mod=salesman_qercode&time=12045">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label">油卡推广二维码</span>
            </div>
            <div class="cell-right">
				<span class="pay-total">用户分期赚佣金
					<img src="../skin/images/m/more.png" width="9" height="16"></span>
            </div>
        </div>
    </a>
        <a href="salesman.php?mod=edit_paw&action=login">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label">修改登录密码</span>
            </div>
            <div class="cell-right">
				<span class="pay-total">
					<img src="../skin/images/m/more.png" width="9" height="16"></span>
            </div>
        </div>
    </a>
    <a href="salesman.php?mod=edit_paw&action=pay">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label">设置提现密码</span>
            </div>
            <div class="cell-right">
				<span class="pay-total">
					<img src="../skin/images/m/more.png" width="9" height="16"></span>
            </div>
        </div>
    </a>
</div>
<div class="cell-box ">
    <!-- <a href="salesman.php?mod=bank_account">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label">分润账户</span>
            </div>
            <div class="cell-right">
                <span class="pay-total">点击绑定银行卡<img src="../skin/images/m/more.png" width="9"
                                                            height="16"></span>
            </div>
        </div>
    </a>-->
    <!--<a href="#">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label">通知公告</span>
            </div>
            <div class="cell-right">
				<span class="pay-total">
					<img src="../skin/images/m/more.png" width="9" height="16"></span>
            </div>
        </div>
    </a>-->
    <a href="javascript:void(0)">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label" style="font-weight: bold;">我的邀请码</span>
            </div>
            <div class="cell-right">
				<span class="pay-total" style="font-weight: bold;">
					10767</span>
            </div>
        </div>
    </a>
    <a href="/salesman.php?mod=bank_account">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label" >管理银行卡</span>
            </div>
            <div class="cell-right">
				<span class="pay-total" ></span>
            </div>
        </div>
    </a>
    <a href="tel:400-0059498">
        <div class="cell">
            <div class="cell-left">
                <span class="cell-label in-credit-label">客服热线</span>
            </div>
            <div class="cell-right">
				<span class="pay-total">
					400-0059498<img src="../skin/images/m/more.png" width="9" height="16">
                </span>
            </div>
        </div>
    </a>

    <input type="button" id="btnexit" name="btnexit" class="button5 btn_exit" onclick="exit();" value="退出登录">
</div>
<div class="bottom_fxied" style="left: 0px; bottom: 0px; width: 100%; display: block;">
	<footer>
		<a href="salesman.php?mod=finance_show" data-ajax="false">
			<span>
				<img src="../skin/images/salesman/icon_tiao5.png"></span>
			<p>收入</p>
		</a>
		<!-- <a href="salesman.php?mod=distribution3" data-ajax="false">
			<span>
				<img src="../skin/images/salesman/icon_jisuanqi.png"></span>
			<p>营销</p>
		</a> -->
		<!--<a href="salesman.php?mod=tixian_list" data-ajax="false">
			<span>
				<img src="../skin/images/salesman/icon_qian3.png"></span>
			<p>提现</p>
		</a>-->
		<a href="salesman.php?mod=me" data-ajax="false">
			<span>
				<img src="../skin/images/salesman/icon_wo.png"></span>
			<p>我的</p>
		</a>
	</footer>
</div>


<style>
	.pagebottom{
		color: #666666;
		text-align: left;
		
	}
	.pagebottom p{
		padding: 0 15px;
		line-height: 30px;
		text-align: left;
	}
	.pagebottom p:first-child{color: red;}
	.pagebottom dl{
		padding: 5px 15px;
		font-size: 14px;
		margin-bottom: 60px;
	}
	.pagebottom dt{text-indent: 20px;}
	.pagebottom dd{line-height: 30px;}
</style>
<div class="pagebottom">
	<p>温馨提示：</p>
	<p><!--优信优卡-->申请流程升级公告：</p>
	<dl>
		<dt>为充分提高白条用户申请的体验感，<!--优信优卡-->申请流程再次迭代更新，更新内容如下：</dt>
		<dd>1、简化申请步骤;</dd>
		<dd>2、由新版人脸语音识别系统替代手持身份证正面照;</dd>
		<dd>3、植入更多人工智能技术，用户手工填写的项目将会大幅度减少;</dd>
		<dd>4、本次优化提高了用户的申请体验感，确保了用户信息安全，审批速度会略有影响，望代理商周知。</dd>
	</dl>
</div>
<div class="tishiYuKuang elementNone" id="tishiYuKuang">
    <a href="javascript:;">提示</a>
</div>
<script type="text/javascript">
    function exit() {
        location.href = 'salesman.php?mod=login&action=exit';
    }
</script>
</body>
</html>