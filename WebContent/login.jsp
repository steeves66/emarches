<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>E-MarchésPublics</title>
    <link rel="shortcut icon" type="image/x-icon" href="resources/portail/img/icons/favicon.png" />
    <link rel="stylesheet" type="text/css" href="resources/portail/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="resources/portail/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="resources/portail/css/style.css" media="screen">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,700i,800,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Poppins:400,400i,500,500i,600,600i,700,700i,800,800i,900" rel="stylesheet">
</head>

<body>

    <div class="container-fluid">
        <div class="row">
            <section class="col-md-8 content-left">
                <div class="row">
                    <div class="col-md-2 col-xs-6 logo-armoirie">
                    <!--  <img src="resources/portail/img/logo_dmp.png" class="img-responsive" alt="logo primature" style=""> -->
                    <br/><br/><br/><br/>
                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12 text-center footer">
                        <ul class="list-unstyled list-inline">
                         <br/><br/><br/><br/><br/>
                            <li>
                                <a href="http://www.marchespublics.ci/">
                                    <br>  ALLER SUR LE PORTAIL DE LA DGMP </a>
                            </li>
                            <li>
                                <a href="http://www.gouv.ci/Main.php">
                                    <br>  ALLER SUR LE PORTAIL DU GOUVERNEMENT </a>
                            </li> 
                            <li>
                                <a href="/E-MarchesPublics/assistance.jsf">
                                    <br>  ASSISTANCE & AIDE </a>
                            </li>
                            
                        </ul>
                    </div>
                </div>
            </section>

            <section class="col-md-4 content-right">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12 logo">
                      <!-- <img src="resources/portail/img/logo.JPG" class="img-responsive center-block" alt="Amoiries Ci" style=""> -->
                       <br/><br/><br/><br/><br/><br/><br/>
                    </div>
                    <div class="col-md-12 col-sm-12 col-xs-12 form-entete text-center">
                      <!--   <h1> BIENVENUE SUR LE PORTAIL DE GESTION DES MARCHES PUBLIC </h1> -->
                      <br/><br/>
                    </div>
                    
                    
                    <div class="col-md-12 col-sm-12 col-xs-12 form text-center">
                        <h3 class="user-icon">
                            <i class="fa fa-user-circle"></i>
                        </h3>

                        <form role="form" class="form" action="j_spring_security_check" method='POST'>
                            <div class="input-group">
                                <input type="text" id="username" name='j_username' class="form-control" placeholder="Utilisateur" aria-describedby="basic-addon2">
                                <span class="input-group-addon" id="basic-addon2">
                                        <i class="fa fa-user-circle"></i>
                                    </span>
                            </div>
                            <div class="input-group">
                                <input type="password" id="password" name='j_password' class="form-control" placeholder="Mot de passe" aria-describedby="basic-addon2">
                                <span class="input-group-addon" id="basic-addon2">
                                        <i class="fa fa-expeditedssl"></i>
                                    </span>
                            </div>
                            
                            <button type="submit" class="btn btn btn-default btn-lg btn-block">
                                SE CONNECTER
                            </button>
                        </form>

                </div>

                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 form-footer text-center">
                       <!--  <a class="register" href="#"> MOT DE PASSE OUBLIE ?</a> -->
                       <!-- <br> PAS DE COMPTE ?
                            <a class="register" href=""> Inscrivez vous ici </a> -->
                    </div>
                    <div class="col-xs-12 col-sm-12 col-md-12 copyright text-center">
                      <!--   <p>
                            © 2019 Designed by SNDI
                            <img class="logo-footer" src="resources/portail/img/logo-footer.png" title="SNDI" alt="SNDI"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        </p> -->
                    </div>
                </div>
            </section>
        </div>
    </div>

    <script src="resources/portail/js/jquery/jquery-3.2.1.min.js"></script>
    <script src="resources/portail/js/bootstrap.min.js"></script>
</body>

</html>