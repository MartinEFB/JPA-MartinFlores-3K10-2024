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
@Table(name = "Categoria")
public class Categoria {

    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column(name = "denominacion")
        private String denominacion;

        @ManyToMany(mappedBy = "categorias")
        private List<Articulo> articulos = new ArrayList<Articulo>();
        public Categoria() {}
        public Categoria(String denominacion){
            this.denominacion = denominacion;
        }


}
