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
    private Integer bugId;
    private String bugMessage;
}
