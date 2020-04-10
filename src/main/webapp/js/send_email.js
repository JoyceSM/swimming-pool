$(document).ready(function () {

			var rootURL = "http://localhost:8080/swimming-pool/rest/";

			loadCustomers();
			

			//create back function
			$('#btnBack').click(function () {
				window.history.back();
			});

			
			// create loadCustomers
			function loadCustomers() {
				console.log('loadCustomers');
				$.ajax({
					type: 'GET',
					async: false,
					url: rootURL + 'user',
					dataType: "json",
					success: function (data) {
						data.forEach(function(ele) {
							$("#fullName").append("<option data-email=" + ele.email + " data-membership=" + ele.membership + " value=" + ele.userId + ">" + ele.fullName + "</option>");
						});
					},
					error: function (jqXHR, textStatus) {
						alert('Class error: ' + textStatus);
					}
				});
			}
	
		
		});
