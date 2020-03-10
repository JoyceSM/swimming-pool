var rootURL = "http://localhost:8080/swimming-pool/";

$(document).ready(function() {
	findAll();
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
			$('#userList li').remove();
			findAll();
		},
		error: function(jqXHR, textStatus, errorThrown){
			alert('addUser error: ' + textStatus)
		}
	});
};