package file.updown.fileuploaddownload.controller;

import file.updown.fileuploaddownload.entities.Message;
import file.updown.fileuploaddownload.message.ResponseMessage;
import file.updown.fileuploaddownload.services.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping()
    public List<Message> getmessages(){
        return messageService.getAllMessages();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable("id") Long id){

            Message msg =messageService.retreiveMessage(id);
        if (msg==null){
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok().body(msg);
        }
    }

}
