package com.vehiclepricelist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vehiclepricelist.bean.Vehicle;
import com.vehiclepricelist.dao.ReferenceDao;

/**
 * @author surab
 *
 */
@Controller
public class VehicleController {
	
	@Autowired
	ReferenceDao referenceDao;

	
	/**
	 * @param vehicle
	 * @param model
	 * @return String
	 * Get detailList of all available Vehicle
	 */
	@RequestMapping(value ="priceList")
	public String getPriceList(@ModelAttribute("vehicleForm")Vehicle vehicle,Model model) {
		
		List<Vehicle> vehicleList = referenceDao.getVehicleDetails();
		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("function","add");
		return "priceList";
		
	}
	
	/**
	 * @param vehicle
	 * @param model
	 * @return String
	 * Add new Vehicle Details
	 */
	@RequestMapping(value ="addVehicle")
	public String addVehicle(@ModelAttribute("vehicleForm")Vehicle vehicle,Model model) {
		System.out.println("Inside Vehicle");
		int num = referenceDao.addVehicle(vehicle);
		List<Vehicle> vehicleList = referenceDao.getVehicleDetails();
		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("function","add");
		System.out.println(num);
		return "priceList";
		
	}
	
	/**
	 * @param id
	 * @param vehicle
	 * @param model
	 * @return String
	 * Delete Vehicle details from database
	 */
	@RequestMapping(value ="deleteVehicle")
	public String deleteVehicle(@RequestParam Integer id,@ModelAttribute("vehicleForm")Vehicle vehicle,Model model) {
		System.out.println("Inside Vehicle");
		referenceDao.deleteVehicle(id);
		List<Vehicle> vehicleList = referenceDao.getVehicleDetails();
		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("function","add");
		return "priceList";
		
	}
	
	/**
	 * @param id
	 * @param vehicle
	 * @param model
	 * @return String
	 * Get a Vehicle detail using Id
	 */
	@RequestMapping(value ="getVehicleDetail")
	public String getVehicleDetail(@RequestParam Integer id,@ModelAttribute("vehicleForm")Vehicle vehicle,Model model) {
		
		System.out.println("Inside Vehicle");
		vehicle = referenceDao.getVehicleDetail(id);
		List<Vehicle> vehicleList = referenceDao.getVehicleDetails();
		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("vehicleForm", vehicle);
		model.addAttribute("function","update");
		return "priceList";
		
	}
	
	
	/**
	 * @param vehicle
	 * @param model
	 * @return String
	 * Update vehicle details using object from jsp
	 */
	@RequestMapping(value ="updateVehicle")
	public String updateVehicle(@ModelAttribute("vehicleForm")Vehicle vehicle,Model model) {
		System.out.println("Inside Vehicle");
		referenceDao.updateVehicle(vehicle);
		List<Vehicle> vehicleList = referenceDao.getVehicleDetails();
		model.addAttribute("vehicleList", vehicleList);
		model.addAttribute("function","add");
		return "priceList";
		
	}
}
