package kmi0817.naara.hospital.repository;

import kmi0817.naara.hospital.domain.Hospital;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HospitalRepository {

    Hospital save(Hospital hospital);
    Hospital update(UUID id, Hospital hospital);
    Optional<Hospital> findOneById(UUID id);
    Optional<Hospital> findOneByAddress(String address);
    List<Hospital> findAll();
}
