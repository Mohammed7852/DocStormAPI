package com.DocStorm.Controllers;

import com.DocStorm.Models.Document;
import com.DocStorm.Models.DocumentTranslation;
import com.DocStorm.Models.User;
import com.DocStorm.Repositories.DocumentTranslation_Repository;
import com.DocStorm.Repositories.Document_Repository;
import com.DocStorm.Repositories.User_Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes
public class MainController {

	@Autowired
	HttpSession session;

	@Autowired
	User_Repository userRepository;

	@Autowired
	Document_Repository documentRepository;

	@Autowired
	DocumentTranslation_Repository dtRepository;

	// ----------------------------Default Service--------

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(ModelMap model) {
		model.put("msg", "welcome page");
		return "show/welcome";

	}

	// ----------------Test Service-------

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String test(ModelMap model) {
		List<User> users = userRepository.findAll();
		User user = new User();
		for (User user2 : users) {
			if (user2.getUseremail().equals("m.alishabanah2017@gmail.com")) {
				user = user2;
				break;
			}
		}

		model.put("msg", user.toString());
		return "show/welcome";
	}

	// ----------------SignUp Service-----------

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String dosignup(ModelMap model, @RequestParam String name, @RequestParam String email,
			@RequestParam String password, @RequestParam String type) {
		boolean check = true;
		List<User> users = userRepository.findAll();
		for (User user : users) {
			if (user.getUseremail().equals(email)) {
				check = false;
				break;
			}
		}

		if (!check) {
			model.put("error", "Re-register your information.");
			return "show/welcome";
		}
		User user = new User(name, email, password, type);
		userRepository.saveAndFlush(user);
		String str = user.toString();
		model.put("msg", str);
		return "show/welcome";
	}

	// ---------------------Login Service------

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(ModelMap model, @RequestParam String email, @RequestParam String password) {

		boolean checkLogin = false;
		User user = new User();
		List<User> list = userRepository.findAll();
		for (User u : list) {
			if ((u.getUseremail().equals(email)) && u.getPassword().equals(password)) {
				checkLogin = true;
				user = u;
				break;
			}
		}

		if (!checkLogin) {
			model.put("error", "Invalid Login");
			return "show/welcome";
		}

		session.setAttribute("user", user);
		model.put("msg", "Valid Login .. Welcome :" + user.getUsername());
		return "show/welcome";
	}

	// ----------------------AddDcoument Service----------------

	@RequestMapping(value = "/addDoc", method = RequestMethod.POST)
	public String doAddDocument(ModelMap model, @RequestParam String docname, @RequestParam String tag,
			@RequestParam String LangCode, @RequestParam String Translation, @RequestParam String useremail) {

		boolean check = false;
		;
		List<User> users = userRepository.findAll();
		User user = new User();

		for (User user2 : users) {
			if (user2.getUseremail().equals(useremail)) {
				user = user2;
				check = true;
				break;
			}
		}

		if (!check) {
			model.put("error", "your mail is not found.");
			return "show/welcome";
		}
		
		if (!user.getUsertype().equals("admin")) {
			model.put("msg", "this user cannot add/edit documents");
			return "show/welcome";
		}
		Date date = new Date();

		Document document = new Document(docname, tag, date, user);
		DocumentTranslation DT = new DocumentTranslation(LangCode, Translation, date, document);

		documentRepository.saveAndFlush(document);
		dtRepository.saveAndFlush(DT);

		model.put("msg", "finish Adding Adocument :" + document.getDocname() + " , to user" + user.getUsername());
		return "show/welcome";
	}

	// --------------------Get AllDocuments Service--------------

	@RequestMapping(value = "/getDoc", method = RequestMethod.GET)
	public String GetDocuments(ModelMap model) {

		List<Document> documents = documentRepository.findAll();

		model.put("msg", "<hr>Documents are:<br>" + documents.toString());
		return "show/welcome";
	}

	// ----------'Add Translation to a document' Service----------

	@RequestMapping(value = "/addtranslation", method = RequestMethod.POST)
	public String AddTranslation(ModelMap model, @RequestParam int docid, @RequestParam String LangCode,
			@RequestParam String Translation) {

		Document document = documentRepository.findOne(docid);
		Date date = new Date();
		DocumentTranslation doctran = new DocumentTranslation(LangCode, Translation, date, document);
		dtRepository.saveAndFlush(doctran);
		
		model.put("msg", "Adding A new " + LangCode + " Translation to Adocument :" + document.getDocname() + "<br>");
		return "show/welcome";
	}

	// --------Get Documents By Tag Service-------------------------

	@RequestMapping(value = "/getdoctag", method = RequestMethod.POST)
	public String GetDocumentsByTag(ModelMap model, @RequestParam String tag) {
		List<Document> ResultDocuments = new ArrayList<>();
		
		List<Document> documents = documentRepository.findAll();
		
		for (Document document : documents) {
			if (document.getTag().equals(tag))
				ResultDocuments.add(document);
		}
		String str = "Documnets of Tag: '" + tag + "' are:<br>";
		for (Document document : ResultDocuments)
			str += document.toString();

		model.put("msg", str);
		return "show/welcome";
	}

}
