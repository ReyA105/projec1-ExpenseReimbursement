/**
 * 
 */

window.onload = function() {
	document.getElementById("viewReimbursement").addEventListener("click", getAllReimbursement);
}

function getAllReimbursement() {

	let xhr = new XMLHttpRequest();

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			let allJSON = JSON.parse(xhr.responseText)
			DOMManipulation(allJSON);
		}
	}


	xhr.open("POST", "http://localhost:8080/project1/AllReimbursements.json");
	xhr.send();

}

function DOMManipulation(allJSON) {
	let table = document.getElementById("reimbursementtable");
	let tbody =  document.getElementById("reimbursementBody");
	tbody.innerHTML = "";
	let reimbids = [];
	table.setAttribute("style", "visibility:visible");

	let selectedOption = document.getElementById("selectType")
	let value = selectedOption.options[selectedOption.selectedIndex].value;

		for (let i = 0; i < allJSON.length; i++) {
			let obj = allJSON[i];
			if (obj.statusid != value)
				continue;

			if(obj.statusid == 1)
				reimbids.push(obj.reimbId);

			let row = tbody.insertRow(-1);

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

			let newText3 = document.createTextNode(`${new Date(obj.submitted)}`);
			cell3.appendChild(newText3);
			
			let newText4
			if(obj.resolved == null){
				newText4 = document.createTextNode("IN PROGRESS");
			}
			else{
				 newText4 = document.createTextNode(`${new Date(obj.resolved)}`);
			}
			
			cell4.appendChild(newText4);

			let newText5 = document.createTextNode(`${obj.description}`);
			cell5.appendChild(newText5);

			let newText6;
			
			if(obj.statusid == "1")
				newText6 = document.createTextNode("PENDING");
			else if(obj.statusid == "2")
				newText6 = document.createTextNode("APPROVED");
			else
				newText6 = document.createTextNode("DENIED");
			
			cell6.appendChild(newText6);

			let newText7 = document.createTextNode(`${obj.typeId}`);
			cell7.appendChild(newText7);
		}

	


	let x = document.getElementById("reimbChoose");
	x.setAttribute("style", "visibility:visible");
	x.innerHTML = "";
	for (let i = 0; i < reimbids.length; i++) {
		let newOption = document.createElement("option");
		newOption.text = reimbids[i];
		x.add(newOption)
	}
	
	x = document.getElementById("reimbStatusChange");
	x.setAttribute("style", "visibility:visible");
	
	
	x = document.getElementById("approveDenyButton");
	x.setAttribute("style", "visibility:visible");
	
}