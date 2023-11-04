package com.google.mlkit.vision.demo.kotlin

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ChooserActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<ChooserActivity> = ActivityScenarioRule(
        ChooserActivity::class.java)

    @Test
    fun launchLivePreviewTest(){
        Espresso.onView(ViewMatchers.withText("LivePreviewActivity")).perform(ViewActions.click())
        Thread.sleep(4000)
        //check "InputImage size:" is displayed
        Espresso.onView(ViewMatchers.withText("Object Detection")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun launchLivePreviewChangeDetectionTest(){
        launchLivePreviewTest()
        Espresso.onView(ViewMatchers.withText("Object Detection")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Image Labeling"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withText("Image Labeling")).perform(ViewActions.click())
        Thread.sleep(4000)
    }

}