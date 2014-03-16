MyPortfolioApp Design doc
==============

##Style conventions:
For java I will use the camelCase style convention. For the models I will use getters and setters. I will try to use loose coupling at all time so things can be seperated from each other. This will be achieved by using dependency injection (which spring integrates very nicely :) ).The project will use a MVC structure wat a mongodb instance as database. I will use Spring-mvc, spring security and spring data to achieve this. The design will be done with bootstrap. I will use javascript to make async ajax calls so things are loaded without refreshing.

##Mongo
I use mongodb because it's a quick way to store and retrieve things because of its document driven structure. an account wil have a username that is unique. In this way the projects, cv and biography will be linked by using a foreign "key".

##Design
The designs can be found in this folder. they are named design 1, 2 and 3!

##java

####Account:
These are the entities that an account has. these will also be saved like this in a collection called "account".
```Java

String firstName;

String lastName;

String username;

String password;

String biographyId

String cvId
```



####Biography
These are the entities that a biography has. these will be saved in a collection called "biography"
```Java
String ownerUsername;

String id;

String text;

Byte pictureBytes[];
```



####Project:
These are the entities that a project has. these will be saved in a collection called project
```Java

String id;

String ownerUsername;

String company;

List<String> collaboratorUsernames = new ArrayList<>();

String description;

List<Byte[]> imagesBytes = new ArrayList<>();
```


####Cv:
these are the entities a CV has. these will be saved in a collection called cv
```Java
String id;
List<String> languages = new ArrayList<>();
List<String> jobs = new ArrayList<>();
```






####AccountController:
This controller maps all request that has something to do with accounts
```Java
showCreateAccountpage();

showAccountHomepage(String username);

showUpdateAccountpage(String username);

createAccount(Account account);

updateAccount(Account account);

deleteAccount(Account account);// if no other collaborators remove projects
```


####ProjectController:
This controller maps all request that has something to do with projects
```Java
showProject(String id);

showNewProjectPage();

showProjectsForUser(String username);

createProject(Project project);

updateProject(Project project);

deleteProject(Project project);
```


####BiographyController:
This controller maps all request that has something to do with biographies
```Java
showUpdateBiographyPage();

showBiographyOfUser(String username);

createBiography(Biography biography);

updateBiography(Biograpy biography);

deleteBiography(Biograpy biography);
```




####CvController:
This controller maps all request that has something to do with cv's
```Java
showUpdateCvPage();

showCv(String username);

createCv(Cv cv);

updateCv(Cv cv);

deleteCv(Cv cv);
```

####indexController:
This controller maps all request that don't belong to the above.
```Java
home();

login();

```
