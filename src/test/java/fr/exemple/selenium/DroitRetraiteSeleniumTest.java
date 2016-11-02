package fr.exemple.selenium;

import fr.exemple.AppConfig;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DroitRetraiteSeleniumTest {

    @LocalServerPort
    private int localServerPort;

    private WebDriver webDriver;

    @BeforeClass
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Outils\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(5000);  // Let the user actually see something!
        webDriver.quit();
    }

    @Test
    public void appelSansDateDeNaissanceAfficheVide() throws Exception {
        webDriver.get("http://localhost:" + localServerPort + "/ageLegal");
        assertThat(webDriver.getTitle()).isEqualTo("Demande Retraite");
        assertThat(webDriver.findElement(By.id("resultat")).getText()).isEmpty();
    }
}
