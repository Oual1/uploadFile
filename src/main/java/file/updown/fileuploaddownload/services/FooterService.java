package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.File;
import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.entities.Record;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public interface FooterService {

    Footer saveFooter(Footer footer);
    List<Message> segregateFooter(Long id) throws IOException;
    Footer retreiveFooter(Long id);
    List<String> getRecordList(Footer footer);
    List<Footer> getAllFooters();



}
