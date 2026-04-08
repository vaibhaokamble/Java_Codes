package vaibhao.housepred.repository;

import java.util.ArrayList;
import java.util.List;

import vaibhao.housepred.config.*;
import vaibhao.housepred.model.*;

public class CityRepository extends DBConfig {
	List<CityMasterModel> list;

	public boolean isAddCity(CityMasterModel model) {
		try {
			stmt = connection.prepareStatement("insert into citymaster values('0',?)");
			stmt.setString(1, model.getName());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return false;
		}
	}

	public List<CityMasterModel> getAllCities() {
		try {
			list = new ArrayList<CityMasterModel>();
			stmt = connection.prepareStatement("select * from citymaster");
			rs = stmt.executeQuery();
			while (rs.next()) {
				CityMasterModel model = new CityMasterModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return null;
		}
	}
	public int getCityIdByName(String cityName) {
		try {
			stmt=connection.prepareStatement("select cityid from citymaster where name=?");
			stmt.setString(1, cityName);
			rs=stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}
		} catch (Exception e) {
		return -1;
		}
	}
}
