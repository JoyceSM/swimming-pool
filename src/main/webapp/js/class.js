var rootURL = "http://localhost:8080/swimming-pool/rest/class";

$(document).ready(function() {

	$('#btnSave').click(function() {
		addClass();

		return false;

	})
});

function addClass() {
	console.log('addClass');
	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		url : rootURL,
		dataType : 'json',
		data : formToJSON(),
		success : function(data) {
			alert('Class created successfully');
			clearFormField();
		},
		error : function(jqXHR, textStatus) {
			alert('Class error: ' + textStatus);
		}
	});
}

var formToJSON = function() {
	return JSON.stringify({
		"classId" : $('#classId').val(),
		"className" : $('#className').val(),
		"price" : $('#price').val(),
		"capacity" : $('#capacity').val(),
		"startDate" : $('#startDate').val(),
		"endDate" : $('#endDate').val(),
		"instructor" : $('#instructor').val()
	});
}

function clearFormField() {
	$('#classId').val(''), $('#className').val(''), $('#price').val(''), $(
			'#capacity').val(''), $('#startDate').val(''), $('#endDate')
			.val(''), $('#instructor').val('')

};