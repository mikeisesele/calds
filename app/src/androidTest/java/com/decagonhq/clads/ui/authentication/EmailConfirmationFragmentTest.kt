package com.decagonhq.clads.ui.authentication

import android.os.Bundle
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.decagonhq.clads.R
import com.decagonhq.clads.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class EmailConfirmationFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        hiltRule.inject()
        launchFragmentInHiltContainer<EmailConfirmationFragment>(fragmentArgs = Bundle()) {}
    }

    @Test
    fun test_email_confirmation_button_view_in_view() {
        Espresso.onView(ViewMatchers.withId(R.id.email_confirmation_fragment_verify_email_address_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}
