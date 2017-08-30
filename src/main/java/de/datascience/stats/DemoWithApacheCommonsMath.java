package de.datascience.stats;

import static java.lang.System.out;

import java.util.Arrays;

import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.apache.commons.math3.stat.descriptive.rank.Median;

public class DemoWithApacheCommonsMath {

	static double[] testData = { 12.5, 18.7, 11.2, 19.0, 22.1, 14.3, 16.9, 12.5, 17.8, 16.9 };

	public static void main(String[] args) {
		
		DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics(testData);
		
		Arrays.stream(testData).forEach(num -> System.out.print(num));
		
		out.println("\nThe mean is " + descriptiveStatistics.getMean());
		out.println("The standard deviation is " + descriptiveStatistics.getStandardDeviation());
		out.println("The median is " + descriptiveStatistics.getPercentile(50));
		
		
		out.println("\nThe mean evaluated is " + getMean(testData));
		out.println("The median evaluated is " + getMedian(testData));

		printModes();

		out.println("\nThe population standard deviation is " + getUnbiasedStandardDeviation(testData));

		out.println("The sample standard deviation is " + getBiasCorrectedStandardDeviation(testData));
		
	}

	private static double getUnbiasedStandardDeviation(double[] testData) {
		// unbiased estimation
		StandardDeviation sdSubset = new StandardDeviation(false);
		return sdSubset.evaluate(testData);
	}

	private static double getBiasCorrectedStandardDeviation(double[] testData) {
		// bias corrected estimation ( n − 1 instead of n in the formula)
		StandardDeviation sdPopulation = new StandardDeviation(true);
		return sdPopulation.evaluate(testData);
	}
	
	public static double getMean(double[] testData) {
		Mean mean = new Mean();
		return mean.evaluate(testData);
	}

	public static double getMedian(double[] testData) {
		Median median = new Median();
		return median.evaluate(testData);
	}

	public static void printModes() {
		double[] modes = StatUtils.mode(testData);
		for (double mode : modes) {
			out.println(mode + " is a mode.");
		}
	}


}
