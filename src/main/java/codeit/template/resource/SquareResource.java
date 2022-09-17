package codeit.template.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SquareResource {
    Logger logger = LoggerFactory.getLogger(SquareResource.class);

   @RequestMapping(value = "square",method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer calculateSquare(@RequestBody Map<String, String> body){
       Integer value = Integer.parseInt(body.get("input"));
       logger.info("My Result--> {}",value);
       return value* value;
    }
}
