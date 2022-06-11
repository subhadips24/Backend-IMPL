package com.ipm.api.unknowncustomersms;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnknownSmsRepo  extends JpaRepository<UnknownSms, Long>{
}
