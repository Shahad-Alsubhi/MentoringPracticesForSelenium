package morningClass.week3;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C35Cookies extends TestBase {
    /*
        Go to URL: https://kitchen.applitools.com/ingredients/cookie
        Get Cookie.
        Find the total number of cookies.
        Print all the cookies.
        Add Cookie.
        Edit Cookie.
        Delete Cookie.
        Delete All Cookies.
     */
    @Test
    public void cookiesTest() {

//        Go to URL: https://kitchen.applitools.com/ingredients/cookie
        driver.get("https://kitchen.applitools.com/ingredients/cookie");

//        Print all the cookies.
        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(System.out::println);
//        Get Cookie.
        System.out.println("first cookie:" + driver.manage().getCookieNamed("protein"));

//        Find the total number of cookies.
        System.out.println("number of cookies: " + cookies.size());
//        Add Cookie.
        Cookie cookie = new Cookie("sweet", "sugar");
        driver.manage().addCookie(cookie);
//        Delete Cookie.
        driver.manage().deleteCookieNamed("vegetable");

//        Delete All Cookies.
        driver.manage().deleteAllCookies();
        System.out.println("number of cookies after deleting all: " + driver.manage().getCookies().size());

    }

}
