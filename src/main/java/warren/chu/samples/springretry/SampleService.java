package warren.chu.samples.springretry;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.QueryTimeoutException;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

    private static final Logger log = LoggerFactory.getLogger(SampleService.class);

    private SampleRepository repository;

    public SampleService(SampleRepository repository) {
        this.repository = repository;
    }

    @Retryable(value = QueryTimeoutException.class, maxAttempts = 3)
    public Iterable<SampleEntity> findAll() {
        return repository.findAll();
    }

    @Recover
    public Iterable<SampleEntity> recover(QueryTimeoutException qte) {
        log.info("Maximum retries of 3 reached");
        return null;
    }
}