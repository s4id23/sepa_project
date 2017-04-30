<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestion des transations SEPA</title>
    </head>
    <body>
    		
   	 <h2>Bienvenue au service de gestion des Transactions</h2>
     <p> vous pouvez :</p>
     <ul>
     	<li><a href="detail">Afficher la liste detailler des transactions</a></li>
  		<li><a href="stats">Afficher une synthèse des transactions stockée</a></li>
  		<li><a href="resume">Afficher sous forme résumée, la liste des transactions enregistrées</a></li>
  		<li>Afficher le contenu complet de la transaction dont l'identifiant est "n"</li>
  		<li>Déposer une nouvelle transaction</li>
	 </ul>
	 
	  <footer>
  		<p>Créer par : BENAOUICHA Mohand-Said & BABAGHAYOU Khaled</p>
  		<p>Le : 28/02/2017</p>
	  </footer>    	
    	 
    </body>
</html>
