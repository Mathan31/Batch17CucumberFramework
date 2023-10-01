package steps;

import base.BrowserFactory;
import base.PicoTestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.EbayPage;

public class EbaySearchSteps extends BrowserFactory {

	private EbayPage ebayPage;

	public EbaySearchSteps(PicoTestContext picoTestContext) {
		ebayPage = picoTestContext.getPageObjectManager().getEbayPage();
	}

	@Given("Navigate to Ebay Home Page")
	public void navigate_to_ebay_home_page() {
		ebayPage.navigateToEbay();
	}

	@When("Search the product and Selected the Catagory")
	public void search_the_product_and_selected_the_catagory() {
		ebayPage.enterSearchText("iPhone");
		ebayPage.selectProdCatagory("Cell Phones & Accessories");
	}

	@When("^User can Search the multiple product as ([^0-9]+) and Selected multiple Catagory as ([^0-9]+)$")
	public void user_can_search_the_multiple_product_and_selected_multiple_catagory(String prodName,
			String prodCatagory) {
		ebayPage.enterSearchText(prodName);
		ebayPage.selectProdCatagory(prodCatagory);
	}

	@When("Click on Submmit button")
	public void click_on_submmit_button() {
		ebayPage.clickOnSearchButton();
	}

	@Then("User should see the search result")
	public void user_should_see_the_search_result() {
		String searchResult = ebayPage.getSearchResult();
		System.out.println("Search Result is : " + searchResult);
	}
}
