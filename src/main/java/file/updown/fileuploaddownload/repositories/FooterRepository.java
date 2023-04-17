package file.updown.fileuploaddownload.repositories;

import file.updown.fileuploaddownload.entities.Footer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooterRepository extends JpaRepository<Footer, Long> {
}
