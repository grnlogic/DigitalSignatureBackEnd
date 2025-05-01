package DigitalSignature.KeamanInformasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DigitalSignature.KeamanInformasi.model.SignatureRecord;

public interface SignatureRepository extends JpaRepository<SignatureRecord, Long>  {
    
}
