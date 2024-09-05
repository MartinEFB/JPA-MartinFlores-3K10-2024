package org.example;


import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Entity
@Table(name = "Domicilio")
public class Domicilio implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "nombreCalle")
        private String nombreCalle;
        @Column(name = "numero", unique = true)
        private int numero;

        @OneToOne(mappedBy = "domicilio")
        private Cliente cliente;

        public Domicilio() {
        }
        public Domicilio(String nombreCalle, int numero){
            this.nombreCalle = nombreCalle;
            this.numero = numero;
        }
        public Domicilio(String nombreCalle, int numero, Cliente cliente) {
            this.nombreCalle = nombreCalle;
            this.numero = numero;
            this.cliente = cliente;
         }

}
