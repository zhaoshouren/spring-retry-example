package warren.chu.samples.springretry;

import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<SampleEntity, Long>{
    SampleEntity findById(long id);
}