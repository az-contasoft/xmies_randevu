package az.contasoft.xmies_randevu.util;

import az.contasoft.xmies_randevu.db.entity.Randevu;
import com.hazelcast.config.Config;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {


    private final HazelcatMapConfigurations hazelcatMapConfigurations;

    public HazelcastConfiguration(HazelcatMapConfigurations hazelcatMapConfigurations) {
        this.hazelcatMapConfigurations = hazelcatMapConfigurations;
    }



    @Bean
    public Config config() {
        Config config = new Config();
        NetworkConfig network = config.getNetworkConfig();
        network.getJoin().getMulticastConfig().setEnabled(false);
        network.getJoin().getTcpIpConfig().setEnabled(true);
        network.setPortAutoIncrement(true);
        network.setPort(33001);
        network.getJoin().getTcpIpConfig().addMember("127.0.0.1");
        return config;
    }

    @Bean
    public HazelcastInstance instance(Config config) {
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<Long, Randevu> mapOfRandevu (HazelcastInstance instance){
        return instance.getMap(hazelcatMapConfigurations.getMapOfRandevu());
    }
}

