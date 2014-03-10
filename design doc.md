MyPortfolioApp Design doc
==============

###Account:
These are the entities that an account has. these will also be saved like this in a collection called "account".
```Java

String firstName;

String lastName;

String username;

String password;

String biographyId

String cvId
```



###Biography
These are the entities that a biography has. these will be saved in a collection called "biography"
```Java
String ownerUsername;

String id;

String text;

Byte pictureBytes[];
```



###Project:
These are the entities that a project has. these will be saved in a collection called project
```Java

String id;

String ownerUsername;

String company;

List<String> collaboratorUsernames = new ArrayList<>();

String description;

List<Byte[]> imagesBytes = new ArrayList<>();
```


these are the entities a CV has. these will be saved in a collection called cv
###Cv:
```Java
String id;
List<String> languages = new ArrayList<>();
List<String> jobs = new ArrayList<>();
```






###AccountController:
This controller maps all request that has something to do with accounts
```Java
showCreateAccountpage();

showAccountHomepage(String username);

showUpdateAccountpage(String username);

createAccount(Account account);

updateAccount(Account account);

deleteAccount(Account account);// if no other collaborators remove projects
```


###ProjectController:
This controller maps all request that has something to do with projects
```Java
showProject(String id);

showNewProjectPage();

showProjectsForUser(String username);

createProject(Project project);

updateProject(Project project);

deleteProject(Project project);
```


###BiographyController:
This controller maps all request that has something to do with biographies
```Java
showUpdateBiographyPage();

showBiographyOfUser(String username);

createBiography(Biography biography);

updateBiography(Biograpy biography);

deleteBiography(Biograpy biography);
```




###CvController:
This controller maps all request that has something to do with cv's
```Java
showUpdateCvPage();

showCv(String username);

createCv(Cv cv);

updateCv(Cv cv);

deleteCv(Cv cv);
```

###indexController:
This controller maps all request that don't belong to the above.
```Java
home();

login();

```
