var rootURL = "http://localhost:8080/swimming-pool/rest/user";

var renderList = function(data){
	var list=data;
	console.log("response");
	$.each(list, function(index, user){
		$('#table_body').append('<tr><td>'+user.userId+'</td><td>'
				+user.fullName+'</td><td>'+user.membership+'</td><td>'
				+user.address+'</td><td>'+user.city+'</td><td>'+user.email+
				'</td><td><a data-toggle="modal" href="#confirm" id="' + user.userId + '">Update</a></td></tr>');
	});
	$('#table_id').DataTable();
}