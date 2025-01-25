package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalcScreen {
    AndroidDriver driver;
    String digitCommonID = "com.google.android.calculator:id/digit_";
    String operatorCommonID = "com.google.android.calculator:id/op_";
    String constantCommonID = "com.google.android.calculator:id/const_";
    //String functionCommonID = "com.google.android.calculator:id/fun_";

    @FindBy(id = "com.google.android.calculator:id/eq")
    WebElement equalBtn;

    @FindBy(id = "com.google.android.calculator:id/del")
    WebElement deleteBtn;

    @FindBy(id = "com.google.android.calculator:id/clr")
    public WebElement clearBtn;

    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement displayResult;

    @FindBy(id = "com.google.android.calculator:id/dec_point")
    WebElement decimalBtn;

    @FindBy(id = "com.google.android.calculator:id/lparen")
    WebElement leftBracketBtn;

    @FindBy(id = "com.google.android.calculator:id/rparen")
    WebElement rightBracketBtn;

    public CalcScreen(AndroidDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    public String calculateSeries(String series){
        char[] seriesArray = series.toCharArray();
        for(int i = 0; i < seriesArray.length; i++){
            char item = seriesArray[i];
            if(item == '1' || item == '2' || item == '3' || item == '4' ||
                    item == '5' || item == '6' || item == '7' || item == '8' ||
            item == '9' || item == '0'){
                driver.findElement(By.id(digitCommonID + item)).click();
            }
            else if(item == '+'){
                driver.findElement(By.id(operatorCommonID + "add")).click();
            } else if(item == '-'){
                driver.findElement(By.id(operatorCommonID + "sub")).click();
            } else if(item == '*'){
                driver.findElement(By.id(operatorCommonID + "mul")).click();
            } else if(item == '/'){
                driver.findElement(By.id(operatorCommonID + "div")).click();
            } else if(item == '^'){
                driver.findElement(By.id(operatorCommonID + "pow")).click();
            } else if(item == '!'){
                driver.findElement(By.id(operatorCommonID + "fact")).click();
            } else if(item == '%'){
                driver.findElement(By.id(operatorCommonID + "pct")).click();
            } else if(item == '.'){
                decimalBtn.click();
            } else if(item == '('){
                leftBracketBtn.click();
            } else if(item == ')'){
                rightBracketBtn.click();
            } else if(item == 'e'){
                driver.findElement(By.id(constantCommonID + "e")).click();
            } else if(item == 'p'){
                if(seriesArray[i+1] == 'i'){
                    driver.findElement(By.id(constantCommonID + "pi")).click();
                    i++;
                }
            } else {
            }
        }

        equalBtn.click();

        return displayResult.getText();
    }

    public String doSeries(String series){
        String result = calculateSeries(series);
        return result;
    }

    public void clearScreen(){
        clearBtn.click();
    }
}
