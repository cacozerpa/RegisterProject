var loginButton = document.getElementById("Login")

function login(event){
	
	event.preventDefault();
	
	var formData = new FormData(document.getElementById("loginForm"))
	
		fetch("https://registerprojectcarloszerpa.herokuapp.com/login", {
	
		method: 'POST',
		body: formData
		}).then(response => {
			if(response.status == 200){
				window.location.href = "https://registerprojectcarloszerpa.herokuapp.com/public/views/user.html"
			}else{
				window.alert("Login Fallido!");
			}
			console.log(response);
			return response.text();
		});
}

loginButton.onclick = login;