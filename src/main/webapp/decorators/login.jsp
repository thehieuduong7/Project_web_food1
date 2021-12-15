<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link href="<c:url value="/assets/css/loginstyle.css"/>" rel="stylesheet" type="text/css"/>
             <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        
        <title>Login Form</title>
    </head>
    <body>
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<div class="login-reg-panel">
		<div class="login-info-box">
			<h2>Have an account?</h2>
			<p>Lorem ipsum dolor sit amet</p>
			<label id="label-register" for="log-reg-show">Login</label>
			<input type="radio" name="active-log-panel" id="log-reg-show"  checked="checked">
		</div>
							
		<div class="register-info-box">
			<h2>Don't have an account?</h2>
			<p>Lorem ipsum dolor sit amet</p>
			<label id="label-login" for="log-login-show">Register</label>
			<input type="radio" name="active-log-panel" id="log-login-show">
		</div>
							
		<div class="white-panel">
			<div class="login-show">
				<div class="alert alert-danger" role="alert">
				${alertMsg }</div>
				<form action="<c:url value="/login"/>" method="post">
					<h2>LOGIN</h2>
					<input type="text" name="input_username"
					 placeholder="Email">
					 <input name="input_password"
						type="password" placeholder="Password"> 

					<div class="form-group form-check">
						<input name="remember" value="1" type="checkbox"
							class="form-check-input" id="remmeber_check"> 
							<label
							class="form-check-label" for="exampleCheck1">Remember me</label> <input type="submit" class="btn btn-primary"
							style="float: right; padding: 10px 30px;
							 float: right; background-color: #242424; 
							 text-transform: uppercase;"
							value="Login">
					</div>
					
				</form>

			</div>
			<div class="register-show">
				<form action="<c:url value="/registor"/>" method="post">
					<h2>REGISTER</h2>
					<input type="text" name="input_full_name" placeholder="Full name" required>
					 <input name="input_username"
						type="text" placeholder="Email" required>
						 <input type="password" name="input_password" id="input_password_reg"
						placeholder="Password" required> 
						<input type="password" name="input_password_confirm" id="input_password_conf_reg"
						placeholder="Confirm Password" required> 
							<input type="submit" class="btn btn-primary"
							style="float: right; padding: 10px 30px;
							 float: right; background-color: #242424; 
							 text-transform: uppercase;" onclick="checkConfirmPass(event)"
							value="register">
				</form>
			</div>
		</div>
	</div>
    </body>
    <script>

    $(document).ready(function(){
    $('.login-info-box').fadeOut();
    $('.login-show').addClass('show-log-panel');
});


$('.login-reg-panel input[type="radio"]').on('change', function() {
    if($('#log-login-show').is(':checked')) {
        $('.register-info-box').fadeOut(); 
        $('.login-info-box').fadeIn();
        
        $('.white-panel').addClass('right-log');
        $('.register-show').addClass('show-log-panel');
        $('.login-show').removeClass('show-log-panel');
        
    }
    else if($('#log-reg-show').is(':checked')) {
        $('.register-info-box').fadeIn();
        $('.login-info-box').fadeOut();
        
        $('.white-panel').removeClass('right-log');
        
        $('.login-show').addClass('show-log-panel');
        $('.register-show').removeClass('show-log-panel');
    }
});
  
 function checkConfirmPass(event){
	 var pwd_reg = document.getElementById("input_password_reg")
	 var pwd_conf_reg = document.getElementById("input_password_conf_reg")
	 
	 console.log(pwd_reg.value)
		console.log(pwd_conf_reg.value)
	
	console.log(event)

	 if(pwd_reg.value.trim()!=pwd_conf_reg.value.trim()){
		 alert("Confirm fail!!!");
		 event.preventDefault()
		 //cancelFormSubmission();
		 //event.stopPropagation();
		 return;
	 }
	 if(!confirm("Bạn chắc chắn muốn tạo tài khoản???")){
		 return;
	 }
	 
 }

    </script>
</html>