package local.jotape.OSApiApplication.domain.service;

import java.time.LocalDateTime;
import local.jotape.OSApiApplication.domain.model.OrdemServico;
import local.jotape.OSApiApplication.domain.model.StatusOrdemServico;
import local.jotape.OSApiApplication.domain.repository.OrdemServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrdemServicoService {
    
    @Autowired
    private OrdemServicoRepository ordemServicoRepository;
    
    public OrdemServico criar (OrdemServico ordemServico) {
        ordemServico.setStatus(StatusOrdemServico.ABERTA);
        ordemServico.setDataAbertura(LocalDateTime.now());
        
        return ordemServicoRepository.save(ordemServico);
    }
    
}
