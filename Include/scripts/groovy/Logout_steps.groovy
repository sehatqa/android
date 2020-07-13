import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Logout_steps {

	@Given("User is on App Settings page")
	def go_to_app_settings_page() {
		Mobile.startApplication('C:\\Users\\User\\Katalon Studio\\SehatQ_Android\\AndroidApp\\sehatq_production.apk', false)

		Mobile.waitForElementPresent(findTestObject('Object Repository/Home_page/btn_profile'), 5)

		Mobile.tap(findTestObject('Object Repository/Home_page/btn_profile'), 1)

		Mobile.verifyElementVisible(findTestObject('Object Repository/Profile_page/btn_more'), 0, FailureHandling.STOP_ON_FAILURE)

		Mobile.tap(findTestObject('Object Repository/Profile_page/btn_more'), 1)

		Mobile.tap(findTestObject('Object Repository/Profile_page/btn_terapkan'), 0)
	}

	@When("User tap logout button")
	def logout() {
		Mobile.tap(findTestObject('Object Repository/AppSetting_page/btn_logout'), 0)
	}

	@And("User confirm to logout")
	def confirm_logout() {

		Mobile.tap(findTestObject('Object Repository/AppSetting_page/btn_yes'), 2)
	}

	@Then("User success logout")
	def verify_logout_logout() {

		Mobile.verifyElementVisible(findTestObject('Object Repository/Home_page/btn_login'), 0, FailureHandling.STOP_ON_FAILURE)
	}
}
