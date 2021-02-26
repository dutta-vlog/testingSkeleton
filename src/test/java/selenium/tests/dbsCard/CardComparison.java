package selenium.tests.dbsCard;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.page.CardsPage;
import selenium.page.PersonalPage;
import seleniumUtil.ExcelSheet;
import seleniumUtil.TestConfiguration;
import seleniumUtil.ExcelSheet.SheetName;

public class CardComparison extends TestConfiguration{

	ExcelSheet excel;
	PersonalPage personalPage;
	CardsPage cardsPage;
	String card1Name;
	String card2Name;
	
	@Test(priority=0)
	public void clickOnCard() {
		excel = new ExcelSheet().setTestCaseName(this.getClass().getSimpleName());
		personalPage = new PersonalPage(scriptController);
		personalPage.clickOnCardMenu();
	}
	
	@Test(priority=1)
	public void clickCreditCard()  {
		cardsPage = new CardsPage(scriptController);
		cardsPage.clickOnCreditCard();
	}
	
	@Test(priority=2)
	public void selectCreditCardForComparison() throws Exception {
		card1Name = excel.getData("DBSCard", SheetName.Data_Page.name(), "Card1");
		card2Name = excel.getData("DBSCard", SheetName.Data_Page.name(), "Card2");
		cardsPage.clickCompareBoxForCard(card1Name);
		cardsPage.clickCompareBoxForCard(card2Name);
	}
	
	@Test(priority=3)
	public void clickOnCardCompareButton() {
		cardsPage.clickOnCompareButton();
	}
	
	@Test(priority=4)
	public void verifyData() throws Exception {
		String card1_allData = excel.getData("DBSCard", SheetName.Parameterize_CheckPoint.name(), "Card1_Data");
		String card2_allData = excel.getData("DBSCard", SheetName.Parameterize_CheckPoint.name(), "Card2_Data");
		List<String> card1_allDataExpected = excel.etractMultipleValuesToList(card1_allData,"&&");
		List<String> card2_allDataExpected = excel.etractMultipleValuesToList(card2_allData,"&&");
		
		List<String> card1_allDataActual = cardsPage.getAllComparedDataOfCard(card1Name);
		List<String> card2_allDataActual = cardsPage.getAllComparedDataOfCard(card2Name);
		
		Assert.assertTrue(card1_allDataActual.containsAll(card1_allDataExpected),"All the data is not present at Card1,"
				+ " Expected list: "+card1_allDataExpected +"\t Actual list: "+card1_allDataActual);
		
		Assert.assertTrue(card2_allDataActual.containsAll(card2_allDataExpected),"All the data is not present at Card2,"
				+ " Expected list: "+card2_allDataExpected +"\t Actual list: "+card2_allDataActual);

	}

	
	
	
}
