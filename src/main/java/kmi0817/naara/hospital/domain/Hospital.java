package kmi0817.naara.hospital.domain;

import kmi0817.naara.hospital.SpecialtyCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class Hospital {

    private UUID id;
    private String name;
    private SpecialtyCode specialty;
    private String classification;
    private String address;
    private String telephone;
    private String url;
    private Date openingDate;
    private int doctors;
    private int generalMedicalCnt;
    private int medicalInternCnt;
    private int medicalResidentCnt;
    private int medicalSpecialistCnt;
    private int generalDentistCnt;
    private int dentalInternCnt;
    private int dentalResidentCnt;
    private int dentalSpecialistCnt;
    private int generalOrientalCnt;
    private int orientalInternCnt;
    private int orientalResidentCnt;
    private int orientalSpecialistCnt;

}
