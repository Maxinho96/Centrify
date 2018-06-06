<%@ page contentType="text/html; charset=UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="en" dir="ltr">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
            <meta http-equiv="X-UA-Compatible" content="ie=edge">
            <meta http-equiv="Content-Language" content="en" />

            <meta name="msapplication-TileColor" content="#2d89ef">
            <meta name="theme-color" content="#4188c9">

            <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent"/>
            <meta name="apple-mobile-web-app-capable" content="yes">
            <meta name="mobile-web-app-capable" content="yes">
            <meta name="HandheldFriendly" content="True">
            <meta name="MobileOptimized" content="320">

            <link rel="icon" href="/assets/images/favicon.png" type="image/x-icon"/>
            <link rel="shortcut icon" href="/assets/images/favicon.png" type="image/x-icon"/>

            <title>Aggiungi attività</title>

            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,300i,400,400i,500,500i,600,600i,700,700i&amp;subset=latin-ext">
            <script src="/assets/js/require.min.js"></script>
            <script>
                requirejs.config({
                    baseUrl: '.'
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
                                <a class="header-brand" href="/mainpage">
                                    <img src="/assets/images/logo_title.png" class="header-brand-img" alt="Centrify logo">
                                </a>
                                <div class="d-flex order-lg-2 ml-auto">
                                    <div class="dropdown">
                                        <a href="#" class="nav-link pr-0 leading-none" data-toggle="dropdown">
                                            <span class="avatar" style="background-image: url(/assets/images/profile_resp.png)">
                                                <span class="avatar-status bg-green"></span>
                                            </span>
                                            <span class="ml-2 d-none d-lg-block">
                                                <span class="text-default">Marco Rossi</span>
                                                <small class="text-muted d-block mt-1">Responsabile</small>
                                            </span>
                                        </a>
                                        <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                            <a class="dropdown-item" href="#">
                                                <i class="dropdown-icon fe fe-user"></i> Profilo
                                            </a>
                                            <a class="dropdown-item" href="/logout">
                                                <i class="dropdown-icon fe fe-log-out"></i> Sign out
                                            </a>
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
                                    <form class="input-icon my-3 my-lg-0">
                                        <input type="search" class="form-control header-search" placeholder="Cerca allievo&hellip;" tabindex="1">
                                        <div class="input-icon-addon">
                                            <i class="fe fe-search"></i>
                                        </div>
                                    </form>
                                </div>
                                <div class="col-lg order-lg-first">
                                    <ul class="nav nav-tabs border-0 flex-column flex-lg-row">
                                        <li class="nav-item">
                                            <a href="/mainpage" class="nav-link"><i class="fe fe-home"></i> Home</a>
                                        </li>
                                        <li class="nav-item">
                                            <a href="/aggiungi_allievo" class="nav-link"><i class="fe fe-user-plus"></i> Aggiungi allievo</a>
                                        </li>

                                        <li class="nav-item">
                                            <a href="/aggiungi_attivita" class="nav-link active"><i class="fe fe-file-plus"></i> Aggiungi attività</a>
                                        </li>                                    
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="my-3 my-md-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-2 col-xl-2"></div>
                                <div class="col-lg-8 col-xl-8">
                                    <div class="card">
                                        <div class="card-header">
                                            <h3 class="card-title">Nuova attività</h3>
                                        </div>
                                        <div class="card-body">
                                            <div class="row">
                                                <div class="col-md-5 col-lg-5">
                                                    <div class="form-group">
                                                        <label class="form-label">Nome</label>
                                                        <input type="text" name="nome_attivita" class="form-control" placeholder="" />
                                                    </div>      
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-7 col-lg-6">
                                                    <div class="form-group">
                                                        <label class="form-label">Data svolgimento</label>
                                                        <div class="row gutters-xs">
                                                            <div class="col-4">
                                                                <select name="giorno_svolgimento" class="form-control custom-select">
                                                                    <option value="" selected="selected">Giorno</option>
                                                                    <option value="1">1</option>
                                                                    <option value="2">2</option>
                                                                    <option value="3">3</option>
                                                                    <option value="4">4</option>
                                                                    <option value="5">5</option>
                                                                    <option value="6">6</option>
                                                                    <option value="7">7</option>
                                                                    <option value="8">8</option>
                                                                    <option value="9">9</option>
                                                                    <option value="10">10</option>
                                                                    <option value="11">11</option>
                                                                    <option value="12">12</option>
                                                                    <option value="13">13</option>
                                                                    <option value="14">14</option>
                                                                    <option value="15">15</option>
                                                                    <option value="16">16</option>
                                                                    <option value="17">17</option>
                                                                    <option value="18">18</option>
                                                                    <option value="19">19</option>
                                                                    <option value="20">20</option>
                                                                    <option value="21">21</option>
                                                                    <option value="22">22</option>
                                                                    <option value="23">23</option>
                                                                    <option value="24">24</option>
                                                                    <option value="25">25</option>
                                                                    <option value="26">26</option>
                                                                    <option value="27">27</option>
                                                                    <option value="28">28</option>
                                                                    <option value="29">29</option>
                                                                    <option value="30">30</option>
                                                                    <option value="31">31</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-4">
                                                                <select name="mese_svolgimento" class="form-control custom-select">
                                                                    <option value="" selected="selected">Mese</option>
                                                                    <option value="1">Gennaio</option>
                                                                    <option value="2">Febbraio</option>
                                                                    <option value="3">Marzo</option>
                                                                    <option value="4">Aprile</option>
                                                                    <option value="5">Maggio</option>
                                                                    <option value="6">Giugno</option>
                                                                    <option value="7">Luglio</option>
                                                                    <option value="8">Agosto</option>
                                                                    <option value="9">Settembre</option>
                                                                    <option value="10">Ottobre</option>
                                                                    <option value="11">Novembre</option>
                                                                    <option value="12">Dicembre</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-3">
                                                                <select name="anno_svolgimento" class="form-control custom-select">
                                                                    <option value="" selected="selected">Anno</option>
                                                                    <option value="2005">2018</option>
                                                                    <option value="2005">2019</option>
                                                                    <option value="2005">2020</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 col-lg-4">
                                                    <div class="form-group">
                                                        <label class="form-label">Orario svolgimento</label>
                                                        <div class="row gutters-xs">
                                                            <div class="col-4">
                                                                <select name="ora_svolgimento" class="form-control custom-select">
                                                                    <option value="" selected="selected">Ore</option>
                                                                    <option value="0">00</option>
                                                                    <option value="1">01</option>
                                                                    <option value="2">02</option>
                                                                    <option value="3">03</option>
                                                                    <option value="4">04</option>
                                                                    <option value="5">05</option>
                                                                    <option value="6">06</option>
                                                                    <option value="7">07</option>
                                                                    <option value="8">08</option>
                                                                    <option value="9">09</option>
                                                                    <option value="10">10</option>
                                                                    <option value="11">11</option>
                                                                    <option value="12">12</option>
                                                                    <option value="13">13</option>
                                                                    <option value="14">14</option>
                                                                    <option value="15">15</option>
                                                                    <option value="16">16</option>
                                                                    <option value="17">17</option>
                                                                    <option value="18">18</option>
                                                                    <option value="19">19</option>
                                                                    <option value="20">20</option>
                                                                    <option value="21">21</option>
                                                                    <option value="22">22</option>
                                                                    <option value="23">23</option>
                                                                </select>
                                                            </div>
                                                            <div class="col-4">
                                                                <select name="minuto_svolgimento" class="form-control custom-select">
                                                                    <option value="" selected="selected">Min</option>
                                                                    <option value="0">00</option>
                                                                    <option value="1">01</option>
                                                                    <option value="2">02</option>
                                                                    <option value="3">03</option>
                                                                    <option value="4">04</option>
                                                                    <option value="5">05</option>
                                                                    <option value="6">06</option>
                                                                    <option value="7">07</option>
                                                                    <option value="8">08</option>
                                                                    <option value="9">09</option>
                                                                    <option value="10">10</option>
                                                                    <option value="11">11</option>
                                                                    <option value="12">12</option>
                                                                    <option value="13">13</option>
                                                                    <option value="14">14</option>
                                                                    <option value="15">15</option>
                                                                    <option value="16">16</option>
                                                                    <option value="17">17</option>
                                                                    <option value="18">18</option>
                                                                    <option value="19">19</option>
                                                                    <option value="20">20</option>
                                                                    <option value="21">21</option>
                                                                    <option value="22">22</option>
                                                                    <option value="23">23</option>
                                                                    <option value="24">24</option>
                                                                    <option value="25">25</option>
                                                                    <option value="26">26</option>
                                                                    <option value="27">27</option>
                                                                    <option value="28">28</option>
                                                                    <option value="29">29</option>
                                                                    <option value="30">30</option>
                                                                    <option value="31">31</option>
                                                                    <option value="13">32</option>
                                                                    <option value="14">33</option>
                                                                    <option value="15">34</option>
                                                                    <option value="16">35</option>
                                                                    <option value="17">36</option>
                                                                    <option value="18">37</option>
                                                                    <option value="19">38</option>
                                                                    <option value="20">39</option>
                                                                    <option value="21">40</option>
                                                                    <option value="22">41</option>
                                                                    <option value="23">42</option>
                                                                    <option value="24">43</option>
                                                                    <option value="25">44</option>
                                                                    <option value="26">45</option>
                                                                    <option value="27">46</option>
                                                                    <option value="28">47</option>
                                                                    <option value="29">48</option>
                                                                    <option value="30">49</option>
                                                                    <option value="31">50</option>
                                                                    <option value="22">51</option>
                                                                    <option value="23">52</option>
                                                                    <option value="24">53</option>
                                                                    <option value="25">54</option>
                                                                    <option value="26">55</option>
                                                                    <option value="27">56</option>
                                                                    <option value="28">57</option>
                                                                    <option value="29">58</option>
                                                                    <option value="30">59</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-5 col-lg-3">
                                                    <div class="form-group">
                                                        <label class="form-label">Nome professore</label>
                                                        <input type="text" name="nome_professore" class="form-control" placeholder="" />
                                                    </div>      
                                                </div>
                                                <div class="col-md-5 col-lg-3">
                                                    <div class="form-group">
                                                        <label class="form-label">Cognome professore</label>
                                                        <input type="text" name="cognome_professore" class="form-control" placeholder="" />
                                                    </div>      
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-12 col-lg-12">
                                                    <div class="form-group">
                                                        <label class="form-label">Descrizione
                                                        </label>
                                                        <textarea class="form-control" name="descrizione" rows="3" placeholder="Inserisci descrizione..."></textarea>
                                                    </div>    
                                                </div>
                                            </div>
                                        </div> 
                                        <div class="card-footer text-right">
                                            <button type="submit" class="btn btn-primary">Aggiungi</button>
                                        </div>
                                    </div>
                                    <script>
                                        require(['input-mask']);
                                    </script>
                                </div>
                            </div>
                        </div>   
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container">
                    <div class="row align-items-center flex-row-reverse">
                        <div class="col-auto ml-lg-auto">
                            <div class="row align-items-center">
                                <div class="col-auto">
                                    <a href="#" class="btn btn-outline-primary btn-sm">Source code</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-12 col-lg-auto mt-3 mt-lg-0 text-center">
                            Sviluppato con amore da Marco Berbeglia, Diego Barbieri e Massimiliano Bruni
                        </div>
                    </div>
                </div>
            </footer>
        </body>
    </html>