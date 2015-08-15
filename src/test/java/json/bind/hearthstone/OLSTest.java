package json.bind.hearthstone;

import org.apache.commons.math3.stat.regression.OLSMultipleLinearRegression;
import org.junit.Test;

/**
 * Created by jimb on 4/28/2015.
 */
public class OLSTest {

    @Test
    public void testSimpleOLS(){
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();
        //double [] manaCost = {4,6,6,3,1,0,4,1};
        //double [] [] x = new double[8][];

        double [] manaCost = {4,6,6,3,1}; // mana cost is y intercept
        double [] [] x = new double[5][];

        //atk,health,charge,divine
        double [] korkon = new double []{4,3,1,0};
        x[0] = korkon;
        double [] reckless = new double []{5,2,1,0};
        x[1] = reckless;
        double [] commander = new double []{4,2,1,1};
        x[2] = commander;
        double [] scarlet = new double []{3,1,0,1};
        x[3] = scarlet;
        double [] squire = new double []{1,1,0,1};
        x[4] = squire;

        /*double [] wisp = new double []{1,1,0,0};
        x[5] = wisp;
        double [] silvermoon = new double []{3,3,0,1};
        x[6] = silvermoon;
        double [] divine = new double []{0,0,0,1};
        x[7] = divine;*/

        ols.newSampleData(manaCost, x);

        double[] regressionParameters = ols.estimateRegressionParameters();

        for (int i = 0; i < regressionParameters.length; i++) {
            double regressionParameter = regressionParameters[i];
            System.out.println(i + " " + regressionParameter);
        }

        System.out.println("Korkon: " + calculateValue(korkon, regressionParameters));
        System.out.println("Reckless: " + calculateValue(reckless, regressionParameters));
        System.out.println("Commander: " + calculateValue(commander, regressionParameters));
        System.out.println("Scarlet: " + calculateValue(scarlet, regressionParameters));
        System.out.println("Squire: " + calculateValue(squire, regressionParameters));
        /*System.out.println("Wisp: " + calculateValue(wisp, regressionParameters));
        System.out.println("Silvermoon: " + calculateValue(silvermoon, regressionParameters));
        System.out.println("Divine: " + calculateValue(divine, regressionParameters));*/
    }

    double calculateValue(double[] card, double[] regressionParameters){
        //regression param 0 is y intercept
        //1 = atk
        //2 = health
        //3 = charge
        //4 = shield

        return card[0] * regressionParameters[1] //attack
                    + card[1] * regressionParameters[2] //health
                + card[2] * regressionParameters[3] * regressionParameters[1] //charge
                + card[3] * regressionParameters[4];// * regressionParameters[1] * 1.1; //divine shield // * attack * extra health
    }


    //from http://bitingcode.blogspot.com/2012/01/simplest-olsmultiplelinearregression.html
    @Test
    public void anotherSimpleOLS(){
        OLSMultipleLinearRegression ols = new OLSMultipleLinearRegression();

        double[] data = { 2, 1, 4, 2 }; // 1
        double[] y = {4,6}  ;
        double [] [] x = new double[2][];
        x[0] = new double []{1};
        x[1] = new double []{2};

        int obs = 2;
        int vars = 1; // 2
        try {
            //ols.newSampleData(data, obs, vars); // 3
            ols.newSampleData(y, x);
        }
        catch(IllegalArgumentException e) {
            System.out.print("Can't sample data: ");
            e.printStackTrace();
            return;
        }

        double[] coe = null;
        try {
            //0=0
            //1=2
            coe = ols.estimateRegressionParameters(); // 4
        }
        catch(IllegalArgumentException e) { // 5
            System.out.print("Can't estimate parameters: ");
            e.printStackTrace();
            return;
        }

        dumpEstimation(coe);
    }

    private void dumpEstimation(double[] coe) {
        if(coe == null)
            return;

        for(double d : coe)
            System.out.print(d + " ");
        System.out.println();

        System.out.println("Estimations:");
        System.out.println("x = 0, y = " + calculateEstimation(0, coe));
        System.out.println("x = 1, y = " + calculateEstimation(1, coe));
        System.out.println("x = 2, y = " + calculateEstimation(2, coe));
        System.out.println("x = 3, y = " + calculateEstimation(3, coe));
        System.out.println("x = 4, y = " + calculateEstimation(4, coe));
    }

    private double calculateEstimation(double x, double[] coe) {
        double result = 0;
        for(int i = 0; i < coe.length; ++i)
            result += coe[i] * Math.pow(x, i); // 1
        return result;
    }


    //http://stackoverflow.com/questions/14533475/using-least-square-method-with-commons-math-and-fitting
    @Test
    public void helpMeUnderstandEstimateRegressionParamters(){
        OLSMultipleLinearRegression regression2 = new OLSMultipleLinearRegression();
        double[] y = {
                4,
                8,
                13,
                18
        };
        double[][] x2 =
                {
                        { 1, 1, 1  },
                        { 1, 2, 4  },
                        { 1, 3, 9  },
                        { 1, 4, 16  },
                };

        regression2.newSampleData(y, x2);
        regression2.setNoIntercept(true);
        regression2.newSampleData(y, x2);
        double[] beta = regression2.estimateRegressionParameters();
        for (double d : beta) {
            System.out.println("D: " + d);
        }
    }

}
