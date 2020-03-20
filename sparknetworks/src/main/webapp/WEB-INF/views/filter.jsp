
<form:form action="/filter" method="post"
	modelAttribute="filterHandlerRequest">
	<table class="table">
		<tr>
			<td><label>Compatibility</label></td>
			<td><form:input path="compatibility.from" class="form-control"
					placeholder="from" type="number" /></td>
			<td><form:input path="compatibility.to" class="form-control"
					placeholder="to" type="number" /></td>
		</tr>
		<tr>
			<td><label>Age</label></td>
			<td><form:input path="age.from" class="form-control"
					placeholder="from" type="number" /></td>
			<td><form:input path="age.to" class="form-control"
					placeholder="to" type="number" /></td>
		</tr>
		<tr>
			<td><label>Height</label></td>
			<td><form:input path="height.from" class="form-control"
					placeholder="from" type="number" /></td>
			<td><form:input path="height.to" class="form-control"
					placeholder="to" type="number" /></td>
		</tr>
		<tr>
			<td><label>Distance</label></td>
			<td><form:input path="distance.from" class="form-control"
					placeholder="from" type="number" /></td>
			<td><form:input path="distance.to" class="form-control"
					placeholder="to" type="number" /></td>
		</tr>
		<tr>
			<td>
				<ul>
					<form:select path="religions" items="${RELIGION_MAP}" />
				</ul>
			</td>
		</tr>
		<tr>
			<td><label class="checkbox-inline"> <form:checkbox
						path="strictType" />Strict
			</label></td>
			<td><label class="checkbox-inline"> <form:checkbox
						path="hasPhoto" />Photo
			</label></td>
			<td><label class="checkbox-inline"> <form:checkbox
						path="inContact" />Contact
			</label></td>
			<td><label class="checkbox-inline"> <form:checkbox
						path="favorite" />Favorite
			</label></td>
		</tr>
		<tr>
			<td><button class="btn btn-primary" type="submit">Search</button></td>
		</tr>
	</table>
</form:form>