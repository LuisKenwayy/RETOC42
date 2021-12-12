package com.Luis.kenway.RETOC42;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

import com.Luis.kenway.RETOC42.model.User;
import com.Luis.kenway.RETOC42.repository.ProductsCrudRepository;
import com.Luis.kenway.RETOC42.repository.UserCrudRepository;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Reto2Ciclo4aApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userCrudRepository;
    @Autowired
    private ProductsCrudRepository productsCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto2Ciclo4aApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userCrudRepository.deleteAll();
        productsCrudRepository.deleteAll();
        /*userCrudRepository.saveAll(List.of(
                new User(1, "1118557622", "William Mahecha", "cll 38 # 44 - 51", "3208088701", "wsmh99@hotmail.com", "Demo", "Zona1", "ADM")
        ));*/
    }
}
