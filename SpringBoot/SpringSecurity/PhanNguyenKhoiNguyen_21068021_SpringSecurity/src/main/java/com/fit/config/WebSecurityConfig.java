package com.fit.config;

import com.fit.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity // Bật tính năng bảo mật trên Web cho ứng dụng Spring
public class WebSecurityConfig {

    @Autowired  // Tự động tiêm các bean đã khai báo ở trên
    @Lazy
    private UserDetailsServiceImpl userDetailsService;  // Dùng để xác thực người dùng


    /**
     * Mã hóa mật khẩu bằng BCryptPasswordEncoder
     * @return : mật khẩu đã được mã hóa
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.csrf().disable();  // Tắt tính năng CSRF (dung để bảo vệ khỏi tấn công giả mạo)
//
//        //PHÂN QUYỀN TRUY CẬP
//
//        // Các trang này không yêu cầu login (có thể truy cập mà không cần đăng nhập)
//        http.authorizeHttpRequests().requestMatchers("/", "/login", "/logout").permitAll();
//
//        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
//        // Nếu chưa login, nó sẽ redirect tới trang /login.
//        http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
//
//        // Trang /admin chỉ cho phép người dùng có vai trò ROLE_ADMIN truy cập.
//        http.authorizeRequests().antMatchers("/admin").access("hasRole('ROLE_ADMIN')");
//
//
//        // XỬ LÝ KHI BỊ TỪ CHỐI TRUY CẬP
//        // Nếu người dùng cố truy cập vào trang mà họ không có quyền, họ sẽ bị chuyển hướng đến trang /403 (thông báo lỗi "Access Denied").
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
//
//        // CẤU HÌNH LOGIN FORM
//        http.authorizeRequests().and().formLogin()//
//                .loginProcessingUrl("/j_spring_security_check") // Khi người dùng ấn nút Login, form sẽ gửi POST request đến URL này để xác thực thông tin đăng nhập.
//                .loginPage("/login") // URL của trang login
//                .defaultSuccessUrl("/userAccountInfo") // URL mặc định sau khi đăng nhập thành công
//                .failureUrl("/login?error=true") // URL khi đăng nhập thất bại
//                .usernameParameter("username")// Tham số của username
//                .passwordParameter("password")// Tham số của password
//                // CẤU HÌNH LOGOUT
//                .and().logout()  // Cấu hình cho Logout Page.
//                .logoutUrl("/logout")  // URL của trang logout
//                .logoutSuccessUrl("/logoutSuccessful");  // URL sau khi logout thành công
//
//        // CẤU HÌNH GHI NHỚ ĐĂNG NHẬP
//        http.authorizeRequests().and() //
//                .rememberMe()  // Ghi nhớ đăng nhập
//                .tokenRepository(this.persistentTokenRepository()) //Lưu token (mã ghi nhớ) vào bộ nhớ.
//                .tokenValiditySeconds(1 * 24 * 60 * 60); // Token có hiệu lực trong 24 giờ.
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login", "/logout","/welcome").permitAll()
                        .requestMatchers("/userInfo").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/admin").hasRole("ADMIN")
                        .anyRequest().authenticated() // Tất cả các request khác đều cần phải xác thực mới được truy cập
                )
                .formLogin(form -> form
                        .loginPage("/login")  // URL của trang login hoặc khi chưa đăng nhập sẽ tự động chuyển hướng đến trang login
                        .loginProcessingUrl("/j_spring_security_check")  // URL sẽ được gửi POST request để xác thực thông tin đăng nhập
                        .defaultSuccessUrl("/admin")  // URL sau khi đăng nhập thành công
                        .failureUrl("/login?error=true")  // URL khi đăng nhập thất bại
                        .usernameParameter("username")  // Tham số của username
                        .passwordParameter("password") // Tham số của password
                )
                //defaultSuccessUrl("/home", true)
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/logoutSuccessful")
                )
                .rememberMe(remember -> remember
                        .tokenRepository(persistentTokenRepository()) // Nơi lưu token
                        .tokenValiditySeconds(24 * 60 * 60) // Thời gian token có hiệu lực (24 giờ)
                        .rememberMeParameter("remember-me") // Tên tham số "Ghi nhớ đăng nhập" trong form login
                );

        return http.build();
    }


    /**
     * Xác thực người dùng (Ai)
     * @param auth
     * @throws Exception
     */
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

//    public void configureGlobal(AuthenticationManagerBuilder auth, PasswordEncoder passwordEncoder) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder.encode("password")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder.encode("password")).roles("ADMIN");
//    }

    /**
     * Lưu trữ token vào bộ nhớ (ghi nhớ đăng nhập)
     * @return : token
     */
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
