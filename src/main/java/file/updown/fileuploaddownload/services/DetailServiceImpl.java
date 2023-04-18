package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.*;
import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.repositories.DetailRepository;
import file.updown.fileuploaddownload.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    private DetailRepository detailRepository;
    private MessageRepository messageRepository;

    public DetailServiceImpl(DetailRepository detailRepository, MessageRepository messageRepository) {
        this.detailRepository = detailRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public List<String> getRecordList(Detail detail) {
        List<String> recContent = new ArrayList<>();
        String conteu = detail.getContent();
        Integer i = 0;
        Integer beginPos = 0;
        Integer endPos = 350;

        while (i < 5) {
            recContent.add(conteu.substring(beginPos, endPos));
            System.out.println(recContent.get(i));
            beginPos = endPos;
            endPos = endPos + 350;
            i++;

        }

        detail.getRecordsDetail().add(new Record(10));
        detailRepository.save(detail);


//        for (int j=0; i< recContent.size(); i++){
//            Integer type= Integer.valueOf(recContent.get(j).substring(0,2));
//            detail.getRecordsDetail().add(new Record(type));
//        }
//        detailRepository.save(detail);

        return recContent;
    }

    @Override
    public Detail retreiveDetail(Long id) {
        return detailRepository.findById(id).orElse(null);
    }

    @Override
    public List<Message> segregateDetail(Long id) {
        Detail segDetail = detailRepository.findById(id).orElse(null);
        List<String> recContent = getRecordList(segDetail);
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < segDetail.getRecordsDetail().size(); i++) {
            Record rec = segDetail.getRecordsDetail().get(i);
            for (int z = 0; z < rec.getZones().size(); z++) {
                Zone zoo = rec.getZones().get(z);
                String contenu = recContent.get(i).substring(zoo.getBeginPosition()-1, zoo.getEndPosition());
                Message msg = new Message(contenu, zoo);
                messageRepository.save(msg);
                messages.add(msg);

            }
        }
        segDetail.setMessagesDetail(messages);
        detailRepository.save(segDetail);
        return messages;
    }

    @Override
    public List<Detail> getAllDetails() {
        return detailRepository.findAll();
    }

}
