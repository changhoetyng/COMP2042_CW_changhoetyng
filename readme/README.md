##Frogger 

The Frogger project is maintained and it is divided into 3 parts:
- **Basic Maintenance**
- **Features**
- **Bug fixes**

###Maintenance

####Basic Maintenance

- **Refactoring**
    - Encapsulate fields:
    The original code is not encapsulated and it is a violation of key object-oriented principles.

    Turtle.java (Before the refactoring)
    ```java
    Image turtle1;
    ```

    Setter and Getter has been added to encapsulate the class.
    <br />
    
    Turtle.java (After the refactoring)
    ```java
    private Image turtle1;

    public Image getTurtle1() {
		return turtle1;
	}
	
	public void setTurtle1(Image turtle1) {
		this.turtle1 = turtle1;
	}
    ```

    - Extracting method from a large block of code
    <br />
- **JavaDocs**
    Javadoc is added to ease the understanding on the code which makes it easier for developer to understand the code.
    <br />
- **MVC(Model View Controller)**
    MVC is created by spliting main classes into three parts: Model, View and Controller 

    Benefits:
    - Ease of modification.
    - Low coupling.
    <br />
- **Rearrange Packages**
    Before rearranging the packages, all the classes are located in the same directory which makes it harder to maintain.
    \
    **Before rearranging:**
    ![rearrangePackagesBefore](rearrangePackagesBefore.jpg)

    The classes are all separated into different packages based on their categories.
    \
    **After rearranging:**
    ![rearrangePackagesAfter](rearrangePackagesAfter.jpg)

    <br />
####Features

- High Score Features
A text file has been added in media.text to record the previous top 5 score by the player.
<br />
- New screens
    - High Score
    A list of top 5 previous high scores after the game.
    <br /> 
    - Info
    An info page that displays instructions for the users.
    <br />
    - Main Menu
    Main menu page that display a Start and Info button.
    <br />
    - Difficulty
    Difficulty page that let players choose the difficulty of the game.
    <br />
- New Game Mode
The original game mode will end after 5 frogs have reached their home which is not how the original game works. Instead, **timer**  have been added in the game to make it look like the original game. The player now can have unlimited tries until the timer stops at 0.

- Levels 
Player are able to choose between easy, medium and hard in the difficulty page before starting the game.

####Bug fixes

- Score
**Before:**
The score will not deduct when it is lower than 50. The original author added an if condition to prevent error.
<br />
**After:**
The bug has been fixed and the marks will be equal to 0 if the marks is lower than 50.
<br />
- Platform
**Before:**
The frog can jump into the platform even though the platform is occupied by another frog.
<br />
**After:**
The frog is no longer allowed into the platform if it's occupied by another frog.
<br />
- Background Image and Digit
**Before:**
![backgroundBeforet](backgroundBefore.jpg)
<br />
**After:**
![backgroundAfter](backgroundAfter.jpg)
<br />
The background image has been edited through GIMP and added into the game.
<br />
The black background for digit has also been removed.
<br />
**Before:**
![beforeDigit](beforeDigit.jpg)
**After:**
![afterDigit](afterDigit.jpg)

####JUnit Test

JUnit 4 has been added into the project and 5 tests have been added to show my understanding on JUnit.

![testing](testing.jpg)

####Version Control

Github is used as the remote repository of this project.

Dev branch was created at the start of the project and it is merged into the master branch after testing to assure it has no issue after the merging.

**Screenshots of the commit history:**
![git1](git1.jpg)
![git2](git2.jpg)
![git3](git3.jpg)

**Build using ant**

The app can be run and compile using Ant.
![git1](build.jpg)

481 words