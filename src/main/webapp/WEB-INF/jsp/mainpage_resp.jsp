<%@ page contentType="text/html; charset=UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
        <html lang="en" dir="ltr">
            <head>
                <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
                <meta http-equiv="X-UA-Compatible" content="ie=edge">
                <meta http-equiv="Content-Language" content="en" />

                <meta name="msapplication-TileColor" content="#2d89ef">
                <meta name="theme-color" content="#4188c9">

                <meta name="apple-mobile-web-app-status-bar-style"
                      content="black-translucent" />
                <meta name="apple-mobile-web-app-capable" content="yes">
                <meta name="mobile-web-app-capable" content="yes">
                <meta name="HandheldFriendly" content="True">
                <meta name="MobileOptimized" content="320">

                <link rel="icon" href="/assets/images/favicon.png" type="image/x-icon" />
                <link rel="shortcut icon" href="/assets/images/favicon.png" type="image/x-icon" />

                <title>Home</title>

                <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
                <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
                <script src="/assets/js/require.min.js"></script>
                <script>
                    requirejs.config({
                        baseUrl : '.'
                    });
                </script>

                <!-- Dashboard Core -->
                <link href="/assets/css/dashboard.css" rel="stylesheet" />
                <script src="/assets/js/dashboard.js"></script>

                <!-- Input Mask Plugin -->
                <script src="/assets/plugins/input-mask/plugin.js"></script>

            </head>
            <body class="">
                <div class="page">
                    <div class="page-main">
                        <div class="header py-4">
                            <div class="container">
                                <div class="d-flex">
                                    <a class="header-brand" href="/mainpage_r"> 
                                        <img src="/assets/images/logo_title.png" class="header-brand-img" alt="Centrify logo">
                                    </a>
                                    <div class="d-flex order-lg-2 ml-auto">
                                        <div class="dropdown">
                                            <a href="" class="nav-link pr-0 leading-none" data-toggle="dropdown"> 
                                                <span class="avatar" style="background-image: url(/assets/images/profile_resp.png)">
                                                    <span class="avatar-status bg-green"></span>
                                                </span> 
                                                <span class="ml-2 d-none d-lg-block"> 
                                                    <span class="text-default">${responsabile.nome} ${responsabile.cognome}</span> 
                                                    <small class="text-muted d-block mt-1">Responsabile</small>
                                                </span>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                <!--a class="dropdown-item" href="/logout"> 
                                                    <i class="dropdown-icon fe fe-log-out"></i> Sign out
                                                </a-->
                                                <form id="logoutForm" method="post" action="/logout" style="cursor:pointer;">
  													<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> 
  													<a class="dropdown-item" onclick="document.getElementById('logoutForm').submit();">
  														<i class="dropdown-icon fe fe-log-out"></i> Sign out
  													</a>
												</form>
											</div>
                                        </div>
                                    </div>
                                    <a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0" data-toggle="collapse" data-target="#headerMenuCollapse"> 
                                        <span class="header-toggler-icon"></span>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="header collapse d-lg-flex p-0" id="headerMenuCollapse">
                            <div class="container">
                                <div class="row align-items-center">
                                    <div class="col-lg-3 ml-auto">
                                        <form class="input-icon my-3 my-lg-0" action="/submit_ricercaAllievo">
                                            <input type="search" name="stringa_ricerca" class="form-control header-search" placeholder="Cerca allievo&hellip;" tabindex="1" method="get">
                                            <div class="input-icon-addon">
                                                <i class="fe fe-search"></i>
                                            </div>
                                        </form>
                                    </div>
                                    <div class="col-lg order-lg-first">
                                        <ul class="nav nav-tabs border-0 flex-column flex-lg-row">
                                            <li class="nav-item">
                                                <a href="/mainpage_r" class="nav-link active">
                                                    <i class="fe fe-home"></i> Home
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="/aggiungi_allievo" class="nav-link">
                                                    <i class="fe fe-user-plus"></i> Aggiungi allievo
                                                </a>
                                            </li>
                                            <li class="nav-item">
                                                <a href="/aggiungi_attivita" class="nav-link">
                                                    <i class="fe fe-file-plus"></i> Aggiungi attività
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="my-3 my-md-5">
                            <div class="container">
                            	<c:forEach var="att" items="${attivita}">
	                                <div class="row">
	                                	<div class="col-lg-2 col-xl-2"></div>
                                        <div class="col-sm-12 col-md-12 col-lg-8 col-xl-8">
                                            <div class="card">
                                                <div class="card-status card-status-left bg-blue"></div>
                                                <div class="card-header">
                                                    <h3 class="card-title">${att.nomeAttivita}</h3>
                                                    <div class="card-options">
                                                        <a href="/scheda_attivita/${att.id}" class="btn btn-primary btn-sm">Apri</a>
                                                    </div>
                                                </div>
                                                <div class="card-body">${att.descrizione}</div>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>

                <footer class="footer">
                    <div class="container">
                        <div class="row align-items-center">
                            <div class="col-10">
                                Sviluppato con amore da Marco Berbeglia, Diego Barbieri e Massimiliano Bruni
                            </div>
                            <div class="col-2 text-right">
                            	<a href="https://bitbucket.org/marcoBerb/progetto_siw/" class="btn btn-outline-primary btn-sm">Source code</a>
                            </div>
                        </div>
                    </div>
                </footer>
            </body>
        </html>