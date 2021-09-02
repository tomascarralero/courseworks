package com.openwebinars.secondhandmarket;

import com.openwebinars.secondhandmarket.modelo.Producto;
import com.openwebinars.secondhandmarket.modelo.Usuario;
import com.openwebinars.secondhandmarket.servicios.ProductoServicio;
import com.openwebinars.secondhandmarket.servicios.UsuarioServicio;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SecondHandMarketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondHandMarketApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(UsuarioServicio usuarioServicio, ProductoServicio productoServicio) {
        return args -> {

            Usuario usuario = new Usuario("Luis Miguel", "López Magaña", null, "luismi.lopez@openwebinars.net", "luismi");
            usuario = usuarioServicio.registrar(usuario);

            Usuario usuario2 = new Usuario("Antonio", "García Martín", null, "antonio.garcia@openwebinars.net", "antonio");
            usuario2 = usuarioServicio.registrar(usuario2);

            List<Producto> listado = Arrays.asList(new Producto("Bicicleta de montaña", 100.0f,
                            "https://contents.mediadecathlon.com/p2091636/k$cc0790528e1a07724f38362c6dc52705/sq/bicicleta-de-montana-ntt-29-pulgadas-24-velocidades-shimano.jpg?f=960x960", usuario),
                    new Producto("Golf GTI Serie 2", 2500.0f,
                            "https://www.minicar.es/large/Volkswagen-Golf-GTi-G60-Serie-II-%281990%29-Norev-1%3A18-i22889.jpg",
                            usuario),
                    new Producto("Raqueta de tenis", 10.5f, "https://cdn.grupoelcorteingles.es/SGFM/dctm/MEDIA03/201711/30/00108432115700____1__640x640.jpg", usuario),
                    new Producto("Xbox One X", 425.0f, "https://as01.epimg.net/meristation/imagenes/2018/06/06/noticia/1528263600_650394_1531812047_sumario_normal.jpg", usuario2),
                    new Producto("Trípode flexible", 10.0f, "https://static.carrefour.es/hd_510x_/imagenes/products/84310/46001/387/8431046001387/imagenGrande1.jpg", usuario2),
                    new Producto("Iphone 7 128 GB", 350.0f, "https://store.storeimages.cdn-apple.com/4667/as-images.apple.com/is/image/AppleInc/aos/published/images/i/ph/iphone7/rosegold/iphone7-rosegold-select-2016?wid=470&hei=556&fmt=jpeg&qlt=95&op_usm=0.5,0.5&.v=1472430205982", usuario2));

            listado.forEach(productoServicio::insertar);

        };
    }
}
