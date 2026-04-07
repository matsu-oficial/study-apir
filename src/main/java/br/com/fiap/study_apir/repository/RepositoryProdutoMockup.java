package br.com.fiap.study_apir.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.fiap.study_apir.model.Produto;

public class RepositoryProdutoMockup {
    private List<Produto> produtos = new ArrayList<>();
    private long ID = 1l;

    public RepositoryProdutoMockup() {
        produtos.add(new Produto(ID++, "Banana",BigDecimal.valueOf(10.50)));

        produtos.add(new Produto(ID++,"Uva",BigDecimal.valueOf(17.50)));

        produtos.add(new Produto(ID++,"Maçã",BigDecimal.valueOf(15.23)));
    }

    public List<Produto> findAll() {
        return produtos;
    }

    public Optional<Produto> findById(Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public boolean deleteById(Long id) {
        return produtos.removeIf(p -> p.getId().equals(id));
    }

    public Produto create(Produto produto){
        // Atribuir o id novo ao produto a ser cadastrado
        produto.setId(ID++);
        // Salvar no BD
        produtos.add(produto);
        // Retornar o produto novo
        return produto;
    }

    public Produto update(Long id, Produto produto){
        produto.getId(ID);
        return produto;
    }

}
