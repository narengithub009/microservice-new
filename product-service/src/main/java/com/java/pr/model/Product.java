package com.java.pr.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Data
@Builder

public class Product {
    @Id

@GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
