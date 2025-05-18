package com.BackPM.BackPM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(title = "BackendPM API", version = "v1"),
	servers = {
		@Server(url = "https://9xmfblmn-9000.use.devtunnels.ms")
	}
)
@SpringBootApplication
public class BackendPmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPmApplication.class, args);
	}

}
