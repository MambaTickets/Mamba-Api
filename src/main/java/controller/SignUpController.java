package controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import request.SignUpRequest;
import response.SignUpResponse;
import service.SignUpService;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@Api(value = "signup")
public class SignUpController {
    private static final Logger logger = Logger.getLogger(String.valueOf(SignUpController.class));

    private final SignUpService service;

    @Autowired
    public SignUpController(SignUpService service) {
        this.service = service;
    }

    @ApiOperation(value = "Register new user")
    @PostMapping(path = "/register")
    @ResponseBody
    public SignUpResponse create(@RequestBody SignUpRequest request) {
        try {
            if (request.getEmail() == null ||
                    !request.getEmail().contains("@") ||
                    !request.getEmail().contains(".com"))
                return null;
            if (request.getPassword() == null ||
                    request.getConfirmPassword() == null ||
                    !request.getPassword().equals(request.getConfirmPassword()) ||
                    request.getPassword().length() != 8 ||
                    request.getConfirmPassword().length() != 8)
                return null;

            boolean response = this.service.Register(request);
            if (!response)
                return null;

            return new SignUpResponse();

        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage());
        }
        return new SignUpResponse();
    }

    public SignUpService getService() {
        return service;
    }
}
