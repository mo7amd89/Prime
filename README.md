
<h1><img src="https://user-images.githubusercontent.com/39574228/152663342-6240ba71-1f28-49a3-be83-4189e60723a3.png"></h1>


At first glance, I actually thought this was a walkover test.

Things started heating up when I started the implementation :)

### FEATURES

- MVVM
- Flow
- Coroutines
- Animation (Using Lottie)
- Room
- Instrumented Unit Test
- Jetpack Navigation Component
- Dependency Injection with Hilt

### FINAL APK

<a href="">Click to download</a>


### ARCHITECTURE

- **MVVM** 

**MODEL** - The list of items (cases/data) which is been populated from room database

**VIEW** - A single activity layout (which houses the content fragment) -  I used jetpack navigation component

**VIEWMODEL** - Named databaseViewModel which interacts with the repository (databaseRepository) to perform room database operations off the main thread using coroutines and kotlin flow

### TEST
Contains Instrumented unit test to ascertain the database access operations functionalities of room


### CHALLENGES

1. The first challenge I faced was implementing the mini navigation drawer with details to specification (as shown on the figma link)
 
This was a bit difficult because **the drawer icons has to be visible when in the collapsed state** (Normal navigation drawer provided doesn't offer that functionality)
 
 - FIX: I ended up using a slidingPane layout which contains both a master fragment and a detail (content view) 
 
2. I had some issues using GridLayout manager to adapt to various screen sizes while displaying the list of items from room database
 
-  FIX: I ended up with a small function to calculate the number of columns which was later used as the span count for the gridlayout. With this, irrespective of the screen size, the items in grid layout automatically fits 


### TODO (Hopefully)

- Create a custom view to use instead of the cardView used for recycler view list items

- Create a more adaptable design for mobile screen layout

### NB

This design was only optimized for tablet variants (as shown in figma link (landscaped view) and stated in docs).

I also went further and tried to implement a mobile variant, but due to time constraint; it is not as efficient YET.


