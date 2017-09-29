package br.com.lfaiska.espressotest;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by User on 24/09/2017.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void test_text_valid() {
        String textValue = "hauisuhiamsh";
        onView(withId(R.id.inputField)).perform(typeText(textValue), closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());

        onView(withId(R.id.resultView)).check(matches(withText(textValue)));
    }

    @Test
    public void test_text_empty() {
        String textValue = "";
        onView(withId(R.id.inputField)).perform(typeText(textValue), closeSoftKeyboard());
        onView(withId(R.id.switchActivity)).perform(click());

        // Descomentar isso pra mostrar pro pessoal um caso de teste que falhou
        //onView(withId(R.id.resultView)).check(matches(withText(textValue)));

        onView(withId(R.id.inputField)).check(matches(ErrorTextMatches.withErrorText(Matchers.containsString("Por favor digite um texto válido."))));
    }
}
