package vaibhao.housepred.repository;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.util.List;

import vaibhao.housepred.config.DBConfig;

public class PredictionRepository extends DBConfig {
	List<Integer> valuesOfX;
	List<Integer> valuesOfY;
	public int getMinOfX() {
		try {
			stmt = connection.prepareStatement("select avg(sqftsize) from landsizemaster");
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public int getMinOfY() {
		try {
			stmt = connection.prepareStatement("select avg(price) from propertyhistoricalprices;");
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}
		} catch (Exception e) {
			return 0;
		}
	}

	public List<Integer> getValuesOfX() {
		valuesOfX = new ArrayList<Integer>();
		try {
			stmt = connection.prepareStatement("select sqftsize from landsizemaster");
			rs = stmt.executeQuery();
			while (rs.next()) {
				valuesOfX.add(rs.getInt(1));
			}
			return valuesOfX.size() > 0 ? valuesOfX : null;
		} catch (Exception e) {
			return null;
		}
	}
	public List<Integer> getValuesOfY(){
		valuesOfY=new ArrayList<Integer>();
		try {
			stmt=connection.prepareStatement("select price from propertyhistoricalprices");
			rs=stmt.executeQuery();
			while(rs.next()) {
				valuesOfY.add(rs.getInt(1));
			}
			return valuesOfY.size()>0?valuesOfY:null;
		} catch (Exception e) {
			return null;
		}
	}
}
