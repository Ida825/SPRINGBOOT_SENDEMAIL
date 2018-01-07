package cn.et;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendController {

	@Autowired
	private JavaMailSender jms;
	
	@PostMapping("/send")
	public String send(@RequestBody Map<String,Object> map){
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("sunyingida@126.com");
		smm.setTo(map.get("sendTo").toString());
		smm.setSubject(map.get("sendSubject").toString());
		smm.setText(map.get("sendContent").toString());
		jms.send(smm);
		return "1";
	}
	
	
	/**
	 * post请求
	 * @return
	 */
	@PostMapping("/sendParam")
	public String sendParam(String sendTo,String sendSubject,String sendContent){
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom("sunyingida@gmail.com");
		smm.setTo(sendTo);
		smm.setSubject(sendSubject);
		smm.setText(sendContent);
		jms.send(smm);
		return "1";
	}
	
	
	@GetMapping("/user/{userId}")
	public Map getUser(@PathVariable String userId){
		Map map = new HashMap();
		map.put("userId", userId);
		map.put("name","zs");
		return map;
	}
}
