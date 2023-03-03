package com.baha.TrainingPlatformEE.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.apache.logging.log4j.CloseableThreadContext;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Data
@MappedSuperclass
public class AbstractEntity implements Serializable {

}
