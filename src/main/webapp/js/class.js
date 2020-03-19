var rootURL = "http://localhost:8080/swimming-pool/rest/class";

$(document).ready(function() {

	$('#btnSave').click(function() {
		addClass();

		return false;

	})

	$('#listClass').DataTable({
		"ajax" : {
			"url" : rootURL,
			"dataSrc" : ""
		},

		"columns" : [ {
			"data" : "classId"
		}, {
			"data" : "className"
		}, {
			"data" : "instructor"
		}, {
			"data" : "capacity"
		}, {
			"data" : "startDate"
		}, {}, {
			"data" : "time"
		}, {
			data : null,
			className : "center",
			defaultContent : '<a href=""class="editor_remove">Remove</a>'

		} ]

	});
});
$('#listClass').on('click', 'a.editor_remove', function(e) {
	e.preventDefault();

	if (confirm("Are you sure that you want to delete this class?")) {
		var classId = $(this).closest("tr").find("td:eq(0)").text();
		deleteClass(classId);
		window.location.reload();
	}

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

var deleteClass = function(classId) {
	console.log('deleteClass');
	$.ajax({
		type : 'DELETE',
		url : rootURL + '/' + classId,
		success : function() {
			alert('Class deleted successfuly');
			currentClass = {};
			findAll();
		},
		error : function() {
			alert('deleteClass error')
		}
	})
}

var formToJSON = function() {
	return JSON.stringify({
		"classId" : $('#classId').val(),
		"className" : $('#className').val(),
		"price" : $('#price').val(),
		"capacity" : $('#capacity').val(),
		"startDate" : $('#startDate').val(),
		"endDate" : $('#endDate').val(),
		"instructor" : $('#instructor').val(),
		"timetable" : [ {
			"dayOfTheWeek" : "Sunday",
			"classTime" : $('#sunday').val(),
		}, {
			"dayOfTheWeek" : "Sunday",
			"classTime" : $('#sunday').val(),
		}, {
			"dayOfTheWeek" : "Monday",
			"classTime" : $('#monday').val(),
		}, {
			"dayOfTheWeek" : "Tuesday",
			"classTime" : $('#tuesday').val(),
		}, {
			"dayOfTheWeek" : "Wednesday",
			"classTime" : $('#wednesday').val(),
		}, {
			"dayOfTheWeek" : "Thursday",
			"classTime" : $('#thursday').val(),
		}, {
			"dayOfTheWeek" : "Friday",
			"classTime" : $('#friday').val(),
		}, {
			"dayOfTheWeek" : "Saturday",
			"classTime" : $('#saturday').val(),

		} ]
	});
}

function clearFormField() {
	$('#classId').val(''), $('#className').val(''), $('#price').val(''), $(
			'#capacity').val(''), $('#startDate').val(''), $('#endDate')
			.val(''), $('#instructor').val('')

};