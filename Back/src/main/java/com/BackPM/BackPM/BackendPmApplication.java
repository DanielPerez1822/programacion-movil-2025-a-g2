package com.BackPM.BackPM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(title = "BackendPM API", version = "v1"),
	servers = {
		@Server(url = "https://3r7vcx2t-9000.use2.devtunnels.ms")
	}
)
@SpringBootApplication
public class BackendPmApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendPmApplication.class, args);
	}

}
