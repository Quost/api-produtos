package com.example.api_produtos.repository;

import com.example.api_produtos.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProdutoRepository {
    private final Map<Long, Produto> produtos = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Produto> findAll() {
        return new ArrayList<>(produtos.values());
    }

    public Optional<Produto> findById(Long id) {
        return Optional.ofNullable(produtos.get(id));
    }

    public Produto save(Produto produto) {
        if (produto.getId() == null) {
            produto.setId(counter.getAndIncrement());
        }
        produtos.put(produto.getId(), produto);
        return produto;
    }

    public void deleteById(Long id) {
        produtos.remove(id);
    }
}