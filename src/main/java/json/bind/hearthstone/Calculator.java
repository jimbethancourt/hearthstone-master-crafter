package json.bind.hearthstone;

import java.util.*;
import json.bind.hearthstone.domain.Card;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

/**
 * Created by jimb on 8/22/2015.
 */
public class Calculator {

    public Map<String, Double> calculateAttributeValues(Collection<Card> cards) {
        double [] origRegressionParams = calculateRegressionParameters(new ArrayList<>(cards));
        double[] regressionParams = Arrays.copyOfRange(origRegressionParams, 1, origRegressionParams.length);

        Card card = cards.toArray(new Card[cards.size()])[0];
        Set<String> paramNames = card.getRawAttributeValues().keySet();

        Map<String, Double> attributeValues = new TreeMap<>();
        int j = 0;
        for (String paramName : paramNames) {
            attributeValues.put(paramName, regressionParams[j++]);
        }

        return attributeValues;
    }

    double[] calculateRegressionParameters(List<Card> cards) {
        double[] manaCost = cards.stream().mapToDouble(Card :: getCostAsDouble).toArray();
        double[][] inputParams = new double[cards.size()][];

        for (int i = 0; i < cards.size(); i++) {
            Collection<Integer> attributes = cards.get(i).getRawAttributeValues().values();
            double [] cardAttributes = attributes.stream().mapToDouble(Integer::doubleValue).toArray();
            inputParams [i] = cardAttributes;
        }

        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();
        ols.newSampleData(manaCost, inputParams);

        return ols.estimateRegressionParameters();

    }

}
