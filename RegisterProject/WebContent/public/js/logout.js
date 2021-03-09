var logoutButton = document.getElementById("Logout");

function logout(event){
	
	event.preventDefault();
	
	fetch("https://registerprojectcarloszerpa.herokuapp.com/logout", {
		
		method: 'POST',
		headers: new Headers()
	
	}).then(response => {
		if(response.status == 200){
			window.location.href = "https://registerprojectcarloszerpa.herokuapp.com/index.html"
		}else{
			window.alert("Logout Fallido!");
		}
		console.log(response);
		return response.text();
	});
	
}

logoutButton.onclick = logout;