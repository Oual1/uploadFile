package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Header;
import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.services.HeaderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/headers")
public class HeaderController {
    private  final HeaderService headerService;

    public HeaderController(HeaderService headerService) {
        this.headerService = headerService;
    }

    @GetMapping("/header-msg/{id}")
    public List<Message> getHeaderSeg(@PathVariable("id") Long id) throws IOException {

        return headerService.segregateHeader(id);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Header> getHeaderById(@PathVariable("id") Long id){

        Header header= headerService.retreiveHeader(id);
        if (header==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(header);
        }
    }
    @GetMapping()
    public List<Header> getHeaders(){
        return headerService.getAllHeaders();
    }

    @GetMapping("/headerRec/{id}")
    public List<String> getRecords(@PathVariable("id") Long id) throws IOException {
        Header header= headerService.retreiveHeader(id);

        return headerService.getRecordList(header);

    }

}
