package umc.spring.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.repository.MemberRepository;
import org.springframework.security.core.userdetails.User;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final MemberRepository memberRepository;

    // 사용자가 로그인 폼을 제출시, spring security는 이 함수를 실행함
    // 이 함수는 이메일을 가지고 데이터 베이스에서 사용자 조회, 존재하면 user 객체로 반환
    // spring security는 해당 user 객체 정보를 사용하여 인증 수행
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다."));

        return User
                .withUsername(member.getEmail())
                .password(member.getPassword())
                .roles(String.valueOf(member.getRole()))
                .build();
    }
}
