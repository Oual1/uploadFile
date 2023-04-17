package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.services.DetailService;
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

    @GetMapping("/detail_rec/{id}")
    public List<String> getRec(@PathVariable("id") Long id) throws IOException {
        Detail det= detailService.retreiveDetail(id);

        return detailService.getRecordList(det);

    }
}
