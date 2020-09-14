package tech.gebel.javazoos.models;

import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Abstract class that adds standard auditing fields to tables that extend it
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class Auditable {
  /**
   * String field containing the username of who created this row
   */
  @CreatedBy
  protected String createdBy;

  /**
   * Date field containing the date and time when the row was created
   * <p>
   * Temporal(TIMESTAMP) - Sets the precision of the date being saved. In this case Date and Time
   */
  @CreatedDate
  @Temporal(TIMESTAMP)
  protected Date createdDate;

  /**
   * String field containing the username of who last modified this row
   */
  @LastModifiedBy
  protected String lastModifiedBy;

  /**
   * Date field containing the data and time when the row was last modified
   * <p>
   * Temporal(TIMESTAMP) - Sets the precision of the date being saved. In this case Date and Time
   */
  @LastModifiedDate
  @Temporal(TIMESTAMP)
  protected Date lastModifiedDate;
}
