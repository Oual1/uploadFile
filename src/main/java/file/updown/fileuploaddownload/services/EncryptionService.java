package file.updown.fileuploaddownload.services;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
public class EncryptionService {
    @Autowired(required = true)
    private StringEncryptor encryptor;

    public void encryptFile(String filePath) throws IOException {
        File file = new File(filePath);
        String fileContent = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        String encryptedContent = encryptor.encrypt(fileContent);
        Files.write(file.toPath(), encryptedContent.getBytes(StandardCharsets.UTF_8));
    }


    public void decryptFile(String filePath) throws IOException {
        File file = new File(filePath);
        String encryptedContent = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
        String decryptedContent = encryptor.decrypt(encryptedContent);
        Files.write(file.toPath(), decryptedContent.getBytes(StandardCharsets.UTF_8));
    }
}
