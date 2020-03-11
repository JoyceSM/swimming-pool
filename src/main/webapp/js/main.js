var rootURL = "http://localhost:8080/swimming-pool/rest/user";

$(document).ready(function() {
	findAll();
	$(document).on("click", "#btnAdd", function(){newUser();});
});

var findAll = function() {
	console.log('findAll');
	$.ajax({
		type: 'GET',
		url: rootURL,
		dataType: "json",
		success:renderList
	});
};

function renderList(data){
	$.each(data, function(index, user){
		$('#userList').append('<li><a href="#" id="' + user.id + '">' + user.name + '</a></li>');
	});
}

var newUser = function(){
	console.log('addUser');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: "json",
		data: formToJSON(),
		success: function(data, textStatus, jqXHR){
			alert('User created successfully');
			$('#userId').val(data.id);
			//$('#userList li').remove();
			findAll();
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addUser error: ' + textStatus)
		}
	});
};

var formToJSON = function(){
//	var userId = $('#userId').val();
	return JSON.stringify({
		//"user_id": userId == "" ? null : userId, 
		"full_name": $('#fullnameuser').val(),
		"date_of_birth": $('#dobuser').val(),
		"gender": $('#gender').val(),
		"membership": $('#membership').val(),
		"address": $('#addressUser').val(),
		"city": $('#cityUser').val(),
		"phone": $('#phoneuser').val(),
		"email_address": $('#emailUser').val()
	});
};

