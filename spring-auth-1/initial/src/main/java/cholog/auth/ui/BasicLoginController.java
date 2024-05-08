package cholog.auth.ui;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cholog.auth.application.AuthService;
import cholog.auth.application.AuthorizationException;
import cholog.auth.dto.AuthInfo;
import cholog.auth.dto.MemberResponse;
import cholog.auth.infrastructure.AuthorizationExtractor;
import cholog.auth.infrastructure.BasicAuthorizationExtractor;

@RestController
public class BasicLoginController {
    private final AuthService authService;
    private final AuthorizationExtractor<AuthInfo> authorizationExtractor;

    public BasicLoginController(AuthService authService) {
        this.authService = authService;
        this.authorizationExtractor = new BasicAuthorizationExtractor();
    }

    /**
     * ex) request sample
     * <p>
     * GET /members/me/basic HTTP/1.1
     * authorization: Basic ZW1haWxAZW1haWwuY29tOjEyMzQ=
     * accept: application/json
     */
    @GetMapping("/members/me/basic")
    public ResponseEntity<Object> findMyInfo(HttpServletRequest request, HttpServletResponse response) {

        AuthInfo authInfo = authorizationExtractor.extract(request);

        if (authInfo == null) {
            response.setHeader("WWW-Authenticate", "Basic realm=\"Users\"");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unauthorized");
        }

        String email = authInfo.getEmail();
        String password = authInfo.getPassword();

        if (authService.checkInvalidLogin(email, password)) {
            throw new AuthorizationException();
        }

        MemberResponse member = authService.findMember(email);
        return ResponseEntity.ok().body(member);
    }
}
