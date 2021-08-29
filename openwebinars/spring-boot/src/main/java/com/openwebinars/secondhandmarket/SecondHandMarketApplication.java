package com.openwebinars.secondhandmarket;

import com.openwebinars.secondhandmarket.modelo.Producto;
import com.openwebinars.secondhandmarket.modelo.Usuario;
import com.openwebinars.secondhandmarket.repositorios.ProductoRepository;
import com.openwebinars.secondhandmarket.repositorios.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class SecondHandMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondHandMarketApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UsuarioRepository usuarioRepository, ProductoRepository productoRepository) {
        return args -> {

            Usuario usuario = new Usuario("Luis Miguel", "LÃ³pez MagaÃ±a", null, "luismi", "luismi");
            usuario = usuarioRepository.save(usuario);

            productoRepository.saveAll(Arrays.asList(
                    new Producto("Bicicleta de montaÃ±a", 100.0f,
                            "https://www.decathlon.es/media/835/8350582/big_23c25284-2810-415d-8bcc-e6bebdb536fc.jpg", usuario),
                    new Producto("Golf GTI Serie 2", 2500.0f,
                            "https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg",
                            usuario),
                    new Producto("Raqueta de tenis", 10.5f, "https://imgredirect.milanuncios.com/fg/2311/04/tenis/Raqueta-tenis-de-segunda-mano-en-Madrid-231104755_1.jpg?VersionId=T9dPhTf.3ZWiAFjnB7CvGKsvbdfPLHht", usuario),
                    new Producto("Xbox One X", 425.0f, "https://images.vibbo.com/635x476/860/86038583196.jpg", usuario),
                    new Producto("TrÃ­pode flexible", 10.0f, "https://images.vibbo.com/635x476/860/86074256163.jpg", usuario),
                    new Producto("Iphone 7 128 GB", 350.0f, "https://store.storeimages.cdn-apple.com/4667/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/rosegold/iphone7-rosegold-select-2016?wid=470&hei=556&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1472430205982", usuario)
            ));
        };
    }
}
