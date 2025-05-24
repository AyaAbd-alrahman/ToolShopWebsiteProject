package ToolShopWebsiteProject.ToolShopWebsiteProject;

import java.awt.Window;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v134.page.model.NavigatedWithinDocument;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;



public class MyTest {
	WebDriver driver = new EdgeDriver();

	String THEWEBSITE = "https://practicesoftwaretesting.com/";

	String email = "ayamuneer@yahoo.com";
	String Password = "Ayoosha@123";

	@BeforeTest
	public void mySetup() {

		driver.manage().window().maximize();

		driver.get(THEWEBSITE);

	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {

		WebElement loginlink = driver.findElement(By.linkText("Sign in"));
		loginlink.click();

		Thread.sleep(2000);
		WebElement EmailInput = driver.findElement(By.id("email"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.cssSelector(".btnSubmit"));

		EmailInput.sendKeys(email);
		PasswordInput.sendKeys(Password);
		Thread.sleep(2000);
		LoginButton.click();

	}

	@Test(priority = 2)
	public void ProductSearchAndFiltiring() throws InterruptedException {
		Thread.sleep(2000);
		WebElement HOME = driver.findElement(By.linkText("Home"));
		HOME.click();
		
		WebElement TheSelector = driver.findElement(By.cssSelector(".form-select"));
		Select mySelect = new Select(TheSelector);
		mySelect.selectByValue("name,asc");
		
		WebElement SearchInput = driver.findElement(By.id("search-query"));
		SearchInput.sendKeys("hammer");
		WebElement Searchbutton=driver.findElement(By.xpath("//button[@data-test='search-submit']"));
		Searchbutton.click();
		                                      

	}
	@Test(priority = 3)
	public void AddItems() throws InterruptedException {

Thread.sleep(2000);
		List<WebElement> products = driver.findElements(By.cssSelector(".card-title"));
		WebElement firstProduct = products.get(0);
		System.out.println(firstProduct.getText());
		firstProduct.click();
		
		
		Thread.sleep(2000);
		Set<String> handles = driver.getWindowHandles();

		List<String> TabList = new ArrayList<>(handles);

		driver.switchTo().window(TabList.get(0));

		Thread.sleep(2000);

		System.out.println(driver.getTitle());
		
		
		
		
		WebElement addtocartButton = driver.findElement(By.id("btn-add-to-cart"));
		addtocartButton.click();
		}
   @Test (priority = 4)
   public void CheckoutFlow () throws InterruptedException {
	   Thread.sleep(7000);
	   WebElement cart = driver.findElement(By.cssSelector(".svg-inline--fa.fa-cart-shopping"));
	   cart.click();
	   
	   Thread.sleep(2000);
		WebElement  ProceedToCheckoutbutton = driver.findElement(By.cssSelector(".btn.btn-success"));
			  ProceedToCheckoutbutton.click();
			  

				Thread.sleep(2000);				
				WebElement  ProceedToCheckoutbutton1 = driver.findElement(By.xpath("//button[@data-test='proceed-2']"));
				  ProceedToCheckoutbutton1.click();
				  
				  
				  Thread.sleep(2000);				
					WebElement  ProceedToCheckoutbutton2 = driver.findElement(By.xpath("//button[@data-test='proceed-3']"));
					  ProceedToCheckoutbutton2.click();
	   
	   WebElement TheSelector = driver.findElement(By.xpath("//select[@data-test='payment-method']"));
		Select mySelect = new Select(TheSelector);
		mySelect.selectByValue("cash-on-delivery");
		
		  WebElement conforimButton= driver.findElement(By.xpath("//button[@data-test='finish']"));
		  conforimButton.click();
		   
   }
   }


