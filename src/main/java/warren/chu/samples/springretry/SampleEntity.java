package warren.chu.samples.springretry;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SampleEntity {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String value;

    public SampleEntity(String value) {
        this.value = value;
    }

    public Long getId() {
        return this.id;
    }

    public String getValue() {
        return this.value;
    }
}