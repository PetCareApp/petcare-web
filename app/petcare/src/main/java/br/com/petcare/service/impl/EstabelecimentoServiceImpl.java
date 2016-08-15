package br.com.petcare.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import br.com.petcare.model.Endereco;
import br.com.petcare.model.Estabelecimento;
import br.com.petcare.model.Proprietario;
import br.com.petcare.model.TipoEstabelecimento;
import br.com.petcare.repository.GenericRepository;
import br.com.petcare.service.EstabelecimentoService;

@Named
public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Inject
	private GenericRepository<TipoEstabelecimento> tipoEstRepo;
	
	@Inject
	private GenericRepository<Estabelecimento> estabelecimentoRepo;
	
	@Inject
	private GenericRepository<Endereco> enderecoRepo;
	
	@Override
	public void cadastrar(Estabelecimento estabelecimento) {
		estabelecimentoRepo.save(estabelecimento);
	}
	
	@Override
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento) {
		tipoEstRepo.save(tipoEstabelecimento);
	}

	@Override
	public List<TipoEstabelecimento> getAllTipoEstabelecimento() {
		return tipoEstRepo.find(TipoEstabelecimento.class);
	}

	@Override
	public List<Estabelecimento> getAll() {
		List<Estabelecimento> estabelecimentos = estabelecimentoRepo.find(Estabelecimento.class);
		for (Estabelecimento e: estabelecimentos) {
			Endereco end = e.getEndereco();
			if (e.getCnpj() == null) {
				e.setCnpj("");
			}
			if(end.getBairro() == null) {
				end.setBairro("");
			}
			if(end.getCep() == null){
				end.setCep("");
			}
			if(end.getCidade() == null) {
				end.setCidade("");
			}
			if(end.getComplemento() == null) {
				end.setComplemento("");
			}
			if(end.getEstado() == null) {
				end.setEstado("");
			}
			if(end.getLatitude() == null) {
				end.setLatitude("");
			}
			if(end.getLongitude() == null) {
				end.setLongitude("");
			}
			if(end.getNumero() == null) {
				end.setNumero("");
			}
			if(end.getPais() == null) {
				end.setPais("");
			}
			if(end.getRua() == null) {
				end.setRua("");
			}
			if(end.getTelefone() == null) {
				end.setTelefone("");
			}
		}
		return estabelecimentos;
	}

	@Override
	public void cadastrarEndereco(Endereco endereco) {
		enderecoRepo.save(endereco);
	}
	
	@Override
	public Estabelecimento find(Integer id) {
		return estabelecimentoRepo.find(Estabelecimento.class, id);
	}

	@Override
	public void atualizar(Estabelecimento estabelecimento) {
		estabelecimentoRepo.update(estabelecimento);
	}

}
