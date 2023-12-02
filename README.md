
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
  http://localhost:4200/newpost/:id
```

## UI Screenshots

### Sign-In Page
![otp](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/12fda008-a093-4fc6-879c-4242184fe715)
### Sign Up Page
![sign_up](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/84ab47c8-6976-4f73-9d7e-62170487c4f9)
### Feed Page
![feed_page](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/2aec2c1f-1090-4bda-9b0d-dba89b3a676d)
### Feed Page2
![feed_page2](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/23d05b14-754c-430e-93bb-f944f70b24b3)
### Feed Page3
![feed_page3](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/017179d5-0c3c-43dc-8f49-5a75e99d4416)
### Forum Creation Page
![new_forum](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/ad901077-4a67-4e09-b74e-a5c2955993e5)
### Profile Page showcasing the Created Forums
![myforums](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/bab9df35-2ba0-47b9-aab4-4696e0a18ab0)
### Post Creation Page
![newpost](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/4141d544-97d2-48fd-8023-ae2d0275a733)
### Posting a Comment
![comment](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/6ec4a5b6-63a9-4262-a2ff-32bcdad248a9)
### Delete Post
![delete_post](https://github.com/sasirekhasooraj/FandomHub/assets/27855331/d56eff09-8ca3-42c6-bcc3-d68dcf2c6d97)
## Demo Link
This is the vedio that demonstrates the working of our web-app : https://drive.google.com/file/d/1n2F_zTBdS232dOBDYxDDRHQfh-gBFaDk/view?usp=drivesdk














