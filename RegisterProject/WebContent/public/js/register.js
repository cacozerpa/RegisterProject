
var registerButton = document.getElementById("Register")

function registro(event) {

	event.preventDefault();
	
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
	
	fetch("https://registerprojectcarloszerpa.herokuapp.com/register", {
        method: 'POST',
        body: formData
   }).then(response => {
	   if(response.status == 200){
		   window.location.href = "https://registerprojectcarloszerpa.herokuapp.com/public/views/login.html";
	   }else{
		   window.alert("Error en el registro de usuario!");
	   }
	   console.log(response);
    	return response.text()
        
    });

}

registerButton.onclick = registro;
