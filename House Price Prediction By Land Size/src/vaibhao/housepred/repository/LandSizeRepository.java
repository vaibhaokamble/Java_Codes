package vaibhao.housepred.repository;

import vaibhao.housepred.config.DBConfig;
import vaibhao.housepred.model.LandSizeModel;

public class LandSizeRepository extends DBConfig {

	public boolean isAddNewLandSize(LandSizeModel model) {
		try {
			stmt = connection.prepareStatement("insert into landsizemaster values('0',?)");
			stmt.setInt(1, model.getSqFeet());
			int value = stmt.executeUpdate();
			return value > 0 ? true : false;
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return false;
		}
	}

	public int getLandSizeIdByAreaSize(int areaSize) {
		try {
			stmt = connection.prepareStatement("select sqftid from landsizemaster where sqftsize=?");
			stmt.setInt(1, areaSize);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			System.out.println("Error is " + e);
			return 0;
		}
	}
}
