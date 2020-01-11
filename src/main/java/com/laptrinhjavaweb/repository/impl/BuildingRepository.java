package com.laptrinhjavaweb.repository.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;

public class BuildingRepository extends SimpleJpaRepository<BuildingEntity> implements IBuildingRepository {
	@Override
	public List<BuildingEntity> findAll(Map<String, Object> params, Pageable pageable,
			BuildingSearchBuilder fieldSerch) {
		StringBuilder sqlSearch = new StringBuilder("select * from building A ");

		if (StringUtils.isNotBlank(fieldSerch.getStaffId())) {
			sqlSearch.append(" INNER JOIN assignmentstaff s on s.buildingid = A.id");
		}

		sqlSearch.append(" where 1 = 1");
		sqlSearch = this.createSqlFindAll(params, sqlSearch);
		String sqlSpecial = buildSqlSpecial(fieldSerch);
		sqlSearch.append(sqlSpecial);
		return super.findAll(sqlSearch.toString(), pageable);
	}

	private String buildSqlSpecial(BuildingSearchBuilder fieldSerch) {
		StringBuilder result = new StringBuilder("");

		if (StringUtils.isNotBlank(fieldSerch.getCostRentFrom())) {
			result.append(" AND A.costrent >= " + fieldSerch.getCostRentFrom() + "");
		}
		if (StringUtils.isNotBlank(fieldSerch.getCostRentTo())) {
			result.append(" AND A.costrent <= " + fieldSerch.getCostRentTo() + "");
		}
		// java 7
//		if (fieldSerch.getBuildingType().length > 0) {
//			sqlSpecial.append(" AND ( 1 = 1");
//			int i = 0;
//			for (String item : fieldSerch.getBuildingType()) {
//				if(StringUtils.isNotBlank(item)) {
//					if (i == 0) {
//						sqlSpecial.append(" AND A.type like '%" + item + "%'");
//					} else {
//						sqlSpecial.append(" OR A.type like '%" + item + "%'");
//					}
//					i++;
//				}
//			}
//			sqlSpecial.append(")");
//		}
		// java 8
		String[] buildingTypes = Arrays.stream(fieldSerch.getBuildingType()).filter(StringUtils::isNotBlank)
				.toArray(String[]::new);
		if (buildingTypes.length > 0) {
			result.append(" AND (");
			result.append(" A.type like '%" + buildingTypes[0] + "%'");
			Arrays.stream(buildingTypes).filter(item -> !item.equals(buildingTypes[0]))
					.forEach(item -> result.append(" OR A.type like '%" + item + "%'"));
			result.append(")");
		}

		if (StringUtils.isNotBlank(fieldSerch.getAreaRentFrom())
				|| StringUtils.isNotBlank(fieldSerch.getAreaRentTo())) {
			result.append(" AND EXISTS (SELECT * FROM rentarea ra WHERE (ra.buildingid = A.id");
			if (fieldSerch.getAreaRentFrom() != null) {
				result.append(" AND ra.value >= " + fieldSerch.getAreaRentFrom() + "");
			}
			if (fieldSerch.getAreaRentTo() != null) {
				result.append(" AND ra.value <= " + fieldSerch.getAreaRentTo() + "");
			}
			result.append("))");
		}
		if (StringUtils.isNotBlank(fieldSerch.getStaffId())) {
			result.append(" AND s.staffid = " + fieldSerch.getStaffId() + "");
		}
		return result.toString();
	}
}
