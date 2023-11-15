package mk.ukim.finki.lab.service.impl;

import mk.ukim.finki.lab.model.Production;
import mk.ukim.finki.lab.repository.ProductionRepository;
import mk.ukim.finki.lab.service.ProductionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductionServiceImpl implements ProductionService {
    private final ProductionRepository productionRepository;

    public ProductionServiceImpl(ProductionRepository productionRepository) {
        this.productionRepository = productionRepository;
    }

    @Override
    public List<Production> findAll() {
        return productionRepository.findAll();
    }
}
