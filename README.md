## TODO List Application

A simple demo project to display the TODO List based on MVVM clean architecture.

### App Features

* Users can view TODO list.
* This list contains completed and in complete todo items.

### App Packages

* common - Contains common class files.

    * di        - Depenency Injection Classes using Dagger2.
    * model     - Data classes.
    * recycler  - Base and common recyclerview related class files.
    * TodoDatabase - Room Database class
    
* list - Contains classes to used to list the todo items.

    * di - Depenency Injection Classes using Dagger2.
    * endpoint - Service endpoint
    * repository - Viewmodel's repository class to make remote service / db calls.
    * ui - Activities and Holders of list screen.
    * viewmodel - List screens ViewModel and ViewModelFactory classes.
    
### App Themes
This application is provided with two themes 
1. LightMaterialTheme 
2. DarkMaterialTheme

Apply the theme inside application tag of AndroidManisfect.xml like below 
```
<application
        android:name=".TodoApplication"
        android:icon="@drawable/ic_todo_launcher"
        android:label="@string/app_name"
        android:roundIcon="@drawable/ic_todo_launcher"
        android:supportsRtl="true"
        android:theme="@style/DarkMaterialTheme">
```

Below are the screeshots of the application
#### LightMaterialTheme

<img src="https://github.com/harisudhan7889/ToDo/blob/master/media/LightMaterialTheme.jpg" width="920" style="max-width:920%;">

#### DarkMaterialTheme

<img src="https://github.com/harisudhan7889/ToDo/blob/master/media/DarkMaterialTheme.jpg" width="920" style="max-width:920%;">
 
### App spec

* Kotlin
* Java 
* MVVM Architecture
* Android Architecture Components (LiveData, Lifecycle, ViewModel, Room Persistence Library, ConstraintLayout)
* RxJava2 for implementing Observable pattern.
* Dagger 2 for dependency injection.
* Retrofit 2 for API integration.
* Gson for serialisation.
* Timber for planting logs.
