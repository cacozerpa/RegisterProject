var backButton = document.getElementById("Back");

function back(event){
	event.preventDefault();
	
	window.location.href = "http://localhost:8080/RegisterProject/public/views/user.html"
}

backButton.onclick = back;

