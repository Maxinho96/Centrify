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

        <!-- Generated: 2018-05-24 16:37:20 +0200 -->

        <title>Aggiungi allievo</title>

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
                            <a class="header-brand" href="/index.html">
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
                                        <a href="/aggiungi_allievo" class="nav-link active"><i class="fe fe-user-plus"></i> Aggiungi allievo</a>
                                    </li>

                                    <li class="nav-item">
                                        <a href="/aggiungi_attivita" class="nav-link"><i class="fe fe-file-plus"></i> Aggiungi attività</a>
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
                                        <h3 class="card-title">Nuovo allievo</h3>
                                    </div>
                                    <div class="card-body">
                                        <div class="row">
                                            <div class="col-md-3 col-lg-3">
                                                <div class="form-group">
                                                    <label class="form-label">Nome</label>
                                                    <input type="text" name="field-name" class="form-control" placeholder="" />
                                                </div>      
                                            </div>
                                            <div class="col-md-3 col-lg-3">
                                                <div class="form-group">
                                                    <label class="form-label">Cognome</label>
                                                    <input type="text" name="field-name" class="form-control" placeholder="" />
                                                </div>
                                            </div>
                                            <div class="col-md-3 col-lg-3">
                                                <div class="form-group">
                                                    <div class="form-label">Sesso</div>
                                                    <div class="custom-controls-stacked">
                                                        <label class="custom-control custom-radio custom-control-inline">
                                                            <input type="radio" class="custom-control-input" name="example-inline-radios" value="option1" checked>
                                                            <span class="custom-control-label">M</span>
                                                        </label>
                                                        <label class="custom-control custom-radio custom-control-inline">
                                                            <input type="radio" class="custom-control-input" name="example-inline-radios" value="option2">
                                                            <span class="custom-control-label">F</span>
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-5 col-lg-5">
                                                <div class="form-group">
                                                    <label class="form-label">Email</label>
                                                    <input type="text" name="field-name" class="form-control" placeholder="email@posta.com" />
                                                </div>   
                                            </div>
                                            <div class="col-md-3 col-lg-3">
                                                <div class="form-group">
                                                    <label class="form-label">Cellulare</label>
                                                    <input type="text" name="field-name" class="form-control" data-mask="000 000 0000" data-mask-clearifnotmatch="true" placeholder="335 123 4567" />
                                                </div>
                                            </div>
                                            <div class="col-md-3 col-lg-3">
                                                <div class="form-group">
                                                    <label class="form-label">Data Iscrizione</label>
                                                    <div class="form-control-plaintext">11/03/2018</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-7 col-lg-7">
                                                <div class="form-group">
                                                    <label class="form-label">Data di nascita</label>
                                                    <div class="row gutters-xs">
                                                        <div class="col-4">
                                                            <select name="giorno_nascita" class="form-control custom-select">
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
                                                            <select name="mese_nascita" class="form-control custom-select">
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
                                                        <div class="col-4">
                                                            <select name="anno_nascita" class="form-control custom-select">
                                                                <option value="" selected="selected">Anno</option>
                                                                <option value="2005">2005</option>
                                                                <option value="2004">2004</option>
                                                                <option value="2003">2003</option>
                                                                <option value="2002">2002</option>
                                                                <option value="2001">2001</option>
                                                                <option value="2000">2000</option>
                                                                <option value="1999">1999</option>
                                                                <option value="1998">1998</option>
                                                                <option value="1997">1997</option>
                                                                <option value="1996">1996</option>
                                                                <option value="1995">1995</option>
                                                                <option value="1994">1994</option>
                                                                <option value="1993">1993</option>
                                                                <option value="1992">1992</option>
                                                                <option value="1991">1991</option>
                                                                <option value="1990">1990</option>
                                                                <option value="1989">1989</option>
                                                                <option value="1988">1988</option>
                                                                <option value="1987">1987</option>
                                                                <option value="1986">1986</option>
                                                                <option value="1985">1985</option>
                                                                <option value="1984">1984</option>
                                                                <option value="1983">1983</option>
                                                                <option value="1982">1982</option>
                                                                <option value="1981">1981</option>
                                                                <option value="1980">1980</option>
                                                                <option value="1979">1979</option>
                                                                <option value="1978">1978</option>
                                                                <option value="1977">1977</option>
                                                                <option value="1976">1976</option>
                                                                <option value="1975">1975</option>
                                                                <option value="1974">1974</option>
                                                                <option value="1973">1973</option>
                                                                <option value="1972">1972</option>
                                                                <option value="1971">1971</option>
                                                                <option value="1970">1970</option>
                                                                <option value="1969">1969</option>
                                                                <option value="1968">1968</option>
                                                                <option value="1967">1967</option>
                                                                <option value="1966">1966</option>
                                                                <option value="1965">1965</option>
                                                                <option value="1964">1964</option>
                                                                <option value="1963">1963</option>
                                                                <option value="1962">1962</option>
                                                                <option value="1961">1961</option>
                                                                <option value="1960">1960</option>
                                                                <option value="1959">1959</option>
                                                                <option value="1958">1958</option>
                                                                <option value="1957">1957</option>
                                                                <option value="1956">1956</option>
                                                                <option value="1955">1955</option>
                                                                <option value="1954">1954</option>
                                                                <option value="1953">1953</option>
                                                                <option value="1952">1952</option>
                                                                <option value="1951">1951</option>
                                                                <option value="1950">1950</option>
                                                                <option value="1949">1949</option>
                                                                <option value="1948">1948</option>
                                                                <option value="1947">1947</option>
                                                                <option value="1946">1946</option>
                                                                <option value="1945">1945</option>
                                                                <option value="1944">1944</option>
                                                                <option value="1943">1943</option>
                                                                <option value="1942">1942</option>
                                                                <option value="1941">1941</option>
                                                                <option value="1940">1940</option>
                                                                <option value="1939">1939</option>
                                                                <option value="1938">1938</option>
                                                                <option value="1937">1937</option>
                                                                <option value="1936">1936</option>
                                                                <option value="1935">1935</option>
                                                                <option value="1934">1934</option>
                                                                <option value="1933">1933</option>
                                                                <option value="1932">1932</option>
                                                                <option value="1931">1931</option>
                                                                <option value="1930">1930</option>
                                                                <option value="1929">1929</option>
                                                                <option value="1928">1928</option>
                                                                <option value="1927">1927</option>
                                                                <option value="1926">1926</option>
                                                                <option value="1925">1925</option>
                                                                <option value="1924">1924</option>
                                                                <option value="1923">1923</option>
                                                                <option value="1922">1922</option>
                                                                <option value="1921">1921</option>
                                                                <option value="1920">1920</option>
                                                                <option value="1919">1919</option>
                                                                <option value="1918">1918</option>
                                                                <option value="1917">1917</option>
                                                                <option value="1916">1916</option>
                                                                <option value="1915">1915</option>
                                                                <option value="1914">1914</option>
                                                                <option value="1913">1913</option>
                                                                <option value="1912">1912</option>
                                                                <option value="1911">1911</option>
                                                                <option value="1910">1910</option>
                                                                <option value="1909">1909</option>
                                                                <option value="1908">1908</option>
                                                                <option value="1907">1907</option>
                                                                <option value="1906">1906</option>
                                                                <option value="1905">1905</option>
                                                                <option value="1904">1904</option>
                                                                <option value="1903">1903</option>
                                                                <option value="1902">1902</option>
                                                                <option value="1901">1901</option>
                                                                <option value="1900">1900</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-lg-4">
                                                <div class="form-group">
                                                    <label class="form-label">Città natale</label>
                                                    <input type="text" name="field-name" class="form-control" placeholder="" />
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