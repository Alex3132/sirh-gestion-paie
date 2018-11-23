<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAIE</title>
</head>
<body>
	<table>
			<c:forEach var="salaire" items="${mapBulletinCalcul}">

			<tr>
				<td><c:out value="${salaire.key.remunerationEmploye.creation}"/></td>
				<td><c:out value="${salaire.key.periode.dateAffichee}"/></td>
				<td><c:out value="${salaire.key.remunerationEmploye.matricule}"/></td>
				<td><c:out value="${salaire.value.salaireBrut}"/></td>
				<td><c:out value="${salaire.value.netImposable}"/></td>
				<td><c:out value="${salaire.value.netAPayer}"/></td>
				<td><a class="btn btn-primary" href="recapitulatif?idBulletin=${bulletin.key.id}">Afficher</a>
			</tr>

		</c:forEach> 
	</table>
</body>
</html>