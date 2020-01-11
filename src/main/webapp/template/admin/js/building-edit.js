$('#btnAddBuilding').click(function(e) {
	e.preventDefault();
	var data = {};
	var buildingTypes = [];
	var formData = $('#formEdit').serializeArray();
	$.each(formData, function(index, v) {
		if (v.name == 'buildingTypes') {
			buildingTypes.push(v.value);
		} else {
			data["" + v.name + ""] = v.value;
		}
	});
	data['buildingType'] = buildingTypes;
	console.log(data);
});