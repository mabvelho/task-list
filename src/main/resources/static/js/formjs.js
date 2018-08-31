this.onload = onload;
function onload() {
	document.getElementById('txtTask').focus();
	
}

this.removerTask = removerTask;
function removerTask(td) {
	if (confirm('Deseja realmente excluir?')) {
		var a = td.parentElement.children[2].children[0];
		a.click();
	}
}

this.validarInput = validarInput;
function validarInput() {
	var input = document.getElementById('txtTask').value;
	if (input === '' || input === null || input === undefined) {
		alert('Task size must be between 2 and 100 characteres.');
		return false;
	}
	if (input.length < 2 || input.length > 100) {
		alert('Task size must be between 2 and 100 characteres.');
		return false;
	}
	return true;
}