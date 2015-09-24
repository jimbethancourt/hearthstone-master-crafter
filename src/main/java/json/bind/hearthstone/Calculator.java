package json.bind.hearthstone;

import java.util.*;

import json.bind.hearthstone.domain.Attribute;
import json.bind.hearthstone.domain.Card;
import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;

/**
 * Created by jimb on 8/22/2015.
 */
public class Calculator {

    public Map<Attribute, Double> calculateAttributeValues(Collection<Card> cards) {
        double [] origRegressionParams = calculateRegressionParameters(new ArrayList<>(cards));
        double[] regressionParams = Arrays.copyOfRange(origRegressionParams, 1, origRegressionParams.length);

        Card card = cards.toArray(new Card[cards.size()])[0];
        Set<Attribute> paramNames = card.getRawAttributeValues().keySet();

        Map<Attribute, Double> attributeValues = new TreeMap<>();
        int j = 0;
        for (Attribute paramName : paramNames) {
            attributeValues.put(paramName, regressionParams[j++]);
        }

        return attributeValues;
    }

    double[] calculateRegressionParameters(List<Card> cards) {
        double[] manaCost = cards.stream().mapToDouble(Card :: getCostAsDouble).toArray();
        double[][] inputParams = new double[cards.size()][];

        //cards.stream().map(card -> card.getRawAttributeValues().values().stream())
        for (int i = 0; i < cards.size(); i++) {
            inputParams [i] = cards.get(i).getRawAttributeValues().values().stream().mapToDouble(Integer::doubleValue).toArray();
        }

        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();
        ols.newSampleData(manaCost, inputParams);

        return ols.estimateRegressionParameters();
    }
}
