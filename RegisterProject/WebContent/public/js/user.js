
var deleteButton = document.getElementById("Delete");

function deleteShow(event){
	
	event.preventDefault();
	window.location.href = "http://localhost:8080/RegisterProject/public/views/delete.html"	
}

deleteButton.onclick = deleteShow;

