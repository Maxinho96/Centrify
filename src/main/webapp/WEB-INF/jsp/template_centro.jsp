<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" dir="ltr">
<head>
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
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
<link rel="shortcut icon" href="/assets/images/favicon.png"
	type="image/x-icon" />

<title>${centro.nome}</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
<script src="/assets/js/require.min.js"></script>
<script>
	requirejs.config({
		baseUrl : '..'
	});
</script>

<!-- Dashboard Core -->
<link href="/assets/css/dashboard.css" rel="stylesheet" />
<script src="/assets/js/dashboard.js"></script>


<!-- c3.js Charts Plugin -->
<link href="/assets/plugins/charts-c3/plugin.css" rel="stylesheet" />
<script src="/assets/plugins/charts-c3/plugin.js"></script>

<!-- Google Maps Plugin -->
<link href="/assets/plugins/maps-google/plugin.css" rel="stylesheet" />
<script src="/assets/plugins/maps-google/plugin.js"></script>

<!-- Input Mask Plugin -->
<script src="/assets/plugins/input-mask/plugin.js"></script>

</head>
<body class="">
	<div class="page">
		<div class="page-main">
			<div class="header py-4">
				<div class="container">
					<div class="d-flex">
						<a class="header-brand" href="/mainpage_dir"> <img
							src="/assets/images/logo_title.png" class="header-brand-img"
							alt="Centrify logo">
						</a>
						<div class="d-flex order-lg-2 ml-auto">
							<div class="dropdown">
								<a href="#" class="nav-link pr-0 leading-none"
									data-toggle="dropdown"> <span class="avatar"
									style="background-image: url(/assets/images/profile_resp.png)">
										<span class="avatar-status bg-green"></span>
								</span> <span class="ml-2 d-none d-lg-block"> <span
										class="text-default">${direttore.nome}
											${direttore.cognome}</span> <small class="text-muted d-block mt-1">Direttore</small>
								</span>
								</a>
								<div
									class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
									<form id="logoutForm" method="post" action="/logout" style="cursor:pointer;">
										<input type="hidden" name="${_csrf.parameterName}"
											value="${_csrf.token}" /> <a class="dropdown-item"
											onclick="document.getElementById('logoutForm').submit();">
											<i class="dropdown-icon fe fe-log-out"></i> Sign out
										</a>
									</form>
								</div>
							</div>
						</div>
						<a href="#" class="header-toggler d-lg-none ml-3 ml-lg-0"
							data-toggle="collapse" data-target="#headerMenuCollapse"> <span
							class="header-toggler-icon"></span>
						</a>
					</div>
				</div>
			</div>
			<div class="header collapse d-lg-flex p-0" id="headerMenuCollapse">
				<div class="container">
					<div class="row align-items-center">
						<div class="col-lg order-lg-first">
							<ul class="nav nav-tabs border-0 flex-column flex-lg-row">
								<li class="nav-item"><a href="/mainpage_d"
									class="nav-link"> <i class="fe fe-home"></i> Home
								</a></li>
								<li class="nav-item"><a href="/aggiungi_centro"
									class="nav-link"> <i class="fe fe-user-plus"></i> Aggiungi
										Centro
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div class="my-3 my-md-5">
				<div class="container">
					<div class="row">
						<div class="col-md-1 col-lg-1"></div>
						<div class="col-md-6 col-lg-4">
							<div class="card">
								<div class="card-header">
									<h1 class="page-title">${centro.nome}</h1>
								</div>
								<div class="card-body">
									<p>${centro.descrizione}</p>
									<p>
                                    	<span class="card-title">Capienza: </span> 
                                        <span>${centro.capienza}</span>
                                    </p>
									<p>
                                    	<span class="card-title">Email: </span> 
                                        <span>${centro.email}</span>
                                    </p>
									<p>
                                    	<span class="card-title">Telefono: </span> 
                                        <span>${centro.telefono}</span>
                                    </p>
									<p>
                                    	<span class="card-title">Indirizzo: </span> 
                                        <span>${centro.indirizzo}</span>
                                    </p>
								</div>
							</div>
						</div>

						<div class="col-lg-6">
							<div class="row row-cards row-deck">
								<div class="col-12">
									<div class="card">
										<div class="card-header">
											<h1 class="card-title">Responsabile</h1>
										</div>
										<div class="table-responsive">
											<table
												class="table table-hover table-outline table-vcenter text-nowrap card-table">
												<thead>
													<tr>
														<th class="text-center w-1"><i class="icon-people"></i></th>
														<th>Nome</th>
														<th>Cognome</th>
														<th>Stipendio</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td class="text-center"><span
															class="avatar avatar-cyan d-block">${fn:substring(centro.responsabile.nome, 0, 1)}${fn:substring(centro.responsabile.cognome, 0, 1)}</span>
														</td>
														<td>
															<div>${centro.responsabile.nome}</div>
														</td>
														<td>
															<div>${centro.responsabile.cognome}</div>
														</td>
														<td>
															<div>${centro.responsabile.stipendio}</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<footer class="footer">
	<div class="container">
		<div class="row align-items-center">
			<div class="col-10">Sviluppato con amore da Marco Berbeglia,
				Diego Barbieri e Massimiliano Bruni</div>
			<div class="col-2 text-right">
				<a href="https://bitbucket.org/marcoBerb/progetto_siw/"
					class="btn btn-outline-primary btn-sm">Source code</a>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>