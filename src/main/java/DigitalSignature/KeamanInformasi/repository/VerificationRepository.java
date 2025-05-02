package DigitalSignature.KeamanInformasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import DigitalSignature.KeamanInformasi.model.VerificationResult;

@Repository
public interface VerificationRepository extends JpaRepository<VerificationResult, Long> {
    // Add custom queries if needed
}
