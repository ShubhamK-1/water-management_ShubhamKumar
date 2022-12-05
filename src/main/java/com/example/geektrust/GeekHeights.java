package com.example.geektrust;

public class GeekHeights {
	private String flatType;
	private String cwBwRatio;
	private String noOfGuests;

	public String getFlatType() {
		return flatType;
	}

	public void setFlatType(String flatType) {
		this.flatType = flatType;
	}

	public String getCwBwRatio() {
		return cwBwRatio;
	}

	public void setCwBwRatio(String cwBwRatio) {
		this.cwBwRatio = cwBwRatio;
	}

	public String getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(String noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public GeekHeights() {
		super();
	}

	public double getBillByCwBw() {
		String[] str = cwBwRatio.split(":");
		double cw = Double.parseDouble(str[0]);
		double bw = Double.parseDouble(str[1]);
		if (this.flatType.equals("2")) {
			return (((cw / (cw + bw)) * 900) * 1) + (((bw / (cw + bw)) * 900) * 1.5);
		} else if (this.flatType.equals("3")) {
			return (((cw / (cw + bw)) * 1500) * 1) + (((bw / (cw + bw)) * 1500) * 1.5);
		}
		return 0;
	}

	public int getWaterConsumptionByTenants() {
		if (this.flatType.equals("2"))
			return 900;
		else if (this.flatType.equals("3"))
			return 1500;
		return 0;
	}

	public int getWaterConsumptionByGuests() {
		return (Integer.parseInt(this.noOfGuests) * 300);
	}

	public double getBillByTanker(int waterConsumptionByGuest) {
		if (waterConsumptionByGuest <= 500)
			return waterConsumptionByGuest * 2.0;
		else if ((waterConsumptionByGuest > 500) && (waterConsumptionByGuest <= 1500)) {
			return ((waterConsumptionByGuest - 500) * 3.0) + (500 * 2.0);
		} else if ((waterConsumptionByGuest > 1500) && (waterConsumptionByGuest <= 3000)) {
			return ((waterConsumptionByGuest - 1500) * 5.0) + (1500 * 3.0) + (500 * 2.0);
		} else if (waterConsumptionByGuest > 3000) {
			return ((waterConsumptionByGuest - 3000) * 8.0) + (3000 * 5.0) + (1500 * 3.0) + (500 * 2.0);
		}
		return 0;
	}

}
