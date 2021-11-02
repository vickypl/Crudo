<%@ page errorPage="errorpage.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="images/ico.png" type="image/x-icon">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
   	<meta name="google-signin-client_id" content="454346989339-ljj48vqbf5emlsukbe7bhdsqbnun74kd.apps.googleusercontent.com">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="css/style.css">
    <title>Crudo</title>
</head>
<body class="container-fluid" onload="typeEffect()">
    <nav class="navbar navbar-expand-lg navbar-light bg-gradient">
        <div class="container-fluid">
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03"
                aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Crudo</a>
            <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" data-toggle="modal" data-target="#exampleModalCenter" href="">Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo" href="">Signup</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="aboutus.jsp">AboutUs</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
  <!--User Login Modal -->
  <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">Login</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <form method="post" action="userlogin">
                <div class="form-group">
                  <label for="exampleInputEmail1">Username/E-mail</label>
                  <input type="text" class="form-control" name="username" required="required" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Password</label>
                  <input type="password" class="form-control" name="password" required="required" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="form-group form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Remember Me</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">SignIn</button>
              </form>
        </div>
        <div class="modal-footer">
            <a href="passwordrecovery.jsp">forgetPassword?</a>
        </div>
      </div>
    </div>
  </div>
  <!--Signup Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel"><h4 class="h4">SignUp</h4></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form method="POST" action="usersignup">
            <div class="form-group">
              <label for="exampleInputEmail1">First Name</label>
              <input type="text" name="fname" maxlength="20" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="First Name">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Last Name</label>
                <input type="text" name="lname" maxlength="20" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Last Name">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">E-mail</label>
                <input type="email" name="email" maxlength="45" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="E-mail">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Username</label>
                <input type="text" id="unm" onblur="usernameAvailable()" name="username" minlength="8" maxlength="30" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Username">
                <small id="availablity"></small>
            </div>
            <div class="form-group">
                <label for="exampleInputEmail1">Password</label>
                <input type="password" name="password" maxlength="20" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Password">
            </div>
            <div class="form-group form-check">
              <input type="checkbox" class="form-check-input" required id="exampleCheck1">
              <label class="form-check-label" for="exampleCheck1">I accept the terms and Conditions.</label>
            </div>
            <button type="submit" class="btn btn-primary btn-block">SignUp</button>
          </form>
      </div>
      <div class="modal-footer">
      </div>
    </div>
  </div>
</div>
  <!-- Admin Login Modal -->
  <div class="modal fade" id="adminlogin" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLongTitle">Admin Login</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
            <form method="post" action="adminlogin">
                <div class="form-group">
                  <label for="exampleInputEmail1">Username/E-mail</label>
                  <input type="text" name="username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Username/Email">
                  <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                  <label for="exampleInputPassword1">Password</label>
                  <input type="password" name="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                </div>
                <div class="form-group form-check">
                  <input type="checkbox" class="form-check-input" id="exampleCheck1">
                  <label class="form-check-label" for="exampleCheck1">Remember Me</label>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Log-In</button>
              </form>
        </div>
        <div class="modal-footer">
            <a href="passwordrecovery.jsp">forgetPassword?</a>
        </div>
      </div>
    </div>
  </div>