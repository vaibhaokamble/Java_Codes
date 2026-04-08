package vaibhao.housepred.service;

import java.util.List;

import vaibhao.housepred.model.CityMasterModel;
import vaibhao.housepred.repository.CityRepository;

public class CityService {
	CityRepository cityRepo = new CityRepository();

	public boolean isAddCity(CityMasterModel model) {
		return cityRepo.isAddCity(model);
	}

	public List<CityMasterModel> getAllCities() {
		return cityRepo.getAllCities();
	}

	public int getCityIdByName(String cityName) {
		return cityRepo.getCityIdByName(cityName);

	}
}
