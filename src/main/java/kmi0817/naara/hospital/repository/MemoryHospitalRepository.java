package kmi0817.naara.hospital.repository;

import jakarta.annotation.PostConstruct;
import kmi0817.naara.hospital.domain.Hospital;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MemoryHospitalRepository implements HospitalRepository {

    private final Map<UUID, Hospital> store = new ConcurrentHashMap<>();

    @Override
    public Hospital save(Hospital hospital) {
        UUID id = UUID.randomUUID();
        hospital.setId(id);
        store.put(hospital.getId(), hospital);
        return hospital;
    }

    @Override
    public Hospital update(UUID id, Hospital hospital) {
        Hospital findHospital = store.get(id);

        log.info("before : findHospital = {}", findHospital);

        if (hospital.getName() != null) {
            findHospital.setName(hospital.getName());
        }

        if (hospital.getClassification() != null) {
            findHospital.setClassification(hospital.getClassification());
        }

        if (hospital.getAddress() != null) {
            findHospital.setAddress(hospital.getAddress());
        }

        if (hospital.getTelephone() != null) {
            findHospital.setTelephone(hospital.getTelephone());
        }

        if (hospital.getUrl() != null) {
            findHospital.setUrl(hospital.getUrl());
        }

        if (hospital.getOpeningDate() != null) {
            findHospital.setOpeningDate(hospital.getOpeningDate());
        }

        if (hospital.getDoctors() != null) {
            findHospital.setDoctors(hospital.getDoctors());
        }

        if (hospital.getGeneralMedicalCnt() != null) {
            findHospital.setGeneralMedicalCnt(hospital.getGeneralMedicalCnt());
        }

        if (hospital.getMedicalInternCnt() != null) {
            findHospital.setMedicalInternCnt(hospital.getMedicalInternCnt());
        }

        if (hospital.getMedicalResidentCnt() != null) {
            findHospital.setMedicalResidentCnt(hospital.getMedicalResidentCnt());
        }

        if (hospital.getMedicalSpecialistCnt() != null) {
            findHospital.setMedicalSpecialistCnt(hospital.getMedicalSpecialistCnt());
        }

        if (hospital.getGeneralDentistCnt() != null) {
            findHospital.setGeneralDentistCnt(hospital.getGeneralDentistCnt());
        }

        if (hospital.getDentalInternCnt() != null) {
            findHospital.setDentalInternCnt(hospital.getDentalInternCnt());
        }

        if (hospital.getDentalResidentCnt() != null) {
            findHospital.setDentalResidentCnt(hospital.getDentalResidentCnt());
        }

        if (hospital.getDentalSpecialistCnt() != null) {
            findHospital.setDentalSpecialistCnt(hospital.getDentalSpecialistCnt());
        }

        if (hospital.getGeneralOrientalCnt() != null) {
            findHospital.setGeneralOrientalCnt(hospital.getGeneralOrientalCnt());
        }

        if (hospital.getOrientalInternCnt() != null) {
            findHospital.setOrientalInternCnt(hospital.getOrientalInternCnt());
        }

        if (hospital.getOrientalResidentCnt() != null) {
            findHospital.setOrientalResidentCnt(hospital.getOrientalResidentCnt());
        }

        if (hospital.getOrientalSpecialistCnt() != null) {
            findHospital.setOrientalSpecialistCnt(hospital.getOrientalSpecialistCnt());
        }

        log.info("after : findHospital = {}", findHospital);
        return findHospital;
    }

    @Override
    public Optional<Hospital> findOneById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Hospital> findOneByAddress(String address) {
        return store.values().stream()
                .filter(hospital -> hospital.getAddress().equals(address))
                .findAny();
    }

    @Override
    public List<Hospital> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }

    // 개발 편의를 위해 OpenAPI 호출 없이 미리 등록하는 데이터
    @PostConstruct
    public void init() {
        Hospital hospital1 = new Hospital();
        hospital1.setName("(신)제일병원");
        hospital1.setAddress("충청남도 보령시 대해로 52, (궁촌동)");
        hospital1.setTelephone("041-931-8330");
        hospital1.setOpeningDate("20050127");
        hospital1.setDoctors(4);
        hospital1.setClassification("병원");

        Hospital hospital2 = new Hospital();
        hospital2.setName("22세기서울치과병원");
        hospital2.setAddress("인천광역시 연수구 컨벤시아대로 69, 415호 (송도동, 송도 밀레니엄)");
        hospital2.setTelephone("032-858-2080");
        hospital2.setOpeningDate("20171018");
        hospital2.setDoctors(4);
        hospital2.setClassification("치과병원");

        Hospital hospital3 = new Hospital();
        hospital3.setName("강동기운찬한방병원");
        hospital3.setAddress("서울특별시 강동구 천호대로 1133, 서울M타워 5,8,9,10층 (길동)");
        hospital3.setTelephone("02-474-8575");
        hospital3.setOpeningDate("20230324");
        hospital3.setDoctors(5);
        hospital3.setClassification("한방병원");

        Hospital hospital4 = new Hospital();
        hospital4.setName("21C프라자내과의원");
        hospital4.setAddress("경기도 성남시 수정구 수정로 106, 503호 (수진동)");
        hospital4.setTelephone("31-721-3813");
        hospital4.setOpeningDate("20070601");
        hospital4.setDoctors(1);
        hospital4.setClassification("의원");

        save(hospital1);
        save(hospital2);
        save(hospital3);
        save(hospital4);
    }
}
