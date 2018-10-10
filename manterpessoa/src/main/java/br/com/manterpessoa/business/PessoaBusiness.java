package br.com.manterpessoa.business;

import java.util.ArrayList;
import java.util.List;

import br.com.manterpessoa.dao.PessoaDAO;
import br.com.manterpessoa.dto.EnderecoDTO;
import br.com.manterpessoa.dto.PessoaDTO;
import br.com.manterpessoa.entidade.Endereco;
import br.com.manterpessoa.entidade.Pessoa;

public class PessoaBusiness {

	private PessoaDAO dao;

	public PessoaBusiness() {
		this.dao = new PessoaDAO();
	}

	public void inserir(PessoaDTO pessoaDTO) {
		Endereco endereco = new Endereco();

		endereco.setCep(pessoaDTO.getEnderecoDTO().getCep());
		endereco.setBairro(pessoaDTO.getEnderecoDTO().getBairro());
		endereco.setCidade(pessoaDTO.getEnderecoDTO().getCidade());
		endereco.setComplemento(pessoaDTO.getEnderecoDTO().getComplemento());
		endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getLogradouro());
		endereco.setNumero(pessoaDTO.getEnderecoDTO().getNumero());
		endereco.setUf(pessoaDTO.getEnderecoDTO().getUf());

		Pessoa pessoa = new Pessoa();

		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setEndereco(endereco);

		if (pessoa != null) {
			dao.inserir(pessoa);
		}

	}

	public List<PessoaDTO> buscarTodas() {
		List<Pessoa> pessoas = dao.buscarTodas();
		List<PessoaDTO> dtos = new ArrayList<>();

		for (Pessoa pessoa : pessoas) {
			PessoaDTO pessoaDTO = new PessoaDTO();
			EnderecoDTO enderecoDto = new EnderecoDTO();

			enderecoDto.setCep(pessoa.getEndereco().getCep());
			enderecoDto.setBairro(pessoa.getEndereco().getBairro());
			enderecoDto.setCidade(pessoa.getEndereco().getCidade());
			enderecoDto.setComplemento(pessoa.getEndereco().getComplemento());
			enderecoDto.setLogradouro(pessoa.getEndereco().getLogradouro());
			enderecoDto.setNumero(pessoa.getEndereco().getUf());
			enderecoDto.setNumero(pessoa.getEndereco().getUf());

			pessoaDTO.setCpf(pessoa.getCpf());
			pessoaDTO.setEmail(pessoa.getEmail());
			pessoaDTO.setNome(pessoa.getNome());
			pessoaDTO.setEnderecoDTO(enderecoDto);
			dtos.add(pessoaDTO);

		}

		return dtos;

	}
	
	public PessoaDTO buscarPorCpf(String cpf) {
		
		Pessoa pessoa = dao.buscarPorCpf(cpf);
		System.out.println(pessoa);
		PessoaDTO pessoaDTO = new PessoaDTO();
		
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		
		enderecoDTO.setBairro(pessoa.getEndereco().getBairro());
		enderecoDTO.setCep(pessoa.getEndereco().getCep());
		enderecoDTO.setCidade(pessoa.getEndereco().getCidade());
		enderecoDTO.setComplemento(pessoa.getEndereco().getComplemento());
		enderecoDTO.setLogradouro(pessoa.getEndereco().getLogradouro());
		enderecoDTO.setNumero(pessoa.getEndereco().getNumero());
		enderecoDTO.setUf(pessoa.getEndereco().getUf());
		
		pessoaDTO.setCpf(pessoa.getCpf());
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setEmail(pessoa.getEmail());
		pessoaDTO.setEnderecoDTO(enderecoDTO);
		
		return pessoaDTO;
	}
	
	public void remover(PessoaDTO pessoaDTO) {
		Pessoa pessoa = dao.buscarPorCpf(pessoaDTO.getCpf());
		dao.remover(pessoa);	
	}

	public void alterar(PessoaDTO pessoaDTO) {
		Endereco endereco = new Endereco();
		
		endereco.setCep(pessoaDTO.getEnderecoDTO().getCep());
		endereco.setBairro(pessoaDTO.getEnderecoDTO().getBairro());
		endereco.setCidade(pessoaDTO.getEnderecoDTO().getCidade());
		endereco.setComplemento(pessoaDTO.getEnderecoDTO().getComplemento());
		endereco.setLogradouro(pessoaDTO.getEnderecoDTO().getLogradouro());
		endereco.setNumero(pessoaDTO.getEnderecoDTO().getNumero());
		endereco.setUf(pessoaDTO.getEnderecoDTO().getUf());
		
		
		Pessoa pessoa = new Pessoa();
		
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEndereco(endereco);
		
		
		dao.alterar(pessoa);
		
		
	}
	

}
