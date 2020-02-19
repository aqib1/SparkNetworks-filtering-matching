<c:if test="${not empty personDetails}">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Count</th>
					<th scope="col">Name</th>
					<th scope="col">Age</th>
					<th scope="col">Job</th>
					<th scope="col">Height</th>
					<th scope="col">City</th>
					<th scope="col">Latitude</th>
					<th scope="col">Longitude</th>
					<th scope="col">Photo</th>
					<th scope="col">Compatibility</th>
					<th scope="col">Contacts</th>
					<th scope="col">Favorite</th>
					<th scope="col">Religion</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="person" items="${personDetails}" varStatus="loop">
					<tr>
						<th scope="row">${loop.count}</th>
						<td>${person.displayName}</td>
						<td>${person.age}</td>
						<td>${person.jobTitle}</td>
						<td>${person.heightInCm}</td>
						<td>${person.city.name}</td>
						<td>${person.city.lat}</td>
						<td>${person.city.lon}</td>
						<td>${person.mainPhoto}</td>
						<td>${person.compatibilityScore}</td>
						<td>${person.contactsExchanged}</td>
						<td>${person.favourite}</td>
						<td>${person.religion}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>