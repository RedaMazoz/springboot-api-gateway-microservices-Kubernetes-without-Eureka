package ma.quantorion.appquitue.personalrest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ma.quantorion.appquitue.personalrest.domain.Condamnation;
import ma.quantorion.appquitue.personalrest.domain.Diploma;
import ma.quantorion.appquitue.personalrest.domain.Injury;
import ma.quantorion.appquitue.personalrest.domain.Internship;
import ma.quantorion.appquitue.personalrest.domain.Mission;
import ma.quantorion.appquitue.personalrest.domain.Permission;
import ma.quantorion.appquitue.personalrest.domain.Personal;
import ma.quantorion.appquitue.personalrest.domain.PersonalRepository;
import ma.quantorion.appquitue.personalrest.domain.Punishment;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PersonalrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PersonalrestApplication.class, args);
	}
	
	@Autowired
	private PersonalRepository rep;
	
	@Override
	public void run(String... args) throws Exception
	{
		rep.save(new Personal(1L,"AAAeda", "AMazoz", 06000000, new Date(9,10,1960), "AFes",
		"ASefrou", "Asergent", new Date (9,10,1980), "ACD456789", "AAB-", "AAvenue Mohammed El-Fassi, Derb el-khokha, Hay elhaj",
		"Aphoto.jpg", "AFes", "Amatricule", 123456, "AccpId", 0611111111,
		"Avenue Hassan II, derb lkhobza", "Hassan Ben Jawad", "Avenue Mohamed El-Fassi, Derb el-khoka", "Couturier",
		"Fatma Bent Mohammed", "Femme au foyer", "Khadija Doughri", "Pere au Foyer", "Mohammed Ghazouani", 2,
		"celibitaire", 456789123, "unit", "currentFunction", new Date(5,10,1986),
		"affectationReference", new ArrayList<Condamnation>(), new ArrayList<Diploma>(), new ArrayList<Injury>(), new ArrayList<Internship>(), new ArrayList<Mission>(), new ArrayList<Permission>(), new ArrayList<Punishment>()));
	}

}
