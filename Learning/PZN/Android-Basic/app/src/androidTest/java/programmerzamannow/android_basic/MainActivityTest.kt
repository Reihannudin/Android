package programmerzamannow.android_basic

import android.content.Context
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

//how to make instrument test : activity scenario with JUnit4
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

////     make activity scenario : Manually
//    lateinit var mainActivityScenario: ActivityScenario<MainActivity>
//
////    make before test
//    @Before
//    fun setUp() {
//        mainActivityScenario = ActivityScenario.launch(MainActivity::class.java)
//    }
//
////    make after test
//    @After
//    fun tearDown() {
//        mainActivityScenario.close()
//    }

    ////     make activity scenario : Rule
    @get:Rule
    var mainActivityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    //    make test blank
    @Test
    fun testSayHello(){
//        define context of activity
        val context = ApplicationProvider.getApplicationContext<Context>()
//        define name
        val name = "Reihannudin"
//        make bot name edit text
        onView(withId(R.id.nameEditText))
            .perform(typeText(name))
//        make bot button
        onView(withId(R.id.sayHelloButton))
            .perform(click())
//        make bot text view
        onView(withId(R.id.sayHelloTextView))
            .check(matches(withText(context.getString(R.string.sayHelloTextView, name))))
        Thread.sleep( 3000) // wait for 3 second
    }




}