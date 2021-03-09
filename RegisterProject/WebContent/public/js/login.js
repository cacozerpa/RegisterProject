var loginButton = document.getElementById("Login")

function login(event){
	
	event.preventDefault();
	
	var formData = new FormData(document.getElementById("loginForm"))
	
		fetch("http://localhost:8080/RegisterProject/login", {
	
		method: 'POST',
		body: formData
		}).then(response => {
			if(response.status == 200){
				window.location.href = "http://localhost:8080/RegisterProject/public/views/user.html"
			}else{
				window.alert("Login Fallido!");
			}
			console.log(response);
			return response.text();
		});
}

loginButton.onclick = login;