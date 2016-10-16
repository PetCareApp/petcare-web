$( document ).ready(function() {
	$('.table-datatables').DataTable({
		"language": {
            "url": "https://cdn.datatables.net/plug-ins/1.10.12/i18n/Portuguese-Brasil.json"
        },
        "lengthChange": false,
        "searching": false
	});
	
	$('select').material_select();
});