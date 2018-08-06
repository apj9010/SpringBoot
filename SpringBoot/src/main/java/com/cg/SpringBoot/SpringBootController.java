package com.cg.SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Message;
import com.cg.model.Sender;
import com.cg.service.MessageRepo;

@RestController
public class SpringBootController {
	@Autowired
	private MessageRepo repo;
	
/*	
	
@RequestMapping(value = "/Message12")
public String sayHello()
{
	return "Thanks god today is friday";
	
}*/
	
	
	@RequestMapping(value = "/Message")
	public Message sendMessage() {
		
		Message m = new Message();
		Sender s = new Sender();
		s.setName("Hello");
		m.setName(s);
		 m.setText("Good morning");
		return m;
	}
	
	
	@RequestMapping(value = "/SendMessage",method = RequestMethod.POST)
	public Message receiveMessage(@RequestBody Message m) {
		
		repo.save(m);
		
		return m;
		
	}
	@RequestMapping(value = "/getMessage")
	public Message getMessage(int id) {
	
		
		return repo.getOne(id);
	}
	
	
	@RequestMapping(value = "/SendSimple")
	public String  receiveSimpleMessage(String s) {
		return s;
	}
	
	@RequestMapping(value="/message1",method=RequestMethod.GET)
	public Message getMsg(String text) {

	
		return repo.getByText(text);
	}  
	
	
	
}
