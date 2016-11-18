package br.cap7.petcare.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.cap7.petcare.model.Agendamento;
import br.cap7.petcare.model.Agendamento.StatusAgendamento;
import br.cap7.petcare.model.Estabelecimento;
import br.cap7.petcare.model.TipoEstabelecimento;
import br.cap7.petcare.repository.AgendamentoRepository;
import br.cap7.petcare.repository.EstabelecimentoRepository;
import br.cap7.petcare.repository.TipoEstabelecimentoRepository;
import br.cap7.petcare.service.EstabelecimentoService;

@Service
public class EstabelecimentoServiceImpl implements EstabelecimentoService {
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	@Autowired
	private TipoEstabelecimentoRepository tipoEstabelecimentoRepository;
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;

	@Override
	public List<Estabelecimento> getAll() {
		return estabelecimentoRepository.findAll();
	}

	@Override
	public List<TipoEstabelecimento> getAllTipoEstabelecimento() {
		return tipoEstabelecimentoRepository.findAll();
	}

	@Override
	public void cadastrar(TipoEstabelecimento tipoEstabelecimento) {
		if (tipoEstabelecimentoRepository.findByNomeIgnoreCase(tipoEstabelecimento.getNome()) == null) {
			tipoEstabelecimentoRepository.save(tipoEstabelecimento);
		}
	}

	@Override
	public void cadastrar(Estabelecimento estabelecimento) {
		estabelecimentoRepository.save(estabelecimento);
	}

	@Override
	public List<Estabelecimento> getAll(String emailProprietario) {
		return estabelecimentoRepository.findByproprietarioUsuarioEmail(emailProprietario);
	}

	@Override
	public List<Agendamento> getAgenda(Estabelecimento estabelecimento, Date data, StatusAgendamento status) {
		return agendamentoRepository.findByEstabelecimentoAndDataAndStatusOrderByHoraAsc(estabelecimento, data, status);
	}

	@Override
	public void excluir(TipoEstabelecimento tipoEstabelecimento) {
		tipoEstabelecimentoRepository.delete(tipoEstabelecimento);
	}

}
