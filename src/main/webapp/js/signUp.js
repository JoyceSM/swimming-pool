var rootURL = "http://localhost:8080/swimming-pool/rest/user";

$(document).ready(function () {
	// create sign in function
	$('#bntSignIn').click(function () {
		addUser();
	
	});

});
// create user
var addUser = function () {
	console.log('addUser');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: 'json',
		data: formToJSON(),
		success: function (data) {
			alert('User created successfully');
			$('#userId').val(data.userId);
		},
		error: function (jqXHR, textStatus) {
			alert('addUser error: ' + textStatus);
		}
	});
}

// Helper function to serialize all the form fields into a JSON string
var formToJSON = function () {
	return JSON.stringify({

		"fullName": $('#inputFullName').val(),
		"dateOfBirth": $("#inputDateOfBirth").val(),
		"membership": $('#inputMembership').val(),
		"email": $('#inputEmail').val(),
		"telephone": $('#inputTelephone').val(),
		"address": $('#inputAddress').val(),
		"city": $('#inputCity').val(),
		"credentials": {
			"username":	$('#inputEmail').val(),
			"password": $('#inputPassword').val(),
			"accessId": $('#inputAccessType').val()
		}
	})

}
