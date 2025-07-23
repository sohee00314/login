package org.example.login.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.login.domain.Role;
import org.example.login.domain.User;
import org.example.login.dto.UserCreateRequest;
import org.example.login.dto.UserLoginRequest;
import org.example.login.repository.UserRepository;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/***
 * 회원 가입, 로그인 기능흘 실제로 실행하는 클래스
 * 1.
 */
@Service
@RequiredArgsConstructor//필요한 객체를 자동으로 생성
@Slf4j
public class UserService {
    //2.DB 저장을 위한 클래스
    private final UserRepository userRepository;
    //4. 암호화를 준비
    private final PasswordEncoder passwordEncoder;

    /***
     * 회원 가입을 위한 메서드
     * 3.이름, 로그인아이디, 비밀번호 받기
     */
    public void register(UserCreateRequest request){

        //로그인 아이디 중복 확인하기
        //isPresent? Optional는 결과 값이 나오면 true, 없으면  false
        if(userRepository.findByLoginId(request.getLoginId()).isPresent()){
            throw new DuplicateKeyException("ID 중복되었습니다");
        }
        //받은 비밀번호를 암호화해서 받기
        String encodedPassword = passwordEncoder.encode(request.getPassword());
        // User에 값 저장해서 DB 에게 보내기
        User user = User.builder()
                .loginId(request.getLoginId())
                .password(encodedPassword)
                .name(request.getName())
                .role(Role.User)
                .build();
log.info("loginId: {}, password: {} name: {} role: {}",request.getLoginId(),request.getPassword(),request.getName(),Role.User);
        userRepository.save(user);
    }

    /***
     * 로그인을 위한 메서드
     *
     */
    public void login(UserLoginRequest request){
    //아이디 비교하기
    User user =
            userRepository.findByLoginId(request.getLoginId())
                    .orElseThrow(//조회해서 없으면 에러메시지 보내기
                            () -> new UsernameNotFoundException("아이디 없음")
                    );
    }
}
