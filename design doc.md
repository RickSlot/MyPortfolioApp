MyPortfolioApp Design doc
==============

###Account:

```Java

String firstName;

String lastName;

String username;

String password;

List<String> projectIds = new ArrayList<>();

String biographyId

String cvId
```



###Biography

```Java
String ownerUsername;

String id;

String text;

Byte pictureBytes[];
```



###Project:
```Java

String id;

String ownerUsername;

String company;

List<String> collaboratorUsernames = new ArrayList<>();

String description;

List<Byte[]> imagesBytes = new ArrayList<>();
```


###Cv:
```Java
String id;
```






###AccountController:
```Java
createAccount();

updateAccount();

deleteAccount();// if no other collaborators remove projects
```


###ProjectController:
```Java
createProject();

updateProject();

deleteProject();
```


###BiographyController:
```Java
createBiography();

updateBiography();

deleteBiography();
```




###CvController:
```Java
createCv();

updateCv();

deleteCv();
```
