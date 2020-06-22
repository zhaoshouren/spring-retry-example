package warren.chu.samples.springretry;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    private SampleService service;
    private ObjectMapper mapper;

    public SampleController(SampleService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping(value = "/")
    public String hello() {
        return "Hello World!";
    }

    @GetMapping(value = "/all")
    public String getAll() throws JsonProcessingException {
        return mapper.writeValueAsString(service.findAll());
    }
}