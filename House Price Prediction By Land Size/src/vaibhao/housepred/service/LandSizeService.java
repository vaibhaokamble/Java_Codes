package vaibhao.housepred.service;

import vaibhao.housepred.model.LandSizeModel;
import vaibhao.housepred.repository.LandSizeRepository;

public class LandSizeService {
	LandSizeRepository landRepo = new LandSizeRepository();

	public boolean isAddNewLandSize(LandSizeModel model) {
		return landRepo.isAddNewLandSize(model);

	}

	public int getLandSizeIdByAreaSize(int areaSize) {
		return landRepo.getLandSizeIdByAreaSize(areaSize);
	}
}
