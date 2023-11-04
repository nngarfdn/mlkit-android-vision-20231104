package com.google.mlkit.vision.demo.kotlin

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.mlkit.vision.demo.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LivePreviewActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<LivePreviewActivity> = ActivityScenarioRule(
        LivePreviewActivity::class.java)

    @Test
    fun changeSizeOfCamera(){
        //goto settings click id settings_button
        Espresso.onView(ViewMatchers.withId(R.id.settings_button)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("Rear camera preview size")).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withText("640x480")).perform(ViewActions.click())
        //on back to live preview
        Espresso.pressBack()
    }

}