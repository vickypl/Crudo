$(document).ready(function() {
    $('#mytable').DataTable();
});

function usernameAvailable() {
	var uname = document.getElementById("unm").value;
	xmlhttp = new XMLHttpRequest();
	xmlhttp.onreadystatechange = function () {
		document.getElementById("availablity").innerHTML = xmlhttp.responseText;
	}
	xmlhttp.open("get", "usernameid?uname="+uname, true);
	xmlhttp.send();
}

function onSignIn(googleUser) {
    // window.location.href='success.jsp';
    var profile = googleUser.getBasicProfile();
    var imagurl=profile.getImageUrl();
    var name=profile.getName();
    var email=profile.getEmail();
    document.getElementById("myImg").src = imagurl;
    document.getElementById("name").innerHTML = name;
    document.getElementById("myP").style.visibility = "hidden";
    document.getElementById("status").innerHTML = 'Welcome '+name+'!<a href=googleauth?email='+email+'&name='+name+'/>Continue with Google login</a></p>'
 }

function sendOtp() {
	var email = document.getElementById("otpemail").value;
	//var otpbox = document.getElementById("otpbox");
	xmlObj = new XMLHttpRequest();
	xmlObj.onreadystatechange= function () {
		console.log("otpsent");
		//otpbox.innerHTML=xmlObj.responseText;
	}
	xmlObj.open("get", "sendotp?email="+email, true);
	xmlObj.send();
}

function deleteMyAccount() {
	var provalue = prompt("Enter password to delete account permanently.");
	var msgat = document.getElementById("maindiv");
	var xmlobj = new XMLHttpRequest();
	xmlobj.onreadystatechange = function () {
		msgat.innerHTML = xmlobj.responseText;
	}
	xmlobj.open("get", "deleteaccount?pwd="+provalue, true);
	xmlobj.send();
}

function getUserTodoToUpdate(id) {
	var showat = document.getElementById("updatetodoformbox");
	var xmlobj = new XMLHttpRequest();
	xmlobj.onreadystatechange = function () {
		showat.innerHTML=xmlobj.responseText;
	}
	xmlobj.open("get", "updatetodo?id="+id, true);
	xmlobj.send();
}

function getAdminUpdateInfo() {
	var showhere = document.getElementById("updateadmininfomodal");
	xmlHttp = new XMLHttpRequest();
	xmlHttp.onreadystatechange = function () {
		showhere.innerHTML=xmlHttp.responseText;
	}
	xmlHttp.open("get", "admininfoupdate", true);
	xmlHttp.send();
}

var i = 0;
var txt = 'Why kill time when you can make it work for you? - Anonymous';
var speed = 50;

function typeEffect() {
  if (i < txt.length) {
    document.getElementById("animtext").innerHTML += txt.charAt(i);
    i++;
    setTimeout(typeEffect, speed);
  }
}