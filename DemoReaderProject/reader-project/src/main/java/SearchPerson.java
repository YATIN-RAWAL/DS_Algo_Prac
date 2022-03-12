import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class SearchPerson {
	
	private static List<Module> modulesList=new ArrayList();
	{
		modulesList.add(new JavaTimeModule());
	}
	
    protected static final ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.json().modules(modulesList)
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS).build();


	
	public Map<String, List<EmployeeDetails>> readEmployeeDetails(String fileLocation){
		Map<String, List<EmployeeDetails>> mapEmployeeIdTOListOFEmployeeDetails= new HashMap<String, List<EmployeeDetails>>();
		List<EmployeeDetails> employeeDetailsList=null;
		try {
			employeeDetailsList=objectMapper.readValue(JsonReader.readFile(fileLocation), new TypeReference<List<EmployeeDetails>>() {});
		} catch (JsonProcessingException e) {
			System.out.println("Error reading document");
		}
		employeeDetailsList.stream().forEach(employee -> {
			if(mapEmployeeIdTOListOFEmployeeDetails.containsKey(employee.getEmployeName())) {
				mapEmployeeIdTOListOFEmployeeDetails.get(employee.getEmployeName()).add(employee);
			}else {
				mapEmployeeIdTOListOFEmployeeDetails.put(employee.getEmployeName(), new ArrayList<EmployeeDetails>(Arrays.asList(employee)));
			}
		});
		
		System.out.println(employeeDetailsList.size());
		return mapEmployeeIdTOListOFEmployeeDetails;
		
	}
	
	
	public void searchEmployeeDetails(String employeeName,String fileName) {
		Map<String, List<EmployeeDetails>> mapEmployeeIdTOListOFEmployeeDetails=readEmployeeDetails(fileName);
		if (mapEmployeeIdTOListOFEmployeeDetails!=null && !mapEmployeeIdTOListOFEmployeeDetails.isEmpty()) {
			mapEmployeeIdTOListOFEmployeeDetails.entrySet().stream().forEach(empIdToDetails -> {
				if (empIdToDetails.getKey().equalsIgnoreCase(employeeName)) {
					empIdToDetails.getValue().forEach(emp -> {
						System.out.println(emp.toString());
					});
				}
			});
		}
		
	}

}
