package vaibhao.housepred.client;

import java.util.List;
import java.util.Scanner;
import vaibhao.housepred.model.AreaMasterModel;
import vaibhao.housepred.model.CityMasterModel;
import vaibhao.housepred.model.LandSizeModel;
import vaibhao.housepred.model.PropertyMasterModel;
import vaibhao.housepred.service.AreaService;
import vaibhao.housepred.service.CityService;
import vaibhao.housepred.service.LandSizeService;
import vaibhao.housepred.service.PredictionService;
import vaibhao.housepred.service.PropertyService;

public class PredictionClientApplication {

	public static void main(String[] args) {
		CityService cs = new CityService();
		AreaService aservice = new AreaService();
		LandSizeService lservice = new LandSizeService();
		PropertyService pservice = new PropertyService();
		PredictionService predService = new PredictionService();
		do {
			Scanner v = new Scanner(System.in);
			System.out.println("1 : Add New City");
			System.out.println("2 : View All City");
			System.out.println("3 : Add New Area");
			System.out.println("4 : Show All Area By Names");
			System.out.println("5 : Add New Land Area");
			System.out.println("6 : Enter Property Details");
			System.out.println("7 : Predict Property Price Area Wise");
			System.out.println("Enter Your Choice");
			int choice = v.nextInt();
			switch (choice) {
			case 1:
				v.nextLine();
				System.out.println("Enter City Name : ");
				String cityName = v.nextLine();
				CityMasterModel model = new CityMasterModel();
				model.setName(cityName);
				boolean b = cs.isAddCity(model);
				if (b) {
					System.out.println("New City Added Successfully...........");
				} else {
					System.out.println("Some Problem is There............");
				}
				break;

			case 2:
				List<CityMasterModel> list = cs.getAllCities();
				for (CityMasterModel c : list) {
					System.out.println(c.getId() + "\t" + c.getName());
				}
				break;

			case 3:
				v.nextLine();
				System.out.println("Enter City Name");
				cityName = v.nextLine();
				int result = cs.getCityIdByName(cityName);
				if (result == 0) {
					System.out.println("City Not in The List  \n Do You Want Add The City");
					String confirm = v.nextLine();
					if (confirm.equals("yes")) {
						model = new CityMasterModel();
						model.setName(cityName);
						b = cs.isAddCity(model);
						if (b) {
							System.out.println("New City Added Successfully...........");
						} else {
							System.out.println("Some Problem is There............");
						}
					}
				} else if (result != 0) {

					System.out.println("Entre Area Name");
					String areaName = v.nextLine();
					System.out.println("Enter Pincode");
					String pincode = v.nextLine();
					AreaMasterModel areaModel = new AreaMasterModel();
					areaModel.setAreaName(areaName);
					areaModel.setCityid(result);
					areaModel.setPincode(pincode);
					b = aservice.isAddNewArea(areaModel);
					if (b) {
						System.out.println("New Area Added.........");
					} else {
						System.out.println("Area Not Added..........");
					}
				} else {
					System.out.println("There is Some Exception");
				}

				break;

			case 4:
				System.out.println("Show All Area With City Name");
				List<AreaMasterModel> areaList = aservice.getAreaByCityNames();
				for (AreaMasterModel m : areaList) {
					System.out.println(m.getName() + "\t\t\t" + m.getAreaName() + "\t\t" + m.getPincode());
				}
				break;

			case 5:
				System.out.println("5 : Add New Land Area Size");
				int landArea = v.nextInt();
				LandSizeModel landModel = new LandSizeModel();
				landModel.setSqFeet(landArea);
				b = lservice.isAddNewLandSize(landModel);
				if (b) {
					System.out.println("New Land Area Added..........");
				} else {
					System.out.println("Some Problem is there");
				}
				break;
			case 6:
				v.nextLine();
				System.out.println("Enter City Name");
				cityName = v.nextLine();
				result = cs.getCityIdByName(cityName);
				List<String> areaNames = aservice.areaList(result);
				System.out.println("Input Area Name From Given List");
				for (String aname : areaNames) {
					System.out.println(aname);
				}
				System.out.println("Enter Area Name");
				String areaName = v.nextLine();
				int areaId = aservice.getAreaIdByName(areaName);
				System.out.println("Area Name is " + areaId);
				System.out.println("Enter Land Size");
				int landSize = v.nextInt();
				int sqftId = lservice.getLandSizeIdByAreaSize(landSize);
				System.out.println("Area Size Id " + sqftId);
				v.nextLine();
				System.out.println("Enter Property Name");
				String pname = v.nextLine();
				System.out.println("Enter Property Address");
				String paddress = v.nextLine();
				System.out.println("Enter Property Price");
				int pprice = v.nextInt();
				PropertyMasterModel propModel = new PropertyMasterModel();
				propModel.setName(pname);
				propModel.setAddress(paddress);
				propModel.setPrice(pprice);
				propModel.setId(areaId);
				b = pservice.isAddNewProperty(propModel, sqftId);
				if (b) {
					System.out.println("New Property Added Successfully...........");
				} else {
					System.out.println("Some Problem is There");
				}
				break;

			case 7:
				v.nextLine();
				System.out.println("Enter City Name");
				cityName = v.nextLine();
				result = cs.getCityIdByName(cityName);
				areaNames = aservice.areaList(result);
				System.out.println("Input Area Name From Given List");
				for (String aname : areaNames) {
					System.out.println(aname);
				}
				System.out.println("Enter Area Name");
				areaName = v.nextLine();
				System.out.println("Enter Your Expected Land Size");
				int expectedLandSize = v.nextInt();
				predService.getPredictedPrice(expectedLandSize);
				break;
			default:
				System.out.println("Wrong Choice");
			}
		} while (true);

	}

}
