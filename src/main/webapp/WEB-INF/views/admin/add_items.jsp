<%@ include file="/WEB-INF/taglib.jsp" %>


<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add new Photo</h3>
					<form:form id='myform' method="POST" action="/admin/addItems" modelAttribute="modelRequest" enctype="multipart/from-data">
					 
			<%-- 			Price: <input type="text" name="price"><br>
						Year: <input type="text" name="year"><br>
				 
						
						Body: 
						<form:select path="bodyType" items="${bodyModel}"></form:select><br>
						
			
						Memory:
						<form:select path="Memory" items="${typeMemory}" itemLabel="memory"></form:select> --%>
						
						  <label class="control-label">Photo Image:</label><br>
							<input type="file" onchange="previewFile()"/> <br>
							<form:input id='imagetosend' path="image" type="hidden"/>
							<img id="preview" src="" height="200" alt="Image preview...">
						<input type="submit" value="Create Photo">
					</form:form>
				</div>
			</div>
		</div>
</div>	

<script>
function previewFile() {
  var preview = document.querySelector('#preview');
  var file    = document.querySelector('input[type=file]').files[0];
	var hidden = document.querySelector('#imagetosend');
  var reader  = new FileReader();

  reader.addEventListener("load", function () {
    preview.src = reader.result;
		hidden.value = reader.result;
  }, false);

  if (file) {
    reader.readAsDataURL(file);
  }
}
</script>	
























<%-- 
<div class="row">
	<div class="col-md-4 col-md-offset-4">
		<div class="login-wrapper">
			<div class="box">
				<div class="content-wrap">
					<h3>Add new Items</h3>
					<form:form action="/register" modelAttribute="userModel">
						<div class="form-group">
							<form:errors path="*" cssClass="error"/>
						</div>
						<div class="form-group">
  							<label class="control-label">E-mail address</label>
							<form:input path="email" cssClass="form-control" title="E-mail address" />
							
							 <label class="control-label">First Name</label>
							<form:input path="firstName" cssClass="form-control" title="E-mail address" />
							
							<label class="control-label">Last Name</label>
							<form:input path="lastName" cssClass="form-control" title="E-mail address" />
							
							<label class="control-label">Age</label>
							<form:input path="age" cssClass="form-control" title="E-mail address" />

							<label class="control-label">Password</label>
							<form:password path="password" cssClass="form-control" title="Password" />
							
							<label class="control-label">Password Confirmation</label>
							<form:password path="passwordConfirmation" cssClass="form-control" title="Password Confirmation" />
						</div>
						<div class="form-group">
							<span class="input-group-btn">
								<input type="submit" class="btn btn-primary" value="Register">
							</span>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
--%>