FetchData Android Application
Overview
This is an Android application that fetches data from a URL (in JSON format) and displays it in a structured manner, grouped by listId and sorted by name. This app provides a simple interface to display the data in a list format with some filtering applied to remove null or empty names.

Prerequisites
Android Studio: You need Android Studio to build and run the project. You can download it from here.

Java Development Kit (JDK): Make sure you have JDK 8 or higher installed. You can check this by running java -version in your terminal.

Android Emulator or Real Device: Set up an Android emulator or connect a real Android device to test the app.

Git: Ensure that Git is installed on your system. You can check this by running git --version.

How to Set Up the Project
Step 1: Clone the Repository
To get started, clone the repository to your local machine:

bash
Copy
git clone https://github.com/kishanrayanal/FetchData.git
This will create a local copy of the project on your machine.

Step 2: Open the Project in Android Studio
Open Android Studio.
Click on Open an existing project.
Navigate to the directory where you cloned the project and select the project folder.
Android Studio will load the project and may prompt you to sync the project with Gradle. Click Sync Now if prompted.

Step 3: Set Up Permissions (for Internet access)
Open the AndroidManifest.xml file.
Ensure the following permission is added to request access to the internet:
xml
Copy
<uses-permission android:name="android.permission.INTERNET"/>
This allows the app to access external data over the network.

Step 4: Run the App
Connect your Android device or launch an emulator.
In Android Studio, click on the Run button (green play icon) to build and run the app.
Features of the App
Data Fetching: The app fetches JSON data from a URL and displays it in a list.
Sorting: The data is sorted first by listId, then by name in ascending order.
Filtering: The app filters out entries where name is blank or null.
Display Format: The list is grouped by listId, and only the items with valid names are displayed.
File Structure
MainActivity.java: The main activity where the JSON data is fetched, sorted, and displayed.
activity_main.xml: The layout file for the main activity that displays the data in a RecyclerView.
network/ApiService.java: A class responsible for making network requests to fetch the JSON data.
models/Item.java: A model class representing the data structure for each item.
Dependencies
This project uses the following dependencies:

OkHttp: For making network requests.
Version: 4.9.0

Gson: For parsing JSON data.
Version: 2.8.8

These dependencies are managed by Gradle and should be automatically resolved when you open the project in Android Studio.

