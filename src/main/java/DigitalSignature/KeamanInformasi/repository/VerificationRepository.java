package DigitalSignature.KeamanInformasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import DigitalSignature.KeamanInformasi.model.VerificationResult;

public interface VerificationRepository extends JpaRepository<VerificationResult, Long> {
    // Add custom queries if needed
}
