
window.onload = function user(event){
	
	event.preventDefault();
	
	
	fetch("http://localhost:8080/RegisterProject/user").then(response => { return response.json(); }).then( data => {
		
		
		document.getElementById("name").value = data[0].name;
		document.getElementById("User").value = data[0].usuario;
		document.getElementById("Email").value = data[0].email;
		document.getElementById("Password").value = data[0].password;
		document.getElementById("Tlf").value = data[0].tlf;
		document.getElementById("direccion").value = data[0].direccion;
		document.getElementById("ci").value = data[0].ci;
		document.getElementById("apodo").value = data[0].apodo;
		
		
	});

}



