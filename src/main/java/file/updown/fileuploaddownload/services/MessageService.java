package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Message;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface MessageService {
    List<Message> getAllMessages();
    Message saveMessage(Message message);
    Message retreiveMessage(Long id);
}
