package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Record;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecordService {

    Record retreiveRecord(Integer id);
    List<Record>getAllRecords();

}
