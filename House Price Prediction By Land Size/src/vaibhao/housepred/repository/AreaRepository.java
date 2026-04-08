package vaibhao.housepred.repository;

import java.util.ArrayList;
import java.util.List;

import vaibhao.housepred.config.DBConfig;
import vaibhao.housepred.model.AreaMasterModel;

public class AreaRepository extends DBConfig {
	List<AreaMasterModel> list;
	List<String> areaList;

	public boolean isAddNewArea(AreaMasterModel model) {
		try {
			cstmt = connection.prepareCall("{call savearea(?,?,?)}");
			cstmt.setString(1, model.getAreaName());
			cstmt.setInt(2, model.getCityid());
			cstmt.setString(3, model.getPincode());
			boolean b = cstmt.execute();
			return !b;
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return false;
		}
	}

	public List<AreaMasterModel> getAreaByCityNames() {
		try {
			list = new ArrayList<AreaMasterModel>();
			stmt = connection.prepareStatement(
					" select c.name as 'city name' ,a.name as 'area name' ,acj.pincode from citymaster c inner join areacityjoin acj on c.cityid=acj.cityid inner join areamaster a on acj.aid=a.aid;");
			rs = stmt.executeQuery();
			while (rs.next()) {
				AreaMasterModel model = new AreaMasterModel();
				model.setName(rs.getString(1));
				model.setAreaName(rs.getString(2));
				model.setPincode(rs.getString(3));
				list.add(model);
			}
			return list.size() > 0 ? list : null;
		} catch (Exception e) {
			System.out.println("Error is" + e);
			return null;
		}
	}

	public List<String> areaList(int cityId) {
		try {
			areaList = new ArrayList<String>();
			stmt = connection.prepareStatement(
					"select ar.name from areamaster ar inner join areacityjoin acj on ar.aid=acj.aid inner join citymaster cm on cm.cityid=acj.cityid where cm.cityid=?");
			stmt.setInt(1, cityId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				areaList.add(rs.getString(1));
			}
			return areaList.size() > 0 ? areaList : null;
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return null;
		}
	}

	public int getAreaIdByName(String areaName) {

		try {
			areaList = new ArrayList<String>();
			stmt = connection.prepareStatement("select aid from areamaster where name=?");
			stmt.setString(1, areaName);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
			else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return 0;
		}
	}
}
