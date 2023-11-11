
# Fandom Hub

FandomHub is a fan site that fosters passionate discussions among individuals sharing similar interests.
It provides a platform to create forums, contribute content, and engage with communities built around beloved topics



## Features

- Validation and Authentication of users by implementing sessions (login/signup pages)
- CRU* users (sign up & settings page - no deleting required)
- CRUD Posts and Forums
- CR*D Comments on posts (no updating required)
- GET and display lists of posts sorted based on upvotes
- Isolation patterns such as Tenant Identification patterns,service calls isolation patterns,data isolation patterns,Tenant wise isolation are implemented.



## Tech Stack

**FrontEnd:** Angular

**Backend:** Springboot

**Database:** MongoDB


## Installation

Install my-project with npm

```bash
  npm Install @angular/cli 
```
    
## Run Locally


### 1.Clone the project
```bash
  git clone https://github.com/Parthiban-7/FandomHub.git
```
### 2.Front End:

Go to the project directory

```bash
  cd FandomHub
```

Install dependencies

```bash
  npm install
```

Start the server

```bash
  ng serve
```
### 3.Back End:
- Open the project in IDE like Eclipse or Intellij IDEA along with JDK 18 installed to run the springboot application
- Configure mongoDB details according to yours by changing it in application.properties
- Run the "MongoangularApplication" to start the tomcat server to be running on http://localhost:8080 




## API Reference

#### Home page

```
 http://localhost:4200
```


#### Login page to log onto your account

```
  http://localhost:4200/login
```

#### Feed page to view the subscribed forum posts
```
  http://localhost:4200/feed 
```
#### Profile page to view the user's details 
```
  http://localhost:4200/profile
```
### To create a new forum 
```
http://localhost:4200/newform 
```

#### To view the specific forum and their respective posts
```
  http://localhost:4200/myforum/:id
```
### To create a post under a specific forum 
```
  :http://localhost:4200/newpost/:id
```

## UI Screenshots


## Screenshots


## Screenshots

### Sign-In Page
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/Sign%20in%20page.jpg)
### Sign Up Page
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/sign%20up.jpg)
### Feed Page
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/Feedpage.jpg)
### Forum Creation Page
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/forum_creation.jpg)
### Profile Page showcasing the Created Forums
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/profile_page_after_forum_creation.jpg)
### Post Creation Page
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/post_creation.jpg)
### Feed Page showcasing new post creation
![App Screenshot](https://github.com/sasirekhasooraj/FandomHub/blob/main/feedpage_after_post_creation.jpg)












