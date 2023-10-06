import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sel {

    public static void main(String[] args) throws InterruptedException {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "D:/Users/SaileswarReddy.Pala/Downloads/Google_Art/src/main/resources/chromedriver.exe");
        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            // Test 1: Verify "standard_user" & "performance_glitch_user" login
            // Login

            Thread.sleep(3000);
            login(driver, "standard_user");
            Thread.sleep(3000);
            // Logout
            logout(driver);
            Thread.sleep(3000);

            // Test 2: Verify "locked_out_user" login fails
            // Login
            login(driver, "locked_out_user");
            Thread.sleep(3000);
            // Verify error message
            WebElement errorElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".error-button")));
            String errorMessage = errorElement.getText();
            if (errorMessage.contains("Epic sadface")) {
                System.out.println("Test 2: Login as 'locked_out_user' failed with error: " + errorMessage);
            } else {
                System.out.println("Test 2: Login as 'locked_out_user' succeeded unexpectedly.");
                Thread.sleep(3000);
            }

            // Test 3: Item sort order validations
            // Login
            Thread.sleep(3000);
            login(driver, "standard_user");
            Thread.sleep(3000);

            // Test 1: Verify default sort order
            // Verify default sort order (you need to implement this)

            // Test 2: Verify user can change sort order
            // Change sort order to "Price (high to low)" (you need to implement this)

            // Test 4: Add items to cart and complete order
            // Add random 3 items to cart
            Thread.sleep(3000);
            addToCart(driver, 3);
            Thread.sleep(3000);
            // Logout
            logout(driver);
            Thread.sleep(3000);
            // Login
            login(driver, "standard_user");
            Thread.sleep(3000);
            // Navigate to cart
            driver.findElement(By.className("shopping_cart_link")).click();
            Thread.sleep(3000);
            addToCart(driver, 2);
            Thread.sleep(3000);
            // Navigate to checkout information page
            driver.findElement(By.cssSelector(".checkout_button")).click();
            Thread.sleep(3000);
            // Verify input field validations (you need to implement this)
            // Navigate to checkout overview page
            driver.findElement(By.cssSelector(".cart_button")).click();
            Thread.sleep(3000);
            // Verify total price (you need to implement this)
            // Place order
            driver.findElement(By.id("finish")).click();
            Thread.sleep(3000);
            // Verify confirmation message (you need to implement this)

        } finally {
            driver.quit();
        }
    }

    private static void login(WebDriver driver, String username) throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(50000);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    private static void logout(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    private static void addToCart(WebDriver driver, int count) throws InterruptedException {
        for (int i = 0; i < count; i++) {
            Thread.sleep(5000);
            driver.findElement(By.cssSelector(".inventory_item:nth-child(" + (i + 1) + ") .btn_inventory")).click();
        }
    }
}
