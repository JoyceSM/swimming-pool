var rootURL = "http://localhost:8080/swimming-pool/rest/login";

var loginVar = localStorage.getItem('loginVar');

$(document).ready(function() {

	$('#btnSignOut').hide();

	if (loginVar == 1) {
		$("#loginContainer").html("<h1>Manager</h1>");
		console.log("Manager");
	} else if (loginVar == 2) {
		console.log("Staff");
		$("#loginContainer").html("<h1>Staff</h1>");
	} else if (loginVar == 3) {
		console.log("Customer");
		$("#loginContainer").html("<h1>Customer</h1>");
	}

	if (loginVar != 0) {
		$('#btnSignOut').show();
	}

	$('#btnSignOut').click(function() {
		logout();
		return false;
	});

	$('#btnSignIn').click(function() {

		var username = $('#inputEmail').val();
		var password = $('#inputPassword').val();

		login(username, password);
		return false;
	})
});
// create findById
function findByUsername(username, password) {
	var loginData;
	console.log('findByUsername: ' + username);
	$.ajax({
		type : 'GET',
		url : rootURL + '?username=' + username + '&password=' + password,

		dataType : "json",
		async : false,
		success : function(data) {
			loginData = data
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			console.log("User doesn't exist error")
		}
	});
	return loginData;
};
// create login function
function login(username, password) {

	if (!username || !password) {

	} else {
		accessType = findByUsername(username, password);
		if (accessType != 0) {
			localStorage.setItem('loginVar', accessType);
			window.location.reload();
		}
	}
}
// create clear field
function clearUsernameAndPasswordField() {
	$('#inputUsername').val('');
	$('#inputPassword').val('');
};
// create logout
function logout() {
	clearUsernameAndPasswordField();

	loginVar = 0;
	localStorage.setItem('loginVar', 0);
	window.location.reload(true);
};
