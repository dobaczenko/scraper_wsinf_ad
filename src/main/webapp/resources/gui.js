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
			var jsonDane = JSON.parse(this.responseText);
			
			generujInformacjeZrwotna(jsonDane);
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

	// paramy
	let paramNaglowki = document.querySelector('#scrap_el_h');
	let paramLinki = document.querySelector('#scrap_el_a');
	
	if(paramNaglowki.checked == true){
		paramNaglowki="true";
	}else{
		paramNaglowki="false";
	}

	if(paramLinki.checked == true){
		paramLinki="true";
	}else{
		paramLinki="false";
	}
	
	let xhr = new XMLHttpRequest();
	let url = "./api/scraper/scrapuj";

	xhr.open("POST", url, true);

	xhr.setRequestHeader("Content-Type", "application/json");

	xhr.onreadystatechange = function() {
		if (xhr.readyState === 4 && xhr.status === 200) {
			result.innerHTML = this.responseText;
			var jsonDane = JSON.parse(this.responseText);
			
			generujInformacjeZrwotna(jsonDane);
		}
	};

	// Converting JSON data to string
	var data = JSON.stringify({
		"authKey" : klucz.value,
		"url" : adres.value,
		"pobierzNaglowki" : paramNaglowki,
		"pobierzLinki" : paramLinki
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
			var jsonDane = JSON.parse(this.responseText);
				
			generujInformacjeZrwotna(jsonDane);
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
function generujInformacjeZrwotna(jsonDane){
	let table = document.querySelector("table");
	clearTable(table);
	
	if(jsonDane.errorId!=null || jsonDane.podsumowanie!=null){
		let data = Object.keys(jsonDane);
		var tab=[jsonDane];
		generateTableHead(table, data);
		generateTable(table, tab);
	}else if(jsonDane.listaelementow!=undefined && jsonDane.listaelementow!=null){
		if(jsonDane.listaelementow.length>0){
			let data = Object.keys(jsonDane.listaelementow[0]);
							
			generateTableHead(table, data);
			generateTable(table, jsonDane.listaelementow);
		}
	}
}

// //kod z https://www.valentinog.com/blog/html-table/ generuje tabelę
function generateTableHead(table, data) {
	  let thead = table.createTHead();
	  let row = thead.insertRow();
	  for (let key of data) {
	    let th = document.createElement("th");
	    let text = document.createTextNode(key);
	    th.appendChild(text);
	    row.appendChild(th);
	  }
	}

	function generateTable(table, data) {
	  for (let element of data) {
	    let row = table.insertRow();
	    for (key in element) {
	      let cell = row.insertCell();
	      let text = document.createTextNode(element[key]);
	      cell.appendChild(text);
	    }
	  }
	}

	function clearTable(tble) { 
        var row = tble.rows;   
        if(row != undefined){
	        if(row.length > 0){
		        var iMax = tble.rows[0].cells.length;
		
		        for(var i=0;i<iMax;i++){
			        for (var j = 0; j < row.length; j++) { 
			            row[j].deleteCell(i); 
			        } 
				}
	        }
        }
    } 

