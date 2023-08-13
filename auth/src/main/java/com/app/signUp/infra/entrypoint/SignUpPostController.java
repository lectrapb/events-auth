package com.app.signUp.infra.entrypoint;

import com.app.signUp.application.SignUp;
import com.app.signUp.domain.UserSignUp;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@CrossOrigin(origins = {"*"})
public class SignUpPostController {

    private final SignUp useCase;

    @PostMapping
    public ResponseEntity<String> signUp(@RequestBody UserSignUp req){
        useCase.save(req);
        return ResponseEntity.ok("Completed");
    }
}
