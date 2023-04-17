package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.File;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface DetailService {
    List<String> getRecordList(Detail detail);
    Detail retreiveDetail(Long id);
}
