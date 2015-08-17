
package ec.edu.ug;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeController {
	
	
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    @RequestMapping("/list")
    public Map<String,Map<String, Object>> listAllPersons() {
    	Map<String,Map<String, Object>> personas=new HashMap<String,Map<String,Object>>();
    	Map<String, Object> personaN;
    	personaN=new HashMap<String, Object>();
    	personaN.put("nombres", "Joel Isaias");
    	personaN.put("apellidos", "Alvarado Torres");
    	personaN.put("identificacion", "0926983099");
    	personaN.put("edad",25);
    	personaN.put("fechaNacimiento",new GregorianCalendar(1990,0, 11).getTime());
    	personas.put("persona1",personaN);
    	personaN=new HashMap<String, Object>();
    	personaN.put("nombres", "Lisbeth Nathaly");
    	personaN.put("apellidos", "Colcha Morales");
    	personaN.put("identificacion", "0923432423");
    	personaN.put("edad",23);
    	personaN.put("fechaNacimiento",new GregorianCalendar(1992,6, 16).getTime().toString());
    	personas.put("persona2",personaN);
    	
        return personas;
    }
	
}
