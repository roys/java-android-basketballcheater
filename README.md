### Basketball cheater for Messenger
**tl;dr:** This is a script that you can run with *gradle* or *Android Studio* to improve your score in Facebook
Messenger's basketball game. If you aren't a developer you probably don't want to check out this further. If you are a
developer you can just checkout and try it yourself.

#### Proof of concept video
[![YouTube proof of concept video](http://img.youtube.com/vi/UyDFA-th3r0/0.jpg)](http://www.youtube.com/watch?v=UyDFA-th3r0)

#### To run the script
Clone the project and open it in Android Studio. On your device you have to start Messenger, go to a chat and start
a basketball game. The just run the test case called BasketballCheaterTest and leave the device for a while. :)

#### Development approach
It didn't take much time to make this script. All I had to do was to run the excellent *uiautomatorviewer* to get the IDs
of the views in Messenger. Then it was just a matter of writing a few commands that simulates a finger dragging from
the ball towards the basket.

![UI Automater Viewer](https://github.com/roys/java-android-basketballcheater/raw/master/misc/uianimatorview.png "UI Automater Viewer")

#### FAQ
**Q:** What's the high score with this script?
**A:** I've only tried it for a few runs, but I got a decent **58**. I'm sure the sky's the limit with some tweaking of the script.
