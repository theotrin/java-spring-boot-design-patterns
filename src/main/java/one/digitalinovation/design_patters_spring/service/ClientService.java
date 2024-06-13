package one.digitalinovation.design_patters_spring.service;

import one.digitalinovation.design_patters_spring.model.Client;

public interface ClientService {
    Iterable<Client> buscarTodos();
    Client buscarPorId(Long id);

    void inserir(Client client);
    void atualizar (Long id, Client client);
    void deletar (Long id);
}
