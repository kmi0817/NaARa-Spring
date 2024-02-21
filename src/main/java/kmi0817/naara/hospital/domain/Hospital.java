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
    @JsonProperty("yadmNm")
    private String name;
    @JsonProperty("clCdNm")
    private String classification;
    @JsonProperty("addr")
    private String address;
    @JsonProperty("telno")
    private String telephone;
    @JsonProperty("hospUrl")
    private String url;
    @JsonProperty("estbDd")
    private String openingDate;
    @JsonProperty("drTotCnt")
    private int doctors;
    @JsonProperty("mdeptGdrCnt")
    private int generalMedicalCnt;
    @JsonProperty("mdeptIntnCnt")
    private int medicalInternCnt;
    @JsonProperty("mdeptResdntCnt")
    private int medicalResidentCnt;
    @JsonProperty("mdeptSdrCnt")
    private int medicalSpecialistCnt;
    @JsonProperty("detyGdrCnt")
    private int generalDentistCnt;
    @JsonProperty("detyIntnCnt")
    private int dentalInternCnt;
    @JsonProperty("detyResdntCnt")
    private int dentalResidentCnt;
    @JsonProperty("detySdrCnt")
    private int dentalSpecialistCnt;
    @JsonProperty("cmdcGdrCnt")
    private int generalOrientalCnt;
    @JsonProperty("cmdcIntnCnt")
    private int orientalInternCnt;
    @JsonProperty("cmdcResdntCnt")
    private int orientalResidentCnt;
    @JsonProperty("cmdcSdrCnt")
    private int orientalSpecialistCnt;

}
