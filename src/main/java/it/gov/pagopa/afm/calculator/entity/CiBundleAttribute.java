package it.gov.pagopa.afm.calculator.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.gov.pagopa.afm.calculator.model.TransferCategoryRelation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "CIBUNDLEATTRIBUTE", schema = "AFM_CALCULATOR")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CiBundleAttribute {

    @Id
    private String id;

    private Long maxPaymentAmount;

    private String transferCategory;

    @Enumerated(EnumType.STRING)
    private TransferCategoryRelation transferCategoryRelation;

}
