<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Petcare - Login</title>
	
	<link href="<c:url value="/resources/css/materialize.min.css"/>" type="text/css" rel="stylesheet" media="screen,projection">
	<link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet" media="screen,projection">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>

<body class="green lighten-4">
	<div id="login-page" class="row">
		<div class="col s12 z-depth-4 card-panel">
	      <form class="login-form" action="<c:url value='j_spring_security_check' />" method="POST">
	        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	        <div class="row">
	          <div class="input-field s12 center">
	            <img id="image-login" src="<c:url value="/resources/images/pet-icon.png"/>" alt="">
	            <p class="center login-form-text">PetCare Administração</p>
	          </div>
	        </div>
	        <div class="row">
	        	<c:if test="${not empty erro }">
		        	<label>${erro }</label>
	        	</c:if>
	        </div>
	        <div class="row margin">
	          <div class="input-field col s12">
	            <i class="material-icons prefix">perm_identity</i>
	            <input id="username" type="text" name="username">
	            <label for="username" class="center-align">Usuário</label>
	          </div>
	        </div>
	        <div class="row margin">
	          <div class="input-field col s12">
	            <i class="material-icons prefix">vpn_key</i>
	            <input id="password" type="password" name="password">
	            <label for="password">Senha</label>
	          </div>
	        </div>
	        <div class="row">
	          <div class="input-field col s12">
	            <input type="submit" value="Login" class="btn waves-effect waves-light col s12"/>
	          </div>
	        </div>
	      </form>
	    </div>
	</div>

	<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.12.3.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/materialize.min.js"/>"></script>
</body>
	
</html>