<%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="images/ico.png" type="image/x-icon">
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
    <div class="errordiv">
    	<p>Oops! Something Went Wrong...</p>
    	<p>Try Later</p>
    </div>
      <footer class="page-footer font-small blue pt-4">
        <div class="container-fluid text-center text-md-left">
            <div class="row">
                <div class="col-md-6 mt-md-0 mt-3">
                    <h5 class="text-uppercase">Crudo</h5>
                    <p>Manage Your Todos Here.</p>
                </div>
                <hr class="clearfix w-100 d-md-none pb-3">
                <div class="col-md-3 mb-md-0 mb-3">
                    <h5 class="text-nowrap">Social</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a href="https://www.facebook.com/thevicky54"
                                class="fa fa-facebook fa-lg text-dark"></a>
                        </li>
                        <li>
                            <a href="https://twitter.com/vickypl54" class="fa fa-twitter fa-lg text-dark"></a>
                        </li>
                        <li>
                            <a href="https://www.linkedin.com/in/vicky-pl/"
                                class="fa fa-linkedin-square fa-lg text-dark"></a>
                        </li>
                        <li>
                            <a href="https://www.instagram.com/the_vicky_pl/"
                                class="fa fa-google-plus fa-lg text-dark"></a>
                        </li>
                    </ul>
                </div>
                <div class="col-md-3 mb-md-0 mb-3">
                    <h5 class="text-nowrap">Quick Links</h5>
                    <ul class="list-unstyled">
                        <li>
                            <a class="fa fa-home" href="index.jsp">&nbsp;Home</a>
                        </li>
                        <li>
                            <a class="fa fa-info" href="">&nbsp;Login</a>
                        </li>
                        <li>
                            <a class="fa fa-sign-in" href="">&nbsp;Signup</a>
                        </li>
                        <li>
                            <a class="fa fa-angle-double-up" href="aboutus.jsp">&nbsp;AboutUs</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="footer-copyright text-center py-3">© 2021 Copyright:
            <a href="index.jsp"> crudo.com</a>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
        integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
        crossorigin="anonymous"></script>
    <script src="js/myjs.js"></script>
</body>

</html>