package az.contasoft.xmies_randevu.util;

import az.contasoft.xmies_randevu.db.entity.Randevu;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {
    @Bean
    public Config config() {
        return new Config();
    }

    @Bean
    public HazelcastInstance instance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<Long, Randevu> mapOfRandevu (HazelcastInstance instance){
        return instance.getMap("mapOfRandevu");
    }
}
