package by.gsu.pms.lr12.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long certificateId;
    private String title;
    private String description;
    private String issuedBy;
    @ManyToMany(mappedBy = "certificates")
    private Set<User> users = new HashSet<>();
}
