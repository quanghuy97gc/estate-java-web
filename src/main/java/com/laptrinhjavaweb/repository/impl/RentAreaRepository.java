package com.laptrinhjavaweb.repository.impl;

import java.util.List;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.IRentAreaRepository;

public class RentAreaRepository extends SimpleJpaRepository<RentAreaEntity> implements IRentAreaRepository{

	@Override
	public List<RentAreaEntity> findByBuildingId(Long buildingId) {
		String sql = "select * from rentarea ra where buildingid = " + buildingId;
		return this.findAll(sql,null);
	}

}
