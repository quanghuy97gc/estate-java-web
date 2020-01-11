function assignBuilding(buildingId) {
	$('#buildingId').val(buildingId);
	openAssignModal();
}
function openAssignModal() {
	$('#assignBuildingModal').modal();
}
$('#btnAssignBuilding').click(
		function() {
			var data = {};
			data['buildingId'] = $('#buildingId').val();
			var staffIds = $('#staffList').find(
					'tbody input[type=checkbox]:checked').map(function() {
				return $(this).val();
			}).get();
			data['staffIds'] = staffIds;
			console.log(data);
		});
function assignStaff(data) {
	$.ajax({
		type : "POST",
		url : "http://localhost:8080/api-user-assignment",
		data : JSON.stringify(data),
		dataType : "json",
		contentType : "application/json",
		success : function(response) {
			
		}
	});
}