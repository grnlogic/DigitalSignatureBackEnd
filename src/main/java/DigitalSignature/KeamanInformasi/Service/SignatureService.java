package DigitalSignature.KeamanInformasi.Service;

import java.security.KeyPair;
import java.time.LocalDateTime;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import DigitalSignature.KeamanInformasi.util.CryptoUtil;

@Service
public class SignatureService {

    private final KeyPair keyPair;

    public SignatureService() throws Exception {
        this.keyPair = CryptoUtil.generateKeyPair();
    }

    public DigitalSignature.KeamanInformasi.model.SignatureRecord signFile(byte[] fileBytes, String fileName, String signedBy) throws Exception {
        String signature = CryptoUtil.signData(fileBytes, keyPair.getPrivate());

        DigitalSignature.KeamanInformasi.model.SignatureRecord record = new DigitalSignature.KeamanInformasi.model.SignatureRecord();
        record.setOriginalFileName(fileName);
        record.setDigitalSignature(signature);
        record.setSignedAt(LocalDateTime.now());
        record.setSignedBy(signedBy);

        return record;
    }

    // Keep the existing method for backward compatibility
    public DigitalSignature.KeamanInformasi.model.SignatureRecord signFile(MultipartFile file, String signedBy) throws Exception {
        return signFile(file.getBytes(), file.getOriginalFilename(), signedBy);
    }

    public boolean verify(byte[] fileData, String digitalSignatureBase64) throws Exception {
        byte[] signatureBytes = Base64.getDecoder().decode(digitalSignatureBase64);
        return CryptoUtil.verifySignature(fileData, signatureBytes, getPublicKey());
    }

    private java.security.PublicKey getPublicKey() throws Exception {
        // Use the public key from our KeyPair for demonstration
        // In a real application, this would likely be stored or retrieved from a secure location
        return keyPair.getPublic();
    }

    public void someMethod() {
        DigitalSignature.KeamanInformasi.model.SignatureRecord record = new DigitalSignature.KeamanInformasi.model.SignatureRecord();
        // ...
    }

}
