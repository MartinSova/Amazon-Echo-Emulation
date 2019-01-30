Team P

Instructions:



	* To compile, go into Echo/EchoMain and run:

		javac *.java


	* After compiling, change directory to Echo/ and run:

		java EchoMain.EchoMain






Additional Features


* Mute Button
* Lighting animations for transition between answering and listening mode
* Button animations
* Voice Command keywords (“turn off”, “mute”)
* Sound effects



Bugs


* Button (mute/unmute, on/off) lighting changes when mouse is hovering over button, we have no idea why this is occurring because we have no mouseOver() event listeners
* Pressing the on/off button in quick succession causes multiple listening threads to spawn



Future Tests


* GUI Robot testing for mute and power button (java.awt.Robot)



Future Features


* Add keyword to delimit the input string (similar to ‘Alexa, …”)
* Add functionality to mute button
* Voice command for unmute (polling in mute state required)
* Window resizing (in order to achieve this we need to restructure our GUI to utilize JPanels so they can be dynamically resized after we set isResizable(true) for the JFrame with a layout manager [GridBagLayout])
* Smoother transition animations 
* Listening to Answering mode transition sound effects
