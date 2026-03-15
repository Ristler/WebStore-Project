package fi.metropolia.danielju.webstore.service;

import fi.metropolia.danielju.webstore.entity.OutOfStock;
import fi.metropolia.danielju.webstore.repositories.OutOfStockRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutOfStockService {

    @PersistenceContext
    private EntityManager em;

    private final OutOfStockRepository outOfStockRepository;

    public OutOfStockService(OutOfStockRepository outOfStockRepository) {
        this.outOfStockRepository = outOfStockRepository;
    }

    public List<OutOfStock> getAllOutOfStock() {
        return outOfStockRepository.findAll();
    }

    @Transactional
    public void removeAvailableProducts() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaDelete<OutOfStock> delete = cb.createCriteriaDelete(OutOfStock.class);
        Root<OutOfStock> root = delete.from(OutOfStock.class);
        delete.where(cb.greaterThan(root.get("product").get("stock_quantity"), 0));

        em.createQuery(delete).executeUpdate();
    }
}