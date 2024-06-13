package one.digitalinovation.design_patters_spring.service.impl;

import one.digitalinovation.design_patters_spring.model.Client;
import one.digitalinovation.design_patters_spring.model.Endereco;
import one.digitalinovation.design_patters_spring.repository.ClientRepository;
import one.digitalinovation.design_patters_spring.repository.EnderecoRepository;
import one.digitalinovation.design_patters_spring.service.ClientService;
import one.digitalinovation.design_patters_spring.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ClientServiceImpl implements ClientService {
    //TODO: Singleton: Injetar os componentes com @Autowired.
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService; //<- client http

    //TODO: Strategy: Implementar os métodos definidos na interface.
    //TODO: Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    private void salvarClienteComCep(Client client){
        String cep = client.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        client.setEndereco(endereco);

        clientRepository.save(client);
    }

    @Override
    public Iterable<Client> buscarTodos() {
        return clientRepository.findAll();
    }

    @Override
    public Client buscarPorId(Long id) {
        Optional<Client> cliente = clientRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void inserir(Client client) {
      salvarClienteComCep(client);
    }

    @Override
    public void atualizar(Long id, Client client) {
        Optional<Client> clienteBuscado = clientRepository.findById(id);
        if(clienteBuscado.isPresent()){
            salvarClienteComCep(client);
        }
    }

    @Override
    public void deletar(Long id) {
        clientRepository.deleteById(id);
    }
}
