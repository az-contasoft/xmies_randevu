package az.contasoft.xmies_randevu.proxy;

import az.contasoft.xmies_randevu.proxy.entity.Note;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "xmies_note")
public interface NoteProxy {

    @PostMapping("/xmies_note/crudServices/add")
    ResponseEntity<Note> saveNote(@RequestBody Note note);
}