package bookcode.p10StreamAndFileIO;

import java.io.Serializable;

/**
 * An auxiliary class
 * 
 * Serialised class for data on endangered species.
 */
public class C09Species implements Serializable {

	private static final long serialVersionUID = 3624114838918359040L;
	private String name;
	private int population;
	private double growthRate;

	public C09Species() {
		name = null;
		population = 0;
		growthRate = 0;
	}

	public C09Species(String initialName, int initialPopulation,
			double initialGrowthRate) {
		name = initialName;
		if (initialPopulation >= 0)
			population = initialPopulation;
		else {
			System.out.println("ERROR: Negative population.");
			System.exit(0);
		}
		growthRate = initialGrowthRate;
	}

	public String toString() {
		return ("Name = " + name + "\n" + "Population = " + population + "\n"
				+ "Growth rate = " + growthRate + "%");
	}

}
