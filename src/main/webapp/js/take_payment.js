$(document).ready(function () {

			var rootURL = "http://localhost:8080/swimming-pool/rest/";

			loadCustomers();
			

			//create save function
			$('#btnSave').click(function () {
				$.ajax({
					type: 'POST',
					contentType: 'application/json',
					url: rootURL + "payment",
					dataType: 'json',
					data: formToJSON(),
					success: function (data) {
						alert('Payment received successfully!');
						window.location.assign("loginPage.html");
					},
					error: function (jqXHR, textStatus) {
						alert('Class error: ' + textStatus);
					}
				});
				return false;
			});
			
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
			
			// get info from JSON
			var formToJSON = function () {
				var date = new Date()
				var formatted_date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate()
				return JSON.stringify(    {
					"userId": $("#fullName").val(),
					"amount": $("#inputAmount").val(),
					"paymentDate": formatted_date
				});
			}
	
		
		});
