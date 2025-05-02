package DigitalSignature.KeamanInformasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "DigitalSignature.KeamanInformasi.repository")
@EntityScan(basePackages = "DigitalSignature.KeamanInformasi.model")
public class KeamanInformasiApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeamanInformasiApplication.class, args);
    }
}
