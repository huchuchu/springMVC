package hello.springtx.apply;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sound.midi.Track;

@SpringBootTest
public class InitTxTest {

    @Slf4j
    static class Hello{

        @Transactional
        @PostConstruct
        public void InitV1(){

            boolean isActive = TransactionSynchronizationManager.isActualTransactionActive();
            log.info("Hello init @PostConstruct tx active={}", isActive);

        }
        public void InitV2(){

        }

    }
}
