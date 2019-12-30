package com.wj.MAC_Query;

import com.wj.MAC_Query.entity.macAddr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface macaddrRepository extends JpaRepository<macAddr, Integer> {
}
