var rootURL = "http://localhost:8080/swimming-pool/rest/user";

$(document).ready(function () {
	var loginVar = localStorage.getItem('loginVar');

	if (loginVar == 1) {
		$('.inputAccessTypeHidden').remove();
	} else {
		$('.inputAccessTypeSelect').remove();
	}

	// create sign up function
	$('#btnSignUp').click(function () {
		addUser();

	});
	//create back function
	$('#btnBack').click(function () {
		window.history.back();
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
				$('#userId').val(data.userId);
				window.location.assign("loginPage.html");
				alert('User created successfully.');
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
				"username": $('#inputEmail').val(),
				"password": $('#inputPassword').val(),
				"accessId": $('#inputAccessType').val()
			}
		})

	}
});