package fr.exemple.selenium;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Quand;
import fr.exemple.AppConfig;
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
public class PhrasesExecutablesSelenium {

    @LocalServerPort
    private int localServerPort;

    private WebDriver webDriver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Dev\\Outils\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(5000);  // Let the user actually see something!
        webDriver.quit();
    }


    @Quand("^j'affiche la page (.*) dans le navigateur$")
    public void jAfficheLaPageDansLeNavigateur(final String uri) throws Throwable {
        webDriver.get("http://localhost:" + localServerPort + uri);
    }

    @Alors("^le titre de la page est '(.*)'$")
    public void leTitreDeLaPageEstDemandeRetraite(final String titrePageAttendu) throws Throwable {
        assertThat(webDriver.getTitle()).isEqualTo(titrePageAttendu);
    }

    @Alors("^le bloc resultat est vide$")
    public void leBlocResultatEstVide() throws Throwable {
        assertThat(webDriver.findElement(By.id("resultat")).getText()).isEmpty();
    }
}
