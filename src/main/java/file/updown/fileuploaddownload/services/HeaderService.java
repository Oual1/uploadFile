package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Header;
import file.updown.fileuploaddownload.entities.Message;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface HeaderService {
    List<Header> segregateHeader(Long id) throws IOException;
    Header retreiveHeader(Long id);
    List<String> getRecordList(Header header);
    List<Header> getAllHeaders();
}
