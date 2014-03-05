MyPortfolioApp Design doc
==============

###Account:

```java

String firstName;

String lastName;

String username;

String password;

List<String> projectIds = new ArrayList<>();

String biographyId

String cvId
```



###Biography

String ownerUsername;

String id;

String text;

Byte pictureBytes[];



###Project:

String id;

String ownerUsername;

String company;

List<String> collaboratorUsernames = new ArrayList<>();

String description;

List<Byte[]> imagesBytes = new ArrayList<>();



###Cv:

String id;







###AccountController:

createAccount();

updateAccount();

deleteAccount();// if no other collaborators remove projects



###ProjectController:

createProject();

updateProject();

deleteProject();



###BiographyController:

createBiography();

updateBiography();

deleteBiography();





###CvController:

createCv();

updateCv();

deleteCv();

