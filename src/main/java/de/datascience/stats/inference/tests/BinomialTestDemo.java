package de.datascience.stats.inference.tests;

import org.apache.commons.math3.stat.inference.AlternativeHypothesis;
import org.apache.commons.math3.stat.inference.BinomialTest;

/*Flipping a coin. Each try is a Bernoulli trial*/
public class BinomialTestDemo {

	public static void main(String[] args) {

		BinomialTest binomialTest = new BinomialTest();

		double nullHypothesis = 0.5; //fair coin
		int numberOfSuccesses = 9; //number of heads (biased coin)
		
		//Two sided = Represents a right-sided test. H0: p ≤ p0, H1: p > p0.
		AlternativeHypothesis alternativeHypothesis = AlternativeHypothesis.TWO_SIDED;
		int numberOfTrials = 10;

		// Returns the observed significance level, or p-value, associated with
		// a Binomial test.
		double significanceLevel = binomialTest.binomialTest(numberOfTrials, numberOfSuccesses, nullHypothesis,
				alternativeHypothesis);

		double alpha = 0.03; //significance level of the test
		
		// Returns whether the null hypothesis can be rejected with the given
		// confidence level.
		//true if signficanceLevel < alpha
		boolean rejected = binomialTest.binomialTest(numberOfTrials, numberOfSuccesses, nullHypothesis,
				alternativeHypothesis, alpha);

		System.out.println("The significance level is" + significanceLevel);
		System.out.println("Can we reject the null hypothesis?" + rejected);
	}

}
