package file.updown.fileuploaddownload.repositories;

import file.updown.fileuploaddownload.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
}
