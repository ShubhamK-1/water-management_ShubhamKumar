package com.example.geektrust;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String filePath = args[0];
		try {
			File myInputFile = new File(filePath);
			Scanner myReader = new Scanner(myInputFile);
			double bill = 0;
			int totalWaterConsumption = 0, waterConsumptionByGuest = 0;
			GeekHeights gh = new GeekHeights();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				String command = getCommand(data);
				List<String> values = getData(data);
				if (command.equals("ALLOT_WATER")) {
					gh.setFlatType(values.get(0));
					gh.setCwBwRatio(values.get(1));
					bill = bill + gh.getBillByCwBw();
					totalWaterConsumption = totalWaterConsumption + gh.getWaterConsumptionByTenants();
				} else if (command.equals("ADD_GUESTS")) {
					gh.setNoOfGuests(values.get(0));
					waterConsumptionByGuest = waterConsumptionByGuest + gh.getWaterConsumptionByGuests();
					totalWaterConsumption = totalWaterConsumption + gh.getWaterConsumptionByGuests();
				} else if (command.equals("BILL")) {
					break;
				}
			}
			bill = bill + gh.getBillByTanker(waterConsumptionByGuest);
			System.out.println(totalWaterConsumption + " " + (int) bill);
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static List<String> getData(String data) {
		List<String> line = new ArrayList<String>();
		if (!(getCommand(data).equals("BILL"))) {
			String[] str = data.split(" ");
			for (int i = 0; i < str.length; i++)
				line.add(str[i]);
			line.remove(0);
			return line;
		}
		return null;
	}

	private static String getCommand(String data) {
		String[] line = data.split(" ");
		return line[0];
	}

}
