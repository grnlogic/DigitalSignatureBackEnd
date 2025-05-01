package DigitalSignature.KeamanInformasi.model;

public class SignatureVerificationRequest {
    private byte[] fileData;
    private String digitalSignature;

    // Getter dan Setter
    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getDigitalSignature() {
        return digitalSignature;
    }

    public void setDigitalSignature(String digitalSignature) {
        this.digitalSignature = digitalSignature;
    }
}
