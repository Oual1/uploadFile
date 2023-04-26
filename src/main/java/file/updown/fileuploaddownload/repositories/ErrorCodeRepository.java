package file.updown.fileuploaddownload.repositories;

import file.updown.fileuploaddownload.entities.ErrorCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErrorCodeRepository extends JpaRepository<ErrorCode, String> {
}
