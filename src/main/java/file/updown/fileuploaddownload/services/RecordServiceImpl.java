package file.updown.fileuploaddownload.services;

import com.sun.source.tree.WhileLoopTree;
import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.repositories.RecordRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RecordServiceImpl implements RecordService {
    private RecordRepository recordRepository;

    public RecordServiceImpl(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }



    @Override
    public Record retreiveRecord(Integer type) {
        return recordRepository.findById(type).orElse(null);
    }

    @Override
    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }


}
