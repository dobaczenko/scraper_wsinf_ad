/**
 * 
 */
function aboutApi() {

	let result = document.querySelector('.result');
	let req=document.getElementById("req");
	let klucz = document.querySelector('#klucz');

	let xhr = new XMLHttpRequest();
	let url = "./api/info/abouts";

	xhr.open("POST", url, true);

	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			result.innerHTML = this.responseText;
		}
	};

	// Converting JSON data to string
	var data = JSON.stringify({
		"authKey" : klucz.value
	});
	req.innerHTML = data;

	// Sending data with the request
	xhr.send(data);
}