package file.updown.fileuploaddownload.repositories;

import file.updown.fileuploaddownload.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {

}
