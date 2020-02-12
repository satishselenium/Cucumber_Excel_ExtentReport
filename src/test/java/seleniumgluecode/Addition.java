package seleniumgluecode;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class Addition {
	
	int Fno,Sno, Result;
	
	@Given("user wants to sum the following numbers:")
	public void user_wants_to_sum_the_following_numbers(DataTable dataTable) {
	    // For other transformations you can register a DataTableType.
		
//		List<Integer> list = dataTable.asList(Integer.class);
//		System.out.println("First Number - " + list.get(3));
//		System.out.println("Second Number - " + list.get(4));
//		Fno = list.get(0);
//		Sno = list.get(1);
		
		
		List<List<Integer>> list = dataTable.asLists(Integer.class);
		for(int i=0; i<list.size(); i++) { //i starts from 1 because i=0 represents the header
			System.out.println(list.get(i).get(0)+"    -------     "+list.get(i).get(1)); 
			Result = Fno+Sno;
			System.out.println(Result);
			//System.out.println(list.get(i).get(1));
		}
	    //throw new cucumber.api.PendingException();
	}

	@Given("I open Facebook URL and create new accounts with below data")
	public void i_open_Facebook_URL_and_create_new_accounts_with_below_data(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
	   // throw new cucumber.api.PendingException();
		
		List<String> list3 = dataTable.asList(String.class);
		System.out.println("First Number - " + list3.get(3));
		System.out.println("Second Number - " + list3.get(4));
		System.out.println("Second Number - " + list3.get(8));
		System.out.println("Second Number - " + list3.get(9));
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		
		List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).get("First Name"));
			System.out.println(list.get(i).get("Last Name"));
			System.out.println();
			
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		List<List<String>> list1 = dataTable.asLists(String.class);
		for(int i=1; i<list1.size(); i++) { //i starts from 1 because i=0 represents the header
			System.out.println(list1.get(i).get(0)); 
			System.out.println(list1.get(i).get(1));
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
	}
	
	
	@Given("Table with example")
	public void table_with_example(DataTable dataTable) {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
	    // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
	    // Double, Byte, Short, Long, BigInteger or BigDecimal.
	    //
	    // For other transformations you can register a DataTableType.
//		List<String> list3 = dataTable.asList(String.class);
//		System.out.println("eeeeeeeee - " + list3.get(0));
//		System.out.println("ttttttttt - " + list3.get(1));
//		System.out.println("ttttttttt - " + list3.get(3));
		
		List<List<String>> list1 = dataTable.asLists(String.class);
		for(int i=0; i<list1.size(); i++) { //i starts from 1 because i=0 represents the header
			System.out.println(list1.get(i).get(0)); 
			System.out.println(list1.get(i).get(1));
		}
	}
	
	
	@When("^I fill in some personal data$")
	public void myMethodToDoSomethingWithTheMap(Map<String, String> myMap) {
	    // Here I can access the different map elements
	    System.out.println(myMap.get("Job"));
	    System.out.println(myMap.get("Name"));
	}
}
