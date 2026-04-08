package vaibhao.housepred.service;

import java.util.ArrayList;
import java.util.List;

import vaibhao.housepred.repository.PredictionRepository;

public class PredictionService {
	PredictionRepository predRepo = new PredictionRepository();

	public int getPredictedPrice(int expectedLandSize) {
		int minOfX = predRepo.getMinOfX();
		int minOfY = predRepo.getMinOfY();
		System.out.println("Min Of X is " + minOfX);
		System.out.println("Min Of Y is " + minOfY);
		List<Integer> valuesOfX = predRepo.getValuesOfX();
		List<Integer> dOfX = new ArrayList<Integer>();
		for (Integer valOfX : valuesOfX) {
			int dVal = valOfX - minOfX;
			dOfX.add(dVal);
		}
		System.out.println("Daviation Of  X" + dOfX);
		List<Integer> valuesOfY = predRepo.getValuesOfY();
		List<Integer> dOfY = new ArrayList<Integer>();

		for (Integer valOfY : valuesOfY) {
			int d = valOfY - minOfY;
			dOfY.add(d);
		}
		System.out.println("Daviation Of  Y " + dOfY);
		List<Integer> prodOfDXandY=new ArrayList<Integer>();
		for(int i=0; i<valuesOfY.size(); i++) {
			int dValOfX=dOfX.get(i);
			int dValOfY=dOfY.get(i);
		}
		return 0;
	}
}
