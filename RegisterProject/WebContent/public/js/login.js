var loginButton = document.getElementById("Login")

function login(){
	
	var formData = new FormData(document.getElementById("loginForm"))
	
	fetch("http://localhost:8080/RegisterProject/login", {
		method: 'POST',
		body: formData
		}).then(response => {
			console.log(response);
			return response.text();
		});
}

loginButton.onclick = login;