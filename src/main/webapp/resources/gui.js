/**
 * 
 */
function aboutApi() {

	let result = document.querySelector('.result');
	let req = document.getElementById("req");
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
function scrapujApi() {

	let result = document.querySelector('.result');
	let req = document.getElementById("req");
	let klucz = document.querySelector('#klucz');
	let adres = document.querySelector('#adres');

	let xhr = new XMLHttpRequest();
	let url = "./api/scraper/scrapuj";

	xhr.open("POST", url, true);

	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			result.innerHTML = this.responseText;
		}
	};

	// Converting JSON data to string
	var data = JSON.stringify({
		"authKey" : klucz.value,
		"url" : adres.value
	});
	req.innerHTML = data;

	// Sending data with the request
	xhr.send(data);
}
function wynikiScrapowaniaApi() {

	let result = document.querySelector('.result');
	let req = document.getElementById("req");
	let klucz = document.querySelector('#klucz');

	let xhr = new XMLHttpRequest();
	let url = "./api/scraper/wyniki";

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