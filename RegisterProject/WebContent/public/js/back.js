var backButton = document.getElementById("Back");

function back(event){
	event.preventDefault();
	
	window.location.href = "https://registerprojectcarloszerpa.herokuapp.com/public/views/user.html"
}

backButton.onclick = back;

