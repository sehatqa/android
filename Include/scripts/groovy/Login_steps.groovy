import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

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


class Login_steps {
	@Given("User is on login page")
	def navigate_to_login_page() {
		Mobile.startApplication('C:\\Users\\User\\Katalon Studio\\SehatQ_Android\\AndroidApp\\sehatq_production.apk', false)

		Mobile.waitForElementPresent(findTestObject('Object Repository/Home_page/btn_login'), 10)

		Mobile.tap(findTestObject('Home_page/btn_login'), 0)

		Mobile.tap(findTestObject('Login_page/btn_login_with_email'), 0)
	}

	@When("User input (.*) and (.*) for login")
	def enter_login_credentials(String email, String password) {

		Mobile.verifyElementVisible(findTestObject('Object Repository/Login_page/input_email'), 2, FailureHandling.STOP_ON_FAILURE)

		Mobile.verifyElementVisible(findTestObject('Object Repository/Login_page/input_password'), 2, FailureHandling.STOP_ON_FAILURE)

		Mobile.setText(findTestObject('Login_page/input_email'), email, 0)

		Mobile.setText(findTestObject('Login_page/input_password'), password, 0)

		Mobile.tap(findTestObject('Login_page/btn_continue'), 0)
	}

	@Then("User failed to login and (.*) will displayed")
	def verify_failed_login(String error_message) {
		Mobile.verifyElementText(findTestObject('Object Repository/Login_page/error_message'), error_message)
	}

	@Then("User success login")
	def verify_success_login() {
		Mobile.verifyElementVisible(findTestObject('Object Repository/Home_page/btn_profile'), 2, FailureHandling.STOP_ON_FAILURE)
	}
}



