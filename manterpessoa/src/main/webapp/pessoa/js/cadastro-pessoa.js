$(function() {
	

	
	
	
		$('#container').on('click', '#btn-salvar-pessoa', function(event){


			var dados = {
					    "cpf": $('#cpf').val(),
					    "nome": $('#nome').val(),
					    "email": $('#email').val(),
					    "enderecoDTO": {
					        "cep": $('#cep').val(),
					        "logradouro": $('#logradouro').val(),
					        "numero": $('#numero').val(),
					        "complemento": $('#complemento').val(),
					        "bairro": $('#bairro').val(),
					        "cidade": $('#cidade').val(),
					        "uf": $('#uf').val()
					}
			}
			
			
			$.ajax( {
				url:'http://localhost:8080/manterpessoa/ServletPessoa',
				method:'POST',
				dataType: 'JSON',
				data: JSON.stringify(dados)
			})
		
	
			});
});