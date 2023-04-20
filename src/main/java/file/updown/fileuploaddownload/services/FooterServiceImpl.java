package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.*;
import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.enums.FileState;
import file.updown.fileuploaddownload.enums.FileType;
import file.updown.fileuploaddownload.repositories.FooterRepository;
import file.updown.fileuploaddownload.repositories.MessageRepository;
import file.updown.fileuploaddownload.repositories.RecordRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class FooterServiceImpl implements FooterService {
    private FooterRepository footerRepository;

    private MessageRepository messageRepository;

    public FooterServiceImpl(FooterRepository footerRepository, MessageRepository messageRepository) {
        this.footerRepository = footerRepository;

        this.messageRepository = messageRepository;
    }



    @Override
    public Footer saveFooter(Footer footer) {
        return footerRepository.save(footer);
    }

    @Override
    public List<Message> segregateFooter(Long id) throws IOException {
        Footer segFooter= footerRepository.findById(id).orElse(null);
        List<String> recContent = getRecordList(segFooter);
        List<Message> messages= new ArrayList<>();

        for (int i=0; i<segFooter.getRecordFooter().size(); i++) {
            Record rec= segFooter.getRecordFooter().get(i);
                for (int z = 0; z < rec.getZones().size(); z++) {
                    Zone zoo = rec.getZones().get(z);
                    String contenu= recContent.get(i).substring(zoo.getBeginPosition()-1, zoo.getEndPosition());

                    Message msg= new Message(contenu, zoo);
                    messageRepository.save(msg);
                    messages.add(msg);
                }
            }

        segFooter.setMessagesFooter(messages);
        footerRepository.save(segFooter);




        return messages;
    }

    @Override
    public Footer retreiveFooter(Long id) {
        return footerRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getRecordList(Footer footer) {
        List<String> recContent= new ArrayList<>();
        String content= footer.getContent();
        String firstRec= content.substring(0,350);
        String secondRec=content.substring(350,700);
        recContent.add(firstRec);
        recContent.add(secondRec);
        String sub= content.substring(0,2);
        if (sub.equals("95")){

            footer.getRecordFooter().add(new Record(95));
            footer.getRecordFooter().add(new Record(96));
        }else {
            footer.getRecordFooter().add(new Record(91));
            footer.getRecordFooter().add(new Record(92));
        }
        footerRepository.save(footer);

        return recContent;

    }

    @Override
    public List<Footer> getAllFooters() {
        return footerRepository.findAll();
    }


}


