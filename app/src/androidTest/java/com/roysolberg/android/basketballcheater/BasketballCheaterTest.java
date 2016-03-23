package com.roysolberg.android.basketballcheater;

import android.content.Context;
import android.graphics.Rect;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.widget.Toast;

import com.roysolberg.android.basketballcheater.activity.MainActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeoutException;

@RunWith(AndroidJUnit4.class)
public class BasketballCheaterTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private final static String TAG = BasketballCheaterTest.class.getSimpleName();

    final int NUMBER_OF_THROWS = 450;
    protected Context applicationContext;

    public BasketballCheaterTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation()); // Injecting the Instrumentation instance is required for your test to run with AndroidJUnitRunner.
        applicationContext = getInstrumentation().getTargetContext();
    }

    @Test
    public void testTypeOperandsAndPerformAddOperation() throws UiObjectNotFoundException, TimeoutException {
        UiDevice uiDevice = UiDevice.getInstance(getInstrumentation());
        UiObject highScoreTextViewUiObject = uiDevice.findObject(new UiSelector().resourceId("com.facebook.orca:id/high_score_text"));
        UiObject currentSessionHighScoreTextViewUiObject = uiDevice.findObject(new UiSelector().resourceId("com.facebook.orca:id/best_score_text"));
        UiObject currentScoreUiObject = uiDevice.findObject(new UiSelector().resourceId("com.facebook.orca:id/score"));
        UiObject ballUiObject = uiDevice.findObject(new UiSelector().resourceId("com.facebook.orca:id/ball"));
        UiObject basketUiObject = uiDevice.findObject(new UiSelector().resourceId("com.facebook.orca:id/rim"));

        if (!highScoreTextViewUiObject.exists() || !currentSessionHighScoreTextViewUiObject.exists() || !currentScoreUiObject.exists() || !ballUiObject.exists() || !basketUiObject.exists()) {
            Log.e(TAG, "Unable to find one or more game objects. Either the game has changed or there is no game running. Will try to proceed with test.");
            toast("Unable to find one or more game objects. Are you running a Messenger basketball game? If so, maybe the game has changed in some way? Script will probably not be able to run properly.", Toast.LENGTH_LONG);
        }

        int basketCenterX = -1;
        int basketCenterY = -1;
        Log.i(TAG, "Will try to throw ball [" + NUMBER_OF_THROWS + "] times.");
        for (int i = 0; i < NUMBER_OF_THROWS; i++) {
            Log.d(TAG, "Throw #" + (i + 1));

            if (basketCenterX == -1) { // Not found basket placement yet
                Rect basketUiObjectBounds = basketUiObject.getBounds();
                basketCenterX = basketUiObjectBounds.centerX();
                basketCenterY = basketUiObjectBounds.centerY();
                Log.i(TAG, "Using x=" + basketCenterX + " and y=" + basketCenterY + " for basket.");
            }
            // TODO: How can we avoid getting all the
            // java.util.concurrent.TimeoutException: No idle state with idle timeout: 500 within global timeout: 10000
            // ? If you solve that you probably have the solution to make this script much better. :)
            ballUiObject.dragTo(basketCenterX, basketCenterY, 5);

            // Alternative ways to do this which gives some good and some not so good results:
//            ballUiObject.dragTo(basketUiObject, 5);
//            Rect ballUiObjectBounds = ballUiObject.getBounds();
//            Rect basketUiObjectBounds = basketUiObject.getBounds();
//            Log.d(TAG, "Ball: " + ballUiObjectBounds.centerX() + "," + ballUiObjectBounds.centerY() + ", basket: " + basketUiObjectBounds.centerX() + "," + basketUiObjectBounds.centerY());
//            ballUiObject.dragTo(basketUiObjectBounds.centerX(), basketUiObjectBounds.centerY(), 20);
//            uiDevice.drag(ballUiObjectBounds.centerX(), ballUiObjectBounds.centerY(), basketUiObjectBounds.centerX(), basketUiObjectBounds.centerY(), 5);
//            uiDevice.swipe(ballUiObjectBounds.centerX(), ballUiObjectBounds.centerY(), basketUiObjectBounds.centerX(), basketUiObjectBounds.centerY(), 4);

            try {
                // TODO: This you probably gotta adjust to make the script run ok on your device:
//                Thread.sleep(400); // Worked well - score of 33
//                Thread.sleep(300); // Not far past 10
//                Thread.sleep(350); // 20ish
                Thread.sleep(370); // 32
//                Thread.sleep(380); // 30-31
//                Thread.sleep(390); // 29
            } catch (InterruptedException e) {
                /* no-op */
            }
        }

    }

    protected void toast(final String text, final int length) {
        getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(applicationContext, text, length).show();
            }
        });
    }

}
