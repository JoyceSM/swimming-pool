$(document)
	.ready(
		function () {

			var rootURL = "http://localhost:8080/swimming-pool/rest/class";
			var loginVar = localStorage.getItem('loginVar');

			var availableBtns = " ";

			if (loginVar == 1) {
				availableBtns = '<a href=""class="editor_edit">Edit</a>/<a href=""class="editor_remove">Remove</a>';

			} else if (loginVar == 2) {
				availableBtns = '<a href=""class="editor_edit">Edit</a>';
				$('#price').prop('disabled', true);
				$('#capacity').prop('disabled', true);
				$('#classId').prop('disabled', true);

			} else {

			}
			// create view class
			if ($('#listClass').length) {
				$('#listClass').DataTable({
					"ajax": {
						"url": rootURL,
						"dataSrc": ""
					},

					"columns": [{
						"data": "classId"
					}, {
						"data": "className"
					}, {
						"data": "instructor"
					}, {
						"data": "capacity"
					}, {
						"data": "startDate"
					},{
						"data": "price"
					},{
						data: null,
						className: "center",

						defaultContent: availableBtns,
					}]
				});
			}
			// create button update/register class
			var urlSearchParams = new URLSearchParams(
				window.location.search);

			if (urlSearchParams.has('classId')) {
				$('#btnSave').click(function () {
					updateClass();
					window.location.assign("viewClass.html");
					return false;
				});

				var classId = urlSearchParams.get('classId');
				findById(classId);
				$('#classId').attr('disabled', true);
			} else {
				$('#btnSave').click(function () {
					addClass();
					window.location.assign("viewClass.html");
					return false;
				})
			}

			// create edit action
			$('#listClass').on(
				'click',
				'a.editor_edit',
				function (e) {
					e.preventDefault();
					var classId = $(this).closest("tr").find(
						"td:eq(0)").text();
					window.location
						.assign("classPage.html?classId="
							+ classId);

				});
			// create remove action
			$('#listClass')
				.on(
					'click',
					'a.editor_remove',
					function (e) {
						e.preventDefault();

						if (confirm("Are you sure that you want to delete this class?")) {
							var classId = $(this).closest("tr")
								.find("td:eq(0)").text();
							deleteClass(classId);
							window.location.reload();
						}

					});

//create back function
$('#btnBack').click(function () {
	window.history.back();
});
// create add class
function addClass() {
	console.log('addClass');
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: rootURL,
		dataType: 'json',
		data: formToJSON(),
		success: function (data) {
			alert('Class created successfully');
			clearFormField();
		},
		error: function (jqXHR, textStatus) {
			alert('Class error: ' + textStatus);
		}
	});
}
// create update class
var updateClass = function () {
	console.log('updateClass');
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: rootURL + '/' + $('#classId').val(),
		dataType: "json",
		data: formToJSONEdit(),
		success: function () {
			alert('Class updated successfully');
			findAll();
		},
		error: function (jqXHR, textStatus, errorThrown) {
			alert('updateClass error: ' + textStatus);

		}
	});
};
// Helper function to serialize all the form
// fields into a
// JSON string
var formToJSONEdit = function () {
	return JSON.stringify({

		"classId": $('#classId').val(),
		"className": $('#className').val(),
		"price": $('#price').val(),
		"capacity": $('#capacity').val(),
		"startDate": $('#startDate').val(),
		"endDate": $('#endDate').val(),
		"instructor": $('#instructor').val(),
		"timetable": [{
			"dayOfTheWeek": "Sunday",
			"classTime": $('#sunday').val(),
		}, {
			"dayOfTheWeek": "Sunday",
			"classTime": $('#sunday').val(),
		}, {
			"dayOfTheWeek": "Monday",
			"classTime": $('#monday').val(),
		}, {
			"dayOfTheWeek": "Tuesday",
			"classTime": $('#tuesday').val(),
		}, {
			"dayOfTheWeek": "Wednesday",
			"classTime": $('#wednesday').val(),
		}, {
			"dayOfTheWeek": "Thursday",
			"classTime": $('#thursday').val(),
		}, {
			"dayOfTheWeek": "Friday",
			"classTime": $('#friday').val(),
		}, {
			"dayOfTheWeek": "Saturday",
			"classTime": $('#saturday').val(),
		}]
	});

};
// create remove class
var deleteClass = function (classId) {
	console.log('deleteClass');
	$.ajax({
		type: 'DELETE',
		url: rootURL + '/' + classId,
		success: function () {
			alert('Class deleted successfuly');
			currentClass = {};
			findAll();
		},
		error: function () {
			alert('deleteClass error')
		}
	})
}
// create findById
function findById(classId) {
	// var findById = function(classId) {
	console.log('findById: ' + classId);
	$.ajax({
		type: 'GET',
		url: rootURL + '/' + classId,
		dataType: "json",
		success: function (data) {
			console.log('findById success: '
				+ data.className)
			renderDetails(data);

		}
	});
}
;
// access info from JSON
var renderDetails = function (data) {

	$('#classId').val(data.classId);
	$('#className').val(data.className);
	$('#price').val(data.price);
	$('#capacity').val(data.capacity);
	$('#startDate').val(data.startDate);
	$('#endDate').val(data.endDate);
	$('#instructor').val(data.instructor)

	for (i = 0; i < data.timetable.length; i++) {
		var timetable = data.timetable[i];

		switch (timetable.dayOfTheWeek.toLowerCase()) {
			case "sunday":
				$('#sunday').val(timetable.classTime);
				break;
			case "monday":
				$('#monday').val(timetable.classTime);
				break;
			case "tuesday":
				$('#tuesday').val(timetable.classTime);
				break;
			case "wednesday":
				$('#wednesday').val(timetable.classTime);
				break;
			case "thursday":
				$('#thursday').val(timetable.classTime);
				break;
			case "friday":
				$('#friday').val(timetable.classTime);
				break;
			case "saturday":
				$('#saturday').val(timetable.classTime);
			default:
		}
	}
};
// get info from JSON
var formToJSON = function () {
	return JSON.stringify({
		"classId": $('#classId').val(),
		"className": $('#className').val(),
		"price": $('#price').val(),
		"capacity": $('#capacity').val(),
		"startDate": $('#startDate').val(),
		"endDate": $('#endDate').val(),
		"instructor": $('#instructor').val(),
		"timetable": [{
			"dayOfTheWeek": "Sunday",
			"classTime": $('#sunday').val(),
		}, {
			"dayOfTheWeek": "Sunday",
			"classTime": $('#sunday').val(),
		}, {
			"dayOfTheWeek": "Monday",
			"classTime": $('#monday').val(),
		}, {
			"dayOfTheWeek": "Tuesday",
			"classTime": $('#tuesday').val(),
		}, {
			"dayOfTheWeek": "Wednesday",
			"classTime": $('#wednesday').val(),
		}, {
			"dayOfTheWeek": "Thursday",
			"classTime": $('#thursday').val(),
		}, {
			"dayOfTheWeek": "Friday",
			"classTime": $('#friday').val(),
		}, {
			"dayOfTheWeek": "Saturday",
			"classTime": $('#saturday').val(),
		}]
	});
}
// clear form field
function clearFormField() {
	$('#classId').val('');
	$('#className').val('');
	$('#price').val('');
	$('#capacity').val('');
	$('#startDate').val('');
	$('#time').val('');
	$('#endDate').val('');
	$('#instructor').val('')
}
;
		});
