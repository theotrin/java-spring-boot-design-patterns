package one.digitalinovation.design_patters_spring.controller;

import one.digitalinovation.design_patters_spring.model.Client;
import one.digitalinovation.design_patters_spring.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<Iterable<Client>> buscarTodos() {
        return ResponseEntity.ok(clientService.buscarTodos());
    }

    @GetMapping("/id")
    public ResponseEntity<Client> buscarPorId(@PathVariable Long id, Client cliente) {
        return ResponseEntity.ok(clientService.buscarPorId(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Client> inserir(@RequestBody Client cliente){
        clientService.inserir(cliente);
        return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> atualizar(@PathVariable Long id, Client cliente){
        clientService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/id")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }


}
