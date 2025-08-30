package com.estopa.ecommerce.model;

import com.estopa.ecommerce.model.enu.StatusPedido;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table (name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    @ManyToOne
    @JoinColumn (name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido",
            cascade = CascadeType.ALL,
             orphanRemoval = true)
    private List<ItemPedido> itemPedidoList;

}
