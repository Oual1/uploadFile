package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll() ;
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);

    }

    @Override
    public Message retreiveMessage(Long id) {
        return messageRepository.findById(id).orElse(null);
    }
}
