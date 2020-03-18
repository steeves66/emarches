<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
        
        <!-- Title -->
        <title>Page de connexion</title>
      
        <!-- Styles -->
       <link href="resources/css/login.css" rel="stylesheet"/>
       
        <script src="resources/js/login.js"></script>

   
        
    </head>
    <body>
<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <div class="login-form">
      
        <form method="post" action="#" role="login">
          <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
          <input type="email" name="email" placeholder="Email" required class="form-control input-lg" value="joestudent@gmail.com" />
          
          <input type="password" class="form-control input-lg" id="password" placeholder="Password" required="" />
          
          
          <div class="pwstrength_viewport_progress"></div>
          
          
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
          <div>
            <a href="#">Create account</a> or <a href="#">reset password</a>
          </div>
           <div>
            <a href="consultation.jsf?faces-redirect=true">Suivi de Mission</a>
          </div>
        </form>
        
        <div class="form-links">
          <a href="#">www.website.com</a>
        </div>
      </div>  
      </div>
      
      <div class="col-md-4"></div>
      

  </div>
   
</div>


</body></html>