package az.contasoft.xmies_randevu.db.repo;

import az.contasoft.xmies_randevu.db.entity.Randevu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepoRandevu extends CrudRepository<Randevu, Long> {
    List<Randevu> findAll();

    Randevu findByIdRandevu(long idRandevu);
}
