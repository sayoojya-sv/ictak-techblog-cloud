package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import assertions.AllPostAssertions;
import assertions.ContactUsAssertions;
import assertions.HomeAssertions;
import assertions.LoginAssertions;
import assertions.MyPostAssertions;
import base.TestBase;
import pages.AdminAboutUs;
import pages.AdminActions;
import pages.AdminAllPost;
import pages.AdminCategory;
import pages.AdminContactUs;
import pages.AdminHomePage;
import pages.AdminLoginPage;
import pages.AdminLogout;
import pages.AdminMyPost;
import utility.ExcelUtility;

@Listeners(listeners.ScreenshotListener.class)
public class AdminTest extends TestBase{
	
	AdminLoginPage ad_log;
	AdminHomePage ad_hom;
	AdminAllPost ad_allPost;
	AdminMyPost ad_mypost;
	AdminActions ad_act;
	AdminCategory ad_cat;
	AdminAboutUs ad_about;
	AdminContactUs ad_us;
	AdminLogout log_out;
	LoginAssertions log_assert;
	HomeAssertions hom_assert;
	AllPostAssertions allp_assert;
	MyPostAssertions mypst_assert;
	ContactUsAssertions us_assert;
	
	@BeforeClass
	public void objectInit() {
		ad_log      =  new AdminLoginPage(driver);
		ad_hom      =  new AdminHomePage(driver);
		ad_allPost  =  new AdminAllPost(driver);
		ad_mypost   =  new AdminMyPost(driver);
		ad_act      =  new AdminActions(driver);
		ad_cat      =  new AdminCategory(driver);
		ad_about    =  new AdminAboutUs(driver);
		ad_us       =  new AdminContactUs(driver);
		log_out     =  new AdminLogout(driver);
		log_assert  =  new LoginAssertions(driver);
		hom_assert  =  new HomeAssertions(driver);
		allp_assert =  new AllPostAssertions(driver);
		mypst_assert=  new MyPostAssertions(driver);
		us_assert   =  new ContactUsAssertions(driver);
	}
	
	@Test(priority=1)
	public void loginTest() throws IOException {
		ad_log.dropDown();
		ad_log.loginEmail("admin");
		ad_log.loginPass("1234");
//		ad_log.loginPage(ExcelUtility.readExcel(0, 0), ExcelUtility.readExcel(0, 1));
		ad_log.subBtn();
		Assert.assertTrue(log_assert.isAdminHomePageDisplayed());
	}

	@Test(priority=2)
	public void homepageTest() {
		ad_hom.admHome();
		Assert.assertTrue(hom_assert.isHomePageDisplayed());
		ad_hom.clickEdit();
		ad_hom.clkDelete();
	}
	
	@Test(priority=3)
	public void deletemsgDisplayTest() {
		Assert.assertTrue(hom_assert.isdeletemsgDisplayed());
	}
	
	@Test(priority=4)
	public void allPostTest() {
		ad_allPost.allPosts();
		Assert.assertTrue(allp_assert.isallPostDisplayed());
		ad_allPost.clickEdit();
		ad_allPost.clkDelete();
	}
	
	@Test(priority=5)
	public void myPostTest() {
		ad_mypost.myPostclk();
		Assert.assertTrue(mypst_assert.isMyPostDisplayed());
	}
	
	@Test(priority=6)
	public void myActionsTest() {
		ad_act.approvePost("Ok!!");
		ad_act.rejPost("Need improvement");
		ad_act.addCat("LIVEDEM");
		ad_act.remCat();
		ad_act.newPost("Flower", "https://getwallpapers.com/wallpaper/full/b/7/5/487484.jpg" , "Tulips!!");
	}
	
	@Test(priority=7)
	public void categoryTest() {
		ad_cat.cate_gory();
		ad_cat.selCat();
	}
	
	@Test(priority=8)
	public void aboutUsTest() {
		ad_about.ab_out();
		Assert.assertTrue(ad_about.isAboutUsDisplayed());
	}
	
	@Test(priority=9)
	public void contactUsTest() {
		ad_us.clk_contact();
		Assert.assertTrue(us_assert.isContactUsDisplayed());
		ad_us.inp_value("abc", "abc@gmail.com", "abcd");
		ad_us.sndBtn();
	}
	
	@Test(priority=10)
	public void iconTest() {
		ad_us.clk_contact();
		ad_us.clickIcon();
		Assert.assertTrue(driver.getCurrentUrl().contains("github"));
	}
	
	@Test(priority=11)
	public void logOutTest() {
		log_out.logOut();
	}
	
	
	@Test(priority=12)
	public void invalidLoginTest() {
		ad_log.dropDown();
		ad_log.loginEmail("admi");
		ad_log.loginPass("123");
		ad_log.subBtn();
		String actual = log_assert.getAlertText();
	    Assert.assertEquals(actual, "User not found");

	}
	
	@Test(priority=13)
	public void emptyPassLogin() {
		ad_hom.admHome();
		ad_log.dropDown();
		ad_log.loginEmail("admi");
		ad_log.subBtn();
		Assert.assertTrue(log_assert.isemptyPassDisplayed());
	}
	
	@Test(priority=14)
	public void emptyfieldLogin() {
		ad_hom.admHome();
		ad_log.dropDown();
//        ad_log.loginPage("","");
		ad_log.subBtn();
		Assert.assertTrue(log_assert.isemptymessagedisplayed());

	}
}

