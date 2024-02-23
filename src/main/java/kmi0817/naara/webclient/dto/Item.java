package kmi0817.naara.webclient.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

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
    private Integer doctors;
    @JsonProperty("mdeptGdrCnt")
    private Integer generalMedicalCnt;
    @JsonProperty("mdeptIntnCnt")
    private Integer medicalInternCnt;
    @JsonProperty("mdeptResdntCnt")
    private Integer medicalResidentCnt;
    @JsonProperty("mdeptSdrCnt")
    private Integer medicalSpecialistCnt;
    @JsonProperty("detyGdrCnt")
    private Integer generalDentistCnt;
    @JsonProperty("detyIntnCnt")
    private Integer dentalInternCnt;
    @JsonProperty("detyResdntCnt")
    private Integer dentalResidentCnt;
    @JsonProperty("detySdrCnt")
    private Integer dentalSpecialistCnt;
    @JsonProperty("cmdcGdrCnt")
    private Integer generalOrientalCnt;
    @JsonProperty("cmdcIntnCnt")
    private Integer orientalInternCnt;
    @JsonProperty("cmdcResdntCnt")
    private Integer orientalResidentCnt;
    @JsonProperty("cmdcSdrCnt")
    private Integer orientalSpecialistCnt;

}
