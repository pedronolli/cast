$(function() {
	
	$('#btn-buscar-todos').click(function () {
		$('#container').load("/manterpessoa/pessoa/listar-todos.html",
				function (){
					
			$.ajax({
				url:'http://localhost:8080/manterpessoa/ServletPessoa',
				method:'GET',
				sucess: function(registros){
					var $tabela = $('#tabela > tbody');
						$tbody.html('');
						
						registros.forEach(function (pessoa) {
							var $tr = $('<tr>');
								var $tdNome = $('<td>').text(pessoa.nome);
								$tr.append($tdNome)
							$tbody.append($tr);
						})
				}
			})
			
		});
			
	})
	
})