package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.*;
import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.enums.FileType;
import file.updown.fileuploaddownload.repositories.HeaderRepository;
import file.updown.fileuploaddownload.repositories.MessageRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HeaderServiceImpl implements HeaderService {
    private HeaderRepository headerRepository;
    private MessageRepository messageRepository;
    private RecordService recordService;

    public HeaderServiceImpl(HeaderRepository headerRepository, MessageRepository messageRepository) {
        this.headerRepository = headerRepository;
        this.messageRepository=messageRepository;
    }

    @Override
    public List<Message> segregateHeader(Long id) throws IOException {
        Header segHeader= headerRepository.findById(id).orElse(null);
        List<String> recContent = getRecordList(segHeader);
        List<Message> messages= new ArrayList<>();

        for (int i=0; i<segHeader.getRecordsHeader().size(); i++) {
            Record rec= segHeader.getRecordsHeader().get(i);
            for (int z = 0; z < rec.getZones().size(); z++) {
                Zone zoo = rec.getZones().get(z);
                String contenu= recContent.get(i).substring(zoo.getBeginPosition()-1, zoo.getEndPosition());

                Message msg= new Message(contenu, zoo);
                messageRepository.save(msg);
                messages.add(msg);
            }
        }

        segHeader.setMessagesHeader(messages);
        headerRepository.save(segHeader);


        return messages;
    }

    @Override
    public Header retreiveHeader(Long id) {
        return headerRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getRecordList(Header header) {
        List<String> recContent= new ArrayList<>();
        String content= header.getContent();

        String secondRec="";
        String firstRec= content.substring(0,67);

        if (header.getFileHeader().getType()== FileType.BORDEREAU_FACTURATION || header.getFileHeader().getType()==FileType.REFUS_BORDEREAUX){

            secondRec=content.substring(67,227);
        }else {

            secondRec=content.substring(67, 676);
        }
        recContent.add(firstRec);
        recContent.add(secondRec);


        header.getRecordsHeader().add(recordService.retreiveRecord(200));
            header.getRecordsHeader().add(recordService.retreiveRecord(300));

        headerRepository.save(header);

        return recContent;

    }

    @Override
    public List<Header> getAllHeaders() {
        return headerRepository.findAll();
    }
}
