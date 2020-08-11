package service;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import interfaces.ISignUpService;
import request.SignUpRequest;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SignUpService implements ISignUpService {
    private static final Logger logger = Logger.getLogger(String.valueOf(SignUpService.class));
    private final FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    public boolean Register(SignUpRequest request) {
        try {
            // TODO: use auth to create user at Firebase
            return true;
        } catch (Exception ex) {
            logger.log(Level.WARNING, ex.getMessage());
            return false;
        }
    }
}
