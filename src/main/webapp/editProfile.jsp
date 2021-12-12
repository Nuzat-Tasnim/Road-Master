<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://fonts.googleapis.com/css?family=Material+Icons|Material+Icons+Outlined|Material+Icons+Two+Tone|Material+Icons+Round|Material+Icons+Sharp" rel="stylesheet">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.myLink {display: none}
.w3-display-middle {
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
  .header {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    padding: 5px;
    background-color: gray;
    color: white;
    border-radius: 2px;
    margin-bottom: 20px;
}

.header .user-name {
    display: flex;
    flex-direction: row;
    justify-content: start;
    align-items: center;
}

.header .user-name .icon {
    margin: 0px 5px;
}

.header .user-name .name {
    font-size: 16px;
}

.header .home-link {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-color: #ff4a4a;
    color: white;
    text-decoration: none;
    padding: 5px;
    border-radius: 2px;
}

.header .home-link .icon {
    margin: 0px 5px;
}

.header .home-link .text {
    font-size: 14px;
    margin-right: 5px;
}

</style>
<body class="w3-light-grey">


<!-- Header -->
<header class="w3-display-container w3-content w3-hide-small" style="max-width:1500px">
  <img class="w3-image" src="index.jpg" width="1280" height="828">
  <div class="w3-display-middle" style="width:65%">
    <div class="header">
            <div class="user-name">
                <span class="material-icons-outlined icon">account_circle</span>
                <span class="name"><c:out value="${model.user.userName}" /></span>
            </div>
            <a class="home-link" href='<c:url value="/home" ></c:url>'>
                <span class="material-icons-outlined icon">home</span>
                <span class="text">Home</span>
            </a>
        </div>
  
    <div class="w3-bar w3-black">
      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'editProfile');">Edit Profile</button>
      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'login');"></button>
    </div>
    

    <!-- Tabs -->
    <div id="login" class="w3-container w3-white w3-padding-16 myLink">
      <h3>Login</h3>
      <div class="w3-row-padding" style="margin:0 -16px; padding: 18px">
        <form action="login" method = "post">
            <div class="w3-half" >
              <label>Email</label>
              <input class="w3-input w3-border" type="email" name="mail" placeholder="Email">
            </div>
            <br><br><br><br>
            
          <p><button class="w3-button w3-dark-grey" type="submit">Login</button></p>
        </form>
    </div>
  </div>

    



    <div id="editProfile" class="w3-container w3-white w3-padding-16 myLink">
      <div class="w3-row-padding" style="margin:0 -16px; padding: 18px">
        <form action="editProfile" method = "post">
          <div class="w3-half" >
            <label>Your Name</label>
            <input class="w3-input w3-border" type="text" name="name" value="${model.user.userName}">
          </div>
          <br><br><br><br>
          <div class="w3-half" >
            <label>Email</label>
            <input class="w3-input w3-border" type="email" name="email" value="${model.user.email}">
          </div>
          <br><br><br><br>
          <div class="w3-half">
            <label>Password</label>
            <input class="w3-input w3-border" type="password" name="password" value="${model.user.password}">
          </div>
          <br><br><br>
          <p><button class="w3-button w3-dark-grey" type="submit">Save</button></p>
      </form>
    </div>
  </div>

</div>
    
</header>




<style type="text/css">
  
</style>


<script>
// Tabs
function openLink(evt, linkName) {
  var i, x, tablinks;
  x = document.getElementsByClassName("myLink");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablink");
  for (i = 0; i < x.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" w3-red", "");
  }
  document.getElementById(linkName).style.display = "block";
  evt.currentTarget.className += " w3-red";
}

// Click on the first tablink on load
document.getElementsByClassName("tablink")[0].click();
</script>

</body>
</html>
