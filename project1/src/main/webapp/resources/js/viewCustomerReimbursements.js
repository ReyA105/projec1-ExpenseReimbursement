/**
 * 
 */


window.onload = function() {
	document.getElementById("pastReimbursement").addEventListener("click", getPastReimbursement);
}

function getPastReimbursement() {
	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let pastJSON = JSON.parse(xhr.responseText)
			DOMManipulation(pastJSON);
		}
	}


	xhr.open("POST", "http://localhost:8080/project1/PastReimbursements.json");
	xhr.send();
}

function DOMManipulation(pastJSON) {
	console.log(pastJSON)
	let table = document.getElementById("reimbursementtable");
	table.setAttribute("style", "visibility:visible");

	let btn = document.getElementById("pastReimbursement");
	btn.setAttribute("style", "visibility:hidden")

	for (let i = 0; i < pastJSON.length; i++) {
		let obj = pastJSON[i];

		let row = table.insertRow(-1);

		let cell1 = row.insertCell(0);
		let cell2 = row.insertCell(1);
		let cell3 = row.insertCell(2);
		let cell4 = row.insertCell(3);
		let cell5 = row.insertCell(4);
		let cell6 = row.insertCell(5);
		let cell7 = row.insertCell(6);


		let newText1 = document.createTextNode(`${obj.reimbId}`);
		cell1.appendChild(newText1);

		let newText2 = document.createTextNode(`${obj.amount}`);
		cell2.appendChild(newText2);

		let newText3 = document.createTextNode(`${obj.submitted}`);
		cell3.appendChild(newText3);

		let newText4 = document.createTextNode(`${obj.resolved}`);
		cell4.appendChild(newText4);

		let newText5 = document.createTextNode(`${obj.description}`);
		cell5.appendChild(newText5);

		let newText6;

		if (obj.statusid == "1")
			newText6 = document.createTextNode("PENDING");
		else if (obj.statusid == "2")
			newText6 = document.createTextNode("APPROVED");
		else
			newText6 = document.createTextNode("DENIED");

		cell6.appendChild(newText6);

		let newText7 = document.createTextNode(`${obj.typeId}`);
		cell7.appendChild(newText7);
	}
}
