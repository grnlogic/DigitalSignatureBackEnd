package DigitalSignature.KeamanInformasi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import DigitalSignature.KeamanInformasi.Service.SignatureService;
import DigitalSignature.KeamanInformasi.model.SignatureRecord;
import DigitalSignature.KeamanInformasi.model.SignatureRequest;
import DigitalSignature.KeamanInformasi.model.SignatureVerificationRequest;

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
    public ResponseEntity<String> verifySignature(@RequestBody SignatureVerificationRequest request) {
        try {
            boolean isValid = service.verify(request.getFileData(), request.getDigitalSignature());
            return ResponseEntity.ok(isValid ? "Valid Signature" : "Invalid Signature");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Verification failed: " + e.getMessage());
        }
    }
}
