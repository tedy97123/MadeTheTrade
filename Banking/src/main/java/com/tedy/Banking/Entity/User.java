package com.tedy.Banking.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name ="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String alternativePhoneNumber;

    private String gender;

    private String country;

    private String state;

    private String address;

    private Date birthDay;

    private String password;

    private String accountNumber;

    private String status;

    private BigDecimal accountBalance;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime modifiedAt;

}
