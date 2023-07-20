package com.lemon.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashibing.dp.A;
import com.mashibing.dp.TestEntity;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.ToString;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LemonStep {
    A a = new A();

/*    static ChromeDriver driver = null;
    static {
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("打开百度搜索")
    public void 打开百度搜索() throws InterruptedException {
        driver.get("https://www.baidu.com");
        Thread.sleep(2000);
    }

    @When("输入 {string}")
    public void 输入(String query) {
        WebElement e = driver.findElement(By.name("wd"));
        e.sendKeys(query);
        e.submit();
    }

    @Then("显示 {string}")
    public void 显示(String title) {
        new WebDriverWait(driver,5).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='"+title+"']"))
        );
    }
    @After
    public void 关闭浏览器()throws Exception{
        Thread.sleep(3000);
        driver.quit();
    }*/
    @Given("获取json文件:{string}")
    public void 获取json文件(String fileName) throws JSONException, IOException {
        String filePath = "src/test/resources/json/A.json";

        Path path = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(path);
        String jsonContent = new String(bytes);

        a = new ObjectMapper().readValue(jsonContent, A.class);
    }

    @Then("输出文件内容")
    public void 输出文件内容() {
        System.out.println(a);
    }

}
