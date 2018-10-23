$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("addproduct.feature");
formatter.feature({
  "line": 1,
  "name": "As a user i want to add a product to cart through Quick view",
  "description": "...i want to add another product to cart and complete the place order",
  "id": "as-a-user-i-want-to-add-a-product-to-cart-through-quick-view",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Verify user able to place the order",
  "description": "",
  "id": "as-a-user-i-want-to-add-a-product-to-cart-through-quick-view;verify-user-able-to-place-the-order",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I navigate to home page",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Create an \"testuser@gmail.com\" user",
  "keyword": "And "
});
formatter.step({
  "line": 6,
  "name": "Search a product",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "Add \"2\" product with \"2\" quantity to cart from quickview",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Add \"1\" product with \"1\" quantity to cart from quickview",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I navigate to shoppingcart",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I navigate to checkoutpage",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I Submit the order",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I should see the Order confirmation messsage",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.I_navigate_to_home_page()"
});
formatter.result({
  "duration": 26573325891,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuser@gmail.com",
      "offset": 11
    }
  ],
  "location": "Stepdefinition.create_an_user(String)"
});
formatter.result({
  "duration": 7219048276,
  "error_message": "org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {\"method\":\"css selector\",\"selector\":\"input#id_gender1\"}\n  (Session info: chrome\u003d69.0.3497.100)\n  (Driver info: chromedriver\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5),platform\u003dWindows NT 10.0.17134 x86_64) (WARNING: The server did not provide any stacktrace information)\nCommand duration or timeout: 0 milliseconds\nFor documentation on this error, please visit: http://seleniumhq.org/exceptions/no_such_element.html\nBuild info: version: \u00273.5.2\u0027, revision: \u002710229a9\u0027, time: \u00272017-08-21T17:29:55.15Z\u0027\nSystem info: host: \u0027SANKAR\u0027, ip: \u0027192.168.0.6\u0027, os.name: \u0027Windows 10\u0027, os.arch: \u0027amd64\u0027, os.version: \u002710.0\u0027, java.version: \u00271.8.0_161\u0027\nDriver info: org.openqa.selenium.chrome.ChromeDriver\nCapabilities [{mobileEmulationEnabled\u003dfalse, hasTouchScreen\u003dfalse, platform\u003dXP, acceptSslCerts\u003dfalse, goog:chromeOptions\u003d{debuggerAddress\u003dlocalhost:39980}, acceptInsecureCerts\u003dfalse, webStorageEnabled\u003dtrue, browserName\u003dchrome, takesScreenshot\u003dtrue, javascriptEnabled\u003dtrue, setWindowRect\u003dtrue, unexpectedAlertBehaviour\u003d, applicationCacheEnabled\u003dfalse, rotatable\u003dfalse, networkConnectionEnabled\u003dfalse, chrome\u003d{chromedriverVersion\u003d2.42.591088 (7b2b2dca23cca0862f674758c9a3933e685c27d5), userDataDir\u003dC:\\Users\\SANKAR~1\\AppData\\Local\\Temp\\scoped_dir3116_12858}, takesHeapSnapshot\u003dtrue, unhandledPromptBehavior\u003d, pageLoadStrategy\u003dnormal, databaseEnabled\u003dfalse, handlesAlerts\u003dtrue, version\u003d69.0.3497.100, browserConnectionEnabled\u003dfalse, nativeEvents\u003dtrue, locationContextEnabled\u003dtrue, cssSelectorsEnabled\u003dtrue}]\nSession ID: c407d34e6705af5b3cfb1c7b6da2c87d\n*** Element info: {Using\u003dcss selector, value\u003dinput#id_gender1}\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\r\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\r\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:423)\r\n\tat org.openqa.selenium.remote.ErrorHandler.createThrowable(ErrorHandler.java:215)\r\n\tat org.openqa.selenium.remote.ErrorHandler.throwIfResponseFailed(ErrorHandler.java:167)\r\n\tat org.openqa.selenium.remote.http.JsonHttpResponseCodec.reconstructValue(JsonHttpResponseCodec.java:40)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:82)\r\n\tat org.openqa.selenium.remote.http.AbstractHttpResponseCodec.decode(AbstractHttpResponseCodec.java:45)\r\n\tat org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:164)\r\n\tat org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:82)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:641)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:414)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElementByCssSelector(RemoteWebDriver.java:505)\r\n\tat org.openqa.selenium.By$ByCssSelector.findElement(By.java:430)\r\n\tat org.openqa.selenium.remote.RemoteWebDriver.findElement(RemoteWebDriver.java:406)\r\n\tat org.openqa.selenium.support.pagefactory.DefaultElementLocator.findElement(DefaultElementLocator.java:69)\r\n\tat org.openqa.selenium.support.pagefactory.internal.LocatingElementHandler.invoke(LocatingElementHandler.java:38)\r\n\tat com.sun.proxy.$Proxy15.getAttribute(Unknown Source)\r\n\tat com.test.support.BrowserActions.isRadioOrCheckBoxSelected(BrowserActions.java:475)\r\n\tat com.test.support.BrowserActions.selectRadioOrCheckbox(BrowserActions.java:463)\r\n\tat com.test.bjss.pages.LoginPage.myPersonalDetails(LoginPage.java:101)\r\n\tat stepdefinition.Stepdefinition.create_an_user(Stepdefinition.java:46)\r\n\tat ✽.And Create an \"testuser@gmail.com\" user(addproduct.feature:5)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Stepdefinition.Search_a_product()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 5
    },
    {
      "val": "2",
      "offset": 22
    }
  ],
  "location": "Stepdefinition.add_a_product_to_cart_from_quickview(int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 5
    },
    {
      "val": "1",
      "offset": 22
    }
  ],
  "location": "Stepdefinition.add_a_product_to_cart_from_quickview(int,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Stepdefinition.i_navigate_to_shoppingcart()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Stepdefinition.i_navigate_to_checkoutpage()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Stepdefinition.i_navigate_to_delivery_details_page()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "Stepdefinition.i_should_see_the_order_confirmation_message()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1384620955,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Verify added review comments in order details",
  "description": "",
  "id": "as-a-user-i-want-to-add-a-product-to-cart-through-quick-view;verify-added-review-comments-in-order-details",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I navigate to home page",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "Login as \"testuser@gmail.com\" user",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "Add review comments in order details",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I should see the review comments",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.I_navigate_to_home_page()"
});
formatter.result({
  "duration": 21330328857,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuser@gmail.com",
      "offset": 10
    }
  ],
  "location": "Stepdefinition.login_as_user(String)"
});
formatter.result({
  "duration": 21979402770,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.add_commments_in_order_details(String)"
});
formatter.result({
  "duration": 1347909,
  "error_message": "cucumber.runtime.CucumberException: Arity mismatch: Step Definition \u0027stepdefinition.Stepdefinition.add_commments_in_order_details(String) in file:/F:/eclipse_Java_with_plugin/workspace/cucumber-selenium/target/test-classes/\u0027 with pattern [^Add review comments in order details$] is declared with 1 parameters. However, the gherkin step has 0 arguments []. \nStep: And Add review comments in order details\r\n\tat cucumber.runtime.StepDefinitionMatch.arityMismatch(StepDefinitionMatch.java:102)\r\n\tat cucumber.runtime.StepDefinitionMatch.transformedArgs(StepDefinitionMatch.java:60)\r\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:37)\r\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:300)\r\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\r\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\r\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:44)\r\n\tat cucumber.runtime.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:102)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:63)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:18)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:70)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:95)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:38)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.api.junit.Cucumber.run(Cucumber.java:100)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)\r\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:498)\r\n\tat org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\r\n\tat org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)\r\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Stepdefinition.i_should_see_the_review_comments()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1384754947,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "Verify the product details in order details page",
  "description": "",
  "id": "as-a-user-i-want-to-add-a-product-to-cart-through-quick-view;verify-the-product-details-in-order-details-page",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 21,
  "name": "I navigate to home page",
  "keyword": "When "
});
formatter.step({
  "line": 22,
  "name": "Login as \"testuser@gmail.com\" user",
  "keyword": "And "
});
formatter.step({
  "line": 23,
  "name": "I open the order details",
  "keyword": "And "
});
formatter.step({
  "line": 24,
  "name": "I should see the product details in order details",
  "keyword": "Then "
});
formatter.match({
  "location": "Stepdefinition.I_navigate_to_home_page()"
});
formatter.result({
  "duration": 22790786211,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "testuser@gmail.com",
      "offset": 10
    }
  ],
  "location": "Stepdefinition.login_as_user(String)"
});
formatter.result({
  "duration": 19231284938,
  "status": "passed"
});
formatter.match({
  "location": "Stepdefinition.i_open_the_order_details()"
});
formatter.result({
  "duration": 16727554812,
  "error_message": "java.lang.Exception: Order History not found in page!!\r\n\tat com.test.support.BrowserActions.clickOnElement(BrowserActions.java:171)\r\n\tat com.test.bjss.pages.MyAccountDetails.openorderhistory(MyAccountDetails.java:40)\r\n\tat stepdefinition.Stepdefinition.i_open_the_order_details(Stepdefinition.java:122)\r\n\tat ✽.And I open the order details(addproduct.feature:23)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "Stepdefinition.i_should_see_the_product_details_in_order_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 1436650002,
  "status": "passed"
});
});