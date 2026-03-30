package br.com.fiap.study_apir.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.study_apir.model.Produto;
import br.com.fiap.study_apir.repository.RepositoryProdutoMockup;

@RestController
@RequestMapping("api/${api.version}/produtos")
public class ProdutoController {

    private RepositoryProdutoMockup mockup = new RepositoryProdutoMockup();

    //dois jeitos de fazer 

    //1 verboso
    @PostMapping("")
    public ResponseEntity<String> create() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto Criado!");
    }
    
    //2 menos verboso
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Optional<Produto> optProduto = mockup.findById(id);

        if(optProduto.isPresent()) {
            return ResponseEntity.ok(optProduto.get());
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        return ResponseEntity.ok(mockup.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update() {
        return ResponseEntity.ok("Produto Atualizado!");
    }

    @DeleteMapping("")
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto Excluido!");
    }

    

}

