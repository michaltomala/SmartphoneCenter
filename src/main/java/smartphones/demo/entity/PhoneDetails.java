package smartphones.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@NoArgsConstructor
public class PhoneDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private boolean isFlagship;

    @NotNull
    private boolean isExFlagship;

    @OneToOne
    @NotNull
    private Phone phone;

}

