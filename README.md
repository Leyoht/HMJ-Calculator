# ==== PROJECT DESCRIPTION ====
# Based on an old C# project called the “Get Lit Calculator,” the HMJ Calculator (“How Many Jrinks” calculator) is a tool developed for the purpose of telling someone how many alcoholic beverages they can have before they reach a specified level of drunkenness. As the base code for this project has its roots in a project from CNIT 255 that one of our programmers had taken a part in, we are confident we can create a system with the amount of classes, interfaces (internal and external), and connections required for it to be a viable Java application that meets the project specifications.
# The first step in making this program function is to allow the user to enter information about themselves into the calculator and store that information in a file. This file--called userinfo.txt--will be placed in the program’s home directory and contain information such as the user’s date of birth, age, preferred drink, and--perhaps most importantly--their prior history with the application. While the user will not be required to store their data on file, the ability to do so allows them to come back into the HMJ Calculator and easily read through their history, if they required information regarding something they had been asked about in the past. Of course, if desired, the user will be able to delete their app history without deleting the original .txt file.
# As of now, there are eleven classes (with children and interfaces) for the HMJ Calculator:
# >Bar
# >>barLocation
# >Drink
# >>Beer
# >>Wine
# >>hardLiq
# >>mixDrink
# >>favDrink
# >iDrinks
# >fiveSomewhere
# >iPreferences
# >Person
# The application will work through a TCP connection and will connect to two external interfaces: Google Maps and TweetSharp. Google Maps will be used to find the bars nearest to the user and will provide a preview of where each bar is. TweetSharp will inform the user where in the world it is currently five o’clock in the evening (its five o’clock somewhere). A list of twenty locations can be brought up at any point and the list is updated with every hour. Please note that despite having a vast array of locations to choose from with the Google Maps API, we are currently recommending that only Lafayette and West Lafayette bars be chosen until we can implement a restaurant menu API to tie into our program’s classes and the respective locations that will be pulled up in Google Maps. It’s possible in the future we may use the OpenMenu API to list bar menus on our application, but such a feature would have to be implemented in the future.
# Assuming the OpenMenu API is NOT implemented into the app, we will instantiate menus and drink lists for all bars within the Greater Lafayette area. While instantiating these objects, we hope to use a SQL or something similar to handle the attributes.
# The HMJ Calculator is being developed by six CNIT 325 students through GitHub and will function as any object-oriented application should. All group members will be working to make the code as functional and usable as possible - working toward the goal of releasing a semi-complete product by this December.

# ==== OBJECTIVES ====
# >Let user input data about themselves
# >>Let the user save this information a file if needed/wanted
# >>The information they can save would consist of their weight, age, preferred drink, and history with the application
# >>The user should be allowed to wipe their history, if desired (without manually deleting the .txt file)
# >Connect to Google Maps to give the user an idea where the nearest bars are
# >>The bars that will work best are ones near West Lafayette
# >>If we can find an API that shows us the menus of all (or most) bars that show up in Google Maps, we can expand the amount of bars we can show drinks from
# >Connect to Twitter so the user knows where in the world it is 5pm
# >Restrict access to those under the age of 21
# >>Have the user enter their date of birth, rather than a number for their age
# >>Of course, the user could change their age if needed (or wanted)
# >Connect through TCP sockets
# >Get menus for the applicable bars and instantiate them into the program
# >We should let the user see a list of their prior actions with the app

# ==== EXTERNAL INTERFACES ====
# >Google Maps API (for finding nearby bars dynamically)
# >TweetSharp (for finding out when it is 5pm and where)
# >Possibility TBD for OpenMenu API (determine drink menu for restaurants/bars)

# ==== Technology Required ====
# >We will be using TCP