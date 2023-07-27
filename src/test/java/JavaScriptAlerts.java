import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class JavaScriptAlerts {

    public static WebDriver driver;

    public static void OpenBrowser(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void AcceptAlert(){
        try{
            OpenBrowser();
            driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
            driver.switchTo().alert().accept();
            String result = driver.findElement(By.id("result")).getText();
            String expected = "You successfully clicked an alert";
            Assert.assertEquals("Message Incorrect",expected,result);
            driver.quit();
        }catch (Exception e){
            System.out.println("Failed");
        }
    }

    @Test
    public void DismissAlert(){
        try{
            OpenBrowser();
            driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
            driver.switchTo().alert().dismiss();
            String result = driver.findElement(By.id("result")).getText();
            String expected = "You clicked: Cancel";
            Assert.assertEquals("Message Incorrect",expected,result);
            driver.quit();
        }catch (Exception e){
            System.out.println("Failed");
        }

    }

    @Test
    public void EnterTextInPrompt(){
        try{
            OpenBrowser();
            driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
            driver.switchTo().alert().sendKeys("Entering Text in Prompt");
            driver.switchTo().alert().accept();
            String result = driver.findElement(By.id("result")).getText();
            String expected = "You entered: Entering Text in Prompt";
            Assert.assertEquals("Message Incorrect",expected,result);
            driver.quit();
        }catch (Exception e){
            System.out.println("Failed");
        }

    }
}
