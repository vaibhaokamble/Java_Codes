package vaibhao.housepred.service;

import java.util.List;

import vaibhao.housepred.model.AreaMasterModel;
import vaibhao.housepred.repository.AreaRepository;

public class AreaService {
	AreaRepository areaRepo = new AreaRepository();

	public boolean isAddNewArea(AreaMasterModel model) {
		return areaRepo.isAddNewArea(model);
	}

	public List<AreaMasterModel> getAreaByCityNames() {
		return areaRepo.getAreaByCityNames();

	}

	public List<String> areaList(int cityId) {
		return areaRepo.areaList(cityId);

	}
	public int getAreaIdByName(String areaName) {
		return areaRepo.getAreaIdByName(areaName);
		
	}
}
