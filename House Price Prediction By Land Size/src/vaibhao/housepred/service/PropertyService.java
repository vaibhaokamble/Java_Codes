package vaibhao.housepred.service;

import vaibhao.housepred.model.PropertyMasterModel;
import vaibhao.housepred.repository.PropertyRepository;

public class PropertyService {
	PropertyRepository propRepo = new PropertyRepository();

	public boolean isAddNewProperty(PropertyMasterModel model, int sqftid) {
		return propRepo.isAddNewProperty(model, sqftid);

	}
}
