package com.searchframework.wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class WebElementActions {

    public static Select selectObj;

    @Autowired
    public BrowserActions browserActions;

    public void clearAndType(WebElement element, String value) {
        browserActions.waitForElementToVisible(element);
        log.info("User typing text on element: " + element);
        element.clear();
        element.sendKeys(value);
    }

    public void selectByVisibleText(WebElement element, String visibleText){
        log.info("User performing Select operation on element: " + element + "for text " + visibleText);
        selectObj = new Select(element);
        selectObj.selectByVisibleText(visibleText);
    }

    public void selectByIndexValue(WebElement element, String indexValue){
        browserActions.waitForElementToVisible(element);
        log.info("User performing Select operation on element: " + element + "for index value " + indexValue);
        selectObj = new Select(element);
        selectObj.selectByVisibleText(indexValue);
    }

    public void selectByValue(WebElement element, String value){
        browserActions.waitForElementToVisible(element);
        log.info("User performing Select operation on element: " + element + "for value " + value);
        selectObj = new Select(element);
        selectObj.selectByVisibleText(value);
    }

    public void onClick(WebElement element){
        try{
            browserActions.waitForElementToClickable(element);
            log.debug("Element is Clickable : " + element);
            element.click();
        } catch (StaleElementReferenceException exception) {
            log.error("Element is Not Clickable " + exception);
        }
    }

    public void selectCheckbox(WebElement element) {
        browserActions.waitForElementToVisible(element);
        boolean isSelected = element.isSelected();
        if (isSelected)
            log.info("Checkbox" + element + " is already selected");
        else {
            log.info("User selecting" + element + " checkbox");
            element.click();
        }
    }

    public boolean isElementPresent(WebElement locatorElement) {
        try {
            browserActions.fluentWait(locatorElement);
            log.info("Element is Present : " + locatorElement);
            return true;
        } catch (NoSuchElementException exception) {
            log.error("Element is Not Present : " + exception);
            return false;
        }
    }

    public boolean isElementVisible(WebElement locatorElement){
        try {
            browserActions.fluentWait(locatorElement).isDisplayed();
            log.info("Element is Visible : " + locatorElement);
            return true;
        } catch (NoSuchElementException exception) {
            log.error(locatorElement + " element is Not Present " + exception);
            return false;
        }
    }
}
