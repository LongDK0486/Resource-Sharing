<%-- 
    Document   : Login
    Created on : May 18, 2021, 5:45:10 PM
    Author     : PRREDETOR
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="Css/Login.css"/>
        <title>Login Page</title>
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body>
        <form action="MainController" method="POST">
            <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="form-body">
                        <ul class="nav nav-tabs final-login">
                            <li class="active"><a data-toggle="tab" href="#sectionA">Sign In</a></li>      
                        </ul>
                        <div class="tab-content">
                            <div id="sectionA" class="tab-pane fade in active">
                                <div class="innter-form">
                                    <form class="sa-innate-form" method="post">
                                        <label>USER ID</label><br/>
                                        <input type="text" name="userID"><br/>
                                        <label>Password</label>
                                        <input type="password" name="password">
                                        <div class="g-recaptcha" data-sitekey="6LcbCNQaAAAAACcuyzxC969q-l9eYCLl397mvxnS" >                
                                        </div>
                                        <br/>
                                        <button type="submit" name="action" value="Login">Sign In</button>
                                        <a href="CreateUser.jsp">Create User</a>
                                    </form>
                                </div>
                                <div class="social-login">
                                    <p>- - - - - - - - - - - - - Sign In With - - - - - - - - - - - - - </p>
                                    <ul>                                       
                                        <li><a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/L3LP0016/login-google&response_type=code
    &client_id=347868517803-g751f34csfdulo09ec3hvka8en5bqrdo.apps.googleusercontent.com&approval_prompt=force"><i class="fa fa-google-plus"></i> Google+</a></li>                                        
                                    </ul>
                                </div>
                                <div class="clearfix"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </form>
        
        
    </body>
</html>
