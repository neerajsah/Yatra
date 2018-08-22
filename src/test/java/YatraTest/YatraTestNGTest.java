/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package YatraTest;

import actionClasses.Homepage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author neerajsah
 */
public class YatraTestNGTest {
    
    WebDriver driver;
    
    @BeforeClass
    public void launchBrowser() throws InterruptedException
    { 
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\neerajsah\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.yatra.com/");
        
        System.out.print(driver.getCurrentUrl());
        Thread.sleep(0500);
    }
    
    @Test
    public void callBasic() throws InterruptedException
    {
        Homepage homepage=new Homepage(driver);
        homepage.searchHotel();
        System.out.print(driver.getCurrentUrl());
        
        homepage.searchHolidays();
        System.out.print(driver.getCurrentUrl());
    } 

//    @AfterClass
//    public void closeBrowser()
//    { driver.quit();
//    }

    
}
