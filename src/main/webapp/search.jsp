<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", Arial, Helvetica, sans-serif}
.myLink {display: none}
.w3-display-middle {
    position: absolute;
    top: 30%;
    left: 50%;
    transform: translate(-50%,-50%);
  }
</style>
<body class="w3-light-grey">


<!-- Header -->
<header class="w3-display-container w3-content w3-hide-small" style="max-width:1500px">
  <img class="w3-image" src="index.jpg" width="1280" height="828">
  <div class="w3-display-middle" style="width:65%">
  
    <div class="w3-bar w3-black">
      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'place');">Search Place</button>
      <button class="w3-bar-item w3-button tablink" onclick="openLink(event, 'journey');">Search Journey</button>
    </div>
    

    <!-- Tabs -->
    <div id="place" class="w3-container w3-white w3-padding-16 myLink">
      <h3>Search For A Place</h3>
      <div class="w3-row-padding" style="margin:0 -16px; padding: 18px">
        <form action="searchPlaceList" method="post">
	        <div class="w3-half" >
	        
	          <label>Enter Place</label>
	          <input class="w3-input w3-border" type="text" name="place">
	        </div>
	        <br> <br><br>
	    	<p><button class="w3-button w3-dark-grey" type="submit">Search Place</button></p>
  		</form>
    </div>
	</div>

    



    <div id="journey" class="w3-container w3-white w3-padding-16 myLink">
      <h3>Search For A Journey</h3>
      <div class="w3-row-padding" style="margin:0 -16px; padding: 18px">
        <form action="searchJourneyList" method = "post">
          <div class="w3-half" >
          <label>Starting Place</label>
          <input class="w3-input w3-border" type="text" name="source">
        </div>
        <br><br><br><br>
        <div class="w3-half" >
          <label>Destination</label>
          <input class="w3-input w3-border" type="text" name="destination">
        </div>
        <br><br><br>
      	<p><button class="w3-button w3-dark-grey" type="submit">Search Journey</button></p>
		</form>
    </div>
	</div>
</div>
    

</header>



    
  
<!-- End page content -->



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
