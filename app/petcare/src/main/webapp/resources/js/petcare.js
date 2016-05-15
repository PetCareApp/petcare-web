$(document).ready(function() {
	
	$("table").dataTable( {
        "language": {
            "url": "/petcare/resources/js/Portuguese-Brasil.json"
        }
    } );
	
	$("select").select2();
	
});