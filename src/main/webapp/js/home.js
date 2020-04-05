var rootURL = "http://localhost:8080/swimming-pool/rest";

$(document).ready(function () {
	//create forEach for timetable
	var days = ['sunday', 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday'];

	days.forEach(function (day) {
		findByDayOfWeek(day);
	});

});
//capitalize first letter
function capitalizeFirstLetter(string) {
	if (typeof string == undefined) return;
	var firstLetter = string[0] || string.charAt(0);
	return firstLetter ? string.replace(/^./, firstLetter.toUpperCase()) : '';
}
//create findByDayOfWeek
function findByDayOfWeek(day) {

	console.log('findByDayOfWeek: ' + day);
	$.ajax({
		type: 'GET',
		url: rootURL + '/classTime/' + day,

		dataType: "json",
		async: false,
		success: function (data) {
			console.log('findByDayOfWeek success: ' + data.classTime);
			renderDetails(data);
		},
		error: function (XMLHttpRequest, textStatus, errorThrown) {

		}
	});

}
// access info from JSON
var renderDetails = function (data) {

	for (i = 0; i < data.length; i++) {
		var classTime = data[i];
		$('#home-timetable').append(
			'<tr><td>' + capitalizeFirstLetter(classTime.dayOfWeek) + '</td><td>' + classTime.classTime
			+ '</td><td>' + classTime.className + '</td></tr>')
	}

};


