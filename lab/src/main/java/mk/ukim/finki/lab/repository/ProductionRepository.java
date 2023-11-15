package mk.ukim.finki.lab.repository;

import mk.ukim.finki.lab.bootstrap.DataHolder;
import mk.ukim.finki.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductionRepository {
    public List<Production> findAll(){
        return DataHolder.productions;
    }


}
