package com.vehiclepricelist.daoImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.vehiclepricelist.bean.Vehicle;
import com.vehiclepricelist.dao.ReferenceDao;
import com.vehiclepricelist.mapper.VehicleMapper;

@Repository
public class ReferenceDaoImpl implements ReferenceDao{
	
	@Autowired
	SimpleJdbcTemplate simpleJdbcTemplate;

	@Override
	public int addVehicle(Vehicle vehicle) {
    		
    	String makeName  = vehicle.getMakeName();
    	String modelName = vehicle.getModelName();
    	String edition   = vehicle.getModelEdition();
    	Integer amount   = vehicle.getPrice();
    	Integer option   = vehicle.getOptions();
    	
    	String insertSql="INSERT INTO VEHICLE(MAKENAME,MODELNAME,MODELEDITION,PRICE,OPTIONS) VALUES(?,?,?,?,?)";
    	Object[] params=new Object[]{makeName,modelName,edition,amount,option};
    	
    	int inserted=simpleJdbcTemplate.update(insertSql,params);    	
    	System.out.println(inserted);
    	
		return 0;
	}

	@Override
	public List<Vehicle> getVehicleDetails() {
		String sql="SELECT ID,MAKENAME,MODELNAME,MODELEDITION,PRICE,OPTIONS FROM VEHICLE";
		  VehicleMapper mapper=new VehicleMapper();
		  List<Vehicle> list=simpleJdbcTemplate.query(sql,mapper);
	     return list;
	}

	@Override
	public void deleteVehicle(int vehicleId) {
		String sql="DELETE FROM VEHICLE WHERE ID=?";
		simpleJdbcTemplate.update(sql,vehicleId);
	}

	@Override
	public void updateVehicle(Vehicle vehicle) {
		String makeName  = vehicle.getMakeName();
    	String modelName = vehicle.getModelName();
    	String edition   = vehicle.getModelEdition();
    	Integer amount   = vehicle.getPrice();
    	Integer option   = vehicle.getOptions();
    	Integer id		 = vehicle.getId();
    	
    	String insertSql="UPDATE VEHICLE SET MAKENAME =?,MODELNAME =?,MODELEDITION=?,PRICE=?,OPTIONS=? WHERE ID=?";
    	Object[] params=new Object[]{makeName,modelName,edition,amount,option,id};
    	
    	int inserted=simpleJdbcTemplate.update(insertSql,params);    	
    	System.out.println(inserted);
    	
	}

	@Override
	public Vehicle getVehicleDetail(int id) {
		String sql="SELECT ID,MAKENAME,MODELNAME,MODELEDITION,PRICE,OPTIONS FROM VEHICLE WHERE ID ="+id+"";
		  VehicleMapper mapper=new VehicleMapper();
		  List<Vehicle> list=simpleJdbcTemplate.query(sql,mapper);
		return list.get(0);
	}

}
