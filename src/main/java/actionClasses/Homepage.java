/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actionClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author neerajsah
 */
public class Homepage 
{
   WebDriver driver;
   
   public Homepage(WebDriver driver)
   {
       this.driver=driver;
   }
   
   public void searchHotel() throws InterruptedException
   {

      WebElement element=driver.findElement(By.xpath("//*[@id=\"booking_engine_hotels\"]"));
      Actions toolAct = new Actions(driver);
      toolAct.click(element);
      toolAct.build().perform();


      WebDriverWait wait = new WebDriverWait(driver, 15);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BE_hotel_destination_city\"]")));
      driver.findElement(By.xpath("//*[@id=\"BE_hotel_destination_city\"]")).sendKeys("New Delhi");

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"booking_engine_modues\"]/div/div/div[2]/ul/li[1]/div/div/ul/div/div/div/div[2]/li")));
      driver.findElement(By.xpath("//*[@id=\"booking_engine_modues\"]/div/div/div[2]/ul/li[1]/div/div/ul/div/div/div/div[2]/li")).click();
      
      driver.findElement(By.xpath("//*[@id=\"BE_hotel_htsearch_btn\"]")).click();
      
      driver.findElement(By.xpath("//*[@id=\"hotel-srp\"]/div[1]/div/div[2]/div/img")).click();
      
      Thread.sleep(5000);
      driver.navigate().back();
      
   }
   
   public void searchHolidays() throws InterruptedException
   {
       WebDriverWait wait = new WebDriverWait(driver, 15);
       
      driver.findElement(By.xpath("//*[@id=\"booking_engine_holidays\"]")).click();
      

      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BE_holiday_leaving_city\"]")));
      driver.findElement(By.xpath("//*[@id=\"BE_holiday_leaving_city\"]")).sendKeys("new delhi");
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BE_holiday_destination_details\"]/div[1]/ul/li[1]/div/div/ul/div/div/div/div/li")));
      driver.findElement(By.xpath("//*[@id=\"BE_holiday_destination_details\"]/div[1]/ul/li[1]/div/div/ul/div/div/div/div/li")).click();
      
      driver.findElement(By.xpath("//*[@id=\"holiday_destination_city\"]")).sendKeys("andaman");
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BE_holiday_destination_details\"]/div[1]/ul/li[2]/div/div/ul/div/div/div/div")));
      driver.findElement(By.xpath("//*[@id=\"BE_holiday_destination_details\"]/div[1]/ul/li[2]/div/div/ul/div/div/div/div")).click();
      
      //submit
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"BE_holiday_search_btn\"]")));
      driver.findElement(By.xpath("//*[@id=\"BE_holiday_search_btn\"]")).click();
      
      Thread.sleep(5000);
      driver.navigate().back();
      
   }
}
