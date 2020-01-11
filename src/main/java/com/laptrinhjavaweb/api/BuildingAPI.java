package com.laptrinhjavaweb.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.FormUtil;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-building" })
public class BuildingAPI extends HttpServlet {

	private IBuildingService buildingService = new BuildingService();

	private static final long serialVersionUID = -7319894879440008039L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		// BuildingDTO building =
		// HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		BuildingDTO building = FormUtil.toModel(BuildingDTO.class, request);
		BuildingSearchBuilder fieldSearch = null;
		Pageable pageable = null;
		if (building != null) {
			fieldSearch = new BuildingSearchBuilder.Builder().setName(building.getName())
					.setDistrict(building.getDistrict()).setWard(building.getWard()).setStreet(building.getStreet())
					.setNumberOfBasement(building.getNumberOfBasement()).setBuildingArea(building.getBuildingArea())
					.setBuildingType(building.getBuildingType()).setCostRentFrom(building.getCostRentFrom())
					.setCostRentTo(building.getCostRentTo()).setAreaRentFrom(building.getAreaRentFrom())
					.setAreaRentTo(building.getAreaRentTo()).setStaffId(building.getStaffId()).build();
			pageable = new PageRequest(building.getPage(), building.getLimit());
		}

		List<BuildingDTO> buildings = buildingService.findAll(fieldSearch, pageable);
		mapper.writeValue(response.getOutputStream(), buildings);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO buildingDTO = HttpUtil.of(request.getReader()).toModel(BuildingDTO.class);
		objectMapper.writeValue(response.getOutputStream(), buildingService.insert(buildingDTO));
	}

	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
