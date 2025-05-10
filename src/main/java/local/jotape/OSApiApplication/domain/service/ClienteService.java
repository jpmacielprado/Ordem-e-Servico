package local.jotape.OSApiApplication.domain.service;

import local.jotape.OSApiApplication.domain.exception.DomainException;
import local.jotape.OSApiApplication.domain.model.Cliente;
import local.jotape.OSApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    @Autowired
    private ClienteRepository  clienteRepository;
    
    public Cliente salvar(Cliente cliente) {
        Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
        
        // Lembrar que o método SAVE também pode ser usado para atualizar um CLIENTE!
        // ID vazio --> Novo REGISTRO
        // ID preenchido --> Alterar Existente
        
        // Verifica se o CLIENTE existe
        if (clienteExistente != null && clienteExistente.equals(cliente)){
            //Lançar exception
            throw new DomainException("Já existe um cliente cadastrado com esse E-mail!!");
        }
        
        return clienteRepository.save(cliente);
        
    }
    
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
