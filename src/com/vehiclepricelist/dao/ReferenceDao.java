package com.vehiclepricelist.dao;

import java.util.List;

import com.vehiclepricelist.bean.Vehicle;

public interface ReferenceDao {
	
	public int addVehicle(Vehicle vehicle);
	public Vehicle getVehicleDetail(int id);
	public List<Vehicle> getVehicleDetails();
	public void deleteVehicle(int vehicleId);
	public void updateVehicle(Vehicle vehicle);

}
