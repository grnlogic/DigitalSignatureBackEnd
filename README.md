# Digital Signature Application

A Spring Boot application that provides digital signature functionality for secure document signing and verification.

## Overview

This application allows users to:
- Generate digital signatures for files
- Verify the authenticity of signed documents
- Store signature records in a database

Digital signatures are a critical component of information security, especially in cryptography. They provide authenticity, integrity, and non-repudiation of digital documents.

## Technologies

- Java 17
- Spring Boot 3.2.4
- Spring Data JPA
- H2 Database (development)
- PostgreSQL (production)
- RSA Cryptography for Signatures
- Swagger/OpenAPI for API documentation

## Getting Started

### Prerequisites

- JDK 17 or higher
- Maven 3.6 or higher
- PostgreSQL (for production deployment)

### Setup

1. Clone the repository:
   ```bash
   git clone [repository-url]
   cd KeamanInformasi
   ```

2. Build the application:
   ```bash
   ./mvnw clean install
   ```

3. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

4. Access the application:
   - API: http://localhost:8080
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - H2 Console: http://localhost:8080/h2-console (development only)

## API Endpoints

### Sign a File
- **Endpoint**: `POST /sign`
- **Request Body**: JSON containing file data, file name, and signer information
- **Response**: Signature record including the digital signature

### Verify a Signature
- **Endpoint**: `POST /verify`
- **Request Body**: JSON containing file data and digital signature
- **Response**: Verification result ("Valid Signature" or "Invalid Signature")

## How Digital Signatures Work

This application uses RSA cryptography for digital signatures:

1. **Key Generation**: The application generates a public-private key pair when it starts
2. **Signing Process**: 
   - The private key signs the file data (SHA-256 hash)
   - The signature is stored in a database along with metadata
3. **Verification Process**:
   - The public key verifies the signature against the file data
   - If the signature matches, the file is verified as authentic and unchanged

## Security Considerations

- The private key is generated at application startup and not persisted
- In a production environment, proper key management should be implemented
- For highest security, consider using a Hardware Security Module (HSM)

## Database Schema

The application uses the following database entity:

**SignatureRecord**:
- `id`: Unique identifier
- `originalFileName`: Name of the signed file
- `digitalSignature`: The cryptographic signature (Base64 encoded)
- `signedAt`: Timestamp of when the file was signed
- `signedBy`: Information about who signed the file

## Development

### Adding New Features

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request
