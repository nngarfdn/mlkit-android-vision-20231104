package com.google.mlkit.vision.demo.kotlin

import android.app.Activity
import android.content.Intent
import android.provider.ContactsContract
import android.provider.MediaStore
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.matcher.IntentMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import com.google.mlkit.vision.demo.R
import org.hamcrest.Matchers
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StillImageActivityTest{

    @get:Rule
    var activityRule: ActivityScenarioRule<StillImageActivity> = ActivityScenarioRule(
        StillImageActivity::class.java
    )

    @Test
    fun testStaticImage() {

        Espresso.onView(withId(R.id.select_image_button)).perform(ViewActions.click())
        Espresso.onView(withText("Take photo")).perform(ViewActions.click())
        Thread.sleep(2000)
        //this step camera was opened, then we need to take a photo
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val result = InstrumentationRegistry.getInstrumentation().targetContext
            .packageManager.queryIntentActivities(intent, 0)
if (result.size > 0) {
    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, ContactsContract.Contacts.Photo.CONTENT_URI)
    activityRule.scenario.onActivity { activity ->
        activity.startActivityForResult(cameraIntent, 1)
    }
}
        Thread.sleep(3000)
        Espresso.onView(withText("OK")).perform(ViewActions.click())

    }






}