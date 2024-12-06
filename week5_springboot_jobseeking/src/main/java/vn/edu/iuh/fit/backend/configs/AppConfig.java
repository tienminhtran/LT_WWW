package vn.edu.iuh.fit.backend.configs;


/*
 * @description:
 * @author: Tran Minh Tien
 * @date: 11/17/2024
 */
@Configuration
public class AppConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
