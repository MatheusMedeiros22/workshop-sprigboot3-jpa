package com.educandoweb.course.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;
    private OrderStatus orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;
//    private List<Product> items = new ArrayList<>();
//    private Payment payment;

    public Order(Long id, Instant moment, User user) {
        this.id = id;
        this.moment = moment;
        this.client = user;
    }

    public Double total(){
        return null;
    }

}
