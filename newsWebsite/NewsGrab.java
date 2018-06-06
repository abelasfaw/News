/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automate;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Abel
 */
public class NewsGrab {

    public static void main(String[] args) {
        // TODO code application logic here

        System.setProperty("Webdriver.chrome.driver", "chromedriver");

        WebDriver driver2 = new ChromeDriver();
        
        
         driver2.get("http://www.awrambatimes.com");
      List<WebElement> ethioLinks = driver2.findElements(By.cssSelector(".post-title a"));
      int count = 0;
      for ( WebElement we: ethioLinks) {   
         
                      we.click();
                      break;            
        } 
      List<WebElement>  ethioPara = driver2.findElements(By.cssSelector(".entry-inner p"));
          
        String ethioContent = " ";
        for ( WebElement we: ethioPara) {
                
                ethioContent = ethioContent.concat(we.getAttribute("innerHTML"));
                
        }
       
        driver2.navigate().to("https://www.bbc.com"); // bbc content starts here
        WebElement link = driver2.findElement(By.cssSelector(".media__title a"));
        link.click();
        
        List<WebElement>  contents = driver2.findElements(By.cssSelector(".story-body__inner p"));
        String bbcContents = " ";
        
        for ( WebElement we: contents) {
                System.out.println(we.getAttribute("innerHTML"));
                bbcContents =bbcContents.concat(we.getAttribute("innerHTML"));
                
        }
       
        driver2.navigate().to("https://www.bbc.com/amharic");
        List<WebElement> habeshaLinks = driver2.findElements(By.cssSelector(".title-link__title-text"));
            
            for ( WebElement we: habeshaLinks) {   
                System.out.println(we.getAttribute("innerHTML"));
                  
                  we.click();
                  break;
                
                  


    }
   List<WebElement> habeshaPara = driver2.findElements(By.cssSelector(".story-body__inner p"));
  String habeshaContents = " ";
    for (WebElement we : habeshaPara) {
            
            habeshaContents = habeshaContents.concat(we.getAttribute("innerHTML"));
            
        }
    System.out.println("habesha contens  " + habeshaContents);
      
      
        driver2.navigate().to("http://localhost:3000/postPage");
        WebElement inputField = driver2.findElement(By.id("input"));
        inputField.sendKeys(habeshaContents);
        WebElement post = driver2.findElement(By.id("postButton"));
        post.click();
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        WebElement inputField2 = driver2.findElement(By.id("input2"));
        inputField2.sendKeys(bbcContents);
        WebElement post2 = driver2.findElement(By.id("postButton2"));
        post2.click();
        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        WebElement inputField3 = driver2.findElement(By.id("input3"));

        inputField3.sendKeys(ethioContent);
        WebElement post3 = driver2.findElement(By.id("postButton3"));
        post3.click();
        driver2.navigate().to("http://localhost:3000");

    
    
    }
}
