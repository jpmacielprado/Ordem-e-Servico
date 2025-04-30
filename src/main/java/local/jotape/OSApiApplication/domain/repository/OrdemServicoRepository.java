package local.jotape.OSApiApplication.domain.repository;

import local.jotape.OSApiApplication.domain.model.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
    
}
