package umc.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.service.StoreService.StoreQueryService;

@EnableJpaAuditing
@SpringBootApplication
@EntityScan("umc.spring.domain")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	// Controller 대신 애플리케이션 시작과 동시에 자동으로 실행되는 커맨드라인 기반의 작업을 정의
	// CommandLineRunner 인터페이스를 사용해 특정 로직을 애플리케이션 시작 시점에 바로 실행
	@Bean
	public CommandLineRunner run(ApplicationContext ctx) {
		return args -> {
			StoreQueryService storeQueryService = ctx.getBean(StoreQueryService.class);

			String name = "요아정";
			Float score = 4.0f;

			System.out.println("Executing findStoresByNameAndScore with parameters:");
			System.out.println("Name: " + name);
			System.out.println("Score: " + score);

			// 검색 결과로 얻은 Store 객체들을 forEach(System.out::println);을 통해 콘솔에 출력
			storeQueryService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);
		};
	}
}
