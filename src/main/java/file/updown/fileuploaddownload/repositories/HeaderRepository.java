package file.updown.fileuploaddownload.repositories;

import file.updown.fileuploaddownload.entities.Header;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeaderRepository extends JpaRepository<Header, Long> {
}
