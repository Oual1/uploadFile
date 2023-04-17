package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.services.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/records")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping()
    public List<Record> getRecords(){
        return recordService.getAllRecords();
    }

    @GetMapping("/{type}")
    public ResponseEntity<Record> getRecordById(@PathVariable("type") Integer type){

        Record rec= recordService.retreiveRecord(type);
        if (rec==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(rec);
        }
    }
}
