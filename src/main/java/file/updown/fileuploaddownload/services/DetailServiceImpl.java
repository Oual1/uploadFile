package file.updown.fileuploaddownload.services;

import file.updown.fileuploaddownload.entities.Detail;
import file.updown.fileuploaddownload.entities.File;
import file.updown.fileuploaddownload.entities.Record;
import file.updown.fileuploaddownload.repositories.DetailRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    private DetailRepository detailRepository;

    public DetailServiceImpl(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @Override
    public List<String> getRecordList(Detail detail) {
        List<String> recContent= new ArrayList<>();
        String conteu= detail.getContent();
        Integer i=0;
        Integer beginPos=0;
        Integer endPos=350;

        while (i<5){
            recContent.add(conteu.substring(beginPos,endPos));
            System.out.println(recContent.get(i));
            beginPos=endPos;
            endPos=endPos+350;
            i++;

        }

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
}
