package kmi0817.naara.hospital.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Hospital {

    private UUID id;
    private String name;
    private String classification;
    private String address;
    private String telephone;
    private String url;
    private String openingDate;
    private Integer doctors;
    private Integer generalMedicalCnt;
    private Integer medicalInternCnt;
    private Integer medicalResidentCnt;
    private Integer medicalSpecialistCnt;
    private Integer generalDentistCnt;
    private Integer dentalInternCnt;
    private Integer dentalResidentCnt;
    private Integer dentalSpecialistCnt;
    private Integer generalOrientalCnt;
    private Integer orientalInternCnt;
    private Integer orientalResidentCnt;
    private Integer orientalSpecialistCnt;

}
