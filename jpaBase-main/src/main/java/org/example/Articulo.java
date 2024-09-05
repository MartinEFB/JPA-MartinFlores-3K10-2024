package org.example;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@ToString
@Setter
@Getter
@Builder
@Entity
@Table(name = "Articulo")
public class Articulo {

    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "cantidad")
        private int cantidad;
        @Column(name = "denominacion")
        private String denominacion;
        @Column(name = "precio")
        private int precio;

        @OneToMany(mappedBy = "articulo")
        private List<DetalleFactura> detalleFacturas = new ArrayList<DetalleFactura>();

        @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(name = "articulo_categoria", joinColumns = @JoinColumn(name = "articulo_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id"))
        private List<Categoria> categorias = new ArrayList<Categoria>();

        public Articulo() {
        }
        public Articulo(int cantidad, String denominacion , int precio){
            this.cantidad = cantidad;
            this.denominacion = denominacion;
            this.precio = precio;
        }

}
