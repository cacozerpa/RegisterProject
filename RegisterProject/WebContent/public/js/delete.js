
var deleteButton = document.getElementById("Delete")

function delte(event){
	
	event.preventDefault();
	
	var formData = new FormData(document.getElementById("deleteForm"))
	
	fetch("https://registerprojectcarloszerpa.herokuapp.com/delete", {
		
		method: 'POST',
		body: formData
		}).then(response => {
			if(response.status == 200){
				window.location.href = "https://registerprojectcarloszerpa.herokuapp.com/index.html"
			}else{
				window.alert("Delete Fallido!");
			}
			console.log(response);
			return response.text();
		});
}

deleteButton.onclick = delte;


