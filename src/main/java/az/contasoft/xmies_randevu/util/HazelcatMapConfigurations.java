package az.contasoft.xmies_randevu.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Deprecated
@Configuration
public class HazelcatMapConfigurations {


    @Value("${hazelcast.map.mapOfRandevu}")
    private String mapOfRandevu;


    public HazelcatMapConfigurations() {
    }

    public String getMapOfRandevu() {
        return mapOfRandevu;
    }

    public void setMapOfRandevu(String mapOfRandevu) {
        this.mapOfRandevu = mapOfRandevu;
    }
}
