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