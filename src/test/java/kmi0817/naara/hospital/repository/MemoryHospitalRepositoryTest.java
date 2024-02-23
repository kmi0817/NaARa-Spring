package kmi0817.naara.hospital.repository;

import kmi0817.naara.hospital.domain.Hospital;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryHospitalRepositoryTest {

    MemoryHospitalRepository repository = new MemoryHospitalRepository();

    @AfterEach
    void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        // given
        Hospital hospital = new Hospital();
        hospital.setName("(신)제일병원");
        hospital.setAddress("충청남도 보령시 대해로 52, (궁촌동)");
        hospital.setTelephone("041-931-8330");
        hospital.setOpeningDate("20050127");
        hospital.setDoctors(4);
        hospital.setClassification("병원");

        // when
        repository.save(hospital);

        // then
            // findHospital은 당연히 존재하므로 get()으로 Optional 내부 객체를 꺼낸다
        Hospital findHospital = repository.findOneById(hospital.getId()).get();
        assertThat(findHospital).isEqualTo(hospital);
    }

    @Test
    void update() {
        // given
        Hospital hospital = new Hospital();
        hospital.setName("(신)제일병원");
        hospital.setAddress("충청남도 보령시 대해로 52, (궁촌동)");
        hospital.setTelephone("041-931-8330");
        hospital.setOpeningDate("20050127");
        hospital.setDoctors(4);
        hospital.setClassification("병원");
        repository.save(hospital);

        // when
        UUID id = hospital.getId();

        Hospital updatedHospital = new Hospital();
        updatedHospital.setAddress("주소가 너무 길어요");
        updatedHospital.setTelephone("041-000-0000");
        repository.update(id, updatedHospital);

        // then
        Hospital findHospital = repository.findOneById(id).get();
        assertThat(findHospital).isEqualTo(hospital);
        assertThat(findHospital.getAddress()).isEqualTo(updatedHospital.getAddress());
        assertThat(findHospital.getTelephone()).isEqualTo(updatedHospital.getTelephone());
    }

    @Test
    void findOneByAddress() {
        // given
        String address = "충청남도 보령시 대해로 52, (궁촌동)";
        Hospital hospital = new Hospital();
        hospital.setName("(신)제일병원");
        hospital.setAddress(address);
        hospital.setTelephone("041-931-8330");
        hospital.setOpeningDate("20050127");
        hospital.setDoctors(4);
        hospital.setClassification("병원");

        // when
        repository.save(hospital);

        // then
        Hospital findHospital = repository.findOneByAddress(address).get();
        assertThat(findHospital).isEqualTo(hospital);
    }

    @Test
    void findAll() {
        // given
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

        // when
        repository.save(hospital1);
        repository.save(hospital2);

        // then
        List<Hospital> hospitals = repository.findAll();
        assertThat(hospitals.size()).isEqualTo(2);
        assertThat(hospitals).contains(hospital1, hospital2);
    }
}