### Basketball cheater for Messenger 🏀
**tl;dr:** This is a script that you can run with *gradle* or *Android Studio* to improve your score in Facebook
Messenger's basketball game. **If you aren't a developer you probably don't want to check this out any further.** If you are a
developer you can just do a clone and try it yourself.

#### Proof of concept video
[![YouTube proof of concept video](http://img.youtube.com/vi/UyDFA-th3r0/0.jpg)](http://www.youtube.com/watch?v=UyDFA-th3r0)

#### To run the script
Clone the project and open it in Android Studio. On your device you have to start Messenger, go to a chat and start
a basketball game. The just run the test case called *[BasketballCheaterTest](app/src/androidTest/java/com/roysolberg/android/basketballcheater/BasketballCheaterTest.java)* and leave the device for a while. :)

Most probably you have to adjust the sleep time in the test method to make it work great. Give it a go a couple of times and see how it performs before adjusting. I've added a few *TODO*s and comments that might be interesting for you to read.

#### Development approach
It didn't take much time to make this script. All I had to do was to run the excellent *uiautomatorviewer* to get the IDs
of the views in Messenger. Then it was just a matter of writing a few commands that simulates a finger dragging from
the ball towards the hoop.

![UI Automater Viewer](https://github.com/roys/java-android-basketballcheater/raw/master/misc/uianimatorview.png "UI Automater Viewer")

#### FAQ
**Q:** What's the high score with this script?  
**A:** I've only tried it for a few runs, but I got a decent **58**. I'm sure the sky's the limit with some tweaking of the script.

**Q:** Why on Earth would you create this script?  
**A:**  
<img src="https://github.com/roys/java-android-basketballcheater/raw/master/misc/i_was_going_to_sleep_then_i_got_basketball.jpg" title="I WAS GOING TO SLEEP BUT THEN I GOT 🏀 MEME" width="281" height="500" />
