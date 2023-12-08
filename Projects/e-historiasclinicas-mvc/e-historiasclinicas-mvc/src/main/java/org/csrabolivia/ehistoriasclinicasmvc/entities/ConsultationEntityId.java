package org.csrabolivia.ehistoriasclinicasmvc.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConsultationEntityId implements Serializable {
    private Integer idConsultation;
    private Integer idPatient;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConsultationEntityId that)) return false;
        return Objects.equals(idConsultation, that.idConsultation) && Objects.equals(idPatient, that.idPatient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idConsultation, idPatient);
    }
}
