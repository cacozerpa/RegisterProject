var logoutButton = document.getElementById("Logout");

function logout(event){
	
	event.preventDefault();
	
	fetch("http://localhost:8080/RegisterProject/logout", {
		
		method: 'POST',
		headers: new Headers()
	
	}).then(response => {
		if(response.status == 200){
			window.location.href = "http://localhost:8080/RegisterProject/index.html"
		}else{
			window.alert("Logout Fallido!");
		}
		console.log(response);
		return response.text();
	});
	
}

logoutButton.onclick = logout;