package org.scijava.ops;

import java.util.function.BiFunction;

public class IndependentBeanThing implements BiFunction<Double, Double, Double>{

	@Override
	public Double apply(Double t, Double u) {
		return t + u;
	}

}
