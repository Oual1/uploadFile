package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.services.DetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailController {
    private  final DetailService detailService;

    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Detail> getDetailById(@PathVariable("id") Long id){

        Detail detail= detailService.retreiveDetail(id);
        if (detail==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(detail);
        }
    }
    @GetMapping("/detail-msg/{id}")
    public List<Message> getDetailSeg(@PathVariable("id") Long id) throws IOException {

        return detailService.segregateDetail(id);

    }

    @GetMapping()
    public List<Detail> getDetails(){
        return detailService.getAllDetails();
    }
}
