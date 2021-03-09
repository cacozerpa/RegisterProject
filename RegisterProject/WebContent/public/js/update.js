var updateButton = document.getElementById("Act");

function update(event){
	
	event.preventDefault();
	
	var formData = new FormData(document.getElementById("Update"))
	
	fetch("https://registerprojectcarloszerpa.herokuapp.com/update", {
		
		method: 'POST',
		body: formData
		
	}).then(response =>{
		
		 if(response.status == 200){
			   window.location.href = "https://registerprojectcarloszerpa.herokuapp.com/public/views/updatedone.html";
		   }else{
			   window.alert("Error en la actualización del usuario!");
		   }
		   console.log(response);
	    	return response.text()
	
	});
	
}

updateButton.onclick = update;
