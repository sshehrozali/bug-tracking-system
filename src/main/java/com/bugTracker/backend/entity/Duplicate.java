package com.bugTracker.backend.entity;

import com.bugTracker.backend.entity.Bug;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Duplicate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime markedAt;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bugId", referencedColumnName = "id")
    private Bug bug;
}
