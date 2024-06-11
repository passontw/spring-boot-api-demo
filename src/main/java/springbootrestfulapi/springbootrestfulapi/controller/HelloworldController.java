package springbootrestfulapi.springbootrestfulapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/hello")
public class HelloworldController {

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
