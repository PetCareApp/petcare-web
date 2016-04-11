<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Petcare - Novo Petshop</title>
	<jsp:include page="fragments/head.jsp"></jsp:include>
</head>
<body class="light-green lighten-5">
	<header>
	  <nav class="green lighten-2">
	    <div class="nav-wrapper">
	      <a href="#" class="brand-logo center"><img src="<c:url value="/resources/images/pet-icon.png"/>" alt=""></a>
	      <ul id="nav-mobile" class="left hide-on-med-and-down">
	        <li><a href="sass.html"><i class="material-icons">location_on</i></a></li>
	        <li><a href="badges.html">Petshops</a></li>
	      </ul>
	    </div>
	  </nav>
	</header>
	
	<div class="container">
       <div class="row">
		    <form class="col s12">
		    	<header>Novo Pet Shop</header>
		    	<h6><i class="material-icons">pets</i> Petshop</h6>
		      	<div class="row">
			        <div class="input-field col s8">
			          <input id="petshop-nome" type="text" class="validate">
			          <label for="petshop-nome">Nome</label>
			        </div>
			      </div>
			      
			      <h6><i class="material-icons">place</i> Endereço</h6>
			      <div class="row">
			        <div class="input-field col s6">
			          <input id="endereco" type="text" class="validate">
			          <label for="endereco">Endereço</label>
			        </div>
			        <div class="input-field col s2">
			          <input id="numero" type="text" class="validate">
			          <label for="numero">Número</label>
			        </div>
			        <div class="input-field col s4">
			          <input id="bairro" type="text" class="validate">
			          <label for="bairro">Bairro</label>
			        </div>
			      </div>
			      <div class="row">
			        <div class="input-field col s6">
			          <input id="cidade" type="text" class="validate">
			          <label for="cidade">Cidade</label>
			        </div>
			        <div class="input-field col s2">
			          <input id="estado" type="text" class="validate">
			          <label for="estado">Estado</label>
			        </div>
			        <div class="input-field col s4">
			          <input id="cep" type="text" class="validate">
			          <label for="cep">CEP</label>
			        </div>
			      </div>
			      
			      <h6><i class="material-icons">account_box</i> Usuário</h6>
			      <div class="row">
			        <div class="input-field col s8">
			          <input id="nome" type="text" class="validate">
			          <label for="nome">Nome</label>
			        </div>
			      </div>
			      <div class="row">
			        <div class="input-field col s6">
			          <input id="email" type="email" class="validate">
			          <label for="email">Email</label>
			        </div>
			        <div class="input-field col s6">
			          <input id="password" type="password" class="validate">
			          <label for="password">Senha</label>
			        </div>
			      </div>
			      <div class="right">
			      	<button class="btn waves-effect waves-light green lighten-1" type="submit" name="action">Cadastrar
    					<i class="material-icons right">send</i>
  					</button>
			      </div>
		    </form>
		  </div>
    </div>
	
	<jsp:include page="fragments/footer.jsp"></jsp:include>
</body>
</html>