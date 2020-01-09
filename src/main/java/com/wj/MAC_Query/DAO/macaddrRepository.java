package com.wj.MAC_Query.DAO;

import com.wj.MAC_Query.entity.macAddr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface macaddrRepository extends JpaRepository<macAddr, Integer> {
     macAddr findByMacaddr(String macAddr);
}
