var registerButton = document.getElementById("Register")

function registro() {

	var Email, ConfEmail, Password, ConfPassword
	
	Email = document.getElementById("Email").value;
	ConfEmail = document.getElementById("ConfEmail").value;
	Password = document.getElementById("Password").value;	
	ConfPassword = document.getElementById("ConfPassword").value;
	
	if(Email != ConfEmail){
		alert("Email does not match!")
		return false;
	}
	if(Password != ConfPassword){
		alert("Password does not match!")
		return false;
	}
	
	var formData = new FormData(document.getElementById("register-form"))
	
	fetch("http://localhost:8080/RegisterProject/register", {
        method: 'POST',
        body: formData
   }).then(response => {
	   console.log(response);
    	return response.text()
        
    });

}

registerButton.onclick = registro;
