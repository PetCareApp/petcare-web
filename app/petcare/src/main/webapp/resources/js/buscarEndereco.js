/**
 * 
 */
$('#botaomapa').click(function(){
	$('#latitude').val('');
	$('#longitude').val('');
	//MAPA
	// Definir endereço, definir variável para os marcadores, definir marcador
	var addrs = [];
	addrs[0] = $('#endereco').val()+','+$('#bairro').val()+','+$('#cidade').val()+','+$("#estado option:selected").text()+','+$('#cep').val(); /// buscando os dados do endereço de forma dinamica 
	var markers = [];
	var marker_num = 0;
	// Processar o endereço para obter seu Latitude e Longitude
	
	var geocoder = new google.maps.Geocoder();
	var center = new google.maps.LatLngBounds();
	for(k=0;k<addrs.length;k++){
		var addr = addrs[k];
		geocoder.geocode({'address':addr},function(res,stat){
			if(stat==google.maps.GeocoderStatus.OK){
				// adicionar o ponto para os LatLngBounds para obter ponto o central
				center.extend(res[0].geometry.location);
				markers[marker_num]=res[0].geometry.location;
				marker_num++;
				// realmente mostrar o mapa e marcadores
				if(k==addrs.length){
					// mostrar o mapa
					var opcoes = { 
						center: center.getCenter(),
						zoom: 16,
						streetViewControl: true,
						mapTypeId: google.maps.MapTypeId.ROADMAP, 
						noClear:true
					}
					var map = new google.maps.Map(document.getElementById("mapa"),opcoes);
					// percorrer os marcadores e exibi-los
					for(p=0;p<markers.length;p++){
						var mark = markers[p];
						new google.maps.Marker({ // aqui seleciona o local node esta o marcador, no meu caso como use um esquema de temas use um echo para selecionar o temas de forma dinamica
								/*('icon':'../../temas//images/mapmarker.png',*/
								//'animation':google.maps.Animation.DROP, // This lags my computer somethin feirce
								title:addrs[p],
								map: map,
								position: mark,
								})
						$('#latitude').val(mark.lat());
						$('#longitude').val(mark.lng());	
						$('#enderecoOk').show();		
						$('#enderecoErrado').hide();													
					}
				}
			}else{
				$('#latitude').val('');
				$('#longitude').val('');		
				$('#popupMapa').hide();
				$('#tdBotaoMapa').hide();
				$('#enderecoOk').hide();		
				$('#enderecoErrado').show();
				$('#popupLatLong').show();							
				alert('Não foi possível encontrar o endereço!');
			}
		});
	}
	$('#popupMapa').show();
});