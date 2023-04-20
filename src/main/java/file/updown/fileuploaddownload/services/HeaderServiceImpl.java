package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Header;
import file.updown.fileuploaddownload.repositories.HeaderRepository;
import file.updown.fileuploaddownload.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {
    private HeaderRepository headerRepository;
    private MessageRepository messageRepository;

    public HeaderServiceImpl(HeaderRepository headerRepository, MessageRepository messageRepository) {
        this.headerRepository = headerRepository;
        this.messageRepository=messageRepository;
    }

    @Override
    public List<Header> segregateHeader(Long id) throws IOException {
        return null;
    }

    @Override
    public Header retreiveHeader(Long id) {
        return null;
    }

    @Override
    public List<String> getRecordList(Header header) {
        return null;
    }

    @Override
    public List<Header> getAllHeaders() {
        return null;
    }
}
