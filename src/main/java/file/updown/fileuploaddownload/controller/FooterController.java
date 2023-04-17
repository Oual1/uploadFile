package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.File;
import file.updown.fileuploaddownload.entities.Footer;
import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.services.FileService;
import file.updown.fileuploaddownload.services.FooterService;
import file.updown.fileuploaddownload.services.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/footers")
public class FooterController {
    private final FooterService footerService;
    private final FileService fileService;
    private final MessageService messageService;

    public FooterController(FooterService footerService, FileService fileService, MessageService messageService) {
        this.footerService = footerService;
        this.fileService = fileService;
        this.messageService = messageService;
    }
    @GetMapping("/footer-msg/{id}")
    public List<Message> getFooterSeg(@PathVariable("id") Long id) throws IOException {

        return footerService.segregateFooter(id);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Footer> getFooterById(@PathVariable("id") Long id){

         Footer footer= footerService.retreiveFooter(id);
        if (footer==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(footer);
        }
    }
    @GetMapping()
    public List<Footer> getFooters(){
        return footerService.getAllFooters();
    }



}
