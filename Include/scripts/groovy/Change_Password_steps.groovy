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
import org.eclipse.persistence.internal.oxm.record.json.JSONParser.object_return
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



class Change_Password_steps {

	@When("User input (.*), (.*) and (.*) for change password")
	def enter_password_credentials(String old_password, String new_password, String confirmation_password) {
		Mobile.tap(findTestObject('Object Repository/AppSetting_page/btn_change_password'), 0)

		Mobile.setText(findTestObject('Object Repository/Change Password Page/txt_old_password'), old_password, 0)
		Mobile.setText(findTestObject('Object Repository/Change Password Page/txt_new_password'), new_password, 0)
		Mobile.setText(findTestObject('Object Repository/Change Password Page/txt_confirmation_password'), confirmation_password, 0)

		Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Change Password Page/btn_save'), 'enabled', 'true', 0, FailureHandling.STOP_ON_FAILURE)
	}

	@And("User save password settings")
	def save_change_password() {
		Mobile.waitForElementPresent(findTestObject('Object Repository/Change Password Page/btn_save'), 2, FailureHandling.STOP_ON_FAILURE)
		Mobile.tap(findTestObject('Object Repository/Change Password Page/btn_save'), 0)
	}

	@Then("User failed to change password")
	def error_message_for_change_password() {
		Mobile.verifyElementExist(findTestObject('Object Repository/Change Password Page/btn_save'), 1, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Change Password Page/btn_save'), 'enabled', 'false', 1, FailureHandling.STOP_ON_FAILURE)
	}

	@Then("User success to change password")
	def success_change_password() {
		//		Mobile.verifyElementNotExist(findTestObject('Object Repository/Change Password Page/btn_save'), 0, FailureHandling.STOP_ON_FAILURE)
		Mobile.verifyElementExist(findTestObject('Object Repository/AppSetting_page/btn_logout'), 0, FailureHandling.STOP_ON_FAILURE)
	}
}