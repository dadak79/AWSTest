package admin.config.auth.dto;

import admin.domain.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.io.Serializable;

//SessionUser에서 Session scope 설정으로 인한 문제로 sessionUser null에러 발생하여
//Session Scope를 아래와 같이 지정해주면 문제가 해결된다.
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture= user.getPicture();

        System.out.println("Session User Name : " + this.name);
        System.out.println("Session User email : " + this.email);
    }
}
