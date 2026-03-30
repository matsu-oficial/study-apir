package br.com.fiap.study_apir.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import br.com.fiap.study_apir.model.Produto;

public class RepositoryProdutoMockup {

    public RepositoryProdutoMockup() {
        Produto produto = new Produto();
        produto.setId(1L);
        produto.setNome("Banana");

        produtos.add(produto);
    }

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> findAll() {
        return produtos;
    }
    
    public Optional<Produto> findById(Long id) {
        return produtos.stream()
            .filter(p -> p.getId().equals(id)) 
            .findFirst();
    }

}
