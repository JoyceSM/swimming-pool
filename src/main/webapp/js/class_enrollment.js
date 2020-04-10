$(document).ready(function () {

			var rootURL = "http://localhost:8080/swimming-pool/rest/";
			var loginVar = localStorage.getItem('loginVar');

			var finalPrice;
			
			if (loginVar == 0) {
				// Must perform login
				window.location.assign("loginPage.html");
			} 
			

			loadCustomers();
			loadClasses();
			
			// create button update/register class
			var urlSearchParams = new URLSearchParams(window.location.search);

			if (urlSearchParams.has('classId') && urlSearchParams.has('username')) {
				var username = urlSearchParams.get('username');
				var classId = urlSearchParams.get('classId');
				$("#inputClassName").val(classId);
				var userId = $("#fullName").find("[data-email='" + username + "']").val();
				$("#fullName").val(userId);
				$('#fullName').prop('disabled', true);
			} 

			$("#inputPaymentType").change(function() {
				updateClassPrice();
			});
			
			$("#inputClassName").change(function() {
				updateClassSlots($("#inputClassName").val());
				updateClassPrice();
			});
			
			$("#fullName").change(function() {
				updateClassPrice();
			});
			

			updateClassPrice();
			$("#inputClassName").trigger("change");


			$("#btnSave").click(function(e) {
				e.preventDefault();
				saveEnrollment();
				return false;
			});

			//create back function
			$('#btnBack').click(function () {
				window.history.back();
			});
			// create add class
			function saveEnrollment() {
				var slotsAvailable = $(".slots-card-title").text();
				if(slotsAvailable <= 0) {
					alert("No slots available. Unable to enroll.");
					return;
				}		
				console.log('addClass');
				$.ajax({
					type: 'POST',
					contentType: 'application/json',
					url: rootURL + "enrollment/",
					dataType: 'json',
					data: formToJSON(),
					success: function (data) {
						alert('Successfully enrolled!');
						window.location.assign("loginPage.html");
					},
					error: function (jqXHR, textStatus) {
						alert('Class error: ' + textStatus);
					}
				});
			}
		
			
			// create loadClasses
			function loadClasses() {
				console.log('loadClasses: ' + username);
				$.ajax({
					type: 'GET',
					async: false,
					url: rootURL + 'class',
					dataType: "json",
					success: function (data) {
						data.forEach(function(ele) {
							$("#inputClassName").append("<option data-price=" + ele.price + " value=" + ele.classId+ ">" + ele.className + "</option>");
						});
					},
					error: function (jqXHR, textStatus) {
						alert('Class error: ' + textStatus);
					}
				});
			}
			
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

			function updateClassSlots(classId) {
				console.log('updateClassSlots: ' + username);
				$.ajax({
					type: 'GET',
					async: false,
					url: rootURL + 'class/slots/' + classId,
					dataType: "json",
					success: function (data) {
						$(".slots-card-title").text(data);
					},
					error: function (jqXHR, textStatus) {
						console.log("Error: " + jqXHR);
					}
				});
			}

			
			// price function
			function updateClassPrice() {
				var totalDiscount = 0;
				var messages = [];
				var text = "";
				
				messages.push("Book now!");
				
				if($("#inputPaymentType").val() == 0) {
					totalDiscount += 0.10;
					messages.push("<strong>Full payment:</strong> 10% discount");
				}
				
				var membership = $("#fullName").children("option:selected").data("membership");
				
				if(membership) {
					totalDiscount += 0.10;
					messages.push("<strong>Membership:</strong> 10% discount plus first class free (up to €50)");
				}
				messages.forEach(function(message) {
					text += "<li>" + message + "</li>";
				})
				$(".class-details").html(text);
				var price = $("#inputClassName").children("option:selected").data("price");
				price *= (1 - totalDiscount);
				$(".pricing-card-title").text("€ " + price)
				finalPrice = price;
			}


			// get info from JSON
			var formToJSON = function () {
				var date = new Date()
				var formatted_date = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate()
				return JSON.stringify(    {
					"userId": $("#fullName").val(),
					"classId": $("#inputClassName").val(),
					"paymentId": $("#inputPaymentType").val(),
					"schoolName": $("#inputSchool").val(),
					"enrollmentDate": formatted_date,
					"price": finalPrice,
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
