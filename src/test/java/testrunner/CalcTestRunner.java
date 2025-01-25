package testrunner;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CalcScreen;
import setup.Setup;
import utils.Utils;

import java.io.IOException;

public class CalcTestRunner extends Setup {

    @Test(priority = 1, description = "Calculate series in calculator app directly")
    public void doSeries(){
        CalcScreen calcScreen = new CalcScreen(driver);
        int result = Integer.parseInt(calcScreen.doSeries("100/10*5-10+60"));
        System.out.println(result);
        Assert.assertEquals(result, 100);
        calcScreen.clearScreen();
    }

    @Test(priority = 2, description = "Calculate series in calculator app from CSV file")
    public void doSeriesFromCSV() throws IOException {
        CalcScreen calcScreen = new CalcScreen(driver);
        Object[] series = Utils.getCSVData();

        double[] results = {95, 0, 100.53};
        for(int i = 0; i < series.length; i++){
            String result = calcScreen.doSeries(series[i].toString());
            result = Utils.decimalFormat(Double.parseDouble(result));
            double value = Double.parseDouble(result);
            System.out.println(value);
            Assert.assertEquals(value, results[i]);
            calcScreen.clearScreen();
        }
    }

//    @AfterMethod
//    public void clear(){
//        CalcScreen calcScreen = new CalcScreen(driver);
//        calcScreen.clearBtn.click();
//    }
}
