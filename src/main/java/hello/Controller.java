package hello;

import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @CrossOrigin(origins = "http://localhost", allowedHeaders = "Access-Control-Allow-Origin")
    @RequestMapping(value = "/getvariants")
    @ResponseBody
    public EntryList getvariants(@RequestParam(value="word", defaultValue="Siva") String word) {
        SortedSet<Entry> test = new ConcurrentSkipListSet<>();
        Handler h = new Handler();
        //test.add(new Entry(new Integer(1),"test","test","test", "body html"));
        EntryList el = new  EntryList(h.handle(word));
        return el;
       /* 
        Handler h = new Handler();
        return h.handle(word);
        String result = h.handle(word);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("result="+result);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return result;
*/
    }
}
