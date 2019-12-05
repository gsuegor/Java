package by.gsu.pms.lr12.repo;

import by.gsu.pms.lr12.domain.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertificateRepo extends JpaRepository<Certificate, Long> {
    @Query(
            value = "SELECT certificate.certificate_id, description, issued_by, title FROM certificate " +
            "INNER JOIN users_certificates on certificate.certificate_id = users_certificates.certificate_id WHERE user_id = ?;",
            nativeQuery = true)
    List<Certificate> findAllByUserId(Long userId);
}
