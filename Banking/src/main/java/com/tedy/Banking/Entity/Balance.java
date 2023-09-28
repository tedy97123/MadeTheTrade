package com.tedy.Banking.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "balances")
public class Balance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "available")
    private Double available;

    @Column(name = "current")
    private Double current;

    @Column(name = "stop")
    private Double stop;

}
