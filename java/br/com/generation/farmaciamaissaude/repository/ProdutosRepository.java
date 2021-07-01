package br.com.generation.farmaciamaissaude.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.generation.farmaciamaissaude.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository <Produtos, Long> {
	public List<Produtos> findAllByProdutoContainingIgnoreCase(String produto);

}
