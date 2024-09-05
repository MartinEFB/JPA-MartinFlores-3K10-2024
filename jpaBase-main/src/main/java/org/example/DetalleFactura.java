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
@Table(name = "DetalleFactura")
public class DetalleFactura implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "cantidad")
        private int cantidad;
        @Column(name = "subtotal")
        private int subtotal;

        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "fk_articulo")
        private Articulo articulo;

        @ManyToOne(cascade = CascadeType.PERSIST)
        @JoinColumn(name = "detalle_fk_factura")
        private Factura factura;

        public DetalleFactura() {
        }
        public DetalleFactura(int cantidad, int subtotal) {
            this.cantidad = cantidad;
            this.subtotal = subtotal;
        }
        public DetalleFactura(int cantidad, int subtotal, Factura factura) {
            this.cantidad = cantidad;
            this.subtotal = subtotal;
            this.factura = factura;
        }


}
