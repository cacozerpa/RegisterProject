var deleteButton = document.getElementById("Delete")

function delte(event){
	
	event.preventDefault();
	
	var formData = new FormData(document.getElementById("deleteForm"))
	
	fetch("http://localhost:8080/RegisterProject/delete", {
		
		method: 'POST',
		body: formData
		}).then(response => {
			if(response.status == 200){
				window.location.href = "http://localhost:8080/RegisterProject/index.html"
			}else{
				window.alert("Delete Fallido!");
			}
			console.log(response);
			return response.text();
		});
}

deleteButton.onclick = delte;

var backButton = document.getElementById("Back");

function back(event){
	event.preventDefault();
	
	window.location.href = "http://localhost:8080/RegisterProject/public/views/user.html"
}

backButton.onclick = back;