package com.test.news

//import junit.framework.Assert.assertEquals

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.test.news.features.login.presentation.LoginActivity
import junit.framework.Assert.assertTrue
import org.junit.Rule
import org.junit.Test


class LoginInstrumentedTest {

    @get:Rule
    var activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)


    @Test
    fun shouldLoginWithValidCredentials() {
        onView(withId(R.id.editTextUserName))
            .perform(clearText(), typeText(VALID_USER_NAME))
        onView(withId(R.id.editTextPassword))
            .perform(clearText(), typeText(VALID_USER_PASSWORD))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // TODO assert login when ready
        assertTrue(activityTestRule.activity.isFinishing)
    }

    @Test
    fun shouldShowLoginButtonAppLaunch() {
        onView(withId(R.id.editTextUserName))
            .check(matches(isDisplayed()))
        onView(withId(R.id.editTextPassword))
            .check(matches(isDisplayed()))
        onView(withId(R.id.buttonLogin))
            .check(matches(isDisplayed()))

    }

    @Test
    fun failedLoginWithInvalidUsername() {
        onView(withId(R.id.editTextUserName))
            .perform(clearText(), typeText(INVALID_USER_NAME))
        onView(withId(R.id.editTextPassword))
            .perform(clearText(), typeText(VALID_USER_PASSWORD))
        onView(withId(R.id.buttonLogin))
            .perform(click())
            .check(matches(isDisplayed()))

    }

    @Test
    fun failedLoginWithInvalidPassword() {
        onView(withId(R.id.editTextUserName))
            .perform(clearText(), typeText(VALID_USER_NAME))
        onView(withId(R.id.editTextPassword))
            .perform(clearText(), typeText(INVALID_USER_PASSWORD))
        onView(withId(R.id.buttonLogin))
            .perform(click())
            .check(matches(isDisplayed()))

    }

    @Test
    fun shouldShowNewsPageWithValidCredentials() {
        onView(withId(R.id.editTextUserName))
            .perform(clearText(), typeText(VALID_USER_NAME))
        onView(withId(R.id.editTextPassword))
            .perform(clearText(), typeText(VALID_USER_PASSWORD))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // TODO assert login when ready
        Thread.sleep(2000)
        onView(withId(R.id.recyclerViewNews)).check(matches(isDisplayed()))

    }

    @Test
    fun shouldShowNewsPageOnAppReOpen() {
        onView(withId(R.id.editTextUserName))
            .perform(clearText(), typeText(VALID_USER_NAME))
        onView(withId(R.id.editTextPassword))
            .perform(clearText(), typeText(VALID_USER_PASSWORD))
        onView(withId(R.id.buttonLogin))
            .perform(click())

        // TODO assert login when ready
        Thread.sleep(3000)

        onView(withId(R.id.home))
            .perform(click())

        Thread.sleep(1000)


    }



    companion object {
        private const val VALID_USER_NAME = "user1"
        private const val VALID_USER_PASSWORD = "password"
        private const val INVALID_USER_NAME = "unknown"
        private const val INVALID_USER_PASSWORD = "unknown"
    }

}
