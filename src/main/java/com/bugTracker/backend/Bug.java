package com.bugTracker.backend;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Bug {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bugMessage;
    @OneToOne
    private Duplicate duplicate;
}
