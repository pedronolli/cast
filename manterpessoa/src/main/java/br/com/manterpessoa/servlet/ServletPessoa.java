package br.com.manterpessoa.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.manterpessoa.business.PessoaBusiness;
import br.com.manterpessoa.dto.PessoaDTO;
import br.com.manterpessoa.entidade.Pessoa;

@WebServlet("/ServletPessoa")
public class ServletPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletPessoa() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PessoaBusiness business = new PessoaBusiness();
		Gson gson = new Gson();

		List<PessoaDTO> pessoaDTOs = business.buscarTodas();

		for (PessoaDTO pessoaDTO : pessoaDTOs) {
			String pessoaDtoJson = gson.toJson(pessoaDTO);
			System.out.println(pessoaDtoJson);
			response.setContentType("application/json");
			response.getWriter().append(pessoaDtoJson);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//Recebe o json
		String json = request.getReader().lines().collect(Collectors.joining());
		Gson gson = new Gson();
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);
		PessoaBusiness business = new PessoaBusiness();
		business.inse		rir(pessoaDTO);
		System.out.println(pessoaDTO);
		
		System.out.println("Json:" + json);
		response.setContentType("application/json");
		response.getWriter().append(json);

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PessoaBusiness business = new PessoaBusiness();
		
		String cpf = req.getParameter("cpf");
		PessoaDTO pessoaDTO = business.buscarPorCpf(cpf);
		
		System.out.println(pessoaDTO);
		business.remover(pessoaDTO);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String json = req.getReader().lines().collect(Collectors.joining());
		Gson gson = new Gson();
		
		PessoaDTO pessoaDTO = gson.fromJson(json, PessoaDTO.class);
		PessoaBusiness pessoaBusiness = new PessoaBusiness();
		pessoaBusiness.alterar(pessoaDTO);
		
		
		
	}

}
