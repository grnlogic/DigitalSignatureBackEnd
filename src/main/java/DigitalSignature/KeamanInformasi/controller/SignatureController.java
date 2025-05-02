package DigitalSignature.KeamanInformasi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import DigitalSignature.KeamanInformasi.Service.SignatureService;
import DigitalSignature.KeamanInformasi.model.SignatureRecord;
import DigitalSignature.KeamanInformasi.model.SignatureRequest;
import DigitalSignature.KeamanInformasi.model.SignatureVerificationRequest;
import DigitalSignature.KeamanInformasi.model.VerificationResult;

@RestController
public class SignatureController {

    private final SignatureService service;

    public SignatureController(SignatureService service) {
        this.service = service;
    }

    @PostMapping("/sign")
    public ResponseEntity<SignatureRecord> signFile(@RequestBody SignatureRequest request) {
        try {
            SignatureRecord record = service.signFile(request.getFileData(), request.getFileName(), request.getSignedBy());
            return ResponseEntity.ok(record);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    
    @PostMapping("/verify")
    public ResponseEntity<VerificationResult> verifySignature(@RequestBody SignatureVerificationRequest request) {
        try {
            // Default values if not provided
            String fileName = request.getFileName() != null ? request.getFileName() : "unknown";
            String verifiedBy = request.getVerifiedBy() != null ? request.getVerifiedBy() : "anonymous";
            
            VerificationResult result = service.verify(
                request.getFileData(), 
                request.getDigitalSignature(),
                fileName,
                verifiedBy
            );
            
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            VerificationResult errorResult = new VerificationResult(
                "unknown", 
                request.getDigitalSignature(), 
                request.getFileData() != null ? (long) request.getFileData().length : 0L,
                "anonymous"
            );
            errorResult.setVerificationStatus(VerificationResult.Status.ERROR);
            errorResult.setMessage("Verification process failed: " + e.getMessage());
            errorResult.setTimestamp(java.time.LocalDateTime.now());
            
            return ResponseEntity.status(500).body(errorResult);
        }
    }
}
