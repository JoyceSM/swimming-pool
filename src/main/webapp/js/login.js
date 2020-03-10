var rootURL = "http://localhost:8080/swimming-pool/rest/login";
var MANAGER = "manager";
var STAFF = "staff";
var CUSTOMER = "customer";

var loginVar = localStorage.getItem('loginVar');

$(document).ready(function() {

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

	$('#btnSignIn').click(function() {

		var username = $('#inputEmail').val();
		var password = $('#inputPassword').val();

		login(username, password);
		return false;
	})
});

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

function logout() {

	localStorage.setItem('loginVar', 0);
	window.location.reload(true);

}
