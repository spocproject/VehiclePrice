package com.vehiclepricelist.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.vehiclepricelist.bean.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet arg0, int arg1) throws SQLException {
		Vehicle vehicle=new Vehicle();
		vehicle.setId(arg0.getInt(1));
		vehicle.setMakeName(arg0.getString(2));
		vehicle.setModelName(arg0.getString(3));
		vehicle.setModelEdition(arg0.getString(4));
		vehicle.setPrice(arg0.getInt(5));
		vehicle.setOptions(arg0.getInt(6));
		return vehicle;
	}

}
