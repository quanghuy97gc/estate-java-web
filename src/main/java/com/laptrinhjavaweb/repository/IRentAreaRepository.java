package com.laptrinhjavaweb.repository;

import java.util.List;

import com.laptrinhjavaweb.entity.RentAreaEntity;

public interface IRentAreaRepository extends JpaRepository<RentAreaEntity>{

	List<RentAreaEntity> findByBuildingId(Long buildingId);
	
}
